package com.indra.iopen.repositories.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Puntomed;
import com.indra.iopen.model.PuntomedPK;

public interface PuntomedRepository extends CrudRepository<Puntomed, PuntomedPK> {

	@Query("Select p From Puntomed p Where p.id.nif = ?1 "
			+ "And p.id.secPm = (Select Max(p1.id.secPm) From Puntomed p1 Where p1.id.nif = ?1)")
	Puntomed findPuntomedByIdNifAndMaxIdSecPm(Long nif);
}
