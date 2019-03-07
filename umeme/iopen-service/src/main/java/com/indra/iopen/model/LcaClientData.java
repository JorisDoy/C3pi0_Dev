package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LCA_CLIENT_DATA database table.
 * 
 */
@Entity
@Table(name="LCA_CLIENT_DATA")
@NamedQuery(name="LcaClientData.findAll", query="SELECT l FROM LcaClientData l")
public class LcaClientData implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LcaClientDataPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="IND_PROC")
	private BigDecimal indProc;

	@Column(name="NUM_REC")
	private BigDecimal numRec;

	private String programa;

	private String usuario;

	@Column(name="VALOR_NEW")
	private String valorNew;

	@Column(name="VALOR_OLD")
	private String valorOld;

	//bi-directional many-to-one association to Sumcon
	@ManyToOne
	@JoinColumn(name="NIS_RAD", referencedColumnName= "NIS_RAD", insertable=false, updatable= false)
	private Sumcon sumcon;

	public LcaClientData() {
	}

	public LcaClientDataPK getId() {
		return this.id;
	}

	public void setId(LcaClientDataPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getIndProc() {
		return this.indProc;
	}

	public void setIndProc(BigDecimal indProc) {
		this.indProc = indProc;
	}

	public BigDecimal getNumRec() {
		return this.numRec;
	}

	public void setNumRec(BigDecimal numRec) {
		this.numRec = numRec;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getValorNew() {
		return this.valorNew;
	}

	public void setValorNew(String valorNew) {
		this.valorNew = valorNew;
	}

	public String getValorOld() {
		return this.valorOld;
	}

	public void setValorOld(String valorOld) {
		this.valorOld = valorOld;
	}

	public Sumcon getSumcon() {
		return this.sumcon;
	}

	public void setSumcon(Sumcon sumcon) {
		this.sumcon = sumcon;
	}

}