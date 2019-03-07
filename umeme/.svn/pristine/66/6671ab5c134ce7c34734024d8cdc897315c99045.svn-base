package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SGD_VALOR database table.
 * 
 */
@Entity
@Table(name="SGD_VALOR")
@NamedQuery(name="SgdValor.findAll", query="SELECT s FROM SgdValor s")
public class SgdValor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgdValorPK id;

	private BigDecimal codigo;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	public SgdValor() {
	}

	public SgdValorPK getId() {
		return this.id;
	}

	public void setId(SgdValorPK id) {
		this.id = id;
	}

	public BigDecimal getCodigo() {
		return this.codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

}