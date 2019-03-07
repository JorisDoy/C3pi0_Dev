package com.indra.iopen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.model.ClienteIdentificadorPK;
import com.indra.iopen.model.Fincas;
import com.indra.iopen.model.Localidade;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.pojo.ContactPerson;
import com.indra.iopen.pojo.PremiseInformation;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.ClienteIdentificadorRepository;
import com.indra.iopen.repositories.model.ClienteRepository;
import com.indra.iopen.repositories.model.FincasRepository;
import com.indra.iopen.repositories.model.LocalidadeRepository;
import com.indra.iopen.service.CustomerProfileService;
import com.indra.iopen.util.ApplicationDefault;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private FincasRepository fincasRepository;
	@Autowired
	private ClienteIdentificadorRepository clienteIdentificadorRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Autowired
	private LocalidadeRepository localidadeRepository;
	@Autowired
	private Environment env;

	@Override
	public CustomerProfile getCustomerProfile(ClientUser clientUser) {
		long codCli = clientUser.getClienteProfile().getCodCli();

		CustomerProfile customerProfile = new CustomerProfile();

		if (codCli > 0) {
			Cliente cliente = clienteRepository.findById(codCli);
			ClienteIdentificador clienteIdentificador = clienteIdentificadorRepository
					.findById(new ClienteIdentificadorPK(codCli,
							Long.valueOf(ApplicationDefault.getClienteIdentificadorPKSecId())));
			customerProfile.setSurname(cliente.getApe1Cli());
			customerProfile.setFirstName(cliente.getNomCli());
			customerProfile.setMiddleName(cliente.getApe2Cli());
			customerProfile.setMobileNumber(cliente.getTfno3Cli());
			customerProfile.setOfficeNumber(cliente.getTfno1Cli());
			customerProfile.setEmailAddress(cliente.getEMail());
			customerProfile.setIdType(clienteIdentificador.getTipDoc());
			customerProfile.setIdNumber(clienteIdentificador.getDocId());

			ContactPerson contactPerson = new ContactPerson();
			contactPerson.setName(cliente.getPersContacto());
			contactPerson.setPhoneNumber(cliente.getNombrePadre());
			customerProfile.setContactPerson(contactPerson);
			PremiseInformation premiseInformation = new PremiseInformation();
			Fincas fincas = fincasRepository.findOne(cliente.getNif().longValue());
			Callejero callejero = callejeroRepository.findOne(fincas.getCodCalle().longValue());

			premiseInformation.setDistrict(callejero.getCodMunic().longValue());
			premiseInformation.setHousePlotNumber(fincas.getNumPuerta().longValue());
			premiseInformation.setLandmark(fincas.getRefDir());
			premiseInformation.setStreet(callejero.getCodCalle());
			Localidade locality = localidadeRepository.findOne(callejero.getCodLocal().longValue());
			premiseInformation.setLocality(callejero.getCodLocal().longValue());
			premiseInformation.setVillage(locality.getUsrNumber1().longValue());
			premiseInformation.setProvince(Long.valueOf(env.getProperty("application.codprov.uganda.value")));
			customerProfile.setPremiseInformation(premiseInformation);

		}

		return customerProfile;

	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void editCustomerProfile(ClientUser clientUser, CustomerProfile customerProfile) {

		long codCli = clientUser.getClienteProfile().getCodCli();
		if (codCli > 0) {
			Cliente cliente = clienteRepository.findById(codCli);
			cliente.setApe1Cli(customerProfile.getSurname());
			cliente.setNomCli(customerProfile.getFirstName());
			cliente.setApe2Cli(customerProfile.getMiddleName());
			cliente.setTfno3Cli(customerProfile.getMobileNumber());
			cliente.setTfno1Cli(customerProfile.getOfficeNumber());
			cliente.setEMail(customerProfile.getEmailAddress());

			cliente.setPersContacto(customerProfile.getContactPerson().getName());
			cliente.setNombrePadre(customerProfile.getContactPerson().getPhoneNumber());

			clienteRepository.save(cliente);

		}

	}

}
