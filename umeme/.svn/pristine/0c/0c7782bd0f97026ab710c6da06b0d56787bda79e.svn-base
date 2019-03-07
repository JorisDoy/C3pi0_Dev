package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Unicom;
import com.indra.iopen.repositories.model.UnicomRepository;
import com.indra.iopen.service.UnicomService;

@Service
public class UnicomServiceImpl implements UnicomService {

	@Autowired
	private UnicomRepository unicomRepository;
	@Autowired
	private Environment env;
	
	@Override
	public List<Unicom> getAllCompanyDistricts(){
		
		return unicomRepository.findUnicomByNomUnicomLike(env.getProperty("application.unicom.company_district_prefix.value"));
	}
	
	@Override
	public List<Unicom> getEmployeeCompanyDistrict(BigDecimal codUnicom){
		return unicomRepository.findUnicomByCodUnicom(codUnicom.longValue());
	}
}
