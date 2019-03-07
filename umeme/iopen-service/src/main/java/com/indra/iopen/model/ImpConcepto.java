package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IMP_CONCEPTO database table.
 * 
 */
@Entity
@Table(name="IMP_CONCEPTO")
@NamedQuery(name="ImpConcepto.findAll", query="SELECT i FROM ImpConcepto i")
public class ImpConcepto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ImpConceptoPK id;

	@Column(name="BASE_CALC_IMP")
	private BigDecimal baseCalcImp;

	@Column(name="CO_CONCEPTO")
	private String coConcepto;

	@Column(name="CSMO_FACT")
	private BigDecimal csmoFact;

	@Column(name="DETALLE_CONCEPTO")
	private String detalleConcepto;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="IMP_CONCEPTO")
	private BigDecimal impConcepto;

	@Column(name="IMP_CTA")
	private BigDecimal impCta;

	@Column(name="PORC_CONCEPTO")
	private BigDecimal porcConcepto;

	@Column(name="PREC_CONCEPTO")
	private BigDecimal precConcepto;

	private String programa;

	private String usuario;

	public ImpConcepto() {
	}

	public ImpConceptoPK getId() {
		return this.id;
	}

	public void setId(ImpConceptoPK id) {
		this.id = id;
	}

	public BigDecimal getBaseCalcImp() {
		return this.baseCalcImp;
	}

	public void setBaseCalcImp(BigDecimal baseCalcImp) {
		this.baseCalcImp = baseCalcImp;
	}

	public String getCoConcepto() {
		return this.coConcepto;
	}

	public void setCoConcepto(String coConcepto) {
		this.coConcepto = coConcepto;
	}

	public BigDecimal getCsmoFact() {
		return this.csmoFact;
	}

	public void setCsmoFact(BigDecimal csmoFact) {
		this.csmoFact = csmoFact;
	}

	public String getDetalleConcepto() {
		return this.detalleConcepto;
	}

	public void setDetalleConcepto(String detalleConcepto) {
		this.detalleConcepto = detalleConcepto;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public BigDecimal getImpConcepto() {
		return this.impConcepto;
	}

	public void setImpConcepto(BigDecimal impConcepto) {
		this.impConcepto = impConcepto;
	}

	public BigDecimal getImpCta() {
		return this.impCta;
	}

	public void setImpCta(BigDecimal impCta) {
		this.impCta = impCta;
	}

	public BigDecimal getPorcConcepto() {
		return this.porcConcepto;
	}

	public void setPorcConcepto(BigDecimal porcConcepto) {
		this.porcConcepto = porcConcepto;
	}

	public BigDecimal getPrecConcepto() {
		return this.precConcepto;
	}

	public void setPrecConcepto(BigDecimal precConcepto) {
		this.precConcepto = precConcepto;
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