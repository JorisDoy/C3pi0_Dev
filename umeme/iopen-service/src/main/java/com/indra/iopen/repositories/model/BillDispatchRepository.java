package com.indra.iopen.repositories.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.BillDispatch;
import com.indra.iopen.model.BillDispatchPK;
import com.indra.iopen.repositories.model.impl.BillDispatchRepositoryCustom;

public interface BillDispatchRepository
		extends CrudRepository<BillDispatch, BillDispatchPK>, BillDispatchRepositoryCustom {

	List<BillDispatch> findBillDispatchByIdNisRadOrderByIdTipDispatchAsc(Long nisRad);
}
