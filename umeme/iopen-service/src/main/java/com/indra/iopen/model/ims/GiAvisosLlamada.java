package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the GI_AVISOS_LLAMADAS database table.
 * 
 */
@Entity
@IdClass(GiAvisosLlamada.class)
@Table(name = "GI_AVISOS_LLAMADAS@IMS",schema="IMSPROD")
@NamedQuery(name = "GiAvisosLlamada.findAll", query = "SELECT g FROM GiAvisosLlamada g")
public class GiAvisosLlamada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String comentario;
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "F_LLAMADA")
	private Date fLlamada;

	@Id
	@Column(name = "IND_AVISO")
	private String indAviso;

	@Id
	@Column(name = "NOM_OPERADOR")
	private String nomOperador;

	@Id
	@Column(name = "NRO_AVISO")
	private BigDecimal nroAviso;

	public GiAvisosLlamada() {
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFLlamada() {
		return this.fLlamada;
	}

	public void setFLlamada(Date fLlamada) {
		this.fLlamada = fLlamada;
	}

	public String getIndAviso() {
		return this.indAviso;
	}

	public void setIndAviso(String indAviso) {
		this.indAviso = indAviso;
	}

	public String getNomOperador() {
		return this.nomOperador;
	}

	public void setNomOperador(String nomOperador) {
		this.nomOperador = nomOperador;
	}

	public BigDecimal getNroAviso() {
		return this.nroAviso;
	}

	public void setNroAviso(BigDecimal nroAviso) {
		this.nroAviso = nroAviso;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}