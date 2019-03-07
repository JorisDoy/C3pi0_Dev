package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PROVINCIAS database table.
 * 
 */
@Entity
@Table(name="PROVINCIAS")
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_PROV")
	private long codProv;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Column(name="NOM_PROV")
	private String nomProv;

	private String programa;

	private String usuario;

	public Provincia() {
	}

	public long getCodProv() {
		return this.codProv;
	}

	public void setCodProv(long codProv) {
		this.codProv = codProv;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public String getNomProv() {
		return this.nomProv;
	}

	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
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