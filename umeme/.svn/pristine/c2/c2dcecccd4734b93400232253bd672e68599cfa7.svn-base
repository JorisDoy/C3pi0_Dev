package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Municipio;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.util.ApplicationDefault;
import com.indra.iopen.util.DomainSort;
/**
 * used to get districts
 * @author smaina
 *
 */
@Service
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;
	private final String orderByColumn = "nomMunic";

	@Override
	public List<Municipio> findAllMunicipios() {
		List<Municipio> list = new ArrayList<Municipio>();
		try {
			list = municipioRepository.findAll(DomainSort.sort(null, orderByColumn));
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Municipio> findAllMunicipiosByDepto() {
		// TODO Auto-generated method stub
		List<Municipio> list = new ArrayList<Municipio>();
		BigDecimal depto = new BigDecimal(ApplicationDefault.getClienteIdentificadorCodProv());
		try {
			list = municipioRepository.findMunicipioByCodDepto(depto);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Municipio> findAllMunicipiosByDeptoAndUnicom(BigDecimal codUnicom) {
		// TODO Auto-generated method stub
		List<Municipio> list = new ArrayList<Municipio>();
		BigDecimal depto = new BigDecimal(ApplicationDefault.getClienteIdentificadorCodProv());
		try {
			list = municipioRepository.findMunicipioByCodDeptoAndUnicom(depto, codUnicom);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return list;
	}

}
