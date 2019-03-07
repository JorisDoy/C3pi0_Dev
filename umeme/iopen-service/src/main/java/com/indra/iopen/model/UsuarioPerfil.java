package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIO_PERFIL database table.
 * 
 */
@Entity
@Table(name="USUARIO_PERFIL")
@NamedQuery(name="UsuarioPerfil.findAll", query="SELECT u FROM UsuarioPerfil u")
public class UsuarioPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPerfilPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to Perfile
	@ManyToOne
	@JoinColumn(name="NOM_PERFIL", updatable=false, insertable=false)
	private Perfile perfile;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="NOM_USR", updatable=false, insertable=false)
	private Usuario usuarioBean;

	//bi-directional many-to-one association to UsuarioPerfilSec
	@OneToMany(mappedBy="usuarioPerfil")
	private List<UsuarioPerfilSec> usuarioPerfilSecs;

	public UsuarioPerfil() {
	}

	public UsuarioPerfilPK getId() {
		return this.id;
	}

	public void setId(UsuarioPerfilPK id) {
		this.id = id;
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

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<UsuarioPerfilSec> getUsuarioPerfilSecs() {
		return this.usuarioPerfilSecs;
	}

	public void setUsuarioPerfilSecs(List<UsuarioPerfilSec> usuarioPerfilSecs) {
		this.usuarioPerfilSecs = usuarioPerfilSecs;
	}

	public UsuarioPerfilSec addUsuarioPerfilSec(UsuarioPerfilSec usuarioPerfilSec) {
		getUsuarioPerfilSecs().add(usuarioPerfilSec);
		usuarioPerfilSec.setUsuarioPerfil(this);

		return usuarioPerfilSec;
	}

	public UsuarioPerfilSec removeUsuarioPerfilSec(UsuarioPerfilSec usuarioPerfilSec) {
		getUsuarioPerfilSecs().remove(usuarioPerfilSec);
		usuarioPerfilSec.setUsuarioPerfil(null);

		return usuarioPerfilSec;
	}

}