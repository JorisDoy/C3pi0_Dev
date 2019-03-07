package com.indra.iopen.repositories.model;

import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.repositories.MasterDataRepository;

/**
 * The persistent interface for the CLIENTE_IDENTIFICADOR database table.
 * @author mbaez
 *
 */
public interface ClienteIdentificadorRepository extends MasterDataRepository<ClienteIdentificador> {

    Long findCodCliByTipDocDocId(String tipDoc, String docId);

}