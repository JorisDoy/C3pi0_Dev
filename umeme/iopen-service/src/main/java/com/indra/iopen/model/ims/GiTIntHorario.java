package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the GI_T_INT_HORARIO database table.
 * 
 */
@Entity
@Table(name="GI_T_INT_HORARIO")
@NamedQuery(name="GiTIntHorario.findAll", query="SELECT g FROM GiTIntHorario g")
public class GiTIntHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_HOR")
	private long codHor;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date desde;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	private Date hasta;

	private String programa;

	private String usuario;

	public GiTIntHorario() {
	}

	public long getCodHor() {
		return this.codHor;
	}

	public void setCodHor(long codHor) {
		this.codHor = codHor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getDesde() {
		return this.desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getHasta() {
		return this.hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
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