package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.GisIopenMapping;

/**
 * UMESCI-732
 * This repository is used for mapping of the request sent from the GIS
 * application
 *
 * @author smaina
 *
 */
public interface GisIopenMappingRepository extends CrudRepository<GisIopenMapping, Long> {

	GisIopenMapping findGisIopenMappingByDescription(String workRequestType);

}
