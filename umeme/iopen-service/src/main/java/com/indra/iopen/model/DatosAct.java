package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DATOS_ACT database table.
 * 
 */
@Entity
@Table(name="DATOS_ACT")
@NamedQuery(name="DatosAct.findAll", query="SELECT d FROM DatosAct d")
public class DatosAct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DatosActPK id;

	@Column(name="DESC_ACT")
	private String descAct;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACT")
	private Date fAct;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	@Column(name="TIP_ACT")
	private String tipAct;

	private String usuario;

	//bi-directional many-to-one association to TrabpendRe
	@ManyToOne
	@JoinColumn(updatable=false,insertable=false,name="NUM_RE")
	private TrabpendRe trabpendRe;

	public DatosAct() {
	}

	public DatosActPK getId() {
		return this.id;
	}

	public void setId(DatosActPK id) {
		this.id = id;
	}

	public String getDescAct() {
		return this.descAct;
	}

	public void setDescAct(String descAct) {
		this.descAct = descAct;
	}

	public Date getFAct() {
		return this.fAct;
	}

	public void setFAct(Date fAct) {
		this.fAct = fAct;
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

	public String getTipAct() {
		return this.tipAct;
	}

	public void setTipAct(String tipAct) {
		this.tipAct = tipAct;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TrabpendRe getTrabpendRe() {
		return this.trabpendRe;
	}

	public void setTrabpendRe(TrabpendRe trabpendRe) {
		this.trabpendRe = trabpendRe;
	}

}