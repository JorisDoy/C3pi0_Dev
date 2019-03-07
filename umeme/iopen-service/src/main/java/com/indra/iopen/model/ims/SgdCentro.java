package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SGD_CENTRO database table.
 * 
 */
@Entity
@Table(name="SGD_CENTRO")
@NamedQuery(name="SgdCentro.findAll", query="SELECT s FROM SgdCentro s")
public class SgdCentro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgdCentroPK id;

	@Column(name="CANT_CLI_CIU")
	private BigDecimal cantCliCiu;

	@Column(name="CANT_CLI_RUR")
	private BigDecimal cantCliRur;

	@Column(name="CANT_CLI_URB")
	private BigDecimal cantCliUrb;

	@Column(name="CENTRO_DEP")
	private BigDecimal centroDep;

	@Column(name="CMD_DEP")
	private BigDecimal cmdDep;

	@Column(name="COD_CALLE")
	private BigDecimal codCalle;

	@Column(name="COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name="COD_LOCAL")
	private BigDecimal codLocal;

	@Column(name="COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name="COD_PROV")
	private BigDecimal codProv;

	private BigDecimal consumo;

	private String duplicador;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	@Column(name="MESA_DEP")
	private BigDecimal mesaDep;

	@Column(name="NOM_CENTRO")
	private String nomCentro;

	@Column(name="NRO_CLIENTES")
	private BigDecimal nroClientes;

	@Column(name="NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name="POT_CIU")
	private BigDecimal potCiu;

	@Column(name="POT_CONTRATADA")
	private BigDecimal potContratada;

	@Column(name="POT_INSTALADA")
	private BigDecimal potInstalada;

	@Column(name="POT_RUR")
	private BigDecimal potRur;

	@Column(name="POT_URB")
	private BigDecimal potUrb;

	private String programa;

	private String usuario;

	public SgdCentro() {
	}

	public SgdCentroPK getId() {
		return this.id;
	}

	public void setId(SgdCentroPK id) {
		this.id = id;
	}

	public BigDecimal getCantCliCiu() {
		return this.cantCliCiu;
	}

	public void setCantCliCiu(BigDecimal cantCliCiu) {
		this.cantCliCiu = cantCliCiu;
	}

	public BigDecimal getCantCliRur() {
		return this.cantCliRur;
	}

	public void setCantCliRur(BigDecimal cantCliRur) {
		this.cantCliRur = cantCliRur;
	}

	public BigDecimal getCantCliUrb() {
		return this.cantCliUrb;
	}

	public void setCantCliUrb(BigDecimal cantCliUrb) {
		this.cantCliUrb = cantCliUrb;
	}

	public BigDecimal getCentroDep() {
		return this.centroDep;
	}

	public void setCentroDep(BigDecimal centroDep) {
		this.centroDep = centroDep;
	}

	public BigDecimal getCmdDep() {
		return this.cmdDep;
	}

	public void setCmdDep(BigDecimal cmdDep) {
		this.cmdDep = cmdDep;
	}

	public BigDecimal getCodCalle() {
		return this.codCalle;
	}

	public void setCodCalle(BigDecimal codCalle) {
		this.codCalle = codCalle;
	}

	public BigDecimal getCodDepto() {
		return this.codDepto;
	}

	public void setCodDepto(BigDecimal codDepto) {
		this.codDepto = codDepto;
	}

	public BigDecimal getCodLocal() {
		return this.codLocal;
	}

	public void setCodLocal(BigDecimal codLocal) {
		this.codLocal = codLocal;
	}

	public BigDecimal getCodMunic() {
		return this.codMunic;
	}

	public void setCodMunic(BigDecimal codMunic) {
		this.codMunic = codMunic;
	}

	public BigDecimal getCodProv() {
		return this.codProv;
	}

	public void setCodProv(BigDecimal codProv) {
		this.codProv = codProv;
	}

	public BigDecimal getConsumo() {
		return this.consumo;
	}

	public void setConsumo(BigDecimal consumo) {
		this.consumo = consumo;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public void setDuplicador(String duplicador) {
		this.duplicador = duplicador;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public BigDecimal getMesaDep() {
		return this.mesaDep;
	}

	public void setMesaDep(BigDecimal mesaDep) {
		this.mesaDep = mesaDep;
	}

	public String getNomCentro() {
		return this.nomCentro;
	}

	public void setNomCentro(String nomCentro) {
		this.nomCentro = nomCentro;
	}

	public BigDecimal getNroClientes() {
		return this.nroClientes;
	}

	public void setNroClientes(BigDecimal nroClientes) {
		this.nroClientes = nroClientes;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public void setNumPuerta(BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public BigDecimal getPotCiu() {
		return this.potCiu;
	}

	public void setPotCiu(BigDecimal potCiu) {
		this.potCiu = potCiu;
	}

	public BigDecimal getPotContratada() {
		return this.potContratada;
	}

	public void setPotContratada(BigDecimal potContratada) {
		this.potContratada = potContratada;
	}

	public BigDecimal getPotInstalada() {
		return this.potInstalada;
	}

	public void setPotInstalada(BigDecimal potInstalada) {
		this.potInstalada = potInstalada;
	}

	public BigDecimal getPotRur() {
		return this.potRur;
	}

	public void setPotRur(BigDecimal potRur) {
		this.potRur = potRur;
	}

	public BigDecimal getPotUrb() {
		return this.potUrb;
	}

	public void setPotUrb(BigDecimal potUrb) {
		this.potUrb = potUrb;
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