package com.indra.iopen.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class IOpenFile implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long codApplication;

	private String storageFilename;

	private String originalFilename;

	private String contentType;

	private Date creationDate;

	private String contentClass;
	// SMA 20160704
	private String tac;

	private byte[] file;

	public Long getCodApplication() {
		return codApplication;
	}

	public void setCodApplication(Long codApplication) {
		this.codApplication = codApplication;
	}

	public String getStorageFilename() {
		return storageFilename;
	}

	public void setStorageFilename(String storageFilename) {
		this.storageFilename = storageFilename;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentClass() {
		return contentClass;
	}

	public void setContentClass(String contentClass) {
		this.contentClass = contentClass;
	}

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (codApplication == null ? 0 : codApplication.hashCode());
		result = prime * result + (storageFilename == null ? 0 : storageFilename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final IOpenFile other = (IOpenFile) obj;
		if (codApplication == null) {
			if (other.codApplication != null) {
				return false;
			}
		} else if (!codApplication.equals(other.codApplication)) {
			return false;
		}
		if (storageFilename == null) {
			if (other.storageFilename != null) {
				return false;
			}
		} else if (!storageFilename.equals(other.storageFilename)) {
			return false;
		}
		return true;
	}
}
