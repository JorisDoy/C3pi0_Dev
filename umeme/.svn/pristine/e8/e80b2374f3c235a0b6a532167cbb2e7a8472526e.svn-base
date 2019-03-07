package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PERFIL_OBJETO database table.
 * 
 */
@Entity
@Table(name="PERFIL_OBJETO")
@NamedQuery(name="PerfilObjeto.findAll", query="SELECT p FROM PerfilObjeto p")
public class PerfilObjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PerfilObjetoPK id;

	private String accion;

	@Column(name="CAD_VALID")
	private String cadValid;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to Objeto
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="aplicacion", referencedColumnName="APLICACION",insertable=false, updatable=false),
		@JoinColumn(name="objeto", referencedColumnName="OBJETO",insertable=false, updatable=false),
		@JoinColumn(name="ventana", referencedColumnName="VENTANA",insertable=false, updatable=false)
		})
	private Objeto objetoBean;

	//bi-directional many-to-one association to Perfile
	@ManyToOne
	@JoinColumn(name="NOM_PERFIL", insertable=false, updatable=false)
	private Perfile perfile;

	public PerfilObjeto() {
	}

	public PerfilObjetoPK getId() {
		return this.id;
	}

	public void setId(PerfilObjetoPK id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getCadValid() {
		return this.cadValid;
	}

	public void setCadValid(String cadValid) {
		this.cadValid = cadValid;
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

	public Objeto getObjetoBean() {
		return this.objetoBean;
	}

	public void setObjetoBean(Objeto objetoBean) {
		this.objetoBean = objetoBean;
	}

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

}