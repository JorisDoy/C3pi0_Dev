package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.indra.iopen.form.ConnectionScheduledApplication;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.repositories.model.impl.IopenApplicationRepositoryCustom;

/**
 * The persistent interface for the IOPEN_APPLICATIONS database table.
 *
 */
public interface IopenApplicationRepository
extends CrudRepository<IopenApplication, Long>, IopenApplicationRepositoryCustom {

	List<IopenApplication> findByCodCliAndClientUsername(BigDecimal codCli, String clientUsername);

	List<IopenApplication> findByIdTypeAndIdNumber(String idType, String idNumber);

	List<IopenApplication> findByExpedienteEstado(String estado);

	List<IopenApplication> findByInspectionScheduledAndExpedienteEstado(Boolean inspectionScheduled, String estado);

	IopenApplication findIopenApplicationByExpedienteNumExp(String applicationNumber);

	IopenApplication findIopenApplicationByCodApplicationOrExpedienteNumExp(Long valueOf, String applicationNumber);

	IopenApplication findIopenApplicationByCodApplicationAndCodCliAndExpedienteIsNull(Long valueOf,
			BigDecimal bigDecimal);

	IopenApplication findIopenApplicationByExpedienteNumExpAndCodCliAndComplete(String applicationNumber,
			BigDecimal bigDecimal, BigDecimal bigDecimal2);

	IopenApplication findIopenApplicationByCodApplicationAndClientUsernameAndComplete(Long valueOf, String username,
			BigDecimal bigDecimal);

	List<IopenApplication> findByCompleteAndEstStatus(BigDecimal bigDecimal, String statusActive);

	@Query("select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
			+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t2.descTipo) "
			+ " from IopenApplication i,Tipo t,Tipo t2,Actividade a, Callejero cal , Municipio mun , Localidade loc "
			+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.connectionScheduled = :connectionScheduled "
			+ " and t.tipo=i.applicationType and t2.tipo=i.expediente.tipObra " + " and i.expediente.estado = :estado"
			+ " and i.expediente.numExp=a.id.numExp" + " and a.estAct = :estAct"
			+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
			+ "  and i.district=:district " + "  order by a.fAct asc ")
	public List<ConnectionScheduledApplication> findConnectionScheduleIopenApplicationByDistrict(
			@Param("estado") String estado, @Param("estAct") String estAct,
			@Param("connectionScheduled") Boolean scheduled, @Param("district") Long district);

	@Query("select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
			+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t2.descTipo) "
			+ " from IopenApplication i,Tipo t,Tipo t2,Actividade a, Callejero cal , Municipio mun , Localidade loc "
			+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.connectionScheduled = :connectionScheduled "
			+ " and t.tipo=i.applicationType and t2.tipo=i.expediente.tipObra " + " and i.expediente.estado = :estado"
			+ " and i.expediente.numExp=a.id.numExp" + " and a.estAct = :estAct"
			+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
			+ " and i.expediente.numExp=:applicationNumber " + "  order by a.fAct asc ")
	public List<ConnectionScheduledApplication> findConnectionScheduleIopenApplicationByApplicationNumber(
			@Param("estado") String estado, @Param("estAct") String estAct,
			@Param("connectionScheduled") Boolean scheduled, @Param("applicationNumber") String applicationNumber);

	@Query("select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
			+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t2.descTipo) "
			+ " from IopenApplication i,Tipo t,Tipo t2,Actividade a, Callejero cal , Municipio mun , Localidade loc "
			+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.connectionScheduled = :connectionScheduled "
			+ " and t.tipo=i.applicationType and t2.tipo=i.expediente.tipObra " + " and i.expediente.estado = :estado"
			+ " and i.expediente.numExp=a.id.numExp" + " and a.estAct = :estAct"
			+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
			+ " and i.codApplication=:trackingNumber" + "  order by a.fAct asc ")
	public List<ConnectionScheduledApplication> findConnectionScheduleIopenApplicationByTrackingNumber(
			@Param("estado") String estado, @Param("estAct") String estAct,
			@Param("connectionScheduled") Boolean scheduled, @Param("trackingNumber") long trackingNumber);

	@Query("select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
			+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t2.descTipo) "
			+ " from IopenApplication i,Tipo t,Tipo t2,Actividade a, Callejero cal , Municipio mun , Localidade loc "
			+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.connectionScheduled = :connectionScheduled "
			+ " and t.tipo=i.applicationType and t2.tipo=i.expediente.tipObra " + " and i.expediente.estado = :estado"
			+ " and i.expediente.numExp=a.id.numExp" + " and a.estAct = :estAct"
			+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
			+ " and t2.tipo=:poleService " + "  order by a.fAct asc ")
	public List<ConnectionScheduledApplication> findConnectionScheduleIopenApplicationByPoleService(
			@Param("estado") String estado, @Param("estAct") String estAct,
			@Param("connectionScheduled") Boolean scheduled, @Param("poleService") String poleService);

}