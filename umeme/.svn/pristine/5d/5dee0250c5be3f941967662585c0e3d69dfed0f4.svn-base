package com.indra.iopen.service.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;

import com.indra.iopen.model.ims.SgdSector;
import com.indra.iopen.repositories.model.ims.SgdSectorRepository;

public class SgdSectorServiceImpl implements SgdSectorService {
	@Autowired
	private SgdSectorRepository sgdSectorRepository;

	/**
	 * finds provinces/departments
	 */
	@Override
	public List<SgdSector> findAll() {
		return (List<SgdSector>) sgdSectorRepository.findAll();
	}

}
