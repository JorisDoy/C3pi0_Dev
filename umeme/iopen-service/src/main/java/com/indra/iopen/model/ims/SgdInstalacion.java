package com.indra.iopen.model.ims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SGD_INSTALACION database table.
 *
 */
@Entity
@Table(name = "SGD_INSTALACION@IMS",schema="IMSPROD")
@NamedQuery(name = "SgdInstalacion.findAll", query = "SELECT s FROM SgdInstalacion s")
public class SgdInstalacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgdInstalacionPK id;

	@Column(name = "CAN_CLI_IMP")
	private BigDecimal canCliImp;

	@Column(name = "CANT_CLI")
	private BigDecimal cantCli;

	@Column(name = "CO_NIVEL")
	private BigDecimal coNivel;

	@Column(name = "COD_CALLE")
	private BigDecimal codCalle;

	@Column(name = "COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name = "COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name = "COD_PROP_INST")
	private String codPropInst;

	@Column(name = "COD_PROV")
	private BigDecimal codProv;

	private String descripcion;

	private String duplicador;

	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_MOVIMIENTO")
	private Date fMovimiento;

	@Temporal(TemporalType.DATE)
	private Date fechaser;

	@Temporal(TemporalType.DATE)
	@Column(name = "H_ACTUAL")
	private Date hActual;

	@Column(name = "KM_LAEREAS")
	private BigDecimal kmLaereas;

	@Column(name = "KM_LSUBTERRANEAS")
	private BigDecimal kmLsubterraneas;

	private BigDecimal kwh;

	@Column(name = "KWH_FACT")
	private BigDecimal kwhFact;

	private String matricula;

	@Column(name = "NOM_INSTALACION")
	private String nomInstalacion;

	@Column(name = "NRO_CENTRO")
	private BigDecimal nroCentro;

	@Column(name = "NRO_CMD")
	private BigDecimal nroCmd;

	@Column(name = "NRO_CMD_REAL")
	private BigDecimal nroCmdReal;

	@Column(name = "NRO_INST_PADRE")
	private BigDecimal nroInstPadre;

	@Column(name = "NRO_INST_UNIFICADA")
	private BigDecimal nroInstUnificada;

	@Column(name = "NRO_MESA")
	private BigDecimal nroMesa;

	@Column(name = "NRO_PUESTO_REAL")
	private BigDecimal nroPuestoReal;

	@Column(name = "NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name = "POT_CONTRATADA")
	private BigDecimal potContratada;

	@Column(name = "POT_INSTALADA")
	private BigDecimal potInstalada;

	private String programa;

	@Column(name = "REF_DIR")
	private String refDir;

	@Column(name = "STAT_FLG")
	private BigDecimal statFlg;

	private BigDecimal tension;

	@Column(name = "TIP_TENSION")
	private BigDecimal tipTension;

	@Column(name = "TIPO_AREA")
	private String tipoArea;

	@Column(name = "TIPO_CONEXION")
	private BigDecimal tipoConexion;

	@Column(name = "TIPO_CT")
	private BigDecimal tipoCt;

	@Column(name = "TIPO_INSTALACION")
	private BigDecimal tipoInstalacion;

	private String usuario;

	public SgdInstalacion() {
	}

	public SgdInstalacionPK getId() {
		return this.id;
	}

	public void setId(SgdInstalacionPK id) {
		this.id = id;
	}

	public BigDecimal getCanCliImp() {
		return this.canCliImp;
	}

	public void setCanCliImp(BigDecimal canCliImp) {
		this.canCliImp = canCliImp;
	}

	public BigDecimal getCantCli() {
		return this.cantCli;
	}

	public void setCantCli(BigDecimal cantCli) {
		this.cantCli = cantCli;
	}

	public BigDecimal getCoNivel() {
		return this.coNivel;
	}

	public void setCoNivel(BigDecimal coNivel) {
		this.coNivel = coNivel;
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

	public BigDecimal getCodMunic() {
		return this.codMunic;
	}

	public void setCodMunic(BigDecimal codMunic) {
		this.codMunic = codMunic;
	}

	public String getCodPropInst() {
		return this.codPropInst;
	}

	public void setCodPropInst(String codPropInst) {
		this.codPropInst = codPropInst;
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

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFMovimiento() {
		return this.fMovimiento;
	}

	public void setFMovimiento(Date fMovimiento) {
		this.fMovimiento = fMovimiento;
	}

	public Date getFechaser() {
		return this.fechaser;
	}

	public void setFechaser(Date fechaser) {
		this.fechaser = fechaser;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public BigDecimal getKmLaereas() {
		return this.kmLaereas;
	}

	public void setKmLaereas(BigDecimal kmLaereas) {
		this.kmLaereas = kmLaereas;
	}

	public BigDecimal getKmLsubterraneas() {
		return this.kmLsubterraneas;
	}

	public void setKmLsubterraneas(BigDecimal kmLsubterraneas) {
		this.kmLsubterraneas = kmLsubterraneas;
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

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomInstalacion() {
		return this.nomInstalacion;
	}

	public void setNomInstalacion(String nomInstalacion) {
		this.nomInstalacion = nomInstalacion;
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

	public BigDecimal getNroCmdReal() {
		return this.nroCmdReal;
	}

	public void setNroCmdReal(BigDecimal nroCmdReal) {
		this.nroCmdReal = nroCmdReal;
	}

	public BigDecimal getNroInstPadre() {
		return this.nroInstPadre;
	}

	public void setNroInstPadre(BigDecimal nroInstPadre) {
		this.nroInstPadre = nroInstPadre;
	}

	public BigDecimal getNroInstUnificada() {
		return this.nroInstUnificada;
	}

	public void setNroInstUnificada(BigDecimal nroInstUnificada) {
		this.nroInstUnificada = nroInstUnificada;
	}

	public BigDecimal getNroMesa() {
		return this.nroMesa;
	}

	public void setNroMesa(BigDecimal nroMesa) {
		this.nroMesa = nroMesa;
	}

	public BigDecimal getNroPuestoReal() {
		return this.nroPuestoReal;
	}

	public void setNroPuestoReal(BigDecimal nroPuestoReal) {
		this.nroPuestoReal = nroPuestoReal;
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

	public BigDecimal getPotInstalada() {
		return this.potInstalada;
	}

	public void setPotInstalada(BigDecimal potInstalada) {
		this.potInstalada = potInstalada;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getRefDir() {
		return this.refDir;
	}

	public void setRefDir(String refDir) {
		this.refDir = refDir;
	}

	public BigDecimal getStatFlg() {
		return this.statFlg;
	}

	public void setStatFlg(BigDecimal statFlg) {
		this.statFlg = statFlg;
	}

	public BigDecimal getTension() {
		return this.tension;
	}

	public void setTension(BigDecimal tension) {
		this.tension = tension;
	}

	public BigDecimal getTipTension() {
		return this.tipTension;
	}

	public void setTipTension(BigDecimal tipTension) {
		this.tipTension = tipTension;
	}

	public String getTipoArea() {
		return this.tipoArea;
	}

	public void setTipoArea(String tipoArea) {
		this.tipoArea = tipoArea;
	}

	public BigDecimal getTipoConexion() {
		return this.tipoConexion;
	}

	public void setTipoConexion(BigDecimal tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public BigDecimal getTipoCt() {
		return this.tipoCt;
	}

	public void setTipoCt(BigDecimal tipoCt) {
		this.tipoCt = tipoCt;
	}

	public BigDecimal getTipoInstalacion() {
		return this.tipoInstalacion;
	}

	public void setTipoInstalacion(BigDecimal tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}