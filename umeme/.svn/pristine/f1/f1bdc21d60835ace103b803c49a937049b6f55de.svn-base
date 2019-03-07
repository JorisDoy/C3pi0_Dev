package com.indra.iopen.model.ims;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the GI_FEEDER database table.
 *
 */
@Entity
@Table(name = "GI_FEEDER@IMS", schema = "IMSPROD")
@NamedQuery(name = "GiFeeder.findAll", query = "SELECT g FROM GiFeeder g")
public class GiFeeder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigo;

	private String feeder;

	private String substation;

	public GiFeeder() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getFeeder() {
		return this.feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public String getSubstation() {
		return this.substation;
	}

	public void setSubstation(String substation) {
		this.substation = substation;
	}

}