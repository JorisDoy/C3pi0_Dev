package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SGD_ACOMETIDA database table.
 * 
 */
@Entity
@Table(name="SGD_ACOMETIDA")
@NamedQuery(name="SgdAcometida.findAll", query="SELECT s FROM SgdAcometida s")
public class SgdAcometida implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgdAcometidaPK id;

	@Column(name="CANT_CLI")
	private BigDecimal cantCli;

	@Column(name="CANT_CLIENTES_IMP")
	private BigDecimal cantClientesImp;

	@Column(name="CLASS_ID")
	private BigDecimal classId;

	@Column(name="CLAVE_HORIZONTAL")
	private String claveHorizontal;

	@Column(name="COD_CALLE")
	private BigDecimal codCalle;

	@Column(name="COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name="COD_LOC")
	private BigDecimal codLoc;

	@Column(name="COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name="COD_PROV")
	private BigDecimal codProv;

	private String descripcion;

	private String duplicador;

	@Column(name="ESTA_EN")
	private BigDecimal estaEn;

	@Column(name="ESTA_EN1")
	private BigDecimal estaEn1;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="INSTALACION_ORIGEN")
	private BigDecimal instalacionOrigen;

	private BigDecimal kwh;

	@Column(name="KWH_FACT")
	private BigDecimal kwhFact;

	private BigDecimal longitud;

	private BigDecimal nif;

	@Column(name="NRO_ACO_SUM")
	private BigDecimal nroAcoSum;

	@Column(name="NRO_CENTRO")
	private BigDecimal nroCentro;

	@Column(name="NRO_CMD")
	private BigDecimal nroCmd;

	@Column(name="NRO_MESA")
	private BigDecimal nroMesa;

	@Column(name="NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name="POT_CONTRATADA")
	private BigDecimal potContratada;

	@Column(name="POTENCIA_MAX")
	private BigDecimal potenciaMax;

	private String programa;

	private String propiedad;

	@Column(name="REF_DIR")
	private String refDir;

	private BigDecimal statflg;

	private BigDecimal tension;

	@Column(name="TIP_ACOMETIDA")
	private String tipAcometida;

	@Column(name="TIP_PROTECCION")
	private String tipProteccion;

	@Column(name="TIPO_CONEXION")
	private BigDecimal tipoConexion;

	private String usuario;

	public SgdAcometida() {
	}

	public SgdAcometidaPK getId() {
		return this.id;
	}

	public void setId(SgdAcometidaPK id) {
		this.id = id;
	}

	public BigDecimal getCantCli() {
		return this.cantCli;
	}

	public void setCantCli(BigDecimal cantCli) {
		this.cantCli = cantCli;
	}

	public BigDecimal getCantClientesImp() {
		return this.cantClientesImp;
	}

	public void setCantClientesImp(BigDecimal cantClientesImp) {
		this.cantClientesImp = cantClientesImp;
	}

	public BigDecimal getClassId() {
		return this.classId;
	}

	public void setClassId(BigDecimal classId) {
		this.classId = classId;
	}

	public String getClaveHorizontal() {
		return this.claveHorizontal;
	}

	public void setClaveHorizontal(String claveHorizontal) {
		this.claveHorizontal = claveHorizontal;
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

	public BigDecimal getCodLoc() {
		return this.codLoc;
	}

	public void setCodLoc(BigDecimal codLoc) {
		this.codLoc = codLoc;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public void setDuplicador(String duplicador) {
		this.duplicador = duplicador;
	}

	public BigDecimal getEstaEn() {
		return this.estaEn;
	}

	public void setEstaEn(BigDecimal estaEn) {
		this.estaEn = estaEn;
	}

	public BigDecimal getEstaEn1() {
		return this.estaEn1;
	}

	public void setEstaEn1(BigDecimal estaEn1) {
		this.estaEn1 = estaEn1;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getInstalacionOrigen() {
		return this.instalacionOrigen;
	}

	public void setInstalacionOrigen(BigDecimal instalacionOrigen) {
		this.instalacionOrigen = instalacionOrigen;
	}

	public BigDecimal getKwh() {
		return this.kwh;
	}

	public void setKwh(BigDecimal kwh) {
		this.kwh = kwh;
	}

	public BigDecimal getKwhFact() {
		return this.kwhFact;
	}

	public void setKwhFact(BigDecimal kwhFact) {
		this.kwhFact = kwhFact;
	}

	public BigDecimal getLongitud() {
		return this.longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public BigDecimal getNif() {
		return this.nif;
	}

	public void setNif(BigDecimal nif) {
		this.nif = nif;
	}

	public BigDecimal getNroAcoSum() {
		return this.nroAcoSum;
	}

	public void setNroAcoSum(BigDecimal nroAcoSum) {
		this.nroAcoSum = nroAcoSum;
	}

	public BigDecimal getNroCentro() {
		return this.nroCentro;
	}

	public void setNroCentro(BigDecimal nroCentro) {
		this.nroCentro = nroCentro;
	}

	public BigDecimal getNroCmd() {
		return this.nroCmd;
	}

	public void setNroCmd(BigDecimal nroCmd) {
		this.nroCmd = nroCmd;
	}

	public BigDecimal getNroMesa() {
		return this.nroMesa;
	}

	public void setNroMesa(BigDecimal nroMesa) {
		this.nroMesa = nroMesa;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public void setNumPuerta(BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public BigDecimal getPotContratada() {
		return this.potContratada;
	}

	public void setPotContratada(BigDecimal potContratada) {
		this.potContratada = potContratada;
	}

	public BigDecimal getPotenciaMax() {
		return this.potenciaMax;
	}

	public void setPotenciaMax(BigDecimal potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getPropiedad() {
		return this.propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public void setRefDir(String refDir) {
		this.refDir = refDir;
	}

	public BigDecimal getStatflg() {
		return this.statflg;
	}

	public void setStatflg(BigDecimal statflg) {
		this.statflg = statflg;
	}

	public BigDecimal getTension() {
		return this.tension;
	}

	public void setTension(BigDecimal tension) {
		this.tension = tension;
	}

	public String getTipAcometida() {
		return this.tipAcometida;
	}

	public void setTipAcometida(String tipAcometida) {
		this.tipAcometida = tipAcometida;
	}

	public String getTipProteccion() {
		return this.tipProteccion;
	}

	public void setTipProteccion(String tipProteccion) {
		this.tipProteccion = tipProteccion;
	}

	public BigDecimal getTipoConexion() {
		return this.tipoConexion;
	}

	public void setTipoConexion(BigDecimal tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}