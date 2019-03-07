package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.repositories.model.SgdInstalacionRepository;

@Service
@PropertySource("classpath:application.properties")
public class SgdInstalacionServiceImpl implements SgdInstalacionService {

	@Autowired
	private SgdInstalacionRepository sgdInstalacionRepository;
	@Autowired
	private Environment env;

	@Override
	public List<SgdInstalacion> findSubStations() {
		List<SgdInstalacion> list = new ArrayList<SgdInstalacion>();

		try {
			BigDecimal tipoInstalacion = new BigDecimal(
					env.getProperty("application.sgd.instalacion.tipo.instalacion.sub.station.value"));
			BigDecimal estado = new BigDecimal(env.getProperty("application.sgd.instalacion.estado.default.value"));
			Long bdiJob = Long.valueOf(env.getProperty("application.sgd.instalacion.bdi.job.default.value"));

			list = sgdInstalacionRepository
					.findSgdInstalacionByTipoInstalacionAndEstadoAndIdBdiJobOrderByNomInstalacionAsc(tipoInstalacion,
							estado, bdiJob);

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SgdInstalacion> findFeeder(BigDecimal nroInstPadre) {
		BigDecimal tipoInstalacion = new BigDecimal(
				env.getProperty("application.sgd.instalacion.tipo.instalacion.feeder.value"));
		return findOtherInstalacions(tipoInstalacion, nroInstPadre);
	}

	@Override
	public List<SgdInstalacion> findTransformer(BigDecimal nroInstPadre) {
		BigDecimal tipoInstalacion = new BigDecimal(
				env.getProperty("application.sgd.instalacion.tipo.instalacion.transformer.value"));
		return findOtherInstalacions(tipoInstalacion, nroInstPadre);
	}

	@Override
	public List<SgdInstalacion> findCircuit(BigDecimal nroInstPadre) {
		BigDecimal tipoInstalacion = new BigDecimal(
				env.getProperty("application.sgd.instalacion.tipo.instalacion.circuit.value"));
		return findOtherInstalacions(tipoInstalacion, nroInstPadre);
	}

	private List<SgdInstalacion> findOtherInstalacions(BigDecimal tipoInstalacion, BigDecimal nroInstPadre) {
		List<SgdInstalacion> list = new ArrayList<SgdInstalacion>();

		try {

			BigDecimal estado = new BigDecimal(env.getProperty("application.sgd.instalacion.estado.default.value"));
			Long bdiJob = Long.valueOf(env.getProperty("application.sgd.instalacion.bdi.job.default.value"));

			list = sgdInstalacionRepository
					.findSgdInstalacionByTipoInstalacionAndNroInstPadreAndEstadoAndIdBdiJobOrderByNomInstalacionAsc(
							tipoInstalacion, nroInstPadre, estado, bdiJob);

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return list;
	}
}
