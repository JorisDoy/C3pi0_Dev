package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IOPEN_APPLICATION_DOCS database table.
 * 
 */
@Embeddable
public class IopenApplicationDocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_APPLICATION", insertable=false, updatable=false)
	private Long codApplication;

	@Column(name="TIP_DOC")
	private String tipDoc;

	public IopenApplicationDocPK() {
	}
	
	
	public IopenApplicationDocPK(Long codApplication, String tipDoc) {
		super();
		this.codApplication = codApplication;
		this.tipDoc = tipDoc;
	}


	public Long getCodApplication() {
		return this.codApplication;
	}
	public void setCodApplication(Long codApplication) {
		this.codApplication = codApplication;
	}
	public String getTipDoc() {
		return this.tipDoc;
	}
	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IopenApplicationDocPK)) {
			return false;
		}
		IopenApplicationDocPK castOther = (IopenApplicationDocPK)other;
		return 
			(this.codApplication == castOther.codApplication)
			&& this.tipDoc.equals(castOther.tipDoc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codApplication ^ (this.codApplication >>> 32)));
		hash = hash * prime + this.tipDoc.hashCode();
		
		return hash;
	}
}