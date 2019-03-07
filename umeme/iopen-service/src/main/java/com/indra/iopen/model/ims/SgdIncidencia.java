package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SGD_INCIDENCIA database table.
 * 
 */
@Entity
@Table(name="SGD_INCIDENCIA@IMS",schema="DCSPROD")
@NamedQuery(name="SgdIncidencia.findAll", query="SELECT s FROM SgdIncidencia s")
public class SgdIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NRO_INCIDENCIA")
	private long nroIncidencia;

	private BigDecimal agente;

	private BigDecimal alcance;

	@Column(name="AREA_AFEC")
	private String areaAfec;

	private BigDecimal asai;

	private BigDecimal caidi;

	@Column(name="CAN_CLI")
	private BigDecimal canCli;

	@Column(name="CANT_AVISOS")
	private BigDecimal cantAvisos;

	@Column(name="CCLI_AFEC")
	private BigDecimal ccliAfec;

	@Column(name="CCLI_AFEC_IND")
	private BigDecimal ccliAfecInd;

	@Column(name="CENTRO_ALTA")
	private BigDecimal centroAlta;

	@Column(name="CMD_ALTA")
	private BigDecimal cmdAlta;

	@Column(name="COD_CAUSA")
	private BigDecimal codCausa;

	@Column(name="COD_EST_CLIMA")
	private BigDecimal codEstClima;

	@Column(name="COD_HOR")
	private BigDecimal codHor;

	@Column(name="COD_MOTIVO")
	private BigDecimal codMotivo;

	@Column(name="CORTE_SR")
	private BigDecimal corteSr;

	@Column(name="DER_MANT_EN_CORTE")
	private BigDecimal derMantEnCorte;

	@Column(name="DESC_INCIDENCIA")
	private String descIncidencia;

	@Column(name="DESCRIPCION_MOTIVO")
	private String descripcionMotivo;

	@Column(name="DIR_AVISO")
	private String dirAviso;

	private BigDecimal duracion;

	@Column(name="DURACION_CE")
	private BigDecimal duracionCe;

	@Column(name="DURACION_CL")
	private BigDecimal duracionCl;

	@Column(name="DURACION_CL_SR")
	private BigDecimal duracionClSr;

	@Column(name="DURACION_EB_CL")
	private BigDecimal duracionEbCl;

	@Column(name="DURACION_EB_ER")
	private BigDecimal duracionEbEr;

	@Column(name="DURACION_ENV_BRIGADA")
	private BigDecimal duracionEnvBrigada;

	@Column(name="DURACION_ER")
	private BigDecimal duracionEr;

	@Column(name="DURACION_ER_SR")
	private BigDecimal duracionErSr;

	@Column(name="DURACION_MANT")
	private BigDecimal duracionMant;

	@Column(name="DURACION_MANT_CORTE")
	private BigDecimal duracionMantCorte;

	@Column(name="DURACION_MTO_CE")
	private BigDecimal duracionMtoCe;

	@Column(name="DURACION_RS")
	private BigDecimal duracionRs;

	@Column(name="DURACION_SR")
	private BigDecimal duracionSr;

	private BigDecimal eb4001;

	private BigDecimal eb4002;

	private BigDecimal eb4003;

	private BigDecimal eb4004;

	private BigDecimal eb4007;

	@Column(name="EB4007_EST")
	private BigDecimal eb4007Est;

	private BigDecimal eb6203;

	private BigDecimal eb7000;

	@Column(name="ELTO_SINSERV")
	private BigDecimal eltoSinserv;

	@Column(name="EST_ACTUAL")
	private BigDecimal estActual;

	@Column(name="ESTADO_ANTERIOR")
	private BigDecimal estadoAnterior;

	@Column(name="ESTADO_BATCH")
	private BigDecimal estadoBatch;

	@Column(name="ESTADO_MANTENIMIENTO")
	private BigDecimal estadoMantenimiento;

	@Column(name="ESTADO_RED")
	private BigDecimal estadoRed;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ALTA")
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="F_DETECCION")
	private Date fDeteccion;

	@Temporal(TemporalType.DATE)
	@Column(name="F_EST_RES")
	private Date fEstRes;

	@Column(name="FAM_CAUSA")
	private BigDecimal famCausa;

	@Column(name="FAM_MANT_AVER")
	private BigDecimal famMantAver;

	@Column(name="FASE_SUGERIDA")
	private String faseSugerida;

	@Column(name="FAULT_TYPE")
	private String faultType;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_CAUSA")
	private Date fecCausa;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_RESOLUCION")
	private Date fecResolucion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ANULACION")
	private Date fechaAnulacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_BATCH")
	private Date fechaBatch;

	private BigDecimal feeder;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ALTA")
	private Date hAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="H_DETECCION")
	private Date hDeteccion;

	@Temporal(TemporalType.DATE)
	@Column(name="H_EST_RES")
	private Date hEstRes;

	@Column(name="IND_ALUM_PUB")
	private BigDecimal indAlumPub;

	@Column(name="IND_ANULACION_SGI")
	private BigDecimal indAnulacionSgi;

	@Column(name="IND_OBLIGADA")
	private BigDecimal indObligada;

	@Column(name="IND_SCADA")
	private BigDecimal indScada;

	@Column(name="INSTALACION_ORIGEN")
	private BigDecimal instalacionOrigen;

	@Column(name="KWH_ESTIMADO")
	private BigDecimal kwhEstimado;

	@Column(name="LUM_REPARADAS")
	private BigDecimal lumReparadas;

	@Column(name="MAT_AVERIADO")
	private String matAveriado;

	@Column(name="NOM_DOC")
	private String nomDoc;

	@Column(name="NRO_AGRUPACION")
	private BigDecimal nroAgrupacion;

	@Column(name="NRO_BRIGADA")
	private BigDecimal nroBrigada;

	@Column(name="NRO_CENTRO")
	private BigDecimal nroCentro;

	@Column(name="NRO_CMD")
	private BigDecimal nroCmd;

	@Column(name="NRO_INST_AFECTADA")
	private Long nroInstAfectada;

	@Column(name="NRO_INST_ORIGEN")
	private BigDecimal nroInstOrigen;

	@Column(name="NRO_MESA")
	private BigDecimal nroMesa;

	@Column(name="OBSERV_MTO")
	private String observMto;

	private String observacion;

	private BigDecimal ot;

	private BigDecimal paxtc;

	private BigDecimal pcxtc;

	@Column(name="PERDIDAS_OPE")
	private BigDecimal perdidasOpe;

	@Column(name="POT_AFECTADA")
	private BigDecimal potAfectada;

	@Column(name="POT_CONTRATADA")
	private BigDecimal potContratada;

	@Column(name="PRIMER_AVISO")
	private BigDecimal primerAviso;

	private String programa;

	@Column(name="PUESTO_ALTA")
	private BigDecimal puestoAlta;

	private BigDecimal saidi;

	private BigDecimal saifi;

	@Column(name="TENSION_AFECTADA")
	private BigDecimal tensionAfectada;

	@Column(name="TENSION_ORIGEN")
	private BigDecimal tensionOrigen;

	private BigDecimal tiebt;

	@Column(name="TIEBT_APORTADO")
	private BigDecimal tiebtAportado;

	@Column(name="TIEMPO_MANT")
	private BigDecimal tiempoMant;

	@Column(name="TIEMPO_OPER")
	private BigDecimal tiempoOper;

	private BigDecimal tiepi;

	@Column(name="TIEPI_APORTADO")
	private BigDecimal tiepiAportado;

	@Column(name="TIP_INCIDENCIA")
	private BigDecimal tipIncidencia;

	@Column(name="TIP_TENSION")
	private BigDecimal tipTension;

	@Column(name="TIPO_LUMINARIA")
	private String tipoLuminaria;

	private String usuario;

	@Column(name="USUARIO_ANULACION")
	private String usuarioAnulacion;

	@Transient
	private BigDecimal x;

	@Transient
	private BigDecimal y;

	public SgdIncidencia() {
	}

	public long getNroIncidencia() {
		return this.nroIncidencia;
	}

	public void setNroIncidencia(long nroIncidencia) {
		this.nroIncidencia = nroIncidencia;
	}

	public BigDecimal getAgente() {
		return this.agente;
	}

	public void setAgente(BigDecimal agente) {
		this.agente = agente;
	}

	public BigDecimal getAlcance() {
		return this.alcance;
	}

	public void setAlcance(BigDecimal alcance) {
		this.alcance = alcance;
	}

	public String getAreaAfec() {
		return this.areaAfec;
	}

	public void setAreaAfec(String areaAfec) {
		this.areaAfec = areaAfec;
	}

	public BigDecimal getAsai() {
		return this.asai;
	}

	public void setAsai(BigDecimal asai) {
		this.asai = asai;
	}

	public BigDecimal getCaidi() {
		return this.caidi;
	}

	public void setCaidi(BigDecimal caidi) {
		this.caidi = caidi;
	}

	public BigDecimal getCanCli() {
		return this.canCli;
	}

	public void setCanCli(BigDecimal canCli) {
		this.canCli = canCli;
	}

	public BigDecimal getCantAvisos() {
		return this.cantAvisos;
	}

	public void setCantAvisos(BigDecimal cantAvisos) {
		this.cantAvisos = cantAvisos;
	}

	public BigDecimal getCcliAfec() {
		return this.ccliAfec;
	}

	public void setCcliAfec(BigDecimal ccliAfec) {
		this.ccliAfec = ccliAfec;
	}

	public BigDecimal getCcliAfecInd() {
		return this.ccliAfecInd;
	}

	public void setCcliAfecInd(BigDecimal ccliAfecInd) {
		this.ccliAfecInd = ccliAfecInd;
	}

	public BigDecimal getCentroAlta() {
		return this.centroAlta;
	}

	public void setCentroAlta(BigDecimal centroAlta) {
		this.centroAlta = centroAlta;
	}

	public BigDecimal getCmdAlta() {
		return this.cmdAlta;
	}

	public void setCmdAlta(BigDecimal cmdAlta) {
		this.cmdAlta = cmdAlta;
	}

	public BigDecimal getCodCausa() {
		return this.codCausa;
	}

	public void setCodCausa(BigDecimal codCausa) {
		this.codCausa = codCausa;
	}

	public BigDecimal getCodEstClima() {
		return this.codEstClima;
	}

	public void setCodEstClima(BigDecimal codEstClima) {
		this.codEstClima = codEstClima;
	}

	public BigDecimal getCodHor() {
		return this.codHor;
	}

	public void setCodHor(BigDecimal codHor) {
		this.codHor = codHor;
	}

	public BigDecimal getCodMotivo() {
		return this.codMotivo;
	}

	public void setCodMotivo(BigDecimal codMotivo) {
		this.codMotivo = codMotivo;
	}

	public BigDecimal getCorteSr() {
		return this.corteSr;
	}

	public void setCorteSr(BigDecimal corteSr) {
		this.corteSr = corteSr;
	}

	public BigDecimal getDerMantEnCorte() {
		return this.derMantEnCorte;
	}

	public void setDerMantEnCorte(BigDecimal derMantEnCorte) {
		this.derMantEnCorte = derMantEnCorte;
	}

	public String getDescIncidencia() {
		return this.descIncidencia;
	}

	public void setDescIncidencia(String descIncidencia) {
		this.descIncidencia = descIncidencia;
	}

	public String getDescripcionMotivo() {
		return this.descripcionMotivo;
	}

	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	public String getDirAviso() {
		return this.dirAviso;
	}

	public void setDirAviso(String dirAviso) {
		this.dirAviso = dirAviso;
	}

	public BigDecimal getDuracion() {
		return this.duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public BigDecimal getDuracionCe() {
		return this.duracionCe;
	}

	public void setDuracionCe(BigDecimal duracionCe) {
		this.duracionCe = duracionCe;
	}

	public BigDecimal getDuracionCl() {
		return this.duracionCl;
	}

	public void setDuracionCl(BigDecimal duracionCl) {
		this.duracionCl = duracionCl;
	}

	public BigDecimal getDuracionClSr() {
		return this.duracionClSr;
	}

	public void setDuracionClSr(BigDecimal duracionClSr) {
		this.duracionClSr = duracionClSr;
	}

	public BigDecimal getDuracionEbCl() {
		return this.duracionEbCl;
	}

	public void setDuracionEbCl(BigDecimal duracionEbCl) {
		this.duracionEbCl = duracionEbCl;
	}

	public BigDecimal getDuracionEbEr() {
		return this.duracionEbEr;
	}

	public void setDuracionEbEr(BigDecimal duracionEbEr) {
		this.duracionEbEr = duracionEbEr;
	}

	public BigDecimal getDuracionEnvBrigada() {
		return this.duracionEnvBrigada;
	}

	public void setDuracionEnvBrigada(BigDecimal duracionEnvBrigada) {
		this.duracionEnvBrigada = duracionEnvBrigada;
	}

	public BigDecimal getDuracionEr() {
		return this.duracionEr;
	}

	public void setDuracionEr(BigDecimal duracionEr) {
		this.duracionEr = duracionEr;
	}

	public BigDecimal getDuracionErSr() {
		return this.duracionErSr;
	}

	public void setDuracionErSr(BigDecimal duracionErSr) {
		this.duracionErSr = duracionErSr;
	}

	public BigDecimal getDuracionMant() {
		return this.duracionMant;
	}

	public void setDuracionMant(BigDecimal duracionMant) {
		this.duracionMant = duracionMant;
	}

	public BigDecimal getDuracionMantCorte() {
		return this.duracionMantCorte;
	}

	public void setDuracionMantCorte(BigDecimal duracionMantCorte) {
		this.duracionMantCorte = duracionMantCorte;
	}

	public BigDecimal getDuracionMtoCe() {
		return this.duracionMtoCe;
	}

	public void setDuracionMtoCe(BigDecimal duracionMtoCe) {
		this.duracionMtoCe = duracionMtoCe;
	}

	public BigDecimal getDuracionRs() {
		return this.duracionRs;
	}

	public void setDuracionRs(BigDecimal duracionRs) {
		this.duracionRs = duracionRs;
	}

	public BigDecimal getDuracionSr() {
		return this.duracionSr;
	}

	public void setDuracionSr(BigDecimal duracionSr) {
		this.duracionSr = duracionSr;
	}

	public BigDecimal getEb4001() {
		return this.eb4001;
	}

	public void setEb4001(BigDecimal eb4001) {
		this.eb4001 = eb4001;
	}

	public BigDecimal getEb4002() {
		return this.eb4002;
	}

	public void setEb4002(BigDecimal eb4002) {
		this.eb4002 = eb4002;
	}

	public BigDecimal getEb4003() {
		return this.eb4003;
	}

	public void setEb4003(BigDecimal eb4003) {
		this.eb4003 = eb4003;
	}

	public BigDecimal getEb4004() {
		return this.eb4004;
	}

	public void setEb4004(BigDecimal eb4004) {
		this.eb4004 = eb4004;
	}

	public BigDecimal getEb4007() {
		return this.eb4007;
	}

	public void setEb4007(BigDecimal eb4007) {
		this.eb4007 = eb4007;
	}

	public BigDecimal getEb4007Est() {
		return this.eb4007Est;
	}

	public void setEb4007Est(BigDecimal eb4007Est) {
		this.eb4007Est = eb4007Est;
	}

	public BigDecimal getEb6203() {
		return this.eb6203;
	}

	public void setEb6203(BigDecimal eb6203) {
		this.eb6203 = eb6203;
	}

	public BigDecimal getEb7000() {
		return this.eb7000;
	}

	public void setEb7000(BigDecimal eb7000) {
		this.eb7000 = eb7000;
	}

	public BigDecimal getEltoSinserv() {
		return this.eltoSinserv;
	}

	public void setEltoSinserv(BigDecimal eltoSinserv) {
		this.eltoSinserv = eltoSinserv;
	}

	public BigDecimal getEstActual() {
		return this.estActual;
	}

	public void setEstActual(BigDecimal estActual) {
		this.estActual = estActual;
	}

	public BigDecimal getEstadoAnterior() {
		return this.estadoAnterior;
	}

	public void setEstadoAnterior(BigDecimal estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}

	public BigDecimal getEstadoBatch() {
		return this.estadoBatch;
	}

	public void setEstadoBatch(BigDecimal estadoBatch) {
		this.estadoBatch = estadoBatch;
	}

	public BigDecimal getEstadoMantenimiento() {
		return this.estadoMantenimiento;
	}

	public void setEstadoMantenimiento(BigDecimal estadoMantenimiento) {
		this.estadoMantenimiento = estadoMantenimiento;
	}

	public BigDecimal getEstadoRed() {
		return this.estadoRed;
	}

	public void setEstadoRed(BigDecimal estadoRed) {
		this.estadoRed = estadoRed;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFAlta() {
		return this.fAlta;
	}

	public void setFAlta(Date fAlta) {
		this.fAlta = fAlta;
	}

	public Date getFDeteccion() {
		return this.fDeteccion;
	}

	public void setFDeteccion(Date fDeteccion) {
		this.fDeteccion = fDeteccion;
	}

	public Date getFEstRes() {
		return this.fEstRes;
	}

	public void setFEstRes(Date fEstRes) {
		this.fEstRes = fEstRes;
	}

	public BigDecimal getFamCausa() {
		return this.famCausa;
	}

	public void setFamCausa(BigDecimal famCausa) {
		this.famCausa = famCausa;
	}

	public BigDecimal getFamMantAver() {
		return this.famMantAver;
	}

	public void setFamMantAver(BigDecimal famMantAver) {
		this.famMantAver = famMantAver;
	}

	public String getFaseSugerida() {
		return this.faseSugerida;
	}

	public void setFaseSugerida(String faseSugerida) {
		this.faseSugerida = faseSugerida;
	}

	public String getFaultType() {
		return this.faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public Date getFecCausa() {
		return this.fecCausa;
	}

	public void setFecCausa(Date fecCausa) {
		this.fecCausa = fecCausa;
	}

	public Date getFecResolucion() {
		return this.fecResolucion;
	}

	public void setFecResolucion(Date fecResolucion) {
		this.fecResolucion = fecResolucion;
	}

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Date getFechaBatch() {
		return this.fechaBatch;
	}

	public void setFechaBatch(Date fechaBatch) {
		this.fechaBatch = fechaBatch;
	}

	public BigDecimal getFeeder() {
		return this.feeder;
	}

	public void setFeeder(BigDecimal feeder) {
		this.feeder = feeder;
	}

	public Date getHActual() {
		return this.hActual;
	}

	public void setHActual(Date hActual) {
		this.hActual = hActual;
	}

	public Date getHAlta() {
		return this.hAlta;
	}

	public void setHAlta(Date hAlta) {
		this.hAlta = hAlta;
	}

	public Date getHDeteccion() {
		return this.hDeteccion;
	}

	public void setHDeteccion(Date hDeteccion) {
		this.hDeteccion = hDeteccion;
	}

	public Date getHEstRes() {
		return this.hEstRes;
	}

	public void setHEstRes(Date hEstRes) {
		this.hEstRes = hEstRes;
	}

	public BigDecimal getIndAlumPub() {
		return this.indAlumPub;
	}

	public void setIndAlumPub(BigDecimal indAlumPub) {
		this.indAlumPub = indAlumPub;
	}

	public BigDecimal getIndAnulacionSgi() {
		return this.indAnulacionSgi;
	}

	public void setIndAnulacionSgi(BigDecimal indAnulacionSgi) {
		this.indAnulacionSgi = indAnulacionSgi;
	}

	public BigDecimal getIndObligada() {
		return this.indObligada;
	}

	public void setIndObligada(BigDecimal indObligada) {
		this.indObligada = indObligada;
	}

	public BigDecimal getIndScada() {
		return this.indScada;
	}

	public void setIndScada(BigDecimal indScada) {
		this.indScada = indScada;
	}

	public BigDecimal getInstalacionOrigen() {
		return this.instalacionOrigen;
	}

	public void setInstalacionOrigen(BigDecimal instalacionOrigen) {
		this.instalacionOrigen = instalacionOrigen;
	}

	public BigDecimal getKwhEstimado() {
		return this.kwhEstimado;
	}

	public void setKwhEstimado(BigDecimal kwhEstimado) {
		this.kwhEstimado = kwhEstimado;
	}

	public BigDecimal getLumReparadas() {
		return this.lumReparadas;
	}

	public void setLumReparadas(BigDecimal lumReparadas) {
		this.lumReparadas = lumReparadas;
	}

	public String getMatAveriado() {
		return this.matAveriado;
	}

	public void setMatAveriado(String matAveriado) {
		this.matAveriado = matAveriado;
	}

	public String getNomDoc() {
		return this.nomDoc;
	}

	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}

	public BigDecimal getNroAgrupacion() {
		return this.nroAgrupacion;
	}

	public void setNroAgrupacion(BigDecimal nroAgrupacion) {
		this.nroAgrupacion = nroAgrupacion;
	}

	public BigDecimal getNroBrigada() {
		return this.nroBrigada;
	}

	public void setNroBrigada(BigDecimal nroBrigada) {
		this.nroBrigada = nroBrigada;
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

	public Long getNroInstAfectada() {
		return this.nroInstAfectada;
	}

	public void setNroInstAfectada(Long nroInstAfectada) {
		this.nroInstAfectada = nroInstAfectada;
	}

	public BigDecimal getNroInstOrigen() {
		return this.nroInstOrigen;
	}

	public void setNroInstOrigen(BigDecimal nroInstOrigen) {
		this.nroInstOrigen = nroInstOrigen;
	}

	public BigDecimal getNroMesa() {
		return this.nroMesa;
	}

	public void setNroMesa(BigDecimal nroMesa) {
		this.nroMesa = nroMesa;
	}

	public String getObservMto() {
		return this.observMto;
	}

	public void setObservMto(String observMto) {
		this.observMto = observMto;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getOt() {
		return this.ot;
	}

	public void setOt(BigDecimal ot) {
		this.ot = ot;
	}

	public BigDecimal getPaxtc() {
		return this.paxtc;
	}

	public void setPaxtc(BigDecimal paxtc) {
		this.paxtc = paxtc;
	}

	public BigDecimal getPcxtc() {
		return this.pcxtc;
	}

	public void setPcxtc(BigDecimal pcxtc) {
		this.pcxtc = pcxtc;
	}

	public BigDecimal getPerdidasOpe() {
		return this.perdidasOpe;
	}

	public void setPerdidasOpe(BigDecimal perdidasOpe) {
		this.perdidasOpe = perdidasOpe;
	}

	public BigDecimal getPotAfectada() {
		return this.potAfectada;
	}

	public void setPotAfectada(BigDecimal potAfectada) {
		this.potAfectada = potAfectada;
	}

	public BigDecimal getPotContratada() {
		return this.potContratada;
	}

	public void setPotContratada(BigDecimal potContratada) {
		this.potContratada = potContratada;
	}

	public BigDecimal getPrimerAviso() {
		return this.primerAviso;
	}

	public void setPrimerAviso(BigDecimal primerAviso) {
		this.primerAviso = primerAviso;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getPuestoAlta() {
		return this.puestoAlta;
	}

	public void setPuestoAlta(BigDecimal puestoAlta) {
		this.puestoAlta = puestoAlta;
	}

	public BigDecimal getSaidi() {
		return this.saidi;
	}

	public void setSaidi(BigDecimal saidi) {
		this.saidi = saidi;
	}

	public BigDecimal getSaifi() {
		return this.saifi;
	}

	public void setSaifi(BigDecimal saifi) {
		this.saifi = saifi;
	}

	public BigDecimal getTensionAfectada() {
		return this.tensionAfectada;
	}

	public void setTensionAfectada(BigDecimal tensionAfectada) {
		this.tensionAfectada = tensionAfectada;
	}

	public BigDecimal getTensionOrigen() {
		return this.tensionOrigen;
	}

	public void setTensionOrigen(BigDecimal tensionOrigen) {
		this.tensionOrigen = tensionOrigen;
	}

	public BigDecimal getTiebt() {
		return this.tiebt;
	}

	public void setTiebt(BigDecimal tiebt) {
		this.tiebt = tiebt;
	}

	public BigDecimal getTiebtAportado() {
		return this.tiebtAportado;
	}

	public void setTiebtAportado(BigDecimal tiebtAportado) {
		this.tiebtAportado = tiebtAportado;
	}

	public BigDecimal getTiempoMant() {
		return this.tiempoMant;
	}

	public void setTiempoMant(BigDecimal tiempoMant) {
		this.tiempoMant = tiempoMant;
	}

	public BigDecimal getTiempoOper() {
		return this.tiempoOper;
	}

	public void setTiempoOper(BigDecimal tiempoOper) {
		this.tiempoOper = tiempoOper;
	}

	public BigDecimal getTiepi() {
		return this.tiepi;
	}

	public void setTiepi(BigDecimal tiepi) {
		this.tiepi = tiepi;
	}

	public BigDecimal getTiepiAportado() {
		return this.tiepiAportado;
	}

	public void setTiepiAportado(BigDecimal tiepiAportado) {
		this.tiepiAportado = tiepiAportado;
	}

	public BigDecimal getTipIncidencia() {
		return this.tipIncidencia;
	}

	public void setTipIncidencia(BigDecimal tipIncidencia) {
		this.tipIncidencia = tipIncidencia;
	}

	public BigDecimal getTipTension() {
		return this.tipTension;
	}

	public void setTipTension(BigDecimal tipTension) {
		this.tipTension = tipTension;
	}

	public String getTipoLuminaria() {
		return this.tipoLuminaria;
	}

	public void setTipoLuminaria(String tipoLuminaria) {
		this.tipoLuminaria = tipoLuminaria;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioAnulacion() {
		return this.usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}

	public BigDecimal getX() {
		return this.x;
	}

	public void setX(BigDecimal x) {
		this.x = x;
	}

	public BigDecimal getY() {
		return this.y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

}