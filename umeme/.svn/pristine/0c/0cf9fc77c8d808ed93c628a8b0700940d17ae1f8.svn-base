package com.indra.iopen.repositories.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.GrupoEst;
import com.indra.iopen.model.GrupoEstPK;

public interface GrupoEstRepository extends CrudRepository<GrupoEst, GrupoEstPK> {
	@Query("Select ge.id.estRec From GrupoEst ge Where ge.id.coGrupo = ?1")
	List<String> findEstRecByidCoGrupo(String coGrupo);
}
