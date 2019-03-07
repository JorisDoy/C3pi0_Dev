package com.indra.iopen.repositories.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.IopenApplicationDoc;
import com.indra.iopen.model.IopenApplicationDocPK;

/**
 * The persistent interface for the IOPEN_APPLICATION_DOCS database table.
 * 
 */
public interface IopenApplicationDocRepository extends CrudRepository<IopenApplicationDoc, IopenApplicationDocPK>{
	
	IopenApplicationDoc findById(IopenApplicationDocPK id);
	List<IopenApplicationDoc> findByIdCodApplication(Long codApplication);

}