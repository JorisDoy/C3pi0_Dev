package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GI_MESSAGES database table.
 * 
 */
@Embeddable
public class GiMessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String msgid;

	@Column(name="LANG_ID")
	private String langId;

	public GiMessagePK() {
	}
	public String getMsgid() {
		return this.msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getLangId() {
		return this.langId;
	}
	public void setLangId(String langId) {
		this.langId = langId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GiMessagePK)) {
			return false;
		}
		GiMessagePK castOther = (GiMessagePK)other;
		return 
			this.msgid.equals(castOther.msgid)
			&& this.langId.equals(castOther.langId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.msgid.hashCode();
		hash = hash * prime + this.langId.hashCode();
		
		return hash;
	}
}