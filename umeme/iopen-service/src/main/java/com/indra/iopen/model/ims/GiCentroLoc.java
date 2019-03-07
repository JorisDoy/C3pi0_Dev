package com.indra.iopen.model.ims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the GI_CENTRO_LOC database table.
 *
 */
@Entity
@Table(name = "GI_CENTRO_LOC@IMS", schema = "IMSPROD")
@NamedQuery(name = "GiCentroLoc.findAll", query = "SELECT g FROM GiCentroLoc g")
public class GiCentroLoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiCentroLocPK id;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "H_ACTUAL")
	private Date hActual;

	@Column(name = "NRO_CENTRO")
	private BigDecimal nroCentro;

	@Column(name = "NRO_CMD")
	private BigDecimal nroCmd;

	private String programa;

	private String usuario;

	public GiCentroLoc() {
	}

	public GiCentroLocPK getId() {
		return id;
	}

	public void setId(GiCentroLocPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getHActual() {
		return hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public BigDecimal getNroCentro() {
		return nroCentro;
	}

	public void setNroCentro(BigDecimal nroCentro) {
		this.nroCentro = nroCentro;
	}

	public BigDecimal getNroCmd() {
		return nroCmd;
	}

	public void setNroCmd(BigDecimal nroCmd) {
		this.nroCmd = nroCmd;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}