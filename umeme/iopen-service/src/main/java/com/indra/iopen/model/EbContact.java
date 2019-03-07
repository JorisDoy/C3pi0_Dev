package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EB_CONTACTS database table.
 * 
 */
@Entity
@Table(name="EB_CONTACTS")
@NamedQuery(name="EbContact.findAll", query="SELECT e FROM EbContact e")
public class EbContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNT_NUM")
	private long accountNum;

	@Column(name="EMAIL_ADD")
	private String emailAdd;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	@Column(name="SEND_IND")
	private BigDecimal sendInd;

	private String usuario;

	public EbContact() {
	}

	public long getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}

	public String getEmailAdd() {
		return this.emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getSendInd() {
		return this.sendInd;
	}

	public void setSendInd(BigDecimal sendInd) {
		this.sendInd = sendInd;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}