package com.indra.iopen.repositories.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.SuministroTipCsmo;
import com.indra.iopen.model.SuministroTipCsmoPK;

public interface SuministroTipCsmoRepository extends CrudRepository<SuministroTipCsmo, SuministroTipCsmoPK> {

	List<SuministroTipCsmo> findSuministroTipCsmoByIdNumSumAndIdTipCsmoAndFBajaGreaterThan(long numSum, String TipCsmo,
			Date fBaja);
}
