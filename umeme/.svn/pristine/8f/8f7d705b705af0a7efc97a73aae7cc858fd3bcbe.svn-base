package com.indra.iopen.repositories.model.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.DistrictDepto;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.DistrictDeptoRepository;


/**
 * The persistent class for the DISTRICT_DEPTOS database table.
 * 
 */
@Repository
public class DistrictDeptoRepositoryJPA  extends BaseRepository<DistrictDepto> implements DistrictDeptoRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<DistrictDepto> findAllDistricts() {
		return this.entityManager.createNamedQuery("DistrictDepto.findAll", DistrictDepto.class).getResultList();
	}

	@Override
	public DistrictDepto findDistrict(String nomDistrict) {
		return (DistrictDepto) this.entityManager
				.createQuery("select d from DistrictDepto d where d.nomDistrict= :nomDistrict")
				.setParameter("nomDistrict", nomDistrict).getSingleResult();
	}
	

}