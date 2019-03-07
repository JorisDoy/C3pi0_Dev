package com.indra.iopen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PASSWORD_RESET_TOKEN")
public class PasswordResetToken {

	@Id
	@SequenceGenerator(name = "PASSWORD_RESET_TOKEN_ID_GENERATOR", sequenceName = "TOKEN_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSWORD_RESET_TOKEN_ID_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "TOKEN_ID", unique = true, nullable = false, precision = 9)
	private Long tokenID;

	@Column(name = "TOKEN", nullable = false)
	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false)
	private Date expireDate;

	@Column(name = "USERNAME")
	private String username;

	public PasswordResetToken() {
		super();
	}

	public PasswordResetToken(String token, Date expireDate, String username) {
		super();
		this.token = token;
		this.expireDate = expireDate;
		this.username = username;
	}

	public Long getTokenID() {
		return tokenID;
	}

	public void setTokenID(Long tokenID) {
		this.tokenID = tokenID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((expireDate == null) ? 0 : expireDate.hashCode());
		result = (prime * result) + ((token == null) ? 0 : token.hashCode());
		result = (prime * result) + ((tokenID == null) ? 0 : tokenID.hashCode());
		result = (prime * result) + ((username == null) ? 0 : username.hashCode());
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
		PasswordResetToken other = (PasswordResetToken) obj;
		if (expireDate == null) {
			if (other.expireDate != null) {
				return false;
			}
		} else if (!expireDate.equals(other.expireDate)) {
			return false;
		}
		if (token == null) {
			if (other.token != null) {
				return false;
			}
		} else if (!token.equals(other.token)) {
			return false;
		}
		if (tokenID == null) {
			if (other.tokenID != null) {
				return false;
			}
		} else if (!tokenID.equals(other.tokenID)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

}
