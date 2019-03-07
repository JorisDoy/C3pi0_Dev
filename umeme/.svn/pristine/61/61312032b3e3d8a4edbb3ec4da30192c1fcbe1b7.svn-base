package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the RECIBOS database table.
 *
 */
@Entity
@Table(
        name = "RECIBOS")
@NamedQuery(
        name = "Recibo.findAll",
        query = "SELECT r FROM Recibo r")
public class Recibo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "RECIBOS_NUMREC_GENERATOR",
            sequenceName = "NUM_REC")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RECIBOS_NUMREC_GENERATOR")
    // @GeneratedValue(
    // strategy = GenerationType.AUTO)
    @Column(
            name = "NUM_REC")
    private Long numRec;

    @Column(
            name = "ACC_PAY_ID")
    private BigDecimal accPayId;

    @Column(
            name = "AJ_REDON")
    private BigDecimal ajRedon;

    @Column(
            name = "CO_COND_FISCAL")
    private String coCondFiscal;

    @Column(
            name = "COD_CTA")
    private BigDecimal codCta;

    @Column(
            name = "COD_CTA_PAGO")
    private BigDecimal codCtaPago;

    @Column(
            name = "COD_TAR")
    private String codTar;

    @Column(
            name = "COD_UNICOM")
    private BigDecimal codUnicom;

    @Column(
            name = "EMP_PROPIETARIA")
    private BigDecimal empPropietaria;

    @Column(
            name = "EST_ACT")
    private String estAct;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_ACTUAL")
    private Date fActual;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_COBRO")
    private Date fCobro;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_CONTABIL")
    private Date fContabil;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_EST_ACT")
    private Date fEstAct;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_FACT")
    private Date fFact;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_FACT_ANT")
    private Date fFactAnt;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_P_CAMB_EST")
    private Date fPCambEst;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_PREV_CORTE")
    private Date fPrevCorte;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_PREV_PUESTA")
    private Date fPrevPuesta;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_PROC_COBRO")
    private Date fProcCobro;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_PUESTA_COBRO")
    private Date fPuestaCobro;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "F_VCTO_FAC")
    private Date fVctoFac;

    @Column(
            name = "GR_CONCEPTO")
    private BigDecimal grConcepto;

    @Column(
            name = "ID_IG")
    private BigDecimal idIg;

    @Column(
            name = "ID_REFERENCIA")
    private BigDecimal idReferencia;

    @Column(
            name = "ID_STATEMENT")
    private BigDecimal idStatement;

    @Column(
            name = "IMP_CTA")
    private BigDecimal impCta;

    @Column(
            name = "IMP_TOT_REC")
    private BigDecimal impTotRec;

    @Column(
            name = "IND_CONVERSION")
    private BigDecimal indConversion;

    @Column(
            name = "IND_CUOTA")
    private BigDecimal indCuota;

    @Column(
            name = "IND_HAY_EXT")
    private BigDecimal indHayExt;

    @Column(
            name = "IND_HAY_REMESA")
    private BigDecimal indHayRemesa;

    @Column(
            name = "IND_IMPUESTO")
    private BigDecimal indImpuesto;

    @Column(
            name = "IND_MULTA")
    private BigDecimal indMulta;

    @Column(
            name = "IND_PAC_URG")
    private BigDecimal indPacUrg;

    @Column(
            name = "IND_REAL_EST")
    private BigDecimal indRealEst;

    @Column(
            name = "IND_RECAR")
    private BigDecimal indRecar;

    @Column(
            name = "IND_SPLIT")
    private BigDecimal indSplit;

    @Column(
            name = "NIS_RAD")
    private BigDecimal nisRad;

    @Column(
            name = "NUM_ACU")
    private BigDecimal numAcu;

    @Column(
            name = "NUM_DIAS_FACT")
    private BigDecimal numDiasFact;

    @Column(
            name = "NUM_DIAS_REC")
    private BigDecimal numDiasRec;

    @Column(
            name = "NUM_FACT")
    private String numFact;

    @Column(
            name = "NUM_FISCAL")
    private String numFiscal;

    @Column(
            name = "NUM_REC_ANUL")
    private BigDecimal numRecAnul;

    @Column(
            name = "OP_CAMBEST")
    private String opCambest;

    private String programa;

    @Column(
            name = "SEC_NIS")
    private BigDecimal secNis;

    @Column(
            name = "TIP_CLI")
    private String tipCli;

    @Column(
            name = "TIP_CTA")
    private String tipCta;

    @Column(
            name = "TIP_ENVIO")
    private String tipEnvio;

    @Column(
            name = "TIP_FACT")
    private String tipFact;

    @Column(
            name = "TIP_REC")
    private String tipRec;

    @Column(
            name = "TIP_SERV")
    private String tipServ;

    private String usuario;

    public Recibo() {
    }

    public long getNumRec() {
        return this.numRec;
    }

    public void setNumRec(final long numRec) {
        this.numRec = numRec;
    }

    public BigDecimal getAccPayId() {
        return this.accPayId;
    }

    public void setAccPayId(final BigDecimal accPayId) {
        this.accPayId = accPayId;
    }

    public BigDecimal getAjRedon() {
        return this.ajRedon;
    }

    public void setAjRedon(final BigDecimal ajRedon) {
        this.ajRedon = ajRedon;
    }

    public String getCoCondFiscal() {
        return this.coCondFiscal;
    }

    public void setCoCondFiscal(final String coCondFiscal) {
        this.coCondFiscal = coCondFiscal;
    }

    public BigDecimal getCodCta() {
        return this.codCta;
    }

    public void setCodCta(final BigDecimal codCta) {
        this.codCta = codCta;
    }

    public BigDecimal getCodCtaPago() {
        return this.codCtaPago;
    }

    public void setCodCtaPago(final BigDecimal codCtaPago) {
        this.codCtaPago = codCtaPago;
    }

    public String getCodTar() {
        return this.codTar;
    }

    public void setCodTar(final String codTar) {
        this.codTar = codTar;
    }

    public BigDecimal getCodUnicom() {
        return this.codUnicom;
    }

    public void setCodUnicom(final BigDecimal codUnicom) {
        this.codUnicom = codUnicom;
    }

    public BigDecimal getEmpPropietaria() {
        return this.empPropietaria;
    }

    public void setEmpPropietaria(final BigDecimal empPropietaria) {
        this.empPropietaria = empPropietaria;
    }

    public String getEstAct() {
        return this.estAct;
    }

    public void setEstAct(final String estAct) {
        this.estAct = estAct;
    }

    public Date getFActual() {
        return this.fActual;
    }

    public void setFActual(final Date fActual) {
        this.fActual = fActual;
    }

    public Date getFCobro() {
        return this.fCobro;
    }

    public void setFCobro(final Date fCobro) {
        this.fCobro = fCobro;
    }

    public Date getFContabil() {
        return this.fContabil;
    }

    public void setFContabil(final Date fContabil) {
        this.fContabil = fContabil;
    }

    public Date getFEstAct() {
        return this.fEstAct;
    }

    public void setFEstAct(final Date fEstAct) {
        this.fEstAct = fEstAct;
    }

    public Date getFFact() {
        return this.fFact;
    }

    public void setFFact(final Date fFact) {
        this.fFact = fFact;
    }

    public Date getFFactAnt() {
        return this.fFactAnt;
    }

    public void setFFactAnt(final Date fFactAnt) {
        this.fFactAnt = fFactAnt;
    }

    public Date getFPCambEst() {
        return this.fPCambEst;
    }

    public void setFPCambEst(final Date fPCambEst) {
        this.fPCambEst = fPCambEst;
    }

    public Date getFPrevCorte() {
        return this.fPrevCorte;
    }

    public void setFPrevCorte(final Date fPrevCorte) {
        this.fPrevCorte = fPrevCorte;
    }

    public Date getFPrevPuesta() {
        return this.fPrevPuesta;
    }

    public void setFPrevPuesta(final Date fPrevPuesta) {
        this.fPrevPuesta = fPrevPuesta;
    }

    public Date getFProcCobro() {
        return this.fProcCobro;
    }

    public void setFProcCobro(final Date fProcCobro) {
        this.fProcCobro = fProcCobro;
    }

    public Date getFPuestaCobro() {
        return this.fPuestaCobro;
    }

    public void setFPuestaCobro(final Date fPuestaCobro) {
        this.fPuestaCobro = fPuestaCobro;
    }

    public Date getFVctoFac() {
        return this.fVctoFac;
    }

    public void setFVctoFac(final Date fVctoFac) {
        this.fVctoFac = fVctoFac;
    }

    public BigDecimal getGrConcepto() {
        return this.grConcepto;
    }

    public void setGrConcepto(final BigDecimal grConcepto) {
        this.grConcepto = grConcepto;
    }

    public BigDecimal getIdIg() {
        return this.idIg;
    }

    public void setIdIg(final BigDecimal idIg) {
        this.idIg = idIg;
    }

    public BigDecimal getIdReferencia() {
        return this.idReferencia;
    }

    public void setIdReferencia(final BigDecimal idReferencia) {
        this.idReferencia = idReferencia;
    }

    public BigDecimal getIdStatement() {
        return this.idStatement;
    }

    public void setIdStatement(final BigDecimal idStatement) {
        this.idStatement = idStatement;
    }

    public BigDecimal getImpCta() {
        return this.impCta;
    }

    public void setImpCta(final BigDecimal impCta) {
        this.impCta = impCta;
    }

    public BigDecimal getImpTotRec() {
        return this.impTotRec;
    }

    public void setImpTotRec(final BigDecimal impTotRec) {
        this.impTotRec = impTotRec;
    }

    public BigDecimal getIndConversion() {
        return this.indConversion;
    }

    public void setIndConversion(final BigDecimal indConversion) {
        this.indConversion = indConversion;
    }

    public BigDecimal getIndCuota() {
        return this.indCuota;
    }

    public void setIndCuota(final BigDecimal indCuota) {
        this.indCuota = indCuota;
    }

    public BigDecimal getIndHayExt() {
        return this.indHayExt;
    }

    public void setIndHayExt(final BigDecimal indHayExt) {
        this.indHayExt = indHayExt;
    }

    public BigDecimal getIndHayRemesa() {
        return this.indHayRemesa;
    }

    public void setIndHayRemesa(final BigDecimal indHayRemesa) {
        this.indHayRemesa = indHayRemesa;
    }

    public BigDecimal getIndImpuesto() {
        return this.indImpuesto;
    }

    public void setIndImpuesto(final BigDecimal indImpuesto) {
        this.indImpuesto = indImpuesto;
    }

    public BigDecimal getIndMulta() {
        return this.indMulta;
    }

    public void setIndMulta(final BigDecimal indMulta) {
        this.indMulta = indMulta;
    }

    public BigDecimal getIndPacUrg() {
        return this.indPacUrg;
    }

    public void setIndPacUrg(final BigDecimal indPacUrg) {
        this.indPacUrg = indPacUrg;
    }

    public BigDecimal getIndRealEst() {
        return this.indRealEst;
    }

    public void setIndRealEst(final BigDecimal indRealEst) {
        this.indRealEst = indRealEst;
    }

    public BigDecimal getIndRecar() {
        return this.indRecar;
    }

    public void setIndRecar(final BigDecimal indRecar) {
        this.indRecar = indRecar;
    }

    public BigDecimal getIndSplit() {
        return this.indSplit;
    }

    public void setIndSplit(final BigDecimal indSplit) {
        this.indSplit = indSplit;
    }

    public BigDecimal getNisRad() {
        return this.nisRad;
    }

    public void setNisRad(final BigDecimal nisRad) {
        this.nisRad = nisRad;
    }

    public BigDecimal getNumAcu() {
        return this.numAcu;
    }

    public void setNumAcu(final BigDecimal numAcu) {
        this.numAcu = numAcu;
    }

    public BigDecimal getNumDiasFact() {
        return this.numDiasFact;
    }

    public void setNumDiasFact(final BigDecimal numDiasFact) {
        this.numDiasFact = numDiasFact;
    }

    public BigDecimal getNumDiasRec() {
        return this.numDiasRec;
    }

    public void setNumDiasRec(final BigDecimal numDiasRec) {
        this.numDiasRec = numDiasRec;
    }

    public String getNumFact() {
        return this.numFact;
    }

    public void setNumFact(final String numFact) {
        this.numFact = numFact;
    }

    public String getNumFiscal() {
        return this.numFiscal;
    }

    public void setNumFiscal(final String numFiscal) {
        this.numFiscal = numFiscal;
    }

    public BigDecimal getNumRecAnul() {
        return this.numRecAnul;
    }

    public void setNumRecAnul(final BigDecimal numRecAnul) {
        this.numRecAnul = numRecAnul;
    }

    public String getOpCambest() {
        return this.opCambest;
    }

    public void setOpCambest(final String opCambest) {
        this.opCambest = opCambest;
    }

    public String getPrograma() {
        return this.programa;
    }

    public void setPrograma(final String programa) {
        this.programa = programa;
    }

    public BigDecimal getSecNis() {
        return this.secNis;
    }

    public void setSecNis(final BigDecimal secNis) {
        this.secNis = secNis;
    }

    public String getTipCli() {
        return this.tipCli;
    }

    public void setTipCli(final String tipCli) {
        this.tipCli = tipCli;
    }

    public String getTipCta() {
        return this.tipCta;
    }

    public void setTipCta(final String tipCta) {
        this.tipCta = tipCta;
    }

    public String getTipEnvio() {
        return this.tipEnvio;
    }

    public void setTipEnvio(final String tipEnvio) {
        this.tipEnvio = tipEnvio;
    }

    public String getTipFact() {
        return this.tipFact;
    }

    public void setTipFact(final String tipFact) {
        this.tipFact = tipFact;
    }

    public String getTipRec() {
        return this.tipRec;
    }

    public void setTipRec(final String tipRec) {
        this.tipRec = tipRec;
    }

    public String getTipServ() {
        return this.tipServ;
    }

    public void setTipServ(final String tipServ) {
        this.tipServ = tipServ;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

}