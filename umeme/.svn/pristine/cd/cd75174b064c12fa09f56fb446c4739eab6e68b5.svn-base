package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IOPEN_APPLICATION_STAGES database table.
 * 
 */
@Entity
@Table(name="IOPEN_APPLICATION_STAGES")
@NamedQuery(name="IopenApplicationStage.findAll", query="SELECT i FROM IopenApplicationStage i")
public class IopenApplicationStage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	@Column(name="SEQ_NUMBER")
	private BigDecimal seqNumber;

	@Column(name="STAGE_COMMENTS")
	private String stageComments;

	private String usuario;

	public IopenApplicationStage() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public BigDecimal getSeqNumber() {
		return this.seqNumber;
	}

	public void setSeqNumber(BigDecimal seqNumber) {
		this.seqNumber = seqNumber;
	}

	public String getStageComments() {
		return this.stageComments;
	}

	public void setStageComments(String stageComments) {
		this.stageComments = stageComments;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}