package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;
import com.indra.iopen.model.TrabpendAf;
import com.indra.iopen.repositories.model.impl.TrabpendAfRepositoryCustom;

public interface TrabpendAfRepository extends CrudRepository<TrabpendAf, Long>, TrabpendAfRepositoryCustom {

    // @Query("select x from trabpend_af x where x.num_af in "
    // + "(select d.num_af from trabpend_af d ,an_trabpend_af f "
    // + " where (((to_char(f.num_os) in (:b0) and d.est_af like '%1') and
    // d.num_af=f.num_af) "
    // + "and d.num_af not in (select a.num_af from an_trabpend_af a ,ordenes b
    // ,trabpend_af c "
    // + "where ((((a.num_os=b.num_os and to_char(a.num_os) in (?)) and c.est_af
    // like '%1') "
    // + "and c.num_af=a.num_af) and b.est_os='EO001'))))")
    // TrabpendAf findTrabpendAfForIssueServiceOrder();

}
