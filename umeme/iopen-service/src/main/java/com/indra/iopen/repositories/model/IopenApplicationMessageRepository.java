package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.IopenApplicationMessage;
import com.indra.iopen.model.IopenApplicationMessagePK;
import com.indra.iopen.repositories.model.impl.IopenApplicationMessageCustom;

//SMA 20160314
public interface IopenApplicationMessageRepository
extends CrudRepository<IopenApplicationMessage, IopenApplicationMessagePK>,IopenApplicationMessageCustom {


}
