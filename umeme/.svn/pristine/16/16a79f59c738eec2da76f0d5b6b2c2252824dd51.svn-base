package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Expediente;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;

/**
 * The persistent class for the EXPEDIENTES database table.
 * 
 */
@Repository
public class ExpedienteRepositoryJPA extends BaseRepository<Expediente> implements ExpedienteRepository{

	public ExpedienteRepositoryJPA() {
		this.entityClass = Expediente.class;
	}
	
	@Override
	public String getNumExpNextVal() {
		String numExp = null;
		BigDecimal num = (BigDecimal) this.entityManager.createNativeQuery("SELECT ICSPROD.NUM_EXP.NEXTVAL FROM DUAL").getSingleResult();
		numExp = String.valueOf(num);		
		return "P299999"+numExp;
	}
	
}