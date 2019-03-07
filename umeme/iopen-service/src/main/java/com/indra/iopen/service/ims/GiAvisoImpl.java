package com.indra.iopen.service.ims;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.model.ims.GiTUltimo;
import com.indra.iopen.repositories.model.ims.GiTUltimoRepository;
import com.indra.iopen.util.ApplicationDefault;

@Transactional
@Service
public class GiAvisoImpl {

	@Autowired
	private GiTUltimoRepository giTUltimoRepository;

	public long getGiAvisoId(String tableName) {
		Long id = null;
		try {
			GiTUltimo giTUltimo = giTUltimoRepository.getGiTUltimoRepositoryByTableName(tableName);
			id = giTUltimo.getUltimo().longValue() + 1;
			Date now = new Date();

			giTUltimo = giTUltimoRepository.findOne(giTUltimo.getId());
			giTUltimo.setUltimo(new BigDecimal(id));
			giTUltimo.setFActual(now);
			giTUltimo.setHActual(now);
			giTUltimo.setPrograma(ApplicationDefault.getProgram());
			giTUltimo.setUsuario(ApplicationDefault.getDatabaseUser());

			giTUltimoRepository.save(giTUltimo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}