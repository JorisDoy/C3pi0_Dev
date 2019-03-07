package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SUMINISTROS database table.
 *
 */
@Entity
@Table(name = "SUMINISTROS")
@NamedQuery(name = "Suministro.findAll", query = "SELECT s FROM Suministro s")
public class Suministro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SUMINISTROS_NUMSUM_GENERATOR", sequenceName = "NUM_SUM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUMINISTROS_NUMSUM_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "NUM_SUM")
	private Long numSum;

	@Column(name = "AUS_CONS")
	private BigDecimal ausCons;

	@Column(name = "CGV_SUM")
	private String cgvSum;

	@Column(name = "CO_ESTM")
	private String coEstm;

	@Column(name = "COD_TAF_REC")
	private String codTafRec;

	@Column(name = "COD_UNICOM")
	private BigDecimal codUnicom;

	@Column(name = "CONT_LECT_DIF")
	private BigDecimal contLectDif;

	@Column(name = "CONT_LECT_REP")
	private BigDecimal contLectRep;

	@Column(name = "DIAMETRO_CONEX")
	private BigDecimal diametroConex;

	@Column(name = "EMPRESA_PROD")
	private BigDecimal empresaProd;

	@Column(name = "EST_SUM")
	private String estSum;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "IND_AN_NODET")
	private BigDecimal indAnNodet;

	@Column(name = "IND_CSMO_ADICIONAL")
	private BigDecimal indCsmoAdicional;

	@Column(name = "IND_LECT_PROPIA")
	private BigDecimal indLectPropia;

	@Column(name = "IND_LVTO")
	private BigDecimal indLvto;

	@Column(name = "IND_MODIF_LECT")
	private BigDecimal indModifLect;

	private BigDecimal nif;

	@Column(name = "NUM_ACOMETIDA")
	private BigDecimal numAcometida;

	@Column(name = "NUM_EXP")
	private String numExp;

	@Column(name = "NUM_LECT_NECESARIAS")
	private BigDecimal numLectNecesarias;

	@Column(name = "NUM_PUNTO_CLIMATICO")
	private BigDecimal numPuntoClimatico;

	@Column(name = "NUM_SUM_UDC")
	private String numSumUdc;

	@Column(name = "POT_MAX_ADMIS")
	private BigDecimal potMaxAdmis;

	private String programa;

	@Column(name = "TIP_ASOC")
	private String tipAsoc;

	@Column(name = "TIP_CONEXION")
	private String tipConexion;

	@Column(name = "TIP_FASE")
	private String tipFase;

	@Column(name = "TIP_PER_LECT")
	private String tipPerLect;

	@Column(name = "TIP_PRODUCTO")
	private String tipProducto;

	@Column(name = "TIP_SUMINISTRO")
	private String tipSuministro;

	@Column(name = "TIP_TENSION")
	private String tipTension;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME1")
	private Date usrDatetime1;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME2")
	private Date usrDatetime2;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME3")
	private Date usrDatetime3;

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

	public Suministro() {
	}

	public Long getNumSum() {
		return numSum;
	}

	public void setNumSum(final Long numSum) {
		this.numSum = numSum;
	}

	public BigDecimal getAusCons() {
		return ausCons;
	}

	public void setAusCons(final BigDecimal ausCons) {
		this.ausCons = ausCons;
	}

	public String getCgvSum() {
		return cgvSum;
	}

	public void setCgvSum(final String cgvSum) {
		this.cgvSum = cgvSum;
	}

	public String getCoEstm() {
		return coEstm;
	}

	public void setCoEstm(final String coEstm) {
		this.coEstm = coEstm;
	}

	public String getCodTafRec() {
		return codTafRec;
	}

	public void setCodTafRec(final String codTafRec) {
		this.codTafRec = codTafRec;
	}

	public BigDecimal getCodUnicom() {
		return codUnicom;
	}

	public void setCodUnicom(final BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public BigDecimal getContLectDif() {
		return contLectDif;
	}

	public void setContLectDif(final BigDecimal contLectDif) {
		this.contLectDif = contLectDif;
	}

	public BigDecimal getContLectRep() {
		return contLectRep;
	}

	public void setContLectRep(final BigDecimal contLectRep) {
		this.contLectRep = contLectRep;
	}

	public BigDecimal getDiametroConex() {
		return diametroConex;
	}

	public void setDiametroConex(final BigDecimal diametroConex) {
		this.diametroConex = diametroConex;
	}

	public BigDecimal getEmpresaProd() {
		return empresaProd;
	}

	public void setEmpresaProd(final BigDecimal empresaProd) {
		this.empresaProd = empresaProd;
	}

	public String getEstSum() {
		return estSum;
	}

	public void setEstSum(final String estSum) {
		this.estSum = estSum;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIndAnNodet() {
		return indAnNodet;
	}

	public void setIndAnNodet(final BigDecimal indAnNodet) {
		this.indAnNodet = indAnNodet;
	}

	public BigDecimal getIndCsmoAdicional() {
		return indCsmoAdicional;
	}

	public void setIndCsmoAdicional(final BigDecimal indCsmoAdicional) {
		this.indCsmoAdicional = indCsmoAdicional;
	}

	public BigDecimal getIndLectPropia() {
		return indLectPropia;
	}

	public void setIndLectPropia(final BigDecimal indLectPropia) {
		this.indLectPropia = indLectPropia;
	}

	public BigDecimal getIndLvto() {
		return indLvto;
	}

	public void setIndLvto(final BigDecimal indLvto) {
		this.indLvto = indLvto;
	}

	public BigDecimal getIndModifLect() {
		return indModifLect;
	}

	public void setIndModifLect(final BigDecimal indModifLect) {
		this.indModifLect = indModifLect;
	}

	public BigDecimal getNif() {
		return nif;
	}

	public void setNif(final BigDecimal nif) {
		this.nif = nif;
	}

	public BigDecimal getNumAcometida() {
		return numAcometida;
	}

	public void setNumAcometida(final BigDecimal numAcometida) {
		this.numAcometida = numAcometida;
	}

	public String getNumExp() {
		return numExp;
	}

	public void setNumExp(final String numExp) {
		this.numExp = numExp;
	}

	public BigDecimal getNumLectNecesarias() {
		return numLectNecesarias;
	}

	public void setNumLectNecesarias(final BigDecimal numLectNecesarias) {
		this.numLectNecesarias = numLectNecesarias;
	}

	public BigDecimal getNumPuntoClimatico() {
		return numPuntoClimatico;
	}

	public void setNumPuntoClimatico(final BigDecimal numPuntoClimatico) {
		this.numPuntoClimatico = numPuntoClimatico;
	}

	public String getNumSumUdc() {
		return numSumUdc;
	}

	public void setNumSumUdc(final String numSumUdc) {
		this.numSumUdc = numSumUdc;
	}

	public BigDecimal getPotMaxAdmis() {
		return potMaxAdmis;
	}

	public void setPotMaxAdmis(final BigDecimal potMaxAdmis) {
		this.potMaxAdmis = potMaxAdmis;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public String getTipAsoc() {
		return tipAsoc;
	}

	public void setTipAsoc(final String tipAsoc) {
		this.tipAsoc = tipAsoc;
	}

	public String getTipConexion() {
		return tipConexion;
	}

	public void setTipConexion(final String tipConexion) {
		this.tipConexion = tipConexion;
	}

	public String getTipFase() {
		return tipFase;
	}

	public void setTipFase(final String tipFase) {
		this.tipFase = tipFase;
	}

	public String getTipPerLect() {
		return tipPerLect;
	}

	public void setTipPerLect(final String tipPerLect) {
		this.tipPerLect = tipPerLect;
	}

	public String getTipProducto() {
		return tipProducto;
	}

	public void setTipProducto(final String tipProducto) {
		this.tipProducto = tipProducto;
	}

	public String getTipSuministro() {
		return tipSuministro;
	}

	public void setTipSuministro(final String tipSuministro) {
		this.tipSuministro = tipSuministro;
	}

	public String getTipTension() {
		return tipTension;
	}

	public void setTipTension(final String tipTension) {
		this.tipTension = tipTension;
	}

	public Date getUsrDatetime1() {
		return usrDatetime1;
	}

	public void setUsrDatetime1(final Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return usrDatetime2;
	}

	public void setUsrDatetime2(final Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public Date getUsrDatetime3() {
		return usrDatetime3;
	}

	public void setUsrDatetime3(final Date usrDatetime3) {
		this.usrDatetime3 = usrDatetime3;
	}

	public BigDecimal getUsrNumber1() {
		return usrNumber1;
	}

	public void setUsrNumber1(final BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return usrNumber2;
	}

	public void setUsrNumber2(final BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return usrNumber3;
	}

	public void setUsrNumber3(final BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public String getUsrVarchar1() {
		return usrVarchar1;
	}

	public void setUsrVarchar1(final String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public String getUsrVarchar2() {
		return usrVarchar2;
	}

	public void setUsrVarchar2(final String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public String getUsrVarchar3() {
		return usrVarchar3;
	}

	public void setUsrVarchar3(final String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}