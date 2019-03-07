package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the FINCAS database table.
 *
 */
@Entity
@Table(name = "FINCAS")
@NamedQuery(name = "Fincas.findAll", query = "SELECT f FROM Fincas f")
public class Fincas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name="FINCAS_NIF_GENERATOR", sequenceName="NIF")
	// @GeneratedValue(strategy=GenerationType.SEQUENCE,
	// generator="FINCAS_NIF_GENERATOR")
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private long nif;

	@Column(name = "ACC_FINCA")
	private String accFinca;

	@Column(name = "AREA_LECT")
	private BigDecimal areaLect;

	@Column(name = "COD_AGRUP_FINCAS")
	private BigDecimal codAgrupFincas;

	@Column(name = "COD_AREA")
	private BigDecimal codArea;

	@Column(name = "COD_CALLE")
	private BigDecimal codCalle;

	@Column(name = "COD_POST")
	private String codPost;

	@Column(name = "COD_POST_EXT")
	private String codPostExt;

	private String duplicador;

	@Column(name = "EST_FIN")
	private String estFin;

	@Column(name = "EST_INST")
	private String estInst;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_BAJA")
	private Date fBaja;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_INST")
	private Date fInst;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_REV")
	private Date fRev;

	@Column(name = "IND_REV")
	private BigDecimal indRev;

	@Column(name = "NUM_PADRON")
	private String numPadron;

	@Column(name = "NUM_PUERTA")
	private BigDecimal numPuerta;

	private String programa;

	@Column(name = "REF_DIR")
	private String refDir;

	@Column(name = "TIP_FIN")
	private String tipFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME1")
	private Date usrDatetime1;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME2")
	private Date usrDatetime2;

	@Column(name = "USR_NUMBER1")
	private BigDecimal usrNumber1;

	@Column(name = "USR_NUMBER2")
	private BigDecimal usrNumber2;

	@Column(name = "USR_NUMBER3")
	private BigDecimal usrNumber3;

	@Column(name = "USR_VARCHAR1")
	private String usrVarchar1;

	@Column(name = "USR_VARCHAR2")
	private String usrVarchar2;

	@Column(name = "USR_VARCHAR3")
	private String usrVarchar3;

	private String usuario;

	public Fincas() {
	}

	public long getNif() {
		return this.nif;
	}

	public void setNif(long nif) {
		this.nif = nif;
	}

	public String getAccFinca() {
		return this.accFinca;
	}

	public void setAccFinca(String accFinca) {
		this.accFinca = accFinca;
	}

	public BigDecimal getAreaLect() {
		return this.areaLect;
	}

	public void setAreaLect(BigDecimal areaLect) {
		this.areaLect = areaLect;
	}

	public BigDecimal getCodAgrupFincas() {
		return this.codAgrupFincas;
	}

	public void setCodAgrupFincas(BigDecimal codAgrupFincas) {
		this.codAgrupFincas = codAgrupFincas;
	}

	public BigDecimal getCodArea() {
		return this.codArea;
	}

	public void setCodArea(BigDecimal codArea) {
		this.codArea = codArea;
	}

	public BigDecimal getCodCalle() {
		return this.codCalle;
	}

	public void setCodCalle(BigDecimal codCalle) {
		this.codCalle = codCalle;
	}

	public String getCodPost() {
		return this.codPost;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public String getCodPostExt() {
		return this.codPostExt;
	}

	public void setCodPostExt(String codPostExt) {
		this.codPostExt = codPostExt;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public void setDuplicador(String duplicador) {
		this.duplicador = duplicador;
	}

	public String getEstFin() {
		return this.estFin;
	}

	public void setEstFin(String estFin) {
		this.estFin = estFin;
	}

	public String getEstInst() {
		return this.estInst;
	}

	public void setEstInst(String estInst) {
		this.estInst = estInst;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFBaja() {
		return this.fBaja;
	}

	public void setFBaja(Date fBaja) {
		this.fBaja = fBaja;
	}

	public Date getFInst() {
		return this.fInst;
	}

	public void setFInst(Date fInst) {
		this.fInst = fInst;
	}

	public Date getFRev() {
		return this.fRev;
	}

	public void setFRev(Date fRev) {
		this.fRev = fRev;
	}

	public BigDecimal getIndRev() {
		return this.indRev;
	}

	public void setIndRev(BigDecimal indRev) {
		this.indRev = indRev;
	}

	public String getNumPadron() {
		return this.numPadron;
	}

	public void setNumPadron(String numPadron) {
		this.numPadron = numPadron;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public void setNumPuerta(BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public void setRefDir(String refDir) {
		this.refDir = refDir;
	}

	public String getTipFin() {
		return this.tipFin;
	}

	public void setTipFin(String tipFin) {
		this.tipFin = tipFin;
	}

	public Date getUsrDatetime1() {
		return this.usrDatetime1;
	}

	public void setUsrDatetime1(Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return this.usrDatetime2;
	}

	public void setUsrDatetime2(Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public BigDecimal getUsrNumber1() {
		return this.usrNumber1;
	}

	public void setUsrNumber1(BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return this.usrNumber2;
	}

	public void setUsrNumber2(BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return this.usrNumber3;
	}

	public void setUsrNumber3(BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public String getUsrVarchar1() {
		return this.usrVarchar1;
	}

	public void setUsrVarchar1(String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public String getUsrVarchar2() {
		return this.usrVarchar2;
	}

	public void setUsrVarchar2(String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public String getUsrVarchar3() {
		return this.usrVarchar3;
	}

	public void setUsrVarchar3(String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}