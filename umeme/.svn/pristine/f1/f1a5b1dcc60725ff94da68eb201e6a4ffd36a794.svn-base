package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERFILES database table.
 * 
 */
@Entity
@Table(name="PERFILES")
@NamedQuery(name="Perfile.findAll", query="SELECT p FROM Perfile p")
public class Perfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NOM_PERFIL")
	private String nomPerfil;

	@Column(name="DESC_PERFIL")
	private String descPerfil;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="IND_DEFECTO")
	private String indDefecto;

	@Column(name="IND_INFORMES")
	private BigDecimal indInformes;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to PerfilObjeto
	@OneToMany(mappedBy="perfile")
	private List<PerfilObjeto> perfilObjetos;

	//bi-directional many-to-one association to UsuarioPerfil
	@OneToMany(mappedBy="perfile")
	private List<UsuarioPerfil> usuarioPerfils;

	public Perfile() {
	}

	public String getNomPerfil() {
		return this.nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	public String getDescPerfil() {
		return this.descPerfil;
	}

	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getIndDefecto() {
		return this.indDefecto;
	}

	public void setIndDefecto(String indDefecto) {
		this.indDefecto = indDefecto;
	}

	public BigDecimal getIndInformes() {
		return this.indInformes;
	}

	public void setIndInformes(BigDecimal indInformes) {
		this.indInformes = indInformes;
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

	public List<PerfilObjeto> getPerfilObjetos() {
		return this.perfilObjetos;
	}

	public void setPerfilObjetos(List<PerfilObjeto> perfilObjetos) {
		this.perfilObjetos = perfilObjetos;
	}

	public PerfilObjeto addPerfilObjeto(PerfilObjeto perfilObjeto) {
		getPerfilObjetos().add(perfilObjeto);
		perfilObjeto.setPerfile(this);

		return perfilObjeto;
	}

	public PerfilObjeto removePerfilObjeto(PerfilObjeto perfilObjeto) {
		getPerfilObjetos().remove(perfilObjeto);
		perfilObjeto.setPerfile(null);

		return perfilObjeto;
	}

	public List<UsuarioPerfil> getUsuarioPerfils() {
		return this.usuarioPerfils;
	}

	public void setUsuarioPerfils(List<UsuarioPerfil> usuarioPerfils) {
		this.usuarioPerfils = usuarioPerfils;
	}

	public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().add(usuarioPerfil);
		usuarioPerfil.setPerfile(this);

		return usuarioPerfil;
	}

	public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().remove(usuarioPerfil);
		usuarioPerfil.setPerfile(null);

		return usuarioPerfil;
	}

}