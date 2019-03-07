package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EST_REC database table.
 * 
 */
@Entity
@Table(name="EST_REC")
@NamedQuery(name="EstRec.findAll", query="SELECT e FROM EstRec e")
public class EstRec implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstRecPK id;

	@Column(name="EST_REC")
	private String estRec;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_INC_EST")
	private Date fIncEst;

	private String programa;

	private String usuario;

	public EstRec() {
	}

	public EstRecPK getId() {
		return this.id;
	}

	public void setId(EstRecPK id) {
		this.id = id;
	}

	public String getEstRec() {
		return this.estRec;
	}

	public void setEstRec(String estRec) {
		this.estRec = estRec;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFIncEst() {
		return this.fIncEst;
	}

	public void setFIncEst(Date fIncEst) {
		this.fIncEst = fIncEst;
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