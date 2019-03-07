package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the REM_PAYROLL database table.
 * 
 */
@Entity
@Table(name="REM_PAYROLL")
@NamedQuery(name="RemPayroll.findAll", query="SELECT r FROM RemPayroll r")
public class RemPayroll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PR_BIFE_ID")
	private long prBifeId;

	@ManyToOne
	@JoinColumn(name="COD_CLI")
	private Cliente cliente;

	@Column(name="EST_REMESA")
	private String estRemesa;

	@Temporal(TemporalType.DATE)
	@Column(name="F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name="F_DEV_BIFE")
	private Date fDevBife;

	@Temporal(TemporalType.DATE)
	@Column(name="F_EST_REMESA")
	private Date fEstRemesa;

	@Temporal(TemporalType.DATE)
	@Column(name="F_RESOL_BIFE")
	private Date fResolBife;

	@Temporal(TemporalType.DATE)
	@Column(name="F_VENC_BIFE")
	private Date fVencBife;

	@Column(name="GRP_REMESA")
	private BigDecimal grpRemesa;

	@Column(name="IMP_COSTO")
	private BigDecimal impCosto;

	@Column(name="NUM_REC_REM")
	private BigDecimal numRecRem;

	@Column(name="PR_BIF_ID")
	private BigDecimal prBifId;

	@Column(name="PR_COD_CENCOBRO")
	private BigDecimal prCodCencobro;

	@Column(name="PR_IMP_BIFE")
	private BigDecimal prImpBife;

	@Column(name="PR_IMP_RESOL_BIFE")
	private BigDecimal prImpResolBife;

	private String programa;

	private String usuario;

	//bi-directional many-to-one association to CuentasCu
	@ManyToOne
	@JoinColumn(name="COD_CTA")
	private CuentasCu cuentasCu;

	//bi-directional many-to-one association to Sumcon
	@ManyToOne
	@JoinColumn(name="NIS_RAD")
	private Sumcon sumcon;

	public RemPayroll() {
	}

	public long getPrBifeId() {
		return this.prBifeId;
	}

	public void setPrBifeId(long prBifeId) {
		this.prBifeId = prBifeId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEstRemesa() {
		return this.estRemesa;
	}

	public void setEstRemesa(String estRemesa) {
		this.estRemesa = estRemesa;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFDevBife() {
		return this.fDevBife;
	}

	public void setFDevBife(Date fDevBife) {
		this.fDevBife = fDevBife;
	}

	public Date getFEstRemesa() {
		return this.fEstRemesa;
	}

	public void setFEstRemesa(Date fEstRemesa) {
		this.fEstRemesa = fEstRemesa;
	}

	public Date getFResolBife() {
		return this.fResolBife;
	}

	public void setFResolBife(Date fResolBife) {
		this.fResolBife = fResolBife;
	}

	public Date getFVencBife() {
		return this.fVencBife;
	}

	public void setFVencBife(Date fVencBife) {
		this.fVencBife = fVencBife;
	}

	public BigDecimal getGrpRemesa() {
		return this.grpRemesa;
	}

	public void setGrpRemesa(BigDecimal grpRemesa) {
		this.grpRemesa = grpRemesa;
	}

	public BigDecimal getImpCosto() {
		return this.impCosto;
	}

	public void setImpCosto(BigDecimal impCosto) {
		this.impCosto = impCosto;
	}

	public BigDecimal getNumRecRem() {
		return this.numRecRem;
	}

	public void setNumRecRem(BigDecimal numRecRem) {
		this.numRecRem = numRecRem;
	}

	public BigDecimal getPrBifId() {
		return this.prBifId;
	}

	public void setPrBifId(BigDecimal prBifId) {
		this.prBifId = prBifId;
	}

	public BigDecimal getPrCodCencobro() {
		return this.prCodCencobro;
	}

	public void setPrCodCencobro(BigDecimal prCodCencobro) {
		this.prCodCencobro = prCodCencobro;
	}

	public BigDecimal getPrImpBife() {
		return this.prImpBife;
	}

	public void setPrImpBife(BigDecimal prImpBife) {
		this.prImpBife = prImpBife;
	}

	public BigDecimal getPrImpResolBife() {
		return this.prImpResolBife;
	}

	public void setPrImpResolBife(BigDecimal prImpResolBife) {
		this.prImpResolBife = prImpResolBife;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public CuentasCu getCuentasCu() {
		return this.cuentasCu;
	}

	public void setCuentasCu(CuentasCu cuentasCu) {
		this.cuentasCu = cuentasCu;
	}

	public Sumcon getSumcon() {
		return this.sumcon;
	}

	public void setSumcon(Sumcon sumcon) {
		this.sumcon = sumcon;
	}

}