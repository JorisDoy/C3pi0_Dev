package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.BillDispatchForm;
import com.indra.iopen.form.Contract;
import com.indra.iopen.model.ApmedidaAp;
import com.indra.iopen.model.BillDispatch;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Deposito;
import com.indra.iopen.model.Fincas;
import com.indra.iopen.model.Localidade;
import com.indra.iopen.model.Sumcon;
import com.indra.iopen.model.Suministro;
import com.indra.iopen.pojo.ContractFinancialSummary;
import com.indra.iopen.pojo.MeterData;
import com.indra.iopen.pojo.PremiseInformation;
import com.indra.iopen.pojo.ServicePoint;
import com.indra.iopen.repositories.model.ApmedidaApRepository;
import com.indra.iopen.repositories.model.BillDispatchRepository;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.DepositoRepository;
import com.indra.iopen.repositories.model.EstadoRepository;
import com.indra.iopen.repositories.model.FincasRepository;
import com.indra.iopen.repositories.model.LocalidadeRepository;
import com.indra.iopen.repositories.model.MtarifaRepository;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.repositories.model.SuministroRepository;
import com.indra.iopen.repositories.model.TipoRepository;
import com.indra.iopen.service.ContractService;

@Service
@PropertySource("classpath:application.properties")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private SumconRepository sumconRepository;
	@Autowired
	private SuministroRepository suministroRepository;
	@Autowired
	private ApmedidaApRepository apmedidaApRepository;
	@Autowired
	private FincasRepository fincasRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;

	@Autowired
	private LocalidadeRepository localidadeRepository;

	@Autowired
	private BillDispatchRepository billDispatchRepository;

	@Autowired
	private TipoRepository tipoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private MtarifaRepository mtarifaRepository;

	@Autowired
	private DepositoRepository depositoRepository;

	@Autowired
	private ReciboRepository reciboRepository;

	@Autowired
	private Environment env;

	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	@Override
	public List<Contract> getClientContracts(Long codCli) {
		List<Contract> contracts = new ArrayList<Contract>();

		// Get contract details
		List<Sumcon> sumcons = sumconRepository.findSumconByCodCliOrderByNisRadAsc(BigDecimal.valueOf(codCli));

		sumcons.stream().filter(Objects::nonNull).forEach((sumcon) -> {
			Contract contract = new Contract();
			contract = mapSumconToContractForList(sumcon);
			contract.setPremiseInformation(getContractPremise(sumcon.getNif().longValue()));
			contracts.add(contract);
		});

		return contracts;
	}

	@Override
	public Contract getContractByContractNumber(Long contractNumber) {

		Contract contract = new Contract();
		Sumcon sumcon = sumconRepository.findOne(contractNumber);
		// sumcon to contract
		contract = mapSumconToContract(sumcon);

		// add service point data
		contract.setServicePoint(getContractServicePoint(sumcon.getNumSum()));

		// add meter data
		contract.setMeterData(getContractMeterData(sumcon.getNumSum()));

		// add contract financial summary
		contract.setContractFinancialSummary(getContractFinincialSummary(BigDecimal.valueOf(sumcon.getNisRad())));

		// add premise information
		contract.setPremiseInformation(getContractPremise(sumcon.getNif().longValue()));

		// add Bill dispatch Methods
		contract.setBillDispatchForms(getContractBillDispatchMethods(sumcon.getNisRad()));

		return contract;
	}

	@Override
	public Long getNumberOfClientContracts(Long codCli) {
		return sumconRepository.getCountByCodCli(BigDecimal.valueOf(codCli));
	}

	private Contract mapSumconToContract(Sumcon sumcon) {
		Contract contract = new Contract();

		contract.setContractNumber(sumcon.getNisRad().toString());
		contract.setTariff(sumcon.getCodTar());
		// contract.setStatus(sumcon.getEstServ());
		contract.setStatus(estadoRepository.findById(sumcon.getEstServ()).getDescEst());
		contract.setBillingPeriod(sumcon.getTipPerFact());
		contract.setEnrollmentDate(df.format(sumcon.getFAlta()));

		return contract;
	}

	private Contract mapSumconToContractForList(Sumcon sumcon) {
		Contract contract = new Contract();

		contract.setContractNumber(sumcon.getNisRad().toString());
		contract.setTariff(mtarifaRepository.findOne(sumcon.getCodTar()).getDescTar());
		contract.setStatus(estadoRepository.findById(sumcon.getEstServ()).getDescEst());
		contract.setBillingPeriod(tipoRepository.findById(sumcon.getTipPerFact()).getDescTipo());

		return contract;
	}

	private PremiseInformation getContractPremise(Long nif) {

		PremiseInformation premise = new PremiseInformation();

		Fincas fincas = fincasRepository.findOne(nif);
		Callejero callejero = callejeroRepository.findOne(fincas.getCodCalle().longValue());
		Localidade locality = localidadeRepository.findOne(callejero.getCodLocal().longValue());

		premise.setDistrict(callejero.getCodMunic().longValue());
		premise.setLocality(callejero.getCodLocal().longValue());
		premise.setVillage(locality.getUsrNumber1().longValue());
		premise.setHousePlotNumber(fincas.getNumPuerta().longValue());
		premise.setLandmark(fincas.getRefDir());
		premise.setStreet(callejero.getCodCalle());

		premise.setStreetName(callejero.getNomCalle());

		return premise;
	}

	private ServicePoint getContractServicePoint(BigDecimal numSum) {
		Suministro suministro = suministroRepository.findOne(numSum.longValue());
		ServicePoint servicePoint = new ServicePoint();

		servicePoint.setStatus(suministro.getEstSum());
		servicePoint.setConnectionType(suministro.getTipConexion());
		servicePoint.setPhaseType(suministro.getTipFase());
		servicePoint.setVoltageType(suministro.getTipTension());
		servicePoint.setReadingFrequency(suministro.getTipPerLect());

		return servicePoint;
	}

	private MeterData getContractMeterData(BigDecimal numSum) {
		MeterData meterData = new MeterData();
		String estApa = env.getProperty("application.apmedida.ap.est.apa.normal.value");
		ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSumAndEstApa(numSum, estApa);

		meterData.setMeterNumber(apmedidaAp.getNumApa());
		meterData.setManufacturer(apmedidaAp.getCoMarca());
		meterData.setMeterModel(apmedidaAp.getCoModelo());
		meterData.setMaterialType(apmedidaAp.getTipMaterial());
		meterData.setMeterNature(apmedidaAp.getTipNatur());
		meterData.setMeterStatus(apmedidaAp.getEstApa());
		meterData.setVoltage(apmedidaAp.getTipTension());

		return meterData;
	}

	private ContractFinancialSummary getContractFinincialSummary(BigDecimal nisRad) {

		double depositAmount = 0;
		Double outstandingBill;

		ContractFinancialSummary contractFinancialSummary = new ContractFinancialSummary();

		// get deposit collected and not returned
		String estDeposito = env.getProperty("contract.deposito.est_deposito.collected.value");
		Deposito deposito = depositoRepository.findByNisRadAndEstDeposito(nisRad, estDeposito);

		if (deposito != null) {
			depositAmount = deposito.getImpDeposito().doubleValue();
		}

		// get outstanding bill amount
		BigDecimal outstanding = reciboRepository.getNisRadBillOutstandingAmount(nisRad);
		if (outstanding == null) {
			return contractFinancialSummary;
		}

		outstandingBill = outstanding.doubleValue();
		// set values
		contractFinancialSummary.setDepositAmount(depositAmount);
		contractFinancialSummary.setOutstandingAmount(outstandingBill);

		return contractFinancialSummary;
	}

	private List<BillDispatchForm> getContractBillDispatchMethods(Long nisRad) {

		List<BillDispatchForm> BillDispatchFormList = new ArrayList<BillDispatchForm>();

		List<BillDispatch> billDispatches = billDispatchRepository
				.findBillDispatchByIdNisRadOrderByIdTipDispatchAsc(nisRad);

		BillDispatchForm billDispatchForm = new BillDispatchForm();
		for (BillDispatch billDispatch : billDispatches) {

			billDispatchForm.setContractNumber(String.valueOf(billDispatch.getId().getNisRad()));
			billDispatchForm
					.setDispatchMethod(tipoRepository.findById(billDispatch.getId().getTipDispatch()).getDescTipo());
			billDispatchForm.setUpdatedDate(df.format(billDispatch.getFActual()));
			BillDispatchFormList.add(billDispatchForm);
		}

		return BillDispatchFormList;
	}

}