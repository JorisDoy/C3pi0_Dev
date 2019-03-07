package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the CLIENTE_PROFILE database table.
 *
 */
@Entity
@Table(
        name = "CLIENTE_PROFILE")
@NamedQuery(
        name = "ClienteProfile.findAll",
        query = "SELECT c FROM ClienteProfile c")
public class ClienteProfile implements Serializable {
    private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private ClienteProfilePK id;

    @Id
    private String username;

    @Column(
            name = "COD_CLI")
    private long codCli;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_ACTUAL")
    private Date fActual;

    private String programa;

    @Column(
            name = "USER_PASS")
    private String userPass;

    private String usuario;

    @Column(
            name = "ACTIVE")
    private Boolean active = Boolean.FALSE;

    @Column(
            name = "ACTIVATION_TOKEN")
    private String activationToken = "";

    @Column(
            name = "FULL_NAME")
    private String fullName;

    @Column(
            name = "PHONE_NUMBER")
    private String phoneNumber;

    public ClienteProfile() {
        this.usuario = "IOPEN";
        this.programa = "IOPEN";
        this.fActual = new Date();
    }

//	public ClienteProfilePK getId() {
//		return this.id;
//	}
//
//	public void setId(ClienteProfilePK id) {
//		this.id = id;
//	}
//

    public String getFullName() {
        return fullName;
    }

    public long getCodCli() {
        return codCli;
    }

    public void setCodCli(final long codCli) {
        this.codCli = codCli;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getFActual() {
        return this.fActual;
    }

    public void setFActual(final Date fActual) {
        this.fActual = fActual;
    }

    public String getPrograma() {
        return this.programa;
    }

    public void setPrograma(final String programa) {
        this.programa = programa;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(final String userPass) {
        this.userPass = userPass;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(final String activationToken) {
        this.activationToken = activationToken;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (username == null ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteProfile other = (ClienteProfile) obj;
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