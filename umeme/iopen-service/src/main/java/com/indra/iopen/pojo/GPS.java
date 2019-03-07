package com.indra.iopen.pojo;

import java.io.Serializable;

/**
 * UMESCI-713 This class is going to be used to store the GPS coordinates
 *
 * @author smaina
 *
 */
public class GPS implements Serializable {
	private static final long serialVersionUID = 1L;
	private String x;
	private String y;

	public GPS() {

	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

}
