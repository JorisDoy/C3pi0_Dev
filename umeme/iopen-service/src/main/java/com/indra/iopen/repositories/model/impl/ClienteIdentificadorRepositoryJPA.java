package com.indra.iopen.repositories.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.ClienteIdentificadorRepository;

/**
 * The persistent class for the CLIENTE_IDENTIFICADOR database table.
 * 
 */
@Repository
public class ClienteIdentificadorRepositoryJPA  extends BaseRepository<ClienteIdentificador> implements ClienteIdentificadorRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public ClienteIdentificadorRepositoryJPA() {
		this.entityClass = ClienteIdentificador.class;
	}
	
	
	@Override
	public Long findCodCliByTipDocDocId(String tipDoc, String docId) {
		
		Long codCli = 0L;
		
		List<Long> codCliList = this.entityManager
				.createQuery("select distinct c.id.codCli from ClienteIdentificador c "
						+ "where c.tipDoc = :tipDoc "
						+ "and c.docId = :docId ")
				.setParameter("tipDoc", tipDoc)
				.setParameter("docId", docId)
				.getResultList(); 
		
		if(codCliList.size() > 1){
			codCli = -1L;
		}else if(codCliList.size() == 1){
			codCli = codCliList.get(0);
		}			
		
		return codCli;
	}
}