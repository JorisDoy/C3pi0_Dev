package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NOM_USR")
	private String nomUsr;

	@Column(name="COD_ALMACEN")
	private BigDecimal codAlmacen;

	@Column(name="COD_CAJA")
	private BigDecimal codCaja;

	@Column(name="COD_CENTEC")
	private BigDecimal codCentec;

	@Column(name="COD_PERFIL")
	private BigDecimal codPerfil;

	@Column(name="COD_UNICOM")
	private BigDecimal codUnicom;

	@Column(name="DESC_USR")
	private String descUsr;

	@Column(name="EMP_USUARIO")
	private BigDecimal empUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to UsuarioPerfil
	@OneToMany(mappedBy="usuarioBean")
	private List<UsuarioPerfil> usuarioPerfils;

	public Usuario() {
	}

	public String getNomUsr() {
		return this.nomUsr;
	}

	public void setNomUsr(String nomUsr) {
		this.nomUsr = nomUsr;
	}

	public BigDecimal getCodAlmacen() {
		return this.codAlmacen;
	}

	public void setCodAlmacen(BigDecimal codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public BigDecimal getCodCaja() {
		return this.codCaja;
	}

	public void setCodCaja(BigDecimal codCaja) {
		this.codCaja = codCaja;
	}

	public BigDecimal getCodCentec() {
		return this.codCentec;
	}

	public void setCodCentec(BigDecimal codCentec) {
		this.codCentec = codCentec;
	}

	public BigDecimal getCodPerfil() {
		return this.codPerfil;
	}

	public void setCodPerfil(BigDecimal codPerfil) {
		this.codPerfil = codPerfil;
	}

	public BigDecimal getCodUnicom() {
		return this.codUnicom;
	}

	public void setCodUnicom(BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public String getDescUsr() {
		return this.descUsr;
	}

	public void setDescUsr(String descUsr) {
		this.descUsr = descUsr;
	}

	public BigDecimal getEmpUsuario() {
		return this.empUsuario;
	}

	public void setEmpUsuario(BigDecimal empUsuario) {
		this.empUsuario = empUsuario;
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

	public List<UsuarioPerfil> getUsuarioPerfils() {
		return this.usuarioPerfils;
	}

	public void setUsuarioPerfils(List<UsuarioPerfil> usuarioPerfils) {
		this.usuarioPerfils = usuarioPerfils;
	}

	public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().add(usuarioPerfil);
		usuarioPerfil.setUsuarioBean(this);

		return usuarioPerfil;
	}

	public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().remove(usuarioPerfil);
		usuarioPerfil.setUsuarioBean(null);

		return usuarioPerfil;
	}

}