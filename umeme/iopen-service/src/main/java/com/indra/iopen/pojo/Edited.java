package com.indra.iopen.pojo;

import java.io.Serializable;
/**
 * This class is used to show if an edit was successful
 * @author smaina
 *
 */
public class Edited implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean created;
	private String error;

	public Edited() {

	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
