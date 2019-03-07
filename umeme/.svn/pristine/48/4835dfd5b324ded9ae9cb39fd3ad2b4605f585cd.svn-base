package com.indra.iopen.repositories.model;

import com.indra.iopen.model.CosteExp;
import com.indra.iopen.repositories.MasterDataRepository;

/**
 * The persistent interface for the COSTE_EXP database table.
 *
 */
public interface CosteExpRepository extends MasterDataRepository<CosteExp> {
	public CosteExp findCoste(String tipTarriff, String tipMov);

	CosteExp findCosteByTipObra(String tipObra, String tipMov);

	/**
	 * SMA/UMESCI-713 Used to find CosteExp By the parameters
	 *
	 * @param tipMovValue
	 * @param tipSolic
	 * @return
	 */
	public CosteExp findCosteExpByTipMovAndTipTarrif(String tipMovValue, String tipSolic);

}