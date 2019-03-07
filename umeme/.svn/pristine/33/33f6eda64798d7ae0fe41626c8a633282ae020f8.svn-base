package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GI_AVISOS database table.
 * 
 */
@Entity
@Table(name="GI_AVISOS")
@NamedQuery(name="GiAviso.findAll", query="SELECT g FROM GiAviso g")
public class GiAviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NRO_AVISO")
	private long nroAviso;

	private String ape1;

	private String ape2;

	@Column(name="AREA_REP")
	private BigDecimal areaRep;

	@Column(name="CGV_SUM")
	private String cgvSum;

	@Column(name="CLASE_AVISO")
	private BigDecimal claseAviso;

	@Column(name="CO_ALCANCE")
	private BigDecimal coAlcance;

	@Column(name="CO_PAIS")
	private String coPais;

	@Column(name="COD_CALLE")
	private BigDecimal codCalle;

	@Column(name="COD_DEPTO")
	private BigDecimal codDepto;

	@Column(name="COD_HORARIO")
	private BigDecimal codHorario;

	@Column(name="COD_LOC")
	private BigDecimal codLoc;

	@Column(name="COD_MUNIC")
	private BigDecimal codMunic;

	@Column(name="COD_PROV")
	private BigDecimal codProv;

	@Column(name="DOC_ID")
	private String docId;

	private String duplicador;

	private BigDecimal eb4005;

	private String esquina;

	@Column(name="EST_AVISO")
	private BigDecimal estAviso;

	@Column(name="EST_WIRELESS")
	private String estWireless;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ALTA")
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="F_RESOL_TRIGGER")
	private Date fResolTrigger;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_BATCH")
	private Date fechaBatch;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PROBLEMA")
	private Date fechaProblema;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_RES")
	private Date fechaRes;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_RES_ANULACION")
	private Date fechaResAnulacion;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ALTA")
	private Date hAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="HORA_RES")
	private Date horaRes;

	@Column(name="INCIDENCIA_ANULACION")
	private BigDecimal incidenciaAnulacion;

	@Column(name="IND_AVISO")
	private String indAviso;

	@Column(name="IND_AYUDA")
	private BigDecimal indAyuda;

	@Column(name="IND_BLOQUEO")
	private BigDecimal indBloqueo;

	@Column(name="IND_CALIDAD")
	private BigDecimal indCalidad;

	@Column(name="IND_CLI_IMP")
	private BigDecimal indCliImp;

	@Column(name="IND_IMPROCEDENTE")
	private BigDecimal indImprocedente;

	@Column(name="IND_INC_ASOC")
	private BigDecimal indIncAsoc;

	@Column(name="IND_INC_MANUAL")
	private BigDecimal indIncManual;

	@Column(name="IND_PELIGRO")
	private BigDecimal indPeligro;

	@Column(name="IND_SUPPLY")
	private BigDecimal indSupply;

	@Column(name="INSTALACION_CON_INT")
	private BigDecimal instalacionConInt;

	@Column(name="NIS_RAD")
	private BigDecimal nisRad;

	@Column(name="NOM_CALLE")
	private String nomCalle;

	@Column(name="NOM_DEPTO")
	private String nomDepto;

	@Column(name="NOM_LOC")
	private String nomLoc;

	@Column(name="NOM_MUNIC")
	private String nomMunic;

	@Column(name="NOM_PROV")
	private String nomProv;

	private String nombre;

	@Column(name="NRO_CENTRO")
	private BigDecimal nroCentro;

	@Column(name="NRO_CMD")
	private BigDecimal nroCmd;

	@Column(name="NRO_INC_TRIGGER")
	private BigDecimal nroIncTrigger;

	@Column(name="NRO_INCIDENCIA")
	private BigDecimal nroIncidencia;

	@Column(name="NRO_INSTALACION")
	private BigDecimal nroInstalacion;

	@Column(name="NRO_LLAMADAS")
	private BigDecimal nroLlamadas;

	@Column(name="NRO_MESA")
	private BigDecimal nroMesa;

	@Column(name="NRO_OT")
	private BigDecimal nroOt;

	@Column(name="NRO_TELEFONISTA")
	private String nroTelefonista;

	@Column(name="NRO_TELEGESTIONES")
	private BigDecimal nroTelegestiones;

	@Column(name="NUM_PUERTA")
	private BigDecimal numPuerta;

	@Column(name="OBS_CMD")
	private String obsCmd;

	@Column(name="OBS_IMPROC")
	private String obsImproc;

	@Column(name="OBS_TELEGESTIONES")
	private String obsTelegestiones;

	@Column(name="ORDEN_AGRUPACION")
	private BigDecimal ordenAgrupacion;

	private String poblacion;

	private BigDecimal prioridad;

	private String programa;

	@Column(name="REF_DIR")
	private String refDir;

	@Column(name="TFNO_CLI")
	private String tfnoCli;

	@Column(name="TIP_AVISO")
	private BigDecimal tipAviso;

	@Column(name="TIP_DOC")
	private String tipDoc;

	@Column(name="TIPO_VIA")
	private String tipoVia;

	private String usuario;

	@Column(name="USUARIO_BLOQUEO")
	private String usuarioBloqueo;

	public GiAviso() {
	}

	public long getNroAviso() {
		return this.nroAviso;
	}

	public void setNroAviso(long nroAviso) {
		this.nroAviso = nroAviso;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public BigDecimal getAreaRep() {
		return this.areaRep;
	}

	public void setAreaRep(BigDecimal areaRep) {
		this.areaRep = areaRep;
	}

	public String getCgvSum() {
		return this.cgvSum;
	}

	public void setCgvSum(String cgvSum) {
		this.cgvSum = cgvSum;
	}

	public BigDecimal getClaseAviso() {
		return this.claseAviso;
	}

	public void setClaseAviso(BigDecimal claseAviso) {
		this.claseAviso = claseAviso;
	}

	public BigDecimal getCoAlcance() {
		return this.coAlcance;
	}

	public void setCoAlcance(BigDecimal coAlcance) {
		this.coAlcance = coAlcance;
	}

	public String getCoPais() {
		return this.coPais;
	}

	public void setCoPais(String coPais) {
		this.coPais = coPais;
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

	public BigDecimal getCodHorario() {
		return this.codHorario;
	}

	public void setCodHorario(BigDecimal codHorario) {
		this.codHorario = codHorario;
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

	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDuplicador() {
		return this.duplicador;
	}

	public void setDuplicador(String duplicador) {
		this.duplicador = duplicador;
	}

	public BigDecimal getEb4005() {
		return this.eb4005;
	}

	public void setEb4005(BigDecimal eb4005) {
		this.eb4005 = eb4005;
	}

	public String getEsquina() {
		return this.esquina;
	}

	public void setEsquina(String esquina) {
		this.esquina = esquina;
	}

	public BigDecimal getEstAviso() {
		return this.estAviso;
	}

	public void setEstAviso(BigDecimal estAviso) {
		this.estAviso = estAviso;
	}

	public String getEstWireless() {
		return this.estWireless;
	}

	public void setEstWireless(String estWireless) {
		this.estWireless = estWireless;
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

	public Date getFResolTrigger() {
		return this.fResolTrigger;
	}

	public void setFResolTrigger(Date fResolTrigger) {
		this.fResolTrigger = fResolTrigger;
	}

	public Date getFechaBatch() {
		return this.fechaBatch;
	}

	public void setFechaBatch(Date fechaBatch) {
		this.fechaBatch = fechaBatch;
	}

	public Date getFechaProblema() {
		return this.fechaProblema;
	}

	public void setFechaProblema(Date fechaProblema) {
		this.fechaProblema = fechaProblema;
	}

	public Date getFechaRes() {
		return this.fechaRes;
	}

	public void setFechaRes(Date fechaRes) {
		this.fechaRes = fechaRes;
	}

	public Date getFechaResAnulacion() {
		return this.fechaResAnulacion;
	}

	public void setFechaResAnulacion(Date fechaResAnulacion) {
		this.fechaResAnulacion = fechaResAnulacion;
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

	public Date getHoraRes() {
		return this.horaRes;
	}

	public void setHoraRes(Date horaRes) {
		this.horaRes = horaRes;
	}

	public BigDecimal getIncidenciaAnulacion() {
		return this.incidenciaAnulacion;
	}

	public void setIncidenciaAnulacion(BigDecimal incidenciaAnulacion) {
		this.incidenciaAnulacion = incidenciaAnulacion;
	}

	public String getIndAviso() {
		return this.indAviso;
	}

	public void setIndAviso(String indAviso) {
		this.indAviso = indAviso;
	}

	public BigDecimal getIndAyuda() {
		return this.indAyuda;
	}

	public void setIndAyuda(BigDecimal indAyuda) {
		this.indAyuda = indAyuda;
	}

	public BigDecimal getIndBloqueo() {
		return this.indBloqueo;
	}

	public void setIndBloqueo(BigDecimal indBloqueo) {
		this.indBloqueo = indBloqueo;
	}

	public BigDecimal getIndCalidad() {
		return this.indCalidad;
	}

	public void setIndCalidad(BigDecimal indCalidad) {
		this.indCalidad = indCalidad;
	}

	public BigDecimal getIndCliImp() {
		return this.indCliImp;
	}

	public void setIndCliImp(BigDecimal indCliImp) {
		this.indCliImp = indCliImp;
	}

	public BigDecimal getIndImprocedente() {
		return this.indImprocedente;
	}

	public void setIndImprocedente(BigDecimal indImprocedente) {
		this.indImprocedente = indImprocedente;
	}

	public BigDecimal getIndIncAsoc() {
		return this.indIncAsoc;
	}

	public void setIndIncAsoc(BigDecimal indIncAsoc) {
		this.indIncAsoc = indIncAsoc;
	}

	public BigDecimal getIndIncManual() {
		return this.indIncManual;
	}

	public void setIndIncManual(BigDecimal indIncManual) {
		this.indIncManual = indIncManual;
	}

	public BigDecimal getIndPeligro() {
		return this.indPeligro;
	}

	public void setIndPeligro(BigDecimal indPeligro) {
		this.indPeligro = indPeligro;
	}

	public BigDecimal getIndSupply() {
		return this.indSupply;
	}

	public void setIndSupply(BigDecimal indSupply) {
		this.indSupply = indSupply;
	}

	public BigDecimal getInstalacionConInt() {
		return this.instalacionConInt;
	}

	public void setInstalacionConInt(BigDecimal instalacionConInt) {
		this.instalacionConInt = instalacionConInt;
	}

	public BigDecimal getNisRad() {
		return this.nisRad;
	}

	public void setNisRad(BigDecimal nisRad) {
		this.nisRad = nisRad;
	}

	public String getNomCalle() {
		return this.nomCalle;
	}

	public void setNomCalle(String nomCalle) {
		this.nomCalle = nomCalle;
	}

	public String getNomDepto() {
		return this.nomDepto;
	}

	public void setNomDepto(String nomDepto) {
		this.nomDepto = nomDepto;
	}

	public String getNomLoc() {
		return this.nomLoc;
	}

	public void setNomLoc(String nomLoc) {
		this.nomLoc = nomLoc;
	}

	public String getNomMunic() {
		return this.nomMunic;
	}

	public void setNomMunic(String nomMunic) {
		this.nomMunic = nomMunic;
	}

	public String getNomProv() {
		return this.nomProv;
	}

	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public BigDecimal getNroIncTrigger() {
		return this.nroIncTrigger;
	}

	public void setNroIncTrigger(BigDecimal nroIncTrigger) {
		this.nroIncTrigger = nroIncTrigger;
	}

	public BigDecimal getNroIncidencia() {
		return this.nroIncidencia;
	}

	public void setNroIncidencia(BigDecimal nroIncidencia) {
		this.nroIncidencia = nroIncidencia;
	}

	public BigDecimal getNroInstalacion() {
		return this.nroInstalacion;
	}

	public void setNroInstalacion(BigDecimal nroInstalacion) {
		this.nroInstalacion = nroInstalacion;
	}

	public BigDecimal getNroLlamadas() {
		return this.nroLlamadas;
	}

	public void setNroLlamadas(BigDecimal nroLlamadas) {
		this.nroLlamadas = nroLlamadas;
	}

	public BigDecimal getNroMesa() {
		return this.nroMesa;
	}

	public void setNroMesa(BigDecimal nroMesa) {
		this.nroMesa = nroMesa;
	}

	public BigDecimal getNroOt() {
		return this.nroOt;
	}

	public void setNroOt(BigDecimal nroOt) {
		this.nroOt = nroOt;
	}

	public String getNroTelefonista() {
		return this.nroTelefonista;
	}

	public void setNroTelefonista(String nroTelefonista) {
		this.nroTelefonista = nroTelefonista;
	}

	public BigDecimal getNroTelegestiones() {
		return this.nroTelegestiones;
	}

	public void setNroTelegestiones(BigDecimal nroTelegestiones) {
		this.nroTelegestiones = nroTelegestiones;
	}

	public BigDecimal getNumPuerta() {
		return this.numPuerta;
	}

	public void setNumPuerta(BigDecimal numPuerta) {
		this.numPuerta = numPuerta;
	}

	public String getObsCmd() {
		return this.obsCmd;
	}

	public void setObsCmd(String obsCmd) {
		this.obsCmd = obsCmd;
	}

	public String getObsImproc() {
		return this.obsImproc;
	}

	public void setObsImproc(String obsImproc) {
		this.obsImproc = obsImproc;
	}

	public String getObsTelegestiones() {
		return this.obsTelegestiones;
	}

	public void setObsTelegestiones(String obsTelegestiones) {
		this.obsTelegestiones = obsTelegestiones;
	}

	public BigDecimal getOrdenAgrupacion() {
		return this.ordenAgrupacion;
	}

	public void setOrdenAgrupacion(BigDecimal ordenAgrupacion) {
		this.ordenAgrupacion = ordenAgrupacion;
	}

	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public BigDecimal getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(BigDecimal prioridad) {
		this.prioridad = prioridad;
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

	public String getTfnoCli() {
		return this.tfnoCli;
	}

	public void setTfnoCli(String tfnoCli) {
		this.tfnoCli = tfnoCli;
	}

	public BigDecimal getTipAviso() {
		return this.tipAviso;
	}

	public void setTipAviso(BigDecimal tipAviso) {
		this.tipAviso = tipAviso;
	}

	public String getTipDoc() {
		return this.tipDoc;
	}

	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	public String getTipoVia() {
		return this.tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioBloqueo() {
		return this.usuarioBloqueo;
	}

	public void setUsuarioBloqueo(String usuarioBloqueo) {
		this.usuarioBloqueo = usuarioBloqueo;
	}

}