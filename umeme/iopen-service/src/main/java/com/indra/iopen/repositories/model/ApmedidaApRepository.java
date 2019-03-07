package com.indra.iopen.repositories.model;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ApmedidaAp;
import com.indra.iopen.repositories.model.impl.ApmedidaApRepositoryCustom;

public interface ApmedidaApRepository extends CrudRepository<ApmedidaAp, Long>, ApmedidaApRepositoryCustom {

	ApmedidaAp findApmedidaApByNumApa(String meterNumber);

	ApmedidaAp findApmedidaApByNumSumAndEstApa(BigDecimal numSum, String estApa);

	ApmedidaAp findApmedidaApByNumSum(BigDecimal numSum);
}
