package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.iopen.model.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	@Query("SELECT m FROM Municipio m WHERE m.codDepto IN ( SELECT d.codDepto FROM Depto d WHERE d.codProv = ? ) "
			+ "ORDER BY m.nomMunic")
	List<Municipio> findMunicipioByCodDepto(BigDecimal depto);

	@Query("SELECT m FROM Municipio m WHERE m.codDepto IN ( SELECT d.codDepto FROM Depto d WHERE d.codProv = ?1 ) "
			+ "AND m.codMunic IN (SELECT distinct c.codMunic from Callejero c WHERE c.codUnicom = ?2)"
			+ "ORDER BY m.nomMunic")
	List<Municipio> findMunicipioByCodDeptoAndUnicom(BigDecimal depto, BigDecimal codUnicom);
}
