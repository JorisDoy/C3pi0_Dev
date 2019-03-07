package com.indra.iopen.repositories.model;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.InvGroup;

/**
 * The persistent interface for the INV_GROUP database table.
 *
 */
public interface InvGroupRepository extends CrudRepository<InvGroup, Long> {

	InvGroup findByCodCta(BigDecimal codCta);

}