package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BILL_DISPATCH database table.
 * 
 */
@Entity
@Table(name="BILL_DISPATCH")
@NamedQuery(name="BillDispatch.findAll", query="SELECT b FROM BillDispatch b")
public class BillDispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BillDispatchPK id;

	@Column(name="BD_STATUS")
	private String bdStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	public BillDispatch() {
	}

	public BillDispatchPK getId() {
		return this.id;
	}

	public void setId(BillDispatchPK id) {
		this.id = id;
	}

	public String getBdStatus() {
		return this.bdStatus;
	}

	public void setBdStatus(String bdStatus) {
		this.bdStatus = bdStatus;
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

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}