package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACTIVIDADES database table.
 *
 */
@Embeddable
public class ActividadePK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(
            name = "NUM_EXP",
            unique = true,
            nullable = false,
            length = 15)
    private String numExp;

    @Column(
            name = "NUM_ACT",
            unique = true,
            nullable = false,
            precision = 2)
    private long numAct;

    public ActividadePK() {
    }

    public String getNumExp() {
        return this.numExp;
    }

    public void setNumExp(final String numExp) {
        this.numExp = numExp;
    }

    public long getNumAct() {
        return this.numAct;
    }

    public void setNumAct(final long numAct) {
        this.numAct = numAct;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActividadePK)) {
            return false;
        }
        final ActividadePK castOther = (ActividadePK) other;
        return this.numExp.equals(castOther.numExp)
                && (this.numAct == castOther.numAct);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = (hash * prime) + this.numExp.hashCode();
        hash = (hash * prime) + ((int) (this.numAct ^ (this.numAct >>> 32)));

        return hash;
    }
}