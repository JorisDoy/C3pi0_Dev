package com.indra.iopen.repositories.model;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Depto;

/**
 * The persistent interface for the ACTIVIDADES database table.
 *
 */

public interface DeptoRepository extends CrudRepository<Depto, BigDecimal> {

}