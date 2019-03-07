package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SGD_SECTOR database table.
 * 
 */
@Entity
@Table(name="SGD_SECTOR@IMS",schema="IMSPROD")
@NamedQuery(name="SgdSector.findAll", query="SELECT s FROM SgdSector s")
public class SgdSector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_SECTOR")
	private long codSector;

	@Column(name="COD_CMD")
	private BigDecimal codCmd;

	@Column(name="COD_ZONA")
	private BigDecimal codZona;

	@Column(name="NOM_SECTOR")
	private String nomSector;

	public SgdSector() {
	}

	public long getCodSector() {
		return this.codSector;
	}

	public void setCodSector(long codSector) {
		this.codSector = codSector;
	}

	public BigDecimal getCodCmd() {
		return this.codCmd;
	}

	public void setCodCmd(BigDecimal codCmd) {
		this.codCmd = codCmd;
	}

	public BigDecimal getCodZona() {
		return this.codZona;
	}

	public void setCodZona(BigDecimal codZona) {
		this.codZona = codZona;
	}

	public String getNomSector() {
		return this.nomSector;
	}

	public void setNomSector(String nomSector) {
		this.nomSector = nomSector;
	}

}