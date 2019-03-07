package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CONTROL_ACCESO_INTERNET database table.
 * 
 */
@Entity
@Table(name="CONTROL_ACCESO_INTERNET")
@NamedQuery(name="ControlAccesoInternet.findAll", query="SELECT c FROM ControlAccesoInternet c")
public class ControlAccesoInternet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDENTIFICADOR_CLI")
	private String identificadorCli;

	private String clave;

	@ManyToOne
	@JoinColumn(name="COD_CLI")
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private BigDecimal fondo;

	private BigDecimal fondohelp;

	private BigDecimal fondoopc;

	private BigDecimal fondotop;

	private BigDecimal letra;

	private BigDecimal letrahelp;

	private BigDecimal letraopc;

	private BigDecimal letratop;

	private String programa;

	private String usuario;

	public ControlAccesoInternet() {
	}

	public String getIdentificadorCli() {
		return this.identificadorCli;
	}

	public void setIdentificadorCli(String identificadorCli) {
		this.identificadorCli = identificadorCli;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getfActual() {
		return fActual;
	}

	public void setfActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getFondo() {
		return this.fondo;
	}

	public void setFondo(BigDecimal fondo) {
		this.fondo = fondo;
	}

	public BigDecimal getFondohelp() {
		return this.fondohelp;
	}

	public void setFondohelp(BigDecimal fondohelp) {
		this.fondohelp = fondohelp;
	}

	public BigDecimal getFondoopc() {
		return this.fondoopc;
	}

	public void setFondoopc(BigDecimal fondoopc) {
		this.fondoopc = fondoopc;
	}

	public BigDecimal getFondotop() {
		return this.fondotop;
	}

	public void setFondotop(BigDecimal fondotop) {
		this.fondotop = fondotop;
	}

	public BigDecimal getLetra() {
		return this.letra;
	}

	public void setLetra(BigDecimal letra) {
		this.letra = letra;
	}

	public BigDecimal getLetrahelp() {
		return this.letrahelp;
	}

	public void setLetrahelp(BigDecimal letrahelp) {
		this.letrahelp = letrahelp;
	}

	public BigDecimal getLetraopc() {
		return this.letraopc;
	}

	public void setLetraopc(BigDecimal letraopc) {
		this.letraopc = letraopc;
	}

	public BigDecimal getLetratop() {
		return this.letratop;
	}

	public void setLetratop(BigDecimal letratop) {
		this.letratop = letratop;
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