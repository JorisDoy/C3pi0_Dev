package com.indra.iopen.repositories.model.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.DireccionCta;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.DireccionCtaRepository;

/**
 * The persistent class for the DIRECCION_CTA database table.
 * 
 */
@Repository
public class DireccionCtaRepositoryJPA extends BaseRepository<DireccionCta> implements DireccionCtaRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}