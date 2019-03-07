package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.model.Codigo;
import com.indra.iopen.model.Estado;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.Mtarifa;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.model.ims.GiTTipAviso;
import com.indra.iopen.model.ims.SgdValor;
import com.indra.iopen.util.ApplicationAdvanceType;

public interface CommonService {

	List<Codigo> getCodigos(String filter);

	List<Tipo> getTipos(String filter);

	List<Estado> getEstados(String filter);

	List<SgdValor> getSgdValors(String filter);

	List<Mtarifa> getAllMtarifas();

	void sendMessagesClientsToInformOfAdvanceInApplicationStatus(List<IopenApplication> iopenApplications,
			ApplicationAdvanceType applicationAdvanceType, Object... object);

	List<SgdValor> getScopes();

	List<GiTTipAviso> getComplaintNatures();

	List<SgdValor> getComplaintTypes();

	String getApplicationTypesName(String applicationTypeCode);

}
