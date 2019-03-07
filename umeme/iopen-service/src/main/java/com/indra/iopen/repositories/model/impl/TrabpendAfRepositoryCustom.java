package com.indra.iopen.repositories.model.impl;

import com.indra.iopen.model.TrabpendAf;

public interface TrabpendAfRepositoryCustom {

    TrabpendAf findTrabpendAfToBeUpdatedWhenCommitingInspectionResults(Long numOs,
            String estAf, String estOs);
}
