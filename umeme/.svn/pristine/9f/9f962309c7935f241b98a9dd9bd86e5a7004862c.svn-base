package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Localidade;
import com.indra.iopen.repositories.model.LocalidadeRepository;
/**
 * used to get division/location
 * @author smaina
 *
 */
@Service
public class LocalidadeServiceImpl implements LocalidadeService {

	@Autowired
	private LocalidadeRepository localidadeRepository;

	@Override
	public List<Localidade> findVillageByDistrictCode(BigDecimal district) {
		// TODO Auto-generated method stub
		List<Localidade> list = new ArrayList<Localidade>();
		try {
			list = localidadeRepository.findLocalidadeByCodMunicAndUsrNumber1OrderByNomLocalAsc(district, new BigDecimal(0));
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Localidade> findLocalityByVillageCode(BigDecimal village) {
		// TODO Auto-generated method stub
		List<Localidade> list = new ArrayList<Localidade>();
		try {
			list = localidadeRepository.findLocalidadeByUsrNumber1OrderByNomLocalAsc(village);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return list;
	}

}
