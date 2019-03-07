package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Callejero;
import com.indra.iopen.repositories.model.CallejeroRepository;

@Service
public class CallejeroServiceImpl implements CallejeroService{
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Override
	public List<Callejero> findStreetByLocalityCode(BigDecimal locality){
		// TODO Auto-generated method stub
		List<Callejero> list = new ArrayList<Callejero>();
		try{
			list = callejeroRepository.findCallejeroByCodLocalOrderByNomCalleAsc(locality);
		}catch(Exception e){
			//e.printStackTrace();
		}
		return list;
	}

	


	



}
