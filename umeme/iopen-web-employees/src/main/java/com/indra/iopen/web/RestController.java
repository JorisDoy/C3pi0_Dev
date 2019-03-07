package com.indra.iopen.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Localidade;
import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.SgdInstalacionService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	LocalidadeService localidadeService;

	@Autowired
	CallejeroService callejeroService;

	@Autowired
	SgdInstalacionService sgdInstalacionService;

	@RequestMapping(value = "/client/application/villages", method = RequestMethod.GET)
	public @ResponseBody List<Localidade> findVillageByDistrict(
			@RequestParam(value = "codMunic", required = true) BigDecimal district) {
		return this.localidadeService.findVillageByDistrictCode(district);
	}

	@RequestMapping(value = "/client/application/localities", method = RequestMethod.GET)
	public @ResponseBody List<Localidade> findLocalityByVillage(
			@RequestParam(value = "codLocal", required = true) BigDecimal village) {
		return this.localidadeService.findLocalityByVillageCode(village);

	}

	@RequestMapping(value = "/client/application/streets", method = RequestMethod.GET)
	public @ResponseBody List<Callejero> findStreetByLocality(
			@RequestParam(value = "codLocal", required = true) BigDecimal locality) {
		return this.callejeroService.findStreetByLocalityCode(locality);
	}

	/* Select the network */
	@RequestMapping(value = "/connection/result/feeders", method = RequestMethod.GET)
	public @ResponseBody List<SgdInstalacion> findFeeders(
			@RequestParam(value = "subStationCode", required = true) BigDecimal subStationCode) {

		return this.sgdInstalacionService.findFeeder(subStationCode);

	}

	@RequestMapping(value = "/connection/result/transformers", method = RequestMethod.GET)
	public @ResponseBody List<SgdInstalacion> findTransformers(
			@RequestParam(value = "feederCode", required = true) BigDecimal feederCode) {

		return this.sgdInstalacionService.findTransformer(feederCode);

	}

	@RequestMapping(value = "/connection/result/circuits", method = RequestMethod.GET)
	public @ResponseBody List<SgdInstalacion> findCircuits(
			@RequestParam(value = "transformerCode", required = true) BigDecimal transformerCode) {

		return this.sgdInstalacionService.findCircuit(transformerCode);

	}

}
