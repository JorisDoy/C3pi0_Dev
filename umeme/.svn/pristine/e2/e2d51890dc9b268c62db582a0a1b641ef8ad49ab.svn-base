package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GI_T_ULTIMO database table.
 * 
 */
@Entity
@Table(name="GI_T_ULTIMO")
@NamedQuery(name="GiTUltimo.findAll", query="SELECT g FROM GiTUltimo g")
public class GiTUltimo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiTUltimoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="H_ACTUAL")
	private Date hActual;

	private String programa;

	private BigDecimal ultimo;

	private String usuario;

	public GiTUltimo() {
	}

	public GiTUltimoPK getId() {
		return this.id;
	}

	public void setId(GiTUltimoPK id) {
		this.id = id;
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

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public BigDecimal getUltimo() {
		return this.ultimo;
	}

	public void setUltimo(BigDecimal ultimo) {
		this.ultimo = ultimo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}