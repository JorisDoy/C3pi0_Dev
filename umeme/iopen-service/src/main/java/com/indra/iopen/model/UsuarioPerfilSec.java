package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USUARIO_PERFIL_SEC database table.
 * 
 */
@Entity
@Table(name="USUARIO_PERFIL_SEC")
@NamedQuery(name="UsuarioPerfilSec.findAll", query="SELECT u FROM UsuarioPerfilSec u")
public class UsuarioPerfilSec implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPerfilSecPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NOM_PERFIL_DET")
	private String nomPerfilDet;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to UsuarioPerfil
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="NOM_PERFIL", referencedColumnName="NOM_PERFIL", insertable=false, updatable=false),
		@JoinColumn(name="NOM_USR", referencedColumnName="NOM_USR", insertable=false, updatable=false)
		})
	private UsuarioPerfil usuarioPerfil;

	public UsuarioPerfilSec() {
	}

	public UsuarioPerfilSecPK getId() {
		return this.id;
	}

	public void setId(UsuarioPerfilSecPK id) {
		this.id = id;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getNomPerfilDet() {
		return this.nomPerfilDet;
	}

	public void setNomPerfilDet(String nomPerfilDet) {
		this.nomPerfilDet = nomPerfilDet;
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

	public UsuarioPerfil getUsuarioPerfil() {
		return this.usuarioPerfil;
	}

	public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

}