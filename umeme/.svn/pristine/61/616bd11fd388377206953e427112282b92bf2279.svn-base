package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the OBJETOS database table.
 * 
 */
@Entity
@Table(name="OBJETOS")
@NamedQuery(name="Objeto.findAll", query="SELECT o FROM Objeto o")
public class Objeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObjetoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to PerfilObjeto
	@OneToMany(mappedBy="objetoBean")
	private List<PerfilObjeto> perfilObjetos;

	public Objeto() {
	}

	public ObjetoPK getId() {
		return this.id;
	}

	public void setId(ObjetoPK id) {
		this.id = id;
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

	public List<PerfilObjeto> getPerfilObjetos() {
		return this.perfilObjetos;
	}

	public void setPerfilObjetos(List<PerfilObjeto> perfilObjetos) {
		this.perfilObjetos = perfilObjetos;
	}

	public PerfilObjeto addPerfilObjeto(PerfilObjeto perfilObjeto) {
		getPerfilObjetos().add(perfilObjeto);
		perfilObjeto.setObjetoBean(this);

		return perfilObjeto;
	}

	public PerfilObjeto removePerfilObjeto(PerfilObjeto perfilObjeto) {
		getPerfilObjetos().remove(perfilObjeto);
		perfilObjeto.setObjetoBean(null);

		return perfilObjeto;
	}

}