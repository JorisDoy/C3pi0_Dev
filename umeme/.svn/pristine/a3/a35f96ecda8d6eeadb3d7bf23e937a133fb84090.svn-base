package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CUENTAS_CU database table.
 *
 */
@Entity
@Table(name = "CUENTAS_CU")
@NamedQuery(name = "CuentasCu.findAll", query = "SELECT c FROM CuentasCu c")
public class CuentasCu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CUENTAS_CU_CODCTA_GENERATOR", sequenceName = "COD_CTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUENTAS_CU_CODCTA_GENERATOR")
	// @GeneratedValue(
	// strategy = GenerationType.AUTO)
	@Column(name = "COD_CTA")
	private long codCta;

	@Column(name = "AGE_CBR_ESP")
	private BigDecimal ageCbrEsp;

	@Column(name = "CO_ACCION_AUSENCIA")
	private String coAccionAusencia;

	@Column(name = "CO_CALIDAD_CUENTA")
	private String coCalidadCuenta;

	@Column(name = "CO_IDIOMA")
	private String coIdioma;

	@Column(name = "CO_MOD_ENV")
	private String coModEnv;

	@Column(name = "CO_MOT_ULT_PAC")
	private String coMotUltPac;

	@Column(name = "COD_CLI")
	private BigDecimal codCli;

	@Column(name = "COD_CLI_BENEF1")
	private BigDecimal codCliBenef1;

	@Column(name = "COD_CLI_BENEF2")
	private BigDecimal codCliBenef2;

	@Column(name = "COD_CLI_BENEF3")
	private BigDecimal codCliBenef3;

	@Column(name = "COD_CTA_TESTIGO_DEUDA")
	private BigDecimal codCtaTestigoDeuda;

	@Column(name = "DESCRIPT_CTA")
	private String descriptCta;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_CAMB")
	private Date fCamb;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_DIA_FIJO")
	private Date fDiaFijo;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_INI_POLITICA")
	private Date fIniPolitica;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_PUESTA")
	private Date fPuesta;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ULT_POLITICA")
	private Date fUltPolitica;

	@Column(name = "IMP_LIMITE_DOMIC")
	private BigDecimal impLimiteDomic;

	@Column(name = "IMP_RECEIVABLES")
	private BigDecimal impReceivables;

	@Column(name = "IND_PAGO_CHEQUE")
	private BigDecimal indPagoCheque;

	@Column(name = "IND_PAGO_PARCIAL")
	private BigDecimal indPagoParcial;

	@Column(name = "IND_SERV_MISMA_FACTURA")
	private BigDecimal indServMismaFactura;

	@Column(name = "IND_TIT_CLI")
	private BigDecimal indTitCli;

	@Column(name = "NIS_RAD_PRINCIPAL")
	private BigDecimal nisRadPrincipal;

	@Column(name = "NUM_COPIAS")
	private BigDecimal numCopias;

	@Column(name = "NUM_RECEIVABLES")
	private BigDecimal numReceivables;

	private String programa;

	private BigDecimal saldo;

	@Column(name = "TIP_CTA")
	private String tipCta;

	@Column(name = "TIP_ENV")
	private String tipEnv;

	@Column(name = "TIP_PERIODICIDAD")
	private String tipPeriodicidad;

	@Column(name = "TIP_PUESTA")
	private String tipPuesta;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME1")
	private Date usrDatetime1;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME2")
	private Date usrDatetime2;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME3")
	private Date usrDatetime3;

	@Column(name = "USR_NUMBER1")
	private BigDecimal usrNumber1;

	@Column(name = "USR_NUMBER2")
	private BigDecimal usrNumber2;

	@Column(name = "USR_NUMBER3")
	private BigDecimal usrNumber3;

	@Column(name = "USR_VARCHAR1")
	private String usrVarchar1;

	@Column(name = "USR_VARCHAR2")
	private String usrVarchar2;

	@Column(name = "USR_VARCHAR3")
	private String usrVarchar3;

	private String usuario;

	// bi-directional many-to-one association to RemPayroll
	@OneToMany(mappedBy = "cuentasCu")
	private List<RemPayroll> remPayrolls;

	public CuentasCu() {
		try {
			this.fActual = new Date();
			this.usuario = "IOPEN";
			this.programa = "IOPEN";

			this.ageCbrEsp = new BigDecimal(1001);
			this.coAccionAusencia = "AC001";
			this.coCalidadCuenta = "CU000";
			this.coIdioma = "ID003";
			this.coModEnv = "EN003";
			this.coMotUltPac = "DP000";

			this.codCliBenef1 = new BigDecimal(0);
			this.codCliBenef2 = new BigDecimal(0);
			this.codCliBenef3 = new BigDecimal(0);
			this.codCtaTestigoDeuda = new BigDecimal(0);

			this.fCamb = new Date();
			this.fDiaFijo = new Date();
			this.fIniPolitica = new Date();
			this.fPuesta = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			this.fUltPolitica = new Date();
			this.impLimiteDomic = new BigDecimal(0);
			this.impReceivables = new BigDecimal(0);
			this.indPagoCheque = new BigDecimal(1);
			this.indPagoParcial = new BigDecimal(1);
			this.indServMismaFactura = new BigDecimal(2);
			this.indTitCli = new BigDecimal(2);
			this.nisRadPrincipal = new BigDecimal(0);
			this.numCopias = new BigDecimal(1);
			this.numReceivables = new BigDecimal(0);

			this.saldo = new BigDecimal(0);
			this.tipPeriodicidad = "PF012";
			this.tipPuesta = "DS001";
			this.usrDatetime1 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			this.usrDatetime2 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			this.usrDatetime3 = new SimpleDateFormat("yyyyMMdd").parse("29991231");
			this.usrNumber1 = new BigDecimal(0);
			this.usrNumber2 = new BigDecimal(0);
			this.usrNumber3 = new BigDecimal(0);
			this.usrVarchar1 = " ";
			this.usrVarchar2 = " ";
			this.usrVarchar3 = " ";
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	public RemPayroll addRemPayroll(final RemPayroll remPayroll) {
		getRemPayrolls().add(remPayroll);
		remPayroll.setCuentasCu(this);

		return remPayroll;
	}

	public BigDecimal getAgeCbrEsp() {
		return this.ageCbrEsp;
	}

	public String getCoAccionAusencia() {
		return this.coAccionAusencia;
	}

	public String getCoCalidadCuenta() {
		return this.coCalidadCuenta;
	}

	public BigDecimal getCodCli() {
		return this.codCli;
	}

	public BigDecimal getCodCliBenef1() {
		return this.codCliBenef1;
	}

	public BigDecimal getCodCliBenef2() {
		return this.codCliBenef2;
	}

	public BigDecimal getCodCliBenef3() {
		return this.codCliBenef3;
	}

	public long getCodCta() {
		return this.codCta;
	}

	public BigDecimal getCodCtaTestigoDeuda() {
		return this.codCtaTestigoDeuda;
	}

	public String getCoIdioma() {
		return this.coIdioma;
	}

	public String getCoModEnv() {
		return this.coModEnv;
	}

	public String getCoMotUltPac() {
		return this.coMotUltPac;
	}

	public String getDescriptCta() {
		return this.descriptCta;
	}

	public Date getFActual() {
		return this.fActual;
	}

	public Date getFCamb() {
		return this.fCamb;
	}

	public Date getFDiaFijo() {
		return this.fDiaFijo;
	}

	public Date getFIniPolitica() {
		return this.fIniPolitica;
	}

	public Date getFPuesta() {
		return this.fPuesta;
	}

	public Date getFUltPolitica() {
		return this.fUltPolitica;
	}

	public BigDecimal getImpLimiteDomic() {
		return this.impLimiteDomic;
	}

	public BigDecimal getImpReceivables() {
		return this.impReceivables;
	}

	public BigDecimal getIndPagoCheque() {
		return this.indPagoCheque;
	}

	public BigDecimal getIndPagoParcial() {
		return this.indPagoParcial;
	}

	public BigDecimal getIndServMismaFactura() {
		return this.indServMismaFactura;
	}

	public BigDecimal getIndTitCli() {
		return this.indTitCli;
	}

	public BigDecimal getNisRadPrincipal() {
		return this.nisRadPrincipal;
	}

	public BigDecimal getNumCopias() {
		return this.numCopias;
	}

	public BigDecimal getNumReceivables() {
		return this.numReceivables;
	}

	public String getPrograma() {
		return this.programa;
	}

	public List<RemPayroll> getRemPayrolls() {
		return this.remPayrolls;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public String getTipCta() {
		return this.tipCta;
	}

	public String getTipEnv() {
		return this.tipEnv;
	}

	public String getTipPeriodicidad() {
		return this.tipPeriodicidad;
	}

	public String getTipPuesta() {
		return this.tipPuesta;
	}

	public Date getUsrDatetime1() {
		return this.usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return this.usrDatetime2;
	}

	public Date getUsrDatetime3() {
		return this.usrDatetime3;
	}

	public BigDecimal getUsrNumber1() {
		return this.usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return this.usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return this.usrNumber3;
	}

	public String getUsrVarchar1() {
		return this.usrVarchar1;
	}

	public String getUsrVarchar2() {
		return this.usrVarchar2;
	}

	public String getUsrVarchar3() {
		return this.usrVarchar3;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public RemPayroll removeRemPayroll(final RemPayroll remPayroll) {
		getRemPayrolls().remove(remPayroll);
		remPayroll.setCuentasCu(null);

		return remPayroll;
	}

	public void setAgeCbrEsp(final BigDecimal ageCbrEsp) {
		this.ageCbrEsp = ageCbrEsp;
	}

	public void setCoAccionAusencia(final String coAccionAusencia) {
		this.coAccionAusencia = coAccionAusencia;
	}

	public void setCoCalidadCuenta(final String coCalidadCuenta) {
		this.coCalidadCuenta = coCalidadCuenta;
	}

	public void setCodCli(final BigDecimal codCli) {
		this.codCli = codCli;
	}

	public void setCodCliBenef1(final BigDecimal codCliBenef1) {
		this.codCliBenef1 = codCliBenef1;
	}

	public void setCodCliBenef2(final BigDecimal codCliBenef2) {
		this.codCliBenef2 = codCliBenef2;
	}

	public void setCodCliBenef3(final BigDecimal codCliBenef3) {
		this.codCliBenef3 = codCliBenef3;
	}

	public void setCodCta(final long codCta) {
		this.codCta = codCta;
	}

	public void setCodCtaTestigoDeuda(final BigDecimal codCtaTestigoDeuda) {
		this.codCtaTestigoDeuda = codCtaTestigoDeuda;
	}

	public void setCoIdioma(final String coIdioma) {
		this.coIdioma = coIdioma;
	}

	public void setCoModEnv(final String coModEnv) {
		this.coModEnv = coModEnv;
	}

	public void setCoMotUltPac(final String coMotUltPac) {
		this.coMotUltPac = coMotUltPac;
	}

	public void setDescriptCta(final String descriptCta) {
		this.descriptCta = descriptCta;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public void setFCamb(final Date fCamb) {
		this.fCamb = fCamb;
	}

	public void setFDiaFijo(final Date fDiaFijo) {
		this.fDiaFijo = fDiaFijo;
	}

	public void setFIniPolitica(final Date fIniPolitica) {
		this.fIniPolitica = fIniPolitica;
	}

	public void setFPuesta(final Date fPuesta) {
		this.fPuesta = fPuesta;
	}

	public void setFUltPolitica(final Date fUltPolitica) {
		this.fUltPolitica = fUltPolitica;
	}

	public void setImpLimiteDomic(final BigDecimal impLimiteDomic) {
		this.impLimiteDomic = impLimiteDomic;
	}

	public void setImpReceivables(final BigDecimal impReceivables) {
		this.impReceivables = impReceivables;
	}

	public void setIndPagoCheque(final BigDecimal indPagoCheque) {
		this.indPagoCheque = indPagoCheque;
	}

	public void setIndPagoParcial(final BigDecimal indPagoParcial) {
		this.indPagoParcial = indPagoParcial;
	}

	public void setIndServMismaFactura(final BigDecimal indServMismaFactura) {
		this.indServMismaFactura = indServMismaFactura;
	}

	public void setIndTitCli(final BigDecimal indTitCli) {
		this.indTitCli = indTitCli;
	}

	public void setNisRadPrincipal(final BigDecimal nisRadPrincipal) {
		this.nisRadPrincipal = nisRadPrincipal;
	}

	public void setNumCopias(final BigDecimal numCopias) {
		this.numCopias = numCopias;
	}

	public void setNumReceivables(final BigDecimal numReceivables) {
		this.numReceivables = numReceivables;
	}

	public void setPrograma(final String programa) {
		this.programa = programa;
	}

	public void setRemPayrolls(final List<RemPayroll> remPayrolls) {
		this.remPayrolls = remPayrolls;
	}

	public void setSaldo(final BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void setTipCta(final String tipCta) {
		this.tipCta = tipCta;
	}

	public void setTipEnv(final String tipEnv) {
		this.tipEnv = tipEnv;
	}

	public void setTipPeriodicidad(final String tipPeriodicidad) {
		this.tipPeriodicidad = tipPeriodicidad;
	}

	public void setTipPuesta(final String tipPuesta) {
		this.tipPuesta = tipPuesta;
	}

	public void setUsrDatetime1(final Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public void setUsrDatetime2(final Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public void setUsrDatetime3(final Date usrDatetime3) {
		this.usrDatetime3 = usrDatetime3;
	}

	public void setUsrNumber1(final BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public void setUsrNumber2(final BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public void setUsrNumber3(final BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public void setUsrVarchar1(final String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public void setUsrVarchar2(final String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public void setUsrVarchar3(final String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

}