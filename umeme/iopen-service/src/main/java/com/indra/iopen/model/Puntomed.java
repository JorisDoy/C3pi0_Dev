package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PUNTOMED database table.
 *
 */
@Entity
@NamedQuery(name = "Puntomed.findAll", query = "SELECT p FROM Puntomed p")
public class Puntomed implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PuntomedPK id;

	@Column(name = "ACC_PM")
	private String accPm;

	@Column(name = "AOL_PM")
	private BigDecimal aolPm;

	@Column(name = "CGV_PM")
	private String cgvPm;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	private String programa;

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

	public Puntomed() {
		usrVarchar1 = " ";
		usrVarchar2 = " ";
		usrVarchar3 = " ";
		usrNumber1 = new BigDecimal(0);
		usrNumber2 = new BigDecimal(0);
		usrNumber3 = new BigDecimal(0);
		aolPm = new BigDecimal(1);
		accPm = "0";
		cgvPm = "0";

		try {
			usrDatetime1 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			usrDatetime2 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PuntomedPK getId() {
		return id;
	}

	public void setId(PuntomedPK id) {
		this.id = id;
	}

	public String getAccPm() {
		return accPm;
	}

	public void setAccPm(String accPm) {
		this.accPm = accPm;
	}

	public BigDecimal getAolPm() {
		return aolPm;
	}

	public void setAolPm(BigDecimal aolPm) {
		this.aolPm = aolPm;
	}

	public String getCgvPm() {
		return cgvPm;
	}

	public void setCgvPm(String cgvPm) {
		this.cgvPm = cgvPm;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Date getUsrDatetime1() {
		return usrDatetime1;
	}

	public void setUsrDatetime1(Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return usrDatetime2;
	}

	public void setUsrDatetime2(Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public BigDecimal getUsrNumber1() {
		return usrNumber1;
	}

	public void setUsrNumber1(BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return usrNumber2;
	}

	public void setUsrNumber2(BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return usrNumber3;
	}

	public void setUsrNumber3(BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public String getUsrVarchar1() {
		return usrVarchar1;
	}

	public void setUsrVarchar1(String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public String getUsrVarchar2() {
		return usrVarchar2;
	}

	public void setUsrVarchar2(String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public String getUsrVarchar3() {
		return usrVarchar3;
	}

	public void setUsrVarchar3(String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}