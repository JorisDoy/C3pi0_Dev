package com.indra.iopen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the GIS_IOPEN_MAPPING database table.
 *
 */
@Entity
@Table(name="GIS_IOPEN_MAPPING")
@NamedQuery(name="GisIopenMapping.findAll", query="SELECT g FROM GisIopenMapping g")
public class GisIopenMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GIS_IOPEN_MAPPING_ID_GENERATOR", sequenceName="GIS_MAPPING")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GIS_IOPEN_MAPPING_ID_GENERATOR")
	private long id;

	private String code;

	private String description;

	public GisIopenMapping() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}