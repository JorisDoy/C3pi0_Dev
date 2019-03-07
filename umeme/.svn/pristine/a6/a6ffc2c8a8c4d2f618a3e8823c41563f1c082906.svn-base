package com.indra.iopen.repositories.model.ims;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.GiTTipAviso;

public interface GiTTipAvisoRepository extends CrudRepository<GiTTipAviso, Long> {
	List<GiTTipAviso> findGiTTipAvisoByIndAssistance(BigDecimal indAssistance);

	List<GiTTipAviso> findGiTTipAvisoByIndNormal(BigDecimal indNormal);

	List<GiTTipAviso> findGiTTipAvisoByIndQuality(BigDecimal indQuality);
}
