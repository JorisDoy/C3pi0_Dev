package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GI_AVISOS_INSTALACION database table.
 * 
 */
@Entity
@Table(name="GI_AVISOS_INSTALACION")
@NamedQuery(name="GiAvisosInstalacion.findAll", query="SELECT g FROM GiAvisosInstalacion g")
public class GiAvisosInstalacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiAvisosInstalacionPK id;

	@Column(name="AVISO_AT")
	private BigDecimal avisoAt;

	@Column(name="CLASE_AVISO")
	private BigDecimal claseAviso;

	@Column(name="EST_AVISO")
	private BigDecimal estAviso;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ALTA")
	private Date fAlta;

	private String fase;

	@Column(name="IND_AVISO")
	private String indAviso;

	@Column(name="IND_AVISO_CONSULTADO")
	private BigDecimal indAvisoConsultado;

	@Column(name="IND_BLOQUEO")
	private BigDecimal indBloqueo;

	@Column(name="IND_INCIDENCIA")
	private BigDecimal indIncidencia;

	@Column(name="IND_OTRAS_SMT")
	private BigDecimal indOtrasSmt;

	@Column(name="IND_RED")
	private BigDecimal indRed;

	@Column(name="INSTALACION_CON_INT")
	private BigDecimal instalacionConInt;

	@Column(name="NOM_INSTALACION")
	private String nomInstalacion;

	@Column(name="NRO_CMD")
	private BigDecimal nroCmd;

	@Column(name="NRO_INST_PADRE")
	private BigDecimal nroInstPadre;

	@Column(name="NRO_OT")
	private BigDecimal nroOt;

	@Column(name="NRO_SECTOR")
	private BigDecimal nroSector;

	@Column(name="NRO_ZONA")
	private BigDecimal nroZona;

	private String programa;

	private BigDecimal tension;

	@Column(name="TIPO_AVISO")
	private BigDecimal tipoAviso;

	@Column(name="TIPO_CT")
	private BigDecimal tipoCt;

	@Column(name="TIPO_INSTALACION")
	private BigDecimal tipoInstalacion;

	private String usuario;

	@Column(name="USUARIO_BLOQUEO")
	private String usuarioBloqueo;

	public GiAvisosInstalacion() {
	}

	public GiAvisosInstalacionPK getId() {
		return this.id;
	}

	public void setId(GiAvisosInstalacionPK id) {
		this.id = id;
	}

	public BigDecimal getAvisoAt() {
		return this.avisoAt;
	}

	public void setAvisoAt(BigDecimal avisoAt) {
		this.avisoAt = avisoAt;
	}

	public BigDecimal getClaseAviso() {
		return this.claseAviso;
	}

	public void setClaseAviso(BigDecimal claseAviso) {
		this.claseAviso = claseAviso;
	}

	public BigDecimal getEstAviso() {
		return this.estAviso;
	}

	public void setEstAviso(BigDecimal estAviso) {
		this.estAviso = estAviso;
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

	public String getFase() {
		return this.fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getIndAviso() {
		return this.indAviso;
	}

	public void setIndAviso(String indAviso) {
		this.indAviso = indAviso;
	}

	public BigDecimal getIndAvisoConsultado() {
		return this.indAvisoConsultado;
	}

	public void setIndAvisoConsultado(BigDecimal indAvisoConsultado) {
		this.indAvisoConsultado = indAvisoConsultado;
	}

	public BigDecimal getIndBloqueo() {
		return this.indBloqueo;
	}

	public void setIndBloqueo(BigDecimal indBloqueo) {
		this.indBloqueo = indBloqueo;
	}

	public BigDecimal getIndIncidencia() {
		return this.indIncidencia;
	}

	public void setIndIncidencia(BigDecimal indIncidencia) {
		this.indIncidencia = indIncidencia;
	}

	public BigDecimal getIndOtrasSmt() {
		return this.indOtrasSmt;
	}

	public void setIndOtrasSmt(BigDecimal indOtrasSmt) {
		this.indOtrasSmt = indOtrasSmt;
	}

	public BigDecimal getIndRed() {
		return this.indRed;
	}

	public void setIndRed(BigDecimal indRed) {
		this.indRed = indRed;
	}

	public BigDecimal getInstalacionConInt() {
		return this.instalacionConInt;
	}

	public void setInstalacionConInt(BigDecimal instalacionConInt) {
		this.instalacionConInt = instalacionConInt;
	}

	public String getNomInstalacion() {
		return this.nomInstalacion;
	}

	public void setNomInstalacion(String nomInstalacion) {
		this.nomInstalacion = nomInstalacion;
	}

	public BigDecimal getNroCmd() {
		return this.nroCmd;
	}

	public void setNroCmd(BigDecimal nroCmd) {
		this.nroCmd = nroCmd;
	}

	public BigDecimal getNroInstPadre() {
		return this.nroInstPadre;
	}

	public void setNroInstPadre(BigDecimal nroInstPadre) {
		this.nroInstPadre = nroInstPadre;
	}

	public BigDecimal getNroOt() {
		return this.nroOt;
	}

	public void setNroOt(BigDecimal nroOt) {
		this.nroOt = nroOt;
	}

	public BigDecimal getNroSector() {
		return this.nroSector;
	}

	public void setNroSector(BigDecimal nroSector) {
		this.nroSector = nroSector;
	}

	public BigDecimal getNroZona() {
		return this.nroZona;
	}

	public void setNroZona(BigDecimal nroZona) {
		this.nroZona = nroZona;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getTension() {
		return this.tension;
	}

	public void setTension(BigDecimal tension) {
		this.tension = tension;
	}

	public BigDecimal getTipoAviso() {
		return this.tipoAviso;
	}

	public void setTipoAviso(BigDecimal tipoAviso) {
		this.tipoAviso = tipoAviso;
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

	public String getUsuarioBloqueo() {
		return this.usuarioBloqueo;
	}

	public void setUsuarioBloqueo(String usuarioBloqueo) {
		this.usuarioBloqueo = usuarioBloqueo;
	}

}