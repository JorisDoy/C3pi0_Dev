package com.indra.iopen.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iopen.facade.InspectionResultsFacade;
import com.indra.iopen.facade.UtilityFacade;
import com.indra.iopen.pojo.Edited;
import com.indra.iopen.pojo.GISInspectionResult;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class GISApplicationController {
	@Autowired
	private InspectionResultsFacade inspectionResultsFacade;
	@Autowired
	private UtilityFacade utilityFacade;

	@RequestMapping(value = "/gis", method = RequestMethod.GET)
	public ResponseEntity<GISInspectionResult> getReceivedInspectionResult() throws Exception {
		return new ResponseEntity<GISInspectionResult>(new GISInspectionResult(), HttpStatus.OK);
	}

	@RequestMapping(value = "/gis", method = RequestMethod.POST)
	public ResponseEntity<Edited> addInspectionResults(@Valid @RequestBody GISInspectionResult gisInspectionResult,
			BindingResult bindingResult) throws Exception {
		utilityFacade.validateRequest(bindingResult);
		return inspectionResultsFacade.recieveGISInspectionResults(gisInspectionResult);
	}
}
