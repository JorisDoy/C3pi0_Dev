package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the IMAGENES_XML database table.
 *
 */
@Entity
@Table(
        name = "IMAGENES_XML")
@NamedQuery(
        name = "ImagenesXml.findAll",
        query = "SELECT i FROM ImagenesXml i")
public class ImagenesXml implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(
            name = "STATEMENT_ID")
    private Long statementId;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_ACTUAL")
    private Date fActual;

    private String programa;

    private String usuario;

    @Lob
    @Column(
            name = "XML_DATA")
    private byte[] xmlData;

    public ImagenesXml() {
    }

    public Long getStatementId() {
        return this.statementId;
    }

    public void setStatementId(final Long statementId) {
        this.statementId = statementId;
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

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public byte[] getXmlData() {
        return this.xmlData;
    }

    public void setXmlData(final byte[] xmlData) {
        this.xmlData = xmlData;
    }

}