package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Personal;
import com.indra.iopen.repositories.model.PersonalRepository;
import com.indra.iopen.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	PersonalRepository personalRepository;

	@Override
	public List<Personal> getPersonalByUnicom(BigDecimal codUnicom) {
		List<Personal> employees = personalRepository.findPersonalByCodUnicom(codUnicom);
		return employees;
	}

}
