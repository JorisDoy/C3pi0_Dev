package com.indra.iopen.repositories.model.impl;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.TipCliTipSolicMapping;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.TipCliTipSolicMappingRepository;


/**
 * The persistent class for the TIP_CLI_TIP_SOLIC_MAPPING database table.
 * 
 */
@Repository
public class TipCliTipSolicMappingRepositoryJPA extends BaseRepository<TipCliTipSolicMapping> implements TipCliTipSolicMappingRepository{

	@Override
	public TipCliTipSolicMapping findTipCliTipSolicMapping(String tipSolic) {
		return (TipCliTipSolicMapping) this.entityManager
				.createQuery("select map from TipCliTipSolicMapping map where map.id.tipSolic = :tipSolic ")
				.setParameter("tipSolic", tipSolic).getSingleResult();
	}
	
}