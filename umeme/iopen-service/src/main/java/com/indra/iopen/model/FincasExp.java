package com.indra.iopen.model;

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
 * The persistent class for the FINCAS_EXP database table.
 * 
 */
@Entity
@Table(name = "FINCAS_EXP")
@NamedQuery(name = "FincasExp.findAll", query = "SELECT f FROM FincasExp f")
public class FincasExp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FincasExpPK id;

	@Column(name = "ACC_FINCA")
	private String accFinca;

	private String bloque;

	private BigDecimal calle;

	@Column(name = "COD_CALLE")
	private BigDecimal codCalle;

	@Column(name = "COD_POST")
	private String codPost;

	@Column(name = "COD_POST_EXT")
	private String codPostExt;

	private String duplicador;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	private String lote;

	@Column(name = "NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name = "PLOT_NUM")
	private String plotNum;

	@Column(name = "POT_ANT")
	private BigDecimal potAnt;

	@Column(name = "POT_SOLIC")
	private BigDecimal potSolic;

	private String programa;

	@Column(name = "REF_DIR")
	private String refDir;

	@Column(name = "TIP_TENSION")
	private String tipTension;

	private String usuario;

	public FincasExp() {
		this.accFinca = "RIDGEWAY";
		this.bloque = " ";
		this.calle = new BigDecimal(0);
		this.codPost = " "; 
		this.codPostExt = " ";
		this.fActual = new Date();
		this.lote = " ";
		this.plotNum = " ";
		this.potAnt = new BigDecimal(0);
		this.potSolic = new BigDecimal(60);
		this.tipTension = "TT999";
	}

	public String getAccFinca() {
		return this.accFinca;
	}

	public String getBloque() {
		return this.bloque;
	}

	public BigDecimal getCalle() {
		return this.calle;
	}

	public BigDecimal getCodCalle() {
		return this.codCalle;
	}

	public String getCodPost() {
		return this.codPost;
	}

	public String getCodPostExt() {
		return this.codPostExt;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public FincasExpPK getId() {
		return this.id;
	}

	public String getLote() {
		return this.lote;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public String getPlotNum() {
		return this.plotNum;
	}

	public BigDecimal getPotAnt() {
		return this.potAnt;
	}

	public BigDecimal getPotSolic() {
		return this.potSolic;
	}

	public String getPrograma() {
		return this.programa;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public String getTipTension() {
		return this.tipTension;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setAccFinca(String accFinca) {
		this.accFinca = accFinca;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public void setCalle(BigDecimal calle) {
		this.calle = calle;
	}

	public void setCodCalle(BigDecimal codCalle) {
		this.codCalle = codCalle;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public void setCodPostExt(String codPostExt) {
		this.codPostExt = codPostExt;
	}

	public void setDuplicador(String duplicador) {
		this.duplicador = duplicador;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public void setId(FincasExpPK id) {
		this.id = id;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setNumPuerta(BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public void setPlotNum(String plotNum) {
		this.plotNum = plotNum;
	}

	public void setPotAnt(BigDecimal potAnt) {
		this.potAnt = potAnt;
	}

	public void setPotSolic(BigDecimal potSolic) {
		this.potSolic = potSolic;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setRefDir(String refDir) {
		this.refDir = refDir;
	}

	public void setTipTension(String tipTension) {
		this.tipTension = tipTension;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}