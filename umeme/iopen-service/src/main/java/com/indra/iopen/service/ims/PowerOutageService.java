package com.indra.iopen.service.ims;

import java.util.List;

import com.indra.iopen.form.PowerOutageFilter;
import com.indra.iopen.form.ims.PowerOutage;
import com.indra.iopen.model.ims.SgdValor;

public interface PowerOutageService {
	List<PowerOutage> getPowerOutages(PowerOutageFilter powerOutageFilter) throws Exception;

	PowerOutage getPowerOutage(long nroIncidencia) throws Exception;

	List<SgdValor> getPowerOutageStatuses();

	PowerOutageFilter getPowerOutageFilter();

}
