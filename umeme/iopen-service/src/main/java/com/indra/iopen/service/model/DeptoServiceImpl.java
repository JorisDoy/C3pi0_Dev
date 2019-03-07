package com.indra.iopen.service.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Depto;
import com.indra.iopen.repositories.model.DeptoRepository;

@Service
public class DeptoServiceImpl implements DeptoService{
	
	@Autowired
	private DeptoRepository deptoRepository;
/**
 * 
 */
	@Override
	public List<Depto> findAllDeptos() {
		// TODO Auto-generated method stub
		List<Depto> list = new ArrayList<Depto>();
		try{
			list = (List<Depto>) deptoRepository.findAll();
		}catch(Exception e){
			//e.printStackTrace();
		}
		return list;
	}



}
