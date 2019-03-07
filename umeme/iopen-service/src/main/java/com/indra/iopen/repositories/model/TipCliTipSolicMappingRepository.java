package com.indra.iopen.repositories.model;

import com.indra.iopen.model.TipCliTipSolicMapping;
import com.indra.iopen.repositories.MasterDataRepository;

/**
 * The persistent interface for the TIP_CLI_TIP_SOLIC_MAPPING database table.
 * 
 */
public interface TipCliTipSolicMappingRepository extends MasterDataRepository<TipCliTipSolicMapping> {
	public TipCliTipSolicMapping findTipCliTipSolicMapping(String tipSolic);

	
}