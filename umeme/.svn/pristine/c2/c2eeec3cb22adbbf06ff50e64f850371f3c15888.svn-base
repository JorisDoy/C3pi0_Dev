package com.indra.iopen.repositories.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Cliente;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.ClienteRepository;

/**
 * The persistent class for the CLIENTES database table.
 * 
 */
@Repository
public class ClienteRepositoryJPA extends BaseRepository<Cliente> implements ClienteRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ClienteRepositoryJPA() {
		this.entityClass = Cliente.class;
	}
	
	@Override
	public long getCodCliNextVal() {		
		long codCli = ((BigDecimal) this.entityManager.createNativeQuery("SELECT ICSPROD.COD_CLI.NEXTVAL FROM DUAL").getSingleResult())
				.longValue();			
		return codCli;
	}
}