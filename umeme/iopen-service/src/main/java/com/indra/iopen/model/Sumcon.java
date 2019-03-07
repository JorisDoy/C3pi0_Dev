package com.indra.iopen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the SUMCON database table.
 *
 */
@Entity
@NamedQuery(name = "Sumcon.findAll", query = "SELECT s FROM Sumcon s")
public class Sumcon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NIS_RAD")
	private Long nisRad;

	@Column(name = "BOCAS_CONTRAINCENDIO")
	private BigDecimal bocasContraincendio;

	@Column(name = "CANT_FIJA_COBRO")
	private BigDecimal cantFijaCobro;

	@Column(name = "CANT_SUM_SER")
	private BigDecimal cantSumSer;

	@Column(name = "CGV_SERV")
	private String cgvServ;

	@Column(name = "CO_AN_VIP")
	private String coAnVip;

	@Column(name = "CO_ASIGNACION")
	private String coAsignacion;

	@Column(name = "CO_COND_FISCAL")
	private String coCondFiscal;

	@Column(name = "CO_ESTM")
	private String coEstm;

	@Column(name = "CO_FACTURACION")
	private String coFacturacion;

	@Column(name = "CO_MODO_PAGO")
	private String coModoPago;

	@Column(name = "CO_MOTIVO")
	private String coMotivo;

	@Column(name = "CO_MOTNOCORT")
	private String coMotnocort;

	@Column(name = "CO_PERFIL_UTILIZACION")
	private String coPerfilUtilizacion;

	@Column(name = "COD_CLI")
	private BigDecimal codCli;

	@Column(name = "COD_CLI_ACC_HOLD")
	private BigDecimal codCliAccHold;

	@Column(name = "COD_CLI_SOLIDARIO")
	private BigDecimal codCliSolidario;

	@Column(name = "COD_CNAE")
	private String codCnae;

	@Column(name = "COD_CTA")
	private BigDecimal codCta;

	@Column(name = "COD_EMPRESA_OPERATIVA")
	private BigDecimal codEmpresaOperativa;

	@Column(name = "COD_EMPRESA_PROVEEDORA")
	private BigDecimal codEmpresaProveedora;

	@Column(name = "COD_TAR")
	private String codTar;

	@Column(name = "COD_TAR_ADICIONAL")
	private String codTarAdicional;

	@Column(name = "COD_UNICOM")
	private BigDecimal codUnicom;

	@Column(name = "CONT_TRANS_POT")
	private BigDecimal contTransPot;

	@Column(name = "CSMO_FIJO")
	private BigDecimal csmoFijo;

	@Column(name = "EST_SERV")
	private String estServ;

	@Column(name = "ESTM_ANUAL")
	private BigDecimal estmAnual;

	@Column(name = "ESTM_CONS")
	private BigDecimal estmCons;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALTA")
	private Date fAlta;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALTA_CONT")
	private Date fAltaCont;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_BAJA_SERV")
	private Date fBajaServ;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_CORR_SERV")
	private Date fCorrServ;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_CORTE_SERV")
	private Date fCorteServ;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_MOD_SERV")
	private Date fModServ;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_POSIBLE_REVISION")
	private Date fPosibleRevision;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_REENGANCHE")
	private Date fReenganche;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_RES_CONT")
	private Date fResCont;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_TRANS_POT")
	private Date fTransPot;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PROXIMA_FAC")
	private Date fechaProximaFac;

	@Column(name = "GR_CONCEPTO")
	private BigDecimal grConcepto;

	@Column(name = "GR_CONCEPTO_ADICIONAL")
	private BigDecimal grConceptoAdicional;

	@Column(name = "GRUPO_FAMIL")
	private BigDecimal grupoFamil;

	@Column(name = "HORA_UTIL")
	private BigDecimal horaUtil;

	@Column(name = "IMP_DERECHOS_CONEX")
	private BigDecimal impDerechosConex;

	@Column(name = "IMP_DERECHOS_CONEX_PAGADO")
	private BigDecimal impDerechosConexPagado;

	@Column(name = "IMP_PREC_DEFECTO")
	private BigDecimal impPrecDefecto;

	@Column(name = "IND_AN_NODET")
	private BigDecimal indAnNodet;

	@Column(name = "IND_BONIF")
	private BigDecimal indBonif;

	@Column(name = "IND_CONVERT_RA")
	private BigDecimal indConvertRa;

	@Column(name = "IND_CORTABLE")
	private BigDecimal indCortable;

	@Column(name = "IND_ESTACION")
	private BigDecimal indEstacion;

	@Column(name = "IND_EVENTUAL")
	private BigDecimal indEventual;

	@Column(name = "IND_GASTOS_ADICIONALES")
	private BigDecimal indGastosAdicionales;

	@Column(name = "LOADSHAPE_ID")
	private BigDecimal loadshapeId;

	private BigDecimal nic;

	private BigDecimal nif;

	@Column(name = "NIS_RAD_PTE")
	private BigDecimal nisRadPte;

	@Column(name = "NIS_SOLIDARIO")
	private BigDecimal nisSolidario;

	@Column(name = "NUM_CORT")
	private BigDecimal numCort;

	@Column(name = "NUM_SUM")
	private BigDecimal numSum;

	private String pot;

	@Column(name = "POT_PENAL")
	private BigDecimal potPenal;

	private String programa;

	@Column(name = "RESP_NO_CORT")
	private String respNoCort;

	@Column(name = "SEC_NIS")
	private BigDecimal secNis;

	@Column(name = "SEC_NIS_SOLIDARIO")
	private BigDecimal secNisSolidario;

	@Column(name = "TASA_MULTA")
	private BigDecimal tasaMulta;

	@Column(name = "TASA_RECARGO")
	private BigDecimal tasaRecargo;

	@Column(name = "TIP_CALENDARIO")
	private String tipCalendario;

	@Column(name = "TIP_CONEXION_CD")
	private String tipConexionCd;

	@Column(name = "TIP_CONTR")
	private String tipContr;

	@Column(name = "TIP_MULTA")
	private String tipMulta;

	@Column(name = "TIP_PER_FACT")
	private String tipPerFact;

	@Column(name = "TIP_RECARGO")
	private String tipRecargo;

	@Column(name = "TIP_SERV")
	private String tipServ;

	@Column(name = "TIP_USO")
	private String tipUso;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME1")
	private Date usrDatetime1;

	@Temporal(TemporalType.DATE)
	@Column(name = "USR_DATETIME2")
	private Date usrDatetime2;

	@Column(name = "USR_NUMBER1")
	private BigDecimal usrNumber1;

	@Column(name = "USR_NUMBER2")
	private BigDecimal usrNumber2;

	@Column(name = "USR_NUMBER3")
	private BigDecimal usrNumber3;

	@Column(name = "USR_NUMBER4")
	private BigDecimal usrNumber4;

	@Column(name = "USR_NUMBER5")
	private BigDecimal usrNumber5;

	@Column(name = "USR_VARCHAR1")
	private String usrVarchar1;

	@Column(name = "USR_VARCHAR2")
	private String usrVarchar2;

	@Column(name = "USR_VARCHAR3")
	private String usrVarchar3;

	private String usuario;

	// bi-directional many-to-one association to LcaClientData
	@OneToMany(mappedBy = "sumcon")
	private List<LcaClientData> lcaClientData;

	// bi-directional many-to-one association to RemPayroll
	@OneToMany(mappedBy = "sumcon")
	private List<RemPayroll> remPayrolls;

	public Sumcon() {
	}

	public Long getNisRad() {
		return nisRad;
	}

	public void setNisRad(Long nisRad) {
		this.nisRad = nisRad;
	}

	public BigDecimal getBocasContraincendio() {
		return bocasContraincendio;
	}

	public void setBocasContraincendio(BigDecimal bocasContraincendio) {
		this.bocasContraincendio = bocasContraincendio;
	}

	public BigDecimal getCantFijaCobro() {
		return cantFijaCobro;
	}

	public void setCantFijaCobro(BigDecimal cantFijaCobro) {
		this.cantFijaCobro = cantFijaCobro;
	}

	public BigDecimal getCantSumSer() {
		return cantSumSer;
	}

	public void setCantSumSer(BigDecimal cantSumSer) {
		this.cantSumSer = cantSumSer;
	}

	public String getCgvServ() {
		return cgvServ;
	}

	public void setCgvServ(String cgvServ) {
		this.cgvServ = cgvServ;
	}

	public String getCoAnVip() {
		return coAnVip;
	}

	public void setCoAnVip(String coAnVip) {
		this.coAnVip = coAnVip;
	}

	public String getCoAsignacion() {
		return coAsignacion;
	}

	public void setCoAsignacion(String coAsignacion) {
		this.coAsignacion = coAsignacion;
	}

	public String getCoCondFiscal() {
		return coCondFiscal;
	}

	public void setCoCondFiscal(String coCondFiscal) {
		this.coCondFiscal = coCondFiscal;
	}

	public String getCoEstm() {
		return coEstm;
	}

	public void setCoEstm(String coEstm) {
		this.coEstm = coEstm;
	}

	public String getCoFacturacion() {
		return coFacturacion;
	}

	public void setCoFacturacion(String coFacturacion) {
		this.coFacturacion = coFacturacion;
	}

	public String getCoModoPago() {
		return coModoPago;
	}

	public void setCoModoPago(String coModoPago) {
		this.coModoPago = coModoPago;
	}

	public String getCoMotivo() {
		return coMotivo;
	}

	public void setCoMotivo(String coMotivo) {
		this.coMotivo = coMotivo;
	}

	public String getCoMotnocort() {
		return coMotnocort;
	}

	public void setCoMotnocort(String coMotnocort) {
		this.coMotnocort = coMotnocort;
	}

	public String getCoPerfilUtilizacion() {
		return coPerfilUtilizacion;
	}

	public void setCoPerfilUtilizacion(String coPerfilUtilizacion) {
		this.coPerfilUtilizacion = coPerfilUtilizacion;
	}

	public BigDecimal getCodCli() {
		return codCli;
	}

	public void setCodCli(BigDecimal codCli) {
		this.codCli = codCli;
	}

	public BigDecimal getCodCliAccHold() {
		return codCliAccHold;
	}

	public void setCodCliAccHold(BigDecimal codCliAccHold) {
		this.codCliAccHold = codCliAccHold;
	}

	public BigDecimal getCodCliSolidario() {
		return codCliSolidario;
	}

	public void setCodCliSolidario(BigDecimal codCliSolidario) {
		this.codCliSolidario = codCliSolidario;
	}

	public String getCodCnae() {
		return codCnae;
	}

	public void setCodCnae(String codCnae) {
		this.codCnae = codCnae;
	}

	public BigDecimal getCodCta() {
		return codCta;
	}

	public void setCodCta(BigDecimal codCta) {
		this.codCta = codCta;
	}

	public BigDecimal getCodEmpresaOperativa() {
		return codEmpresaOperativa;
	}

	public void setCodEmpresaOperativa(BigDecimal codEmpresaOperativa) {
		this.codEmpresaOperativa = codEmpresaOperativa;
	}

	public BigDecimal getCodEmpresaProveedora() {
		return codEmpresaProveedora;
	}

	public void setCodEmpresaProveedora(BigDecimal codEmpresaProveedora) {
		this.codEmpresaProveedora = codEmpresaProveedora;
	}

	public String getCodTar() {
		return codTar;
	}

	public void setCodTar(String codTar) {
		this.codTar = codTar;
	}

	public String getCodTarAdicional() {
		return codTarAdicional;
	}

	public void setCodTarAdicional(String codTarAdicional) {
		this.codTarAdicional = codTarAdicional;
	}

	public BigDecimal getCodUnicom() {
		return codUnicom;
	}

	public void setCodUnicom(BigDecimal codUnicom) {
		this.codUnicom = codUnicom;
	}

	public BigDecimal getContTransPot() {
		return contTransPot;
	}

	public void setContTransPot(BigDecimal contTransPot) {
		this.contTransPot = contTransPot;
	}

	public BigDecimal getCsmoFijo() {
		return csmoFijo;
	}

	public void setCsmoFijo(BigDecimal csmoFijo) {
		this.csmoFijo = csmoFijo;
	}

	public String getEstServ() {
		return estServ;
	}

	public void setEstServ(String estServ) {
		this.estServ = estServ;
	}

	public BigDecimal getEstmAnual() {
		return estmAnual;
	}

	public void setEstmAnual(BigDecimal estmAnual) {
		this.estmAnual = estmAnual;
	}

	public BigDecimal getEstmCons() {
		return estmCons;
	}

	public void setEstmCons(BigDecimal estmCons) {
		this.estmCons = estmCons;
	}

	public Date getFActual() {
		return fActual;
	}

	public void setFActual(Date fActual) {
		this.fActual = fActual;
	}

	public Date getFAlta() {
		return fAlta;
	}

	public void setFAlta(Date fAlta) {
		this.fAlta = fAlta;
	}

	public Date getFAltaCont() {
		return fAltaCont;
	}

	public void setFAltaCont(Date fAltaCont) {
		this.fAltaCont = fAltaCont;
	}

	public Date getFBajaServ() {
		return fBajaServ;
	}

	public void setFBajaServ(Date fBajaServ) {
		this.fBajaServ = fBajaServ;
	}

	public Date getFCorrServ() {
		return fCorrServ;
	}

	public void setFCorrServ(Date fCorrServ) {
		this.fCorrServ = fCorrServ;
	}

	public Date getFCorteServ() {
		return fCorteServ;
	}

	public void setFCorteServ(Date fCorteServ) {
		this.fCorteServ = fCorteServ;
	}

	public Date getFModServ() {
		return fModServ;
	}

	public void setFModServ(Date fModServ) {
		this.fModServ = fModServ;
	}

	public Date getFPosibleRevision() {
		return fPosibleRevision;
	}

	public void setFPosibleRevision(Date fPosibleRevision) {
		this.fPosibleRevision = fPosibleRevision;
	}

	public Date getFReenganche() {
		return fReenganche;
	}

	public void setFReenganche(Date fReenganche) {
		this.fReenganche = fReenganche;
	}

	public Date getFResCont() {
		return fResCont;
	}

	public void setFResCont(Date fResCont) {
		this.fResCont = fResCont;
	}

	public Date getFTransPot() {
		return fTransPot;
	}

	public void setFTransPot(Date fTransPot) {
		this.fTransPot = fTransPot;
	}

	public Date getFechaProximaFac() {
		return fechaProximaFac;
	}

	public void setFechaProximaFac(Date fechaProximaFac) {
		this.fechaProximaFac = fechaProximaFac;
	}

	public BigDecimal getGrConcepto() {
		return grConcepto;
	}

	public void setGrConcepto(BigDecimal grConcepto) {
		this.grConcepto = grConcepto;
	}

	public BigDecimal getGrConceptoAdicional() {
		return grConceptoAdicional;
	}

	public void setGrConceptoAdicional(BigDecimal grConceptoAdicional) {
		this.grConceptoAdicional = grConceptoAdicional;
	}

	public BigDecimal getGrupoFamil() {
		return grupoFamil;
	}

	public void setGrupoFamil(BigDecimal grupoFamil) {
		this.grupoFamil = grupoFamil;
	}

	public BigDecimal getHoraUtil() {
		return horaUtil;
	}

	public void setHoraUtil(BigDecimal horaUtil) {
		this.horaUtil = horaUtil;
	}

	public BigDecimal getImpDerechosConex() {
		return impDerechosConex;
	}

	public void setImpDerechosConex(BigDecimal impDerechosConex) {
		this.impDerechosConex = impDerechosConex;
	}

	public BigDecimal getImpDerechosConexPagado() {
		return impDerechosConexPagado;
	}

	public void setImpDerechosConexPagado(BigDecimal impDerechosConexPagado) {
		this.impDerechosConexPagado = impDerechosConexPagado;
	}

	public BigDecimal getImpPrecDefecto() {
		return impPrecDefecto;
	}

	public void setImpPrecDefecto(BigDecimal impPrecDefecto) {
		this.impPrecDefecto = impPrecDefecto;
	}

	public BigDecimal getIndAnNodet() {
		return indAnNodet;
	}

	public void setIndAnNodet(BigDecimal indAnNodet) {
		this.indAnNodet = indAnNodet;
	}

	public BigDecimal getIndBonif() {
		return indBonif;
	}

	public void setIndBonif(BigDecimal indBonif) {
		this.indBonif = indBonif;
	}

	public BigDecimal getIndConvertRa() {
		return indConvertRa;
	}

	public void setIndConvertRa(BigDecimal indConvertRa) {
		this.indConvertRa = indConvertRa;
	}

	public BigDecimal getIndCortable() {
		return indCortable;
	}

	public void setIndCortable(BigDecimal indCortable) {
		this.indCortable = indCortable;
	}

	public BigDecimal getIndEstacion() {
		return indEstacion;
	}

	public void setIndEstacion(BigDecimal indEstacion) {
		this.indEstacion = indEstacion;
	}

	public BigDecimal getIndEventual() {
		return indEventual;
	}

	public void setIndEventual(BigDecimal indEventual) {
		this.indEventual = indEventual;
	}

	public BigDecimal getIndGastosAdicionales() {
		return indGastosAdicionales;
	}

	public void setIndGastosAdicionales(BigDecimal indGastosAdicionales) {
		this.indGastosAdicionales = indGastosAdicionales;
	}

	public BigDecimal getLoadshapeId() {
		return loadshapeId;
	}

	public void setLoadshapeId(BigDecimal loadshapeId) {
		this.loadshapeId = loadshapeId;
	}

	public BigDecimal getNic() {
		return nic;
	}

	public void setNic(BigDecimal nic) {
		this.nic = nic;
	}

	public BigDecimal getNif() {
		return nif;
	}

	public void setNif(BigDecimal nif) {
		this.nif = nif;
	}

	public BigDecimal getNisRadPte() {
		return nisRadPte;
	}

	public void setNisRadPte(BigDecimal nisRadPte) {
		this.nisRadPte = nisRadPte;
	}

	public BigDecimal getNisSolidario() {
		return nisSolidario;
	}

	public void setNisSolidario(BigDecimal nisSolidario) {
		this.nisSolidario = nisSolidario;
	}

	public BigDecimal getNumCort() {
		return numCort;
	}

	public void setNumCort(BigDecimal numCort) {
		this.numCort = numCort;
	}

	public BigDecimal getNumSum() {
		return numSum;
	}

	public void setNumSum(BigDecimal numSum) {
		this.numSum = numSum;
	}

	public String getPot() {
		return pot;
	}

	public void setPot(String pot) {
		this.pot = pot;
	}

	public BigDecimal getPotPenal() {
		return potPenal;
	}

	public void setPotPenal(BigDecimal potPenal) {
		this.potPenal = potPenal;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getRespNoCort() {
		return respNoCort;
	}

	public void setRespNoCort(String respNoCort) {
		this.respNoCort = respNoCort;
	}

	public BigDecimal getSecNis() {
		return secNis;
	}

	public void setSecNis(BigDecimal secNis) {
		this.secNis = secNis;
	}

	public BigDecimal getSecNisSolidario() {
		return secNisSolidario;
	}

	public void setSecNisSolidario(BigDecimal secNisSolidario) {
		this.secNisSolidario = secNisSolidario;
	}

	public BigDecimal getTasaMulta() {
		return tasaMulta;
	}

	public void setTasaMulta(BigDecimal tasaMulta) {
		this.tasaMulta = tasaMulta;
	}

	public BigDecimal getTasaRecargo() {
		return tasaRecargo;
	}

	public void setTasaRecargo(BigDecimal tasaRecargo) {
		this.tasaRecargo = tasaRecargo;
	}

	public String getTipCalendario() {
		return tipCalendario;
	}

	public void setTipCalendario(String tipCalendario) {
		this.tipCalendario = tipCalendario;
	}

	public String getTipConexionCd() {
		return tipConexionCd;
	}

	public void setTipConexionCd(String tipConexionCd) {
		this.tipConexionCd = tipConexionCd;
	}

	public String getTipContr() {
		return tipContr;
	}

	public void setTipContr(String tipContr) {
		this.tipContr = tipContr;
	}

	public String getTipMulta() {
		return tipMulta;
	}

	public void setTipMulta(String tipMulta) {
		this.tipMulta = tipMulta;
	}

	public String getTipPerFact() {
		return tipPerFact;
	}

	public void setTipPerFact(String tipPerFact) {
		this.tipPerFact = tipPerFact;
	}

	public String getTipRecargo() {
		return tipRecargo;
	}

	public void setTipRecargo(String tipRecargo) {
		this.tipRecargo = tipRecargo;
	}

	public String getTipServ() {
		return tipServ;
	}

	public void setTipServ(String tipServ) {
		this.tipServ = tipServ;
	}

	public String getTipUso() {
		return tipUso;
	}

	public void setTipUso(String tipUso) {
		this.tipUso = tipUso;
	}

	public Date getUsrDatetime1() {
		return usrDatetime1;
	}

	public void setUsrDatetime1(Date usrDatetime1) {
		this.usrDatetime1 = usrDatetime1;
	}

	public Date getUsrDatetime2() {
		return usrDatetime2;
	}

	public void setUsrDatetime2(Date usrDatetime2) {
		this.usrDatetime2 = usrDatetime2;
	}

	public BigDecimal getUsrNumber1() {
		return usrNumber1;
	}

	public void setUsrNumber1(BigDecimal usrNumber1) {
		this.usrNumber1 = usrNumber1;
	}

	public BigDecimal getUsrNumber2() {
		return usrNumber2;
	}

	public void setUsrNumber2(BigDecimal usrNumber2) {
		this.usrNumber2 = usrNumber2;
	}

	public BigDecimal getUsrNumber3() {
		return usrNumber3;
	}

	public void setUsrNumber3(BigDecimal usrNumber3) {
		this.usrNumber3 = usrNumber3;
	}

	public BigDecimal getUsrNumber4() {
		return usrNumber4;
	}

	public void setUsrNumber4(BigDecimal usrNumber4) {
		this.usrNumber4 = usrNumber4;
	}

	public BigDecimal getUsrNumber5() {
		return usrNumber5;
	}

	public void setUsrNumber5(BigDecimal usrNumber5) {
		this.usrNumber5 = usrNumber5;
	}

	public String getUsrVarchar1() {
		return usrVarchar1;
	}

	public void setUsrVarchar1(String usrVarchar1) {
		this.usrVarchar1 = usrVarchar1;
	}

	public String getUsrVarchar2() {
		return usrVarchar2;
	}

	public void setUsrVarchar2(String usrVarchar2) {
		this.usrVarchar2 = usrVarchar2;
	}

	public String getUsrVarchar3() {
		return usrVarchar3;
	}

	public void setUsrVarchar3(String usrVarchar3) {
		this.usrVarchar3 = usrVarchar3;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<LcaClientData> getLcaClientData() {
		return lcaClientData;
	}

	public void setLcaClientData(List<LcaClientData> lcaClientData) {
		this.lcaClientData = lcaClientData;
	}

	public LcaClientData addLcaClientData(LcaClientData lcaClientData) {
		getLcaClientData().add(lcaClientData);
		lcaClientData.setSumcon(this);

		return lcaClientData;
	}

	public LcaClientData removeLcaClientData(LcaClientData lcaClientData) {
		getLcaClientData().remove(lcaClientData);
		lcaClientData.setSumcon(null);

		return lcaClientData;
	}

	public List<RemPayroll> getRemPayrolls() {
		return remPayrolls;
	}

	public void setRemPayrolls(List<RemPayroll> remPayrolls) {
		this.remPayrolls = remPayrolls;
	}

	public RemPayroll addRemPayroll(RemPayroll remPayroll) {
		getRemPayrolls().add(remPayroll);
		remPayroll.setSumcon(this);

		return remPayroll;
	}

	public RemPayroll removeRemPayroll(RemPayroll remPayroll) {
		getRemPayrolls().remove(remPayroll);
		remPayroll.setSumcon(null);

		return remPayroll;
	}

}