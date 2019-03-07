package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.BillDispatchForm;
import com.indra.iopen.form.Contract;
import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.model.BillDispatch;
import com.indra.iopen.model.BillDispatchPK;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.model.ClienteIdentificadorPK;
import com.indra.iopen.model.EbContact;
import com.indra.iopen.model.Sumcon;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.repositories.model.BillDispatchRepository;
import com.indra.iopen.repositories.model.ClienteIdentificadorRepository;
import com.indra.iopen.repositories.model.ClienteRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.repositories.model.impl.EbContactRepository;
import com.indra.iopen.service.BillDispatchService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.service.CustomerProfileService;
import com.indra.iopen.util.ApplicationDefault;

@Service
public class BillDispatchServiceImpl implements BillDispatchService {
	@Autowired
	private BillDispatchRepository billDispatchRepository;
	@Autowired
	private CommonService commonService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private Environment env;
	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private EbContactRepository ebContactRepository;
	@Autowired
	private SumconRepository sumconRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteIdentificadorRepository clienteIdentificadorRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void addBillDispatchMethod(BillDispatchForm billDispatchForm) throws Exception {

		Sumcon sumcon = sumconRepository.findOne(Long.valueOf(billDispatchForm.getContractNumber()));
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (!sumcon.getCodCli().equals(new BigDecimal(clientUser.getClienteProfile().getCodCli()))) {
			throw new DataIntegrityException("that's not your contract");
		}

		BillDispatchPK billDispatchPK = new BillDispatchPK();
		billDispatchPK.setNisRad(Long.valueOf(billDispatchForm.getContractNumber()));
		billDispatchPK.setTipDispatch(billDispatchForm.getDispatchMethod());

		BillDispatch billDispatch = billDispatchRepository.findOne(billDispatchPK);

		if (billDispatch == null) {
			billDispatch = new BillDispatch();
		} else {
			if (!billDispatchForm.isSelected()) {
				billDispatchRepository.delete(billDispatch);
			}
		}

		if (billDispatchForm.isSelected()) {
			billDispatch.setId(billDispatchPK);
			billDispatch.setFActual(new Date());
			billDispatch.setPrograma(ApplicationDefault.getDatabaseUser());
			billDispatch.setUsuario(ApplicationDefault.getProgram());
			// save email to eb_contacts
			if (billDispatchForm.getDispatchMethod()
					.equalsIgnoreCase(env.getProperty("application.tipos.tipo.emailbilldispatch.value"))) {
				EbContact ebContact = new EbContact();
				ebContact.setUsuario(ApplicationDefault.getDatabaseUser());
				ebContact.setPrograma(ApplicationDefault.getProgram());
				ebContact.setFActual(new Date());
				ebContact.setEmailAdd(billDispatchForm.getContact());
				ebContact.setAccountNum(Long.valueOf(billDispatchForm.getContractNumber()));
				ebContact.setSendInd(new BigDecimal(1));

				ebContactRepository.save(ebContact);
			}
			if (billDispatchForm.getDispatchMethod()
					.equalsIgnoreCase(env.getProperty("application.tipos.tipo.smsbilldispatch.value"))) {
				long codCli = clientUser.getClienteProfile().getCodCli();
				Cliente cliente = clienteRepository.findById(codCli);
				cliente.setTfno3Cli(billDispatchForm.getContact());
				clienteRepository.save(cliente);
			}
			billDispatchRepository.save(billDispatch);
		}
	}

	/**
	 * to be used to add a specific bill dispatch method for all contracts
	 *
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void addBillDispatchMethods(BillDispatchForm billDispatchForm, long codCli) throws Exception {
		List<BillDispatch> billDispatchs = new ArrayList<BillDispatch>();
		List<EbContact> ebContacts = new ArrayList<EbContact>();
		Sumcon sumcon = sumconRepository.findOne(Long.valueOf(billDispatchForm.getContractNumber()));

		if (!sumcon.getCodCli().equals(new BigDecimal(codCli))) {
			throw new DataIntegrityException("that's not your contract");
		}
		List<Contract> contracts = contractService.getClientContracts(codCli);
		contracts.parallelStream().filter(Objects::nonNull).forEach((contract) -> {
			BillDispatchPK billDispatchPK = new BillDispatchPK();
			billDispatchPK.setNisRad(Long.valueOf(billDispatchForm.getContractNumber()));
			billDispatchPK.setTipDispatch(billDispatchForm.getDispatchMethod());
			BillDispatch billDispatch = new BillDispatch();
			billDispatch.setId(billDispatchPK);
			billDispatch.setFActual(new Date());
			billDispatch.setPrograma(ApplicationDefault.getDatabaseUser());
			billDispatch.setUsuario(ApplicationDefault.getProgram());
			billDispatchs.add(billDispatch);
			// save email to eb_contacts
			if (billDispatchForm.getDispatchMethod()
					.equalsIgnoreCase(env.getProperty("application.tipos.tipo.emailbilldispatch.value"))) {
				EbContact ebContact = new EbContact();
				ebContact.setUsuario(ApplicationDefault.getDatabaseUser());
				ebContact.setPrograma(ApplicationDefault.getProgram());
				ebContact.setFActual(new Date());
				ebContact.setEmailAdd(billDispatchForm.getContact());
				ebContact.setAccountNum(Long.valueOf(billDispatchForm.getContractNumber()));
				ebContact.setSendInd(new BigDecimal(1));
				ebContacts.add(ebContact);
			}
		});

		billDispatchRepository.save(billDispatchs);
		if (!ebContacts.isEmpty()) {
			ebContactRepository.save(ebContacts);
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void removeBillDispatchMethod(BillDispatchForm billDispatchForm) {
		BillDispatchPK billDispatchPK = new BillDispatchPK();
		billDispatchPK.setNisRad(Long.valueOf(billDispatchForm.getContractNumber()));
		billDispatchPK.setTipDispatch(billDispatchForm.getDispatchMethod());
		// check eb_contact
		if (billDispatchForm.getDispatchMethod()
				.equalsIgnoreCase(env.getProperty("application.tipos.tipo.emailbilldispatch.value"))) {
			EbContact ebContact = ebContactRepository.findOne(Long.valueOf(billDispatchForm.getContractNumber()));
			if (ebContact != null) {
				ebContact.setSendInd(new BigDecimal(0));
				ebContact.setFActual(new Date());
				ebContactRepository.save(ebContact);
			}
		}

		billDispatchRepository.delete(billDispatchPK);
	}

	@Override
	public List<BillDispatchForm> getBillDispatchMethodsOfASpecificContract(Long contractNumber) throws Exception {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);

		EbContact ebContact = ebContactRepository.findOne(contractNumber);
		List<BillDispatchForm> billDispatchs = billDispatchRepository
				.getBillDispatchMethodsOfASpecificContract(contractNumber);
		List<Tipo> billDispatchMethods = commonService.getTipos("BD");
		Map<String, String> dispatchMap = billDispatchMethods.parallelStream()
				.collect(Collectors.toMap(Tipo::getTipo, Tipo::getDescTipo));

		billDispatchs.parallelStream().filter(Objects::nonNull).forEach((billDispatchForm) -> {
			billDispatchForm.setSelected(true);
			String dispatchCode = billDispatchForm.getDispatchMethod();
			billDispatchForm.setDispatchName(dispatchMap.get(dispatchCode));
			// billDispatchForm.setDispatchName(dispatchMap.get(dispatchCode));
			if (dispatchCode.equalsIgnoreCase(env.getProperty("application.tipos.tipo.smsbilldispatch.value"))) {
				billDispatchForm.setContact(customerProfile.getMobileNumber());
			} else
				if (dispatchCode.equalsIgnoreCase(env.getProperty("application.tipos.tipo.emailbilldispatch.value"))) {
				if (ebContact != null && ebContact.getEmailAdd() != null && !ebContact.getEmailAdd().isEmpty()) {
					billDispatchForm.setContact(ebContact.getEmailAdd());
				} else {
					billDispatchForm.setContact(customerProfile.getEmailAddress());
				}
			} else {
				// paper method no contact is needed to be shown
			}
		});
		// add methods not selected
		Set<String> unselectedDispatchCodeSet = dispatchMap.keySet();
		billDispatchs.parallelStream().filter(Objects::nonNull).map(map -> map.getDispatchMethod())
				.forEach((billDispatchType) -> {
					unselectedDispatchCodeSet.remove(billDispatchType);
				});

		unselectedDispatchCodeSet.parallelStream().filter(Objects::nonNull).forEach((dispatchCode) -> {
			BillDispatchForm billDispatchForm = new BillDispatchForm();
			billDispatchForm.setSelected(false);
			billDispatchForm.setDispatchMethod(dispatchCode);
			billDispatchForm.setDispatchName(dispatchMap.get(dispatchCode));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			billDispatchForm.setUpdatedDate(formatter.format(new Date()));
			billDispatchForm.setContractNumber(String.valueOf(contractNumber));
			if (dispatchCode.equalsIgnoreCase(env.getProperty("application.tipos.tipo.smsbilldispatch.value"))) {
				billDispatchForm.setContact(customerProfile.getMobileNumber());
			} else
				if (dispatchCode.equalsIgnoreCase(env.getProperty("application.tipos.tipo.emailbilldispatch.value"))) {
				if (ebContact != null && ebContact.getEmailAdd() != null && !ebContact.getEmailAdd().isEmpty()) {
					billDispatchForm.setContact(ebContact.getEmailAdd());
				} else {
					billDispatchForm.setContact(customerProfile.getEmailAddress());
				}
			} else {
				// paper method no contact is needed to be shown
			}
			billDispatchs.add(billDispatchForm);
		});
		return billDispatchs;
	}

	// @Override
	// public List<BillDispatchForm> getBillDispatchMethods() {
	//
	// List<BillDispatchForm> billDispatchs =
	// billDispatchRepository.getBillDispatchMethods();
	// List<Tipo> billDispatchMethods = commonService.getTipos("BD");
	// Map<String, String> dispatchMap = billDispatchMethods.parallelStream()
	// .collect(Collectors.toMap(Tipo::getTipo, Tipo::getDescTipo));
	//
	// billDispatchs.parallelStream().filter(filter -> filter !=
	// null).forEach((billDispatchForm) -> {
	// String dispatchCode = billDispatchForm.getDispatchMethod();
	// billDispatchForm.setDispatchMethod(dispatchMap.get(dispatchCode));
	// });
	// return billDispatchs;
	// }

}
