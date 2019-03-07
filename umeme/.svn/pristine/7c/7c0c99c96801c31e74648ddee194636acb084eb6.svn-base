package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Callejero;

public interface CallejeroRepository extends CrudRepository<Callejero, Long> {
	List<Callejero> findCallejeroByCodLocalOrderByNomCalleAsc(BigDecimal codLocal);

}
