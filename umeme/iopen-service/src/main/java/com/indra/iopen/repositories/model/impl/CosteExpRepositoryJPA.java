package com.indra.iopen.repositories.model.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.CosteExp;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;

/**
 * The persistent class for the COSTE_EXP database table.
 *
 */
@Repository
public class CosteExpRepositoryJPA extends BaseRepository<CosteExp> implements CosteExpRepository, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CosteExp findCoste(String tipTarriff, String tipMov) {
		System.out.println("tipmov=" + tipMov + " tipTarriff=" + tipTarriff);
		return (CosteExp) entityManager
				.createQuery(
						"select cost from CosteExp cost where cost.id.tipTarriff = :tipTarriff and cost.id.tipMov = :tipMov")
				.setParameter("tipTarriff", tipTarriff).setParameter("tipMov", tipMov).getSingleResult();
	}

	@Override
	public CosteExp findCosteByTipObra(String tipObra, String tipMov) {
		System.out.println("tipmov=" + tipMov + " tipObra=" + tipObra);

		return (CosteExp) entityManager
				.createQuery(
						"select cost from CosteExp cost where cost.id.tipObra = :tipObra and cost.id.tipMov = :tipMov")
				.setParameter("tipObra", tipObra).setParameter("tipMov", tipMov).getSingleResult();
	}

	@Override
	public CosteExp findCosteExpByTipMovAndTipTarrif(String tipMovValue, String tipTarrif) {
		return (CosteExp) entityManager
				.createQuery(
						"select cost from CosteExp cost where cost.id.tipTarriff = :tipTarrif and cost.id.tipMov = :tipMov")
				.setParameter("tipMov", tipMovValue).setParameter("tipTarrif", tipTarrif).getSingleResult();
	}

}