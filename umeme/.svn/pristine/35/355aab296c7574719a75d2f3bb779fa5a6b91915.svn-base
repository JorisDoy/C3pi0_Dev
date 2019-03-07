package com.indra.iopen.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application.properties")
@Component
public class ApplicationDefault implements EnvironmentAware {

	private static Environment env;

	private static final String PROPERTY_NAME_TIP_MOV = "application.default.presupestos_exped.tip_mov.value";

	public static String getActividadesestAct() {
		return env.getRequiredProperty("application.stage.initial.insertion.value");
	}

	public static String getActividadesnumAct() {
		return env.getRequiredProperty("application.default.actividades.num_act.value");
	}

	public static String getApplicationExpedienteCancel() {
		return env.getRequiredProperty("application.expediente.cancel");
	}

	public static String getApplicationIopenStatusCancel() {
		return env.getRequiredProperty("application.iopenstatus.cancel");
	}
	
	public static String getApplicationIopenStatusReject() {
		return env.getRequiredProperty("application.iopenstatus.reject");
	}

	public static String getApplicationstatus() {
		return env.getRequiredProperty("application.default.status");
	}

	public static String getClienteIdentificadorCodProv() {
		return env.getRequiredProperty("application.default.cliente_identificador.cod_prov.value");
	}

	public static String getClienteIdentificadorIndPrimario() {
		return env.getRequiredProperty("application.default.cliente_identificador.ind_primario.value");
	}

	public static String getClienteIdentificadorPKSecId() {
		return env.getRequiredProperty("application.default.cliente_identificador_pk.sec_id.value");
	}

	public static String getClientesNif() {
		return env.getRequiredProperty("application.default.clientes.nif.value");
	}

	public static String getCuentasCucoAccionAusencia() {
		return env.getRequiredProperty("application.default.cuentas_cu.co_accion_ausencia.value");
	}

	public static String getCuentasCucoCalidadCuenta() {
		return env.getRequiredProperty("application.default.cuentas_cu.co_calidad_cuenta.value");
	}

	public static String getCuentasCucoIdioma() {
		return env.getRequiredProperty("application.default.cuentas_cu.co_idioma.value");
	}

	public static String getCuentasCucoModEnv() {
		return env.getRequiredProperty("application.default.cuentas_cu.co_mod_env.value");
	}

	public static String getCuentasCuCoModEnv() {
		return env.getRequiredProperty("application.default.cuentas_cu.co_mod_env.value");
	}

	public static String getCuentasCucoMotUltPac() {
		return env.getRequiredProperty("application.default.cuentas_cu.co_mot_ult_pac.value");
	}

	public static String getCuentasCuNomCopias() {
		return env.getRequiredProperty("application.default.cuentas_cu.nom_copias.value");
	}

	public static String getCuentasCuTipCta() {
		return env.getRequiredProperty("application.default.cuentas_cu.tip_cta.value");
	}

	public static String getCuentasCuTipEnv() {
		return env.getRequiredProperty("application.default.cuentas_cu.tip_env.value");
	}

	public static String getCuentasCutipPeriodicidad() {
		return env.getRequiredProperty("application.default.cuentas_cu.tip_periodicidad.value");
	}

	public static String getCuentasCutipPuesta() {
		return env.getRequiredProperty("application.default.cuentas_cu.tip_puesta.value");
	}

	public static String getDatabaseUser() {
		return env.getRequiredProperty("application.database.user.value");
	}

	public static String getDireccionprioridad() {
		return env.getRequiredProperty("application.default.direccion_cta.prioridad.value");
	}

	public static String getDirecciontipDirecion() {
		return env.getRequiredProperty("application.default.direccion.tip_direcion.value");
	}

	public static String getExpedientesestado() {
		return env.getRequiredProperty("application.stage.initial.insertion.value");
	}

	public static String getExpedientespotTotLine() {
		return env.getRequiredProperty("application.default.expedientes.pot_tot_line.value");
	}

	public static String getExpedientestipConexion() {
		return env.getRequiredProperty("application.default.expedientes.tip_conexion.value");
	}

	public static String getExpedientestipObra() {
		return env.getRequiredProperty("application.default.expedientes.tip_obra.value");
	}

	public static String getExpedientestipServ() {
		return env.getRequiredProperty("application.default.expedientes.tip_serv.value");
	}

	public static String getInvGroupidTipImagen() {
		return env.getRequiredProperty("application.default.inv_group.id_tip_imagen.value");
	}

	public static String getInvGroupigSize() {
		return env.getRequiredProperty("application.default.inv_group.ig_size.value");
	}

	public static String getPresupestosExpedcantidad() {
		return env.getRequiredProperty("application.default.presupestos_exped.cantidad.value");
	}

	public static String getPresupestosExpedcodPresupuesto() {
		return env.getRequiredProperty("application.default.presupestos_exped.cod_presupuesto.value");
	}

	public static String getPresupestosExpeddescCategoria() {
		return env.getRequiredProperty("application.default.presupestos_exped.desc_categoria");
	}

	public static String getPresupestosExpeddescCncepto_pres() {
		return env.getRequiredProperty("application.default.presupestos_exped.desc_cncepto_pres");
	}

	public static String getPresupestosExpedestado() {
		return env.getRequiredProperty("application.default.presupestos_exped.estado.value");
	}

	public static String getPresupestosExpedindBg() {
		return env.getRequiredProperty("application.default.presupestos_exped.ind_bg.value");
	}

	public static String getPresupestosExpedpresupuestosSec() {
		return env.getRequiredProperty("application.default.presupestos_exped.presupuestos_sec.value");
	}

	public static String getPresupestosExpedtipMov() {
		return env.getRequiredProperty(PROPERTY_NAME_TIP_MOV);
	}

	public static String getProgram() {
		return env.getRequiredProperty("application.program.value");
	}

	public static String getSumExpcantSum() {
		return env.getRequiredProperty("application.default.sum_exp.cant_sum.value");
	}

	@Override

	public void setEnvironment(final Environment environment) {

		ApplicationDefault.env = environment;

	}

}
