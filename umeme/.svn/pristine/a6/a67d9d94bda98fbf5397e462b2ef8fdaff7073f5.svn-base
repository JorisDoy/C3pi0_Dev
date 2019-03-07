package com.indra.iopen.repositories.model;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Deposito;

public interface DepositoRepository extends CrudRepository<Deposito, Long> {
	Deposito findByNisRadAndEstDeposito(BigDecimal nisRad, String estDeposito);
}
