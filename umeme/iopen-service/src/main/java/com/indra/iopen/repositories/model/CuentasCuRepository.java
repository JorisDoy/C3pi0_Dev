package com.indra.iopen.repositories.model;

import java.math.BigDecimal;

import com.indra.iopen.model.CuentasCu;
import com.indra.iopen.repositories.MasterDataRepository;

/**
 * The persistent interface for the CUENTAS_CU database table.
 *
 */
public interface CuentasCuRepository extends MasterDataRepository<CuentasCu> {

	CuentasCu findCuentasCuByCodCli(BigDecimal codCli);

	/**
	 *
	 */

}