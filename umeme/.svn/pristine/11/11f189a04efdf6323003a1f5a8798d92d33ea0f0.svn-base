package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CLIENTE_PROFILE database table.
 *
 */
@Embeddable
public class ClienteProfilePK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(
            name = "COD_CLI")
    private long codCli;

    private String username;

    public ClienteProfilePK() {
    }

    public ClienteProfilePK(final long codCli, final String username) {
        super();
        this.codCli = codCli;
        this.username = username;
    }

    public long getCodCli() {
        return this.codCli;
    }

    public void setCodCli(final long codCli) {
        this.codCli = codCli;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClienteProfilePK)) {
            return false;
        }
        final ClienteProfilePK castOther = (ClienteProfilePK) other;
        return (this.codCli == castOther.codCli)
                && this.username.equals(castOther.username);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = (hash * prime) + ((int) (this.codCli ^ (this.codCli >>> 32)));
        hash = (hash * prime) + this.username.hashCode();

        return hash;
    }
}