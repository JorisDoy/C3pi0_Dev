package com.indra.iopen.repositories.model;

import com.indra.iopen.model.Cliente;
import com.indra.iopen.repositories.MasterDataRepository;

/**
 * The persistent interface for the CLIENTES database table.
 * 
 */
public interface ClienteRepository extends MasterDataRepository<Cliente>{

	public long getCodCliNextVal();	
}