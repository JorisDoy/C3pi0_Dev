
package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ConnectionScheduledApplication;
import com.indra.iopen.form.InspectionScheduledApplication;
import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.Localidade;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.TipoRepository;

/**
 * The persistent class for the IOPEN_APPLICATIONS database table.
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class IopenApplicationRepositoryImpl implements IopenApplicationRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private ExpedienteRepository expedienteRepository;

	@Override
	public List<IopenApplication> findAllIopenApplications() {
		final List<IopenApplication> iopenApplications = entityManager
				.createQuery("select i from IopenApplication i  order by i.fActual desc").getResultList();

		return iopenApplications;
	}

	@Override
	public List<IopenApplication> findByDistrictStatusFilters(Long district, String status, int batch, int page) {
		List<IopenApplication> iopenApplications = new ArrayList<>();

		if (district == 0 && status.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager.createQuery("select i from IopenApplication i  order by i.fActual desc")
					.setFirstResult((page - 1) * batch).setMaxResults(batch).getResultList();
		} else if (district != 0 && !status.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i where i.district = :district and i.estStatus = :status  order by i.fActual desc")
					.setParameter("district", district).setParameter("status", status)
					.setFirstResult((page - 1) * batch).setMaxResults(batch).getResultList();
		} else if (district != 0) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i where i.district = :district order by i.fActual desc")
					.setParameter("district", district).setFirstResult((page - 1) * batch).setMaxResults(batch)
					.getResultList();
		} else if (!status.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery("select i from IopenApplication i where i.estStatus = :status order by i.fActual desc")
					.setParameter("status", status).setFirstResult((page - 1) * batch).setMaxResults(batch)
					.getResultList();
		}

		return iopenApplications;
	}

	@Override
	public Long countDistrictStatusFilters(Long district, String status) {
		Long iopenApplications = null;

		if (district == 0 && status.equalsIgnoreCase("ALL")) {
			iopenApplications = (Long) entityManager
					.createQuery("select count(i) from IopenApplication i  order by i.fActual desc").getSingleResult();
		} else if (district != 0 && !status.equalsIgnoreCase("ALL")) {
			iopenApplications = (Long) entityManager
					.createQuery(
							"select count(i) from IopenApplication i where i.district = :district and i.estStatus = :status  order by i.fActual desc")
					.setParameter("district", district).setParameter("status", status).getSingleResult();
		} else if (district != 0) {
			iopenApplications = (Long) entityManager
					.createQuery(
							"select count(i) from IopenApplication i where i.district = :district order by i.fActual desc")
					.setParameter("district", district).getSingleResult();
		} else if (!status.equalsIgnoreCase("ALL")) {
			iopenApplications = (Long) entityManager
					.createQuery(
							"select count(i) from IopenApplication i where i.estStatus = :status order by i.fActual desc")
					.setParameter("status", status).getSingleResult();
		}

		return iopenApplications;
	}

	@Override
	public List<IopenApplication> findByDistrictStatusFilters(Long district, String status, boolean complete, int batch,
			int page) {
		List<IopenApplication> iopenApplications = new ArrayList<IopenApplication>();
		if (district == null) {
			district = 0l;
		}
		final BigDecimal completeNumber = new BigDecimal(1);
		if (complete) {
			if (district == 0 && status.equalsIgnoreCase("ALL")) {
				iopenApplications = entityManager
						.createQuery(
								"select i from IopenApplication i WHERE i.complete = :complete order by i.fActual desc")
						.setParameter("complete", completeNumber).setFirstResult((page - 1) * batch)
						.setMaxResults(batch).getResultList();
			} else if (district != 0 && !status.equalsIgnoreCase("ALL")) {
				iopenApplications = entityManager
						.createQuery(
								"select i from IopenApplication i where i.district = :district and i.estStatus = :status "
										+ "and i.complete=:complete  order by i.fActual desc")
						.setParameter("district", district).setParameter("complete", completeNumber)
						.setParameter("status", status).setFirstResult((page - 1) * batch).setMaxResults(batch)
						.getResultList();
			} else if (district != 0) {
				iopenApplications = entityManager
						.createQuery("select i from IopenApplication i where i.district = :district "
								+ "and i.complete = :complete order by i.fActual desc")
						.setParameter("district", district).setParameter("complete", completeNumber)
						.setFirstResult((page - 1) * batch).setMaxResults(batch).getResultList();
			} else if (!status.equalsIgnoreCase("ALL") && district != 0) {
				iopenApplications = entityManager
						.createQuery(
								"select i from IopenApplication i where i.estStatus = :status and i.complete =:complete order by i.fActual desc")
						.setParameter("status", status).setParameter("complete", completeNumber)
						.setFirstResult((page - 1) * batch).setMaxResults(batch).getResultList();
			}
		}

		return iopenApplications;
	}

	@Override
	public Long countDistrictStatusFilters(Long district, String status, boolean complete) {
		Long iopenApplications = null;
		if (district == null) {
			district = 0l;
		}
		final BigDecimal completeNumber = new BigDecimal(1);
		if (complete) {
			if (district == 0 && status.equalsIgnoreCase("ALL")) {
				iopenApplications = (Long) entityManager
						.createQuery(
								"select count(i) from IopenApplication i WHERE i.complete = :complete order by i.fActual desc")
						.setParameter("complete", completeNumber).getSingleResult();
			} else if (district != 0 && !status.equalsIgnoreCase("ALL")) {
				iopenApplications = (Long) entityManager
						.createQuery(
								"select count(i)i from IopenApplication i where i.district = :district and i.estStatus = :status "
										+ "and i.complete=:complete  order by i.fActual desc")
						.setParameter("district", district).setParameter("complete", completeNumber)
						.setParameter("status", status).getSingleResult();
			} else if (district != 0) {
				iopenApplications = (Long) entityManager
						.createQuery("select count(i) from IopenApplication i where i.district = :district "
								+ "and i.complete = :complete order by i.fActual desc")
						.setParameter("district", district).setParameter("complete", completeNumber).getSingleResult();
			} else if (!status.equalsIgnoreCase("ALL") && district != 0) {
				iopenApplications = (Long) entityManager
						.createQuery(
								"select count(i) from IopenApplication i where i.estStatus = :status and i.complete =:complete order by i.fActual desc")
						.setParameter("status", status).setParameter("complete", completeNumber).getSingleResult();
			}
		}

		return iopenApplications;
	}

	@Override
	public List<IopenApplication> findByDistrictStatusUnicomFilters(Long district, String status, boolean complete,
			BigDecimal codUnicom, int batch, int page) {
		List<IopenApplication> iopenApplications = new ArrayList<IopenApplication>();
		if (district == null) {
			district = 0l;
		}
		final BigDecimal completeNumber = new BigDecimal(1);
		if (complete) {
			if (codUnicom.equals(new BigDecimal(district)) && status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit

				iopenApplications = entityManager
						.createQuery(
								"select i from IopenApplication i WHERE i.expediente IS NOT NULL AND i.expediente.codUnicomCompet = :codUnicom order by i.fActual desc")
						.setParameter("codUnicom", codUnicom).setFirstResult((page - 1) * batch).setMaxResults(batch)
						.getResultList();

			} else if (!codUnicom.equals(new BigDecimal(district)) && !status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit
				if (!codUnicom.equals(new BigDecimal(district))) {
					iopenApplications = entityManager
							.createQuery("select i from IopenApplication i where i.estStatus = :status "
									+ "and i.complete =:complete order by i.fActual desc")
							.setParameter("status", status).setParameter("complete", completeNumber)
							.setFirstResult((page - 1) * batch).setMaxResults(batch).getResultList();
				}
			} else if (!codUnicom.equals(new BigDecimal(district)) && status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit
				if (!codUnicom.equals(new BigDecimal(district))) {
					iopenApplications = entityManager
							.createQuery(
									"select i from IopenApplication i where i.complete =:complete order by i.fActual desc")
							.setParameter("complete", completeNumber).setFirstResult((page - 1) * batch)
							.setMaxResults(batch).getResultList();
				}
			} else if (codUnicom.equals(new BigDecimal(district)) && !status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit
				if (codUnicom.equals(new BigDecimal(district))) {
					iopenApplications = entityManager
							.createQuery(
									"select i from IopenApplication i where i.estStatus = :status and i.complete =:complete AND i.expediente.codUnicomCompet = :codUnicom order by i.fActual desc")
							.setParameter("complete", completeNumber).setParameter("status", status)
							.setParameter("codUnicom", codUnicom).setFirstResult((page - 1) * batch)
							.setMaxResults(batch).getResultList();
				}

			}
		}

		return iopenApplications;
	}

	@Override
	public Long countDistrictStatusUnicomFilters(Long district, String status, boolean complete, BigDecimal codUnicom) {
		Long iopenApplications = null;
		if (district == null) {
			district = 0l;
		}
		final BigDecimal completeNumber = new BigDecimal(1);
		if (complete) {
			if (codUnicom.equals(new BigDecimal(district)) && status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit

				iopenApplications = (Long) entityManager
						.createQuery(
								"select count(i) from IopenApplication i WHERE i.expediente IS NOT NULL AND i.expediente.codUnicomCompet = :codUnicom order by i.fActual desc")
						.setParameter("codUnicom", codUnicom).getSingleResult();

			} else if (!codUnicom.equals(new BigDecimal(district)) && !status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit
				if (!codUnicom.equals(new BigDecimal(district))) {
					iopenApplications = (Long) entityManager
							.createQuery("select count(i) from IopenApplication i where i.estStatus = :status "
									+ "and i.complete =:complete order by i.fActual desc")
							.setParameter("status", status).setParameter("complete", completeNumber).getSingleResult();
				}
			} else if (!codUnicom.equals(new BigDecimal(district)) && status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit
				if (!codUnicom.equals(new BigDecimal(district))) {
					iopenApplications = (Long) entityManager
							.createQuery(
									"select count(i) from IopenApplication i where i.complete =:complete order by i.fActual desc")
							.setParameter("complete", completeNumber).getSingleResult();
				}
			} else if (codUnicom.equals(new BigDecimal(district)) && !status.equalsIgnoreCase("ALL")) {
				// check done to enable user to search all districts to view the
				// data but they will not be able to edit
				if (codUnicom.equals(new BigDecimal(district))) {
					iopenApplications = (Long) entityManager
							.createQuery(
									"select count(i) from IopenApplication i where i.estStatus = :status and i.complete =:complete AND i.expediente.codUnicomCompet = :codUnicom order by i.fActual desc")
							.setParameter("complete", completeNumber).setParameter("status", status)
							.setParameter("codUnicom", codUnicom).getSingleResult();
				}
			}
		}

		return iopenApplications;
	}

	@Override
	public List<IopenApplication> findByIdNumber(String idType, String idNumber) {
		final List<IopenApplication> iopenApplications = entityManager
				.createQuery(
						"select i from IopenApplication i where i.idType = :idType and i.idNumber = :idNumber  order by i.fActual desc")
				.setParameter("idType", idType).setParameter("idNumber", idNumber).getResultList();

		return iopenApplications;
	}

	@Override
	public List<IopenApplication> findByCurrentStageApplicationNumberFilters(String currentStage,
			String applicationNumber) {
		List<IopenApplication> iopenApplications = new ArrayList<IopenApplication>();

		if (applicationNumber.isEmpty() && currentStage.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i WHERE i.expediente IS NOT NULL order by i.fActual desc")
					.getResultList();
		} else if (!applicationNumber.isEmpty() && !currentStage.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i where i.expediente.estado = :currentStage and i.expediente.numExp = :applicationNumber "
									+ "and i.expediente IS NOT NULL  order by i.fActual desc")
					.setParameter("currentStage", currentStage).setParameter("applicationNumber", applicationNumber)
					.getResultList();
		} else if (!applicationNumber.isEmpty()) {
			iopenApplications = entityManager
					.createQuery("select i from IopenApplication i where i.expediente.numExp = :applicationNumber "
							+ " and i.expediente IS NOT NULL order by i.fActual desc")
					.setParameter("applicationNumber", applicationNumber).getResultList();
		} else if (!currentStage.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i where i.expediente.estado = :currentStage and i.expediente IS NOT NULL order by i.fActual desc")
					.setParameter("currentStage", currentStage).getResultList();
		}

		return iopenApplications;
	}

	@Override
	public List<IopenApplication> clientFindByCurrentStageApplicationNumberFilters(String currentStage,
			BigDecimal codCli) {
		List<IopenApplication> iopenApplications = new ArrayList<IopenApplication>();

		if (currentStage.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i WHERE i.expediente IS NOT NULL and codCli =:codCli order by i.fActual desc")
					.setParameter("codCli", codCli).getResultList();
		} else if (!currentStage.equalsIgnoreCase("ALL")) {
			iopenApplications = entityManager
					.createQuery(
							"select i from IopenApplication i where i.expediente.estado = :currentStage and codCli =:codCli and i.expediente IS NOT NULL order by i.fActual desc")
					.setParameter("currentStage", currentStage).setParameter("codCli", codCli).getResultList();
		}

		return iopenApplications;
	}

	@Override
	// SMA 20160219 UMESCI-446 start added complete
	public List<IopenApplication> findByStatus(String status, String clientUsername, BigDecimal complete) {
		final List<IopenApplication> iopenApplications = entityManager
				.createQuery("select i from IopenApplication i where i.estStatus = :estStatus "
						+ "and i.clientUsername= :clientUsername and i.complete=:complete order by i.fActual desc")
				.setParameter("estStatus", status).setParameter("complete", complete)
				.setParameter("clientUsername", clientUsername).getResultList();
		return iopenApplications;
	}

	@Override
	public List<IopenApplication> findClientIopenApplications(String clientUsername, boolean complete) {
		List<IopenApplication> iopenApplications = null;
		if (complete) {
			iopenApplications = entityManager
					.createQuery("select i from IopenApplication i where  i.clientUsername= :clientUsername "
							+ "and i.complete =:complete order by i.fActual desc")
					.setParameter("complete", new BigDecimal(1)).setParameter("clientUsername", clientUsername)
					.getResultList();
		} else {
			iopenApplications = entityManager
					.createQuery("select i from IopenApplication i where  i.clientUsername= :clientUsername "
							+ "and  i.complete =:complete order by i.fActual desc")
					.setParameter("complete", new BigDecimal(0)).setParameter("clientUsername", clientUsername)
					.getResultList();
		}

		return iopenApplications;

	}

	@Override
	public List<IopenApplication> findIncompleteClientIopenApplications(String clientUsername) {

		final List<IopenApplication> iopenApplications = entityManager
				.createQuery("select i from IopenApplication i where "
						+ " i.clientUsername= :clientUsername and i.complete = :complete " + "order by i.fActual desc")
				.setParameter("clientUsername", clientUsername).setParameter("complete", new BigDecimal(0))
				.getResultList();

		return iopenApplications;

	}

	@Override
	public List<IopenApplication> findIopenApplicationsWhereMessageIsNotYetSent(String estado) {

		// SMA 20160316
		final List<IopenApplication> iopenApplications = entityManager
				.createQuery("select i from IopenApplication i where i.expediente.estado= :estado "
						+ " and i.codApplication NOT IN (SELECT im.id.codApplication FROM IopenApplicationMessage im WHERE im.expedienteEstado = :estado AND im.messageSent= :messageSent )"
						+ "  order by i.fActual desc ")
				.setParameter("estado", estado).setParameter("messageSent", true).getResultList();

		return iopenApplications;

	}

	/* TODO Check from recibos if paid */
	@Override
	public List<IopenApplication> findIopenApplicationsWhereFeePaidButStatusNotChanged(String tipRec, String paidEstado,
			String applicationStage) {

		final String query = "Select i From IopenApplication i, Recibo r Where i.expediente.numExp = r.numFact "
				+ "And r.tipRec = :tipRec And r.estRec = :paidEstado And i.expediente.estado = :applicationStage";

		final List<IopenApplication> iopenApplications = entityManager.createQuery(query).setParameter("tipRec", tipRec)
				.setParameter("paidEstado", paidEstado).setParameter("applicationStage", applicationStage)
				.getResultList();

		return iopenApplications;
	}

	@Override
	public List<InspectionScheduledApplication> findRejectedOnInspectionScheduleIopenApplication(
			String reInspectionEstAct, String estAct) {
		List<InspectionScheduledApplication> rejectedOnScheduleApplications = null;

		final Query query = entityManager
				.createQuery(
						"select new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.inspectionScheduled = :inspectionScheduled "
								+ " and t.tipo=i.applicationType"
								+ " and (i.expediente.estado = :estAct or i.expediente.estado = :reInspectionEstAct)"
								+ " and i.expediente.numExp=a.id.numExp"
								+ " and ( a.estAct = :estAct  or a.estAct = :reInspectionEstAct) "
								+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp) "
								+ " and i.inspectionRejected = :rejected" + "  order by a.fAct asc ")
				.setParameter("reInspectionEstAct", reInspectionEstAct).setParameter("estAct", estAct)
				.setParameter("rejected", Boolean.TRUE).setParameter("inspectionScheduled", Boolean.FALSE);

		rejectedOnScheduleApplications = query.getResultList();

		return rejectedOnScheduleApplications;

	}

	@Override
	public List<InspectionScheduledApplication> findScheduledIopenApplicationsWhichPaymentHaveBeenRecieved(
			String reInspectionEstAct, String estado, String estAct, Boolean scheduled, String clientUserName,
			Boolean rejected) {
		List<InspectionScheduledApplication> scheduledApplications = null;
		if (clientUserName == null) {
			if (scheduled != null) {
				final Query query = entityManager
						.createQuery(
								"select new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
										+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments) "
										+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
										+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.inspectionScheduled = :inspectionScheduled "
										+ " and t.tipo=i.applicationType"
										+ " and (i.expediente.estado = :estado or i.expediente.estado = :reInspectionEstAct)"
										+ " and i.expediente.numExp=a.id.numExp"
										+ " and ( a.estAct = :estAct  or a.estAct = :reInspectionEstAct) "
										+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp) "
										+ " and i.inspectionRejected = :rejected" + "  order by a.fAct asc ")
						.setParameter("estado", estado).setParameter("reInspectionEstAct", reInspectionEstAct)
						.setParameter("estAct", estAct).setParameter("rejected", rejected);
				if (scheduled) {
					scheduledApplications = findOnlyScheduledApplications(query);

				} else {
					scheduledApplications = findAllNotScheduledApplications(query);
				}
			} else {
				scheduledApplications = findAllScheduledApplications(reInspectionEstAct, estado, estAct);
			}
		} else {
			if (scheduled != null) {
				final Query query = entityManager
						.createQuery(
								"select new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
										+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments) "
										+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
										+ " where cal.codCalle=i.street " + "and mun.codMunic=i.district "
										+ "and loc.codLocal=i.village "
										+ "and i.inspectionScheduled = :inspectionScheduled "
										+ " and t.tipo=i.applicationType" + " and i.expediente.estado = :estado"
										+ " and i.expediente.numExp=a.id.numExp"
										+ " and ( a.estAct = :estAct  or a.estAct = :reInspectionEstAct) "
										+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and (a1.estAct = :estAct or a.estAct = :reInspectionEstAct )    ) "
										+ " and i.clientUsername = :clientUsername " + "  order by a.fAct asc ")
						.setParameter("estado", estado).setParameter("reInspectionEstAct", reInspectionEstAct)
						.setParameter("clientUsername", clientUserName).setParameter("estAct", estAct);
				if (scheduled) {
					scheduledApplications = findOnlyScheduledApplicationsForClient(query);
				} else {
					scheduledApplications = findNotScheduledApplicationsForClient(query);
				}
			} else {
				scheduledApplications = findAllScheduledApplicationsForClient(reInspectionEstAct, estado, estAct,
						clientUserName);
			}

		}
		return scheduledApplications;

	}

	@Override
	public InspectionScheduledApplication findScheduledApplicationForClient(String reInspectionestAct, String estAct,
			Long codApplication) {
		// TODO deal with loops
		return (InspectionScheduledApplication) entityManager.createQuery(
				"select new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
						+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments) "
						+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
						+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and t.tipo=i.applicationType"
						+ " and i.expediente.numExp=a.id.numExp" + " and i.codApplication = :codApplication "
						+ " and a.id.numAct = (Select MAX(a1.id.numAct) from Actividade a1 where a1.id.numExp=a.id.numExp) "
						// + " and (a.estAct = :estAct or a.estAct =
						// :reInspectionestAct) "
						+ "  order by a.fAct asc ")
				.setParameter("codApplication", codApplication)
				/*
				 * .setParameter("estAct", estAct)
				 * .setParameter("reInspectionestAct", reInspectionestAct)
				 */.getSingleResult();
	}

	private List<InspectionScheduledApplication> findNotScheduledApplicationsForClient(Query query) {
		return query.setParameter("inspectionScheduled", Boolean.FALSE).getResultList();
	}

	private List<InspectionScheduledApplication> findAllScheduledApplicationsForClient(String reInspectionEstAct,
			String estado, String estAct, String clientUserName) {
		return entityManager
				.createQuery(
						"select new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and t.tipo=i.applicationType"
								+ " and i.expediente.estado = :estado" + " and i.expediente.numExp=a.id.numExp"
								+ " and a.estAct = :estAct or a.estAct = :reInspectionEstAct "
								+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where i.expediente.numExp=a.id.numExp  and a.estAct = :estAct or a.estAct = :reInspectionEstAct    )  "
								+ " and i.clientUsername = :clientUsername " + "  order by a.fAct asc ")
				.setParameter("estado", estado).setParameter("clientUsername", clientUserName)
				.setParameter("reInspectionEstAct", reInspectionEstAct).setParameter("estAct", estAct).getResultList();
	}

	private List<InspectionScheduledApplication> findOnlyScheduledApplicationsForClient(Query query) {
		return query.setParameter("inspectionScheduled", Boolean.TRUE).getResultList();
	}

	private List<InspectionScheduledApplication> findAllScheduledApplications(String reInspectionEstAct, String estado,
			String estAct) {
		return entityManager
				.createQuery(
						"select new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and  t.tipo=i.applicationType"
								+ " and i.expediente.estado = :estado" + " and i.expediente.numExp=a.id.numExp"
								+ " and ( a.estAct = :estAct  or a.estAct = :reInspectionEstAct) "
								+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and (a1.estAct = :estAct or a.estAct = :reInspectionEstAct )    ) "
								+ "  order by a.fAct asc ")
				.setParameter("reInspectionEstAct", reInspectionEstAct).setParameter("estado", estado)
				.setParameter("estAct", estAct).getResultList();
	}

	private List<InspectionScheduledApplication> findAllNotScheduledApplications(Query query) {
		return query.setParameter("inspectionScheduled", Boolean.FALSE).getResultList();
	}

	private List<InspectionScheduledApplication> findOnlyScheduledApplications(Query query) {
		return query.setParameter("inspectionScheduled", Boolean.TRUE).getResultList();
	}

	@Override
	public int countOnlyScheduledApplications(String reInspectionEstAct, String estado, String estAct) {
		return (int) entityManager
				.createQuery(
						"select count(new com.indra.iopen.form.InspectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.inspectionScheduledBy,i.inspectionScheduledDate,i.inspectionScheduled,i.coRejectReason,i.comments)) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and  i.inspectionScheduled = :inspectionScheduled"
								+ " and t.tipo=i.applicationType" + " and i.expediente.estado = :estado"
								+ " and i.expediente.numExp=a.id.numExp"
								+ " and ( a.estAct = :estAct  or a.estAct = :reInspectionEstAct) "
								+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and (a1.estAct = :estAct or a.estAct = :reInspectionEstAct )    ) "
								+ "  order by a.fAct asc ")
				.setParameter("inspectionScheduled", Boolean.TRUE).setParameter("estado", estado)
				.setParameter("reInspectionEstAct", reInspectionEstAct).setParameter("estAct", estAct)
				.getSingleResult();
	}

	@Override
	public List<ConnectionScheduledApplication> findConnectionIopenApplicationsWhichPaymentHaveBeenRecieved(
			String estado, String estAct, Boolean scheduled, String clientUserName) {
		List<ConnectionScheduledApplication> scheduledApplications = null;
		if (clientUserName == null) {
			if (scheduled != null) {
				final Query query = entityManager
						.createQuery(
								"select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
										+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t.descTipo) "
										+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
										+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.connectionScheduled = :connectionScheduled "
										+ " and t.tipo=i.applicationType" + " and i.expediente.estado = :estado"
										+ " and i.expediente.numExp=a.id.numExp" + " and a.estAct = :estAct"
										+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
										+ "  order by a.fAct asc ")
						.setParameter("estado", estado).setParameter("estAct", estAct);
				if (scheduled) {
					scheduledApplications = findOnlyScheduledConnectionApplications(query);

				} else {
					scheduledApplications = findAllNotScheduledConnectionApplications(query);
				}
			} else {
				scheduledApplications = findAllScheduledConnectionApplications(estado, estAct);
			}
		} else {
			if (scheduled != null) {
				final Query query = entityManager
						.createQuery(
								"select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
										+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t.descTipo) "
										+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
										+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and i.connectionScheduled = :connectionScheduled "
										+ " and t.tipo=i.applicationType" + " and i.expediente.estado = :estado"
										+ " and i.expediente.numExp=a.id.numExp" + " and a.estAct = :estAct"
										+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
										+ " and i.clientUsername = :clientUsername " + "  order by a.fAct asc ")
						.setParameter("estado", estado).setParameter("clientUsername", clientUserName)
						.setParameter("estAct", estAct);
				if (scheduled) {
					scheduledApplications = findOnlyScheduledConnectionApplicationsForClient(query);
				} else {
					scheduledApplications = findNotScheduledConnectionApplicationsForClient(query);
				}
			} else {
				scheduledApplications = findAllScheduledConnectionApplicationsForClient(estado, estAct, clientUserName);
			}

		} // SMA/UMESCI-732 -20170506 start
		final List<ConnectionScheduledApplication> connectionScheduledApplications = new ArrayList<>();
		scheduledApplications.stream().filter(Objects::nonNull).forEach(sched -> {
			connectionScheduledApplications.add(findTypeDescription(sched));
		});
		return connectionScheduledApplications;
		// SMA/UMESCI-732 -20170506 end
	}

	private List<ConnectionScheduledApplication> findOnlyScheduledConnectionApplications(Query query) {
		return query.setParameter("connectionScheduled", Boolean.TRUE).getResultList();

	}

	private List<ConnectionScheduledApplication> findAllNotScheduledConnectionApplications(Query query) {
		return query.setParameter("connectionScheduled", Boolean.FALSE).getResultList();
	}

	private List<ConnectionScheduledApplication> findAllScheduledConnectionApplications(String estado, String estAct) {
		return entityManager
				.createQuery(
						"select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t.descTipo) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and  t.tipo=i.applicationType"
								+ " and i.expediente.estado = :estado" + " and i.expediente.numExp=a.id.numExp"
								+ " and a.estAct = :estAct "
								+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
								+ "  order by a.fAct asc ")
				.setParameter("estado", estado).setParameter("estAct", estAct).getResultList();
	}

	private List<ConnectionScheduledApplication> findOnlyScheduledConnectionApplicationsForClient(Query query) {
		return query.setParameter("connectionScheduled", Boolean.TRUE).getResultList();
	}

	private List<ConnectionScheduledApplication> findNotScheduledConnectionApplicationsForClient(Query query) {
		return query.setParameter("connectionScheduled", Boolean.FALSE).getResultList();
	}

	private List<ConnectionScheduledApplication> findAllScheduledConnectionApplicationsForClient(String estado,
			String estAct, String clientUserName) {
		return entityManager
				.createQuery(
						"select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t.descTipo) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and t.tipo=i.applicationType"
								+ " and i.expediente.estado = :estado" + " and i.expediente.numExp=a.id.numExp"
								+ " and a.estAct = :estAct "
								+ " and a.fAct = (Select MAX(a1.fAct) from Actividade a1 where a1.id.numExp=a.id.numExp  and a.estAct = :estAct   ) "
								+ " and i.clientUsername = :clientUsername " + "  order by a.fAct asc ")
				.setParameter("estado", estado).setParameter("clientUsername", clientUserName)
				.setParameter("estAct", estAct).getResultList();
	}

	@Override
	public ConnectionScheduledApplication findScheduledConectionApplicationForClient(String estAct,
			Long codApplication) {// SMA/UMESCI-732 -20170506
		return findTypeDescription((ConnectionScheduledApplication) entityManager
				.createQuery(
						"select new com.indra.iopen.form.ConnectionScheduledApplication(i.expediente.numExp,t.descTipo,mun.nomMunic"
								+ ",loc.nomLocal,cal.nomCalle,i.housePlot,i.mobileNumber,i.codApplication,a.fAct,i.connectionScheduledBy,i.connectionScheduledDate,i.connectionScheduled,i.coRejectReason,i.comments,t.descTipo) "
								+ " from IopenApplication i,Tipo t,Actividade a, Callejero cal , Municipio mun , Localidade loc "
								+ " where cal.codCalle=i.street and mun.codMunic=i.district and loc.codLocal=i.village and t.tipo=i.applicationType"
								+ " and i.expediente.numExp=a.id.numExp" + " and i.codApplication = :codApplication "
								+ " and a.estAct = :estAct" + "  order by a.fAct asc ")
				.setParameter("codApplication", codApplication).setParameter("estAct", estAct).getSingleResult());
	}

	// SMA/UMESCI-732 -20170506 -start
	private ConnectionScheduledApplication findTypeDescription(
			ConnectionScheduledApplication connectionScheduledApplication) {
		try {
			connectionScheduledApplication
			.setWorkTypeDesc(tipoRepository
					.findById(expedienteRepository
							.findById(connectionScheduledApplication.getApplicationNumber()).getTipObra())
					.getDescTipo());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return connectionScheduledApplication;
	}

	@Override
	public List<ConnectionScheduledApplication> findConnectionScheduleIopenApplication(Boolean scheduled,
			ApplicationListFilter applicationListFilter) {
		final String expediente = "expediente";
		final String numExp = "numExp";
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<ConnectionScheduledApplication> iopenApplicationCriteria = builder
				.createQuery(ConnectionScheduledApplication.class);
		final Root<IopenApplication> iopenApplicationRoot = iopenApplicationCriteria.from(IopenApplication.class);
		final Root<Tipo> tipoRoot = iopenApplicationCriteria.from(Tipo.class);
		final Root<Tipo> tipoRoot2 = iopenApplicationCriteria.from(Tipo.class);
		final Root<Actividade> actividadeRoot = iopenApplicationCriteria.from(Actividade.class);
		final Root<Callejero> callejeroRoot = iopenApplicationCriteria.from(Callejero.class);
		final Root<Municipio> municipioRoot = iopenApplicationCriteria.from(Municipio.class);
		final Root<Localidade> localidadeRoot = iopenApplicationCriteria.from(Localidade.class);

		Predicate criteria = builder.conjunction();
		criteria = builder.and(criteria,
				builder.equal(tipoRoot.get("tipo"), iopenApplicationRoot.get("applicationType")));
		criteria = builder.and(criteria,
				builder.equal(callejeroRoot.get("codCalle"), iopenApplicationRoot.get("street")));
		criteria = builder.and(criteria,
				builder.equal(municipioRoot.get("codMunic"), iopenApplicationRoot.get("district")));
		criteria = builder.and(criteria,
				builder.equal(localidadeRoot.get("codLocal"), iopenApplicationRoot.get("village")));
		criteria = builder.and(criteria,
				builder.equal(iopenApplicationRoot.get(expediente).get(numExp), actividadeRoot.get("id").get(numExp)));
		if (applicationListFilter.getEstado() != null && !applicationListFilter.getEstado().isEmpty())
			criteria = builder.and(criteria, builder.equal(iopenApplicationRoot.get(expediente).get("estado"),
					builder.parameter(String.class, applicationListFilter.getEstado())));

		if (applicationListFilter.getEstAct() != null && !applicationListFilter.getEstAct().isEmpty())
			criteria = builder.and(criteria,
					builder.equal(actividadeRoot.get("estAct"), applicationListFilter.getEstAct()));
		if (applicationListFilter.getApplicationNumber() != null
				&& !applicationListFilter.getApplicationNumber().isEmpty())
			criteria = builder.and(criteria, builder.equal(iopenApplicationRoot.get(expediente).get(numExp),
					applicationListFilter.getApplicationNumber()));
		if (applicationListFilter.getDistrict() != null && !applicationListFilter.getDistrict().equals(0))
			criteria = builder.and(criteria,
					builder.equal(iopenApplicationRoot.get("district"), applicationListFilter.getDistrict()));
		if (applicationListFilter.getTrackingNumber() != null && !applicationListFilter.getTrackingNumber().isEmpty())
			criteria = builder.and(criteria, builder.equal(iopenApplicationRoot.get("codApplication"),
					applicationListFilter.getTrackingNumber()));
		if (applicationListFilter.getWorkType() != null && !applicationListFilter.getWorkType().isEmpty())
			criteria = builder.and(criteria, builder.equal(tipoRoot2.get("tipo"), applicationListFilter.getWorkType()));
		final Subquery<Date> sq = iopenApplicationCriteria.subquery(Date.class);
		final Root<Actividade> actividadeRoot2 = sq.from(Actividade.class);
		Predicate criteria2 = builder.conjunction();
		criteria2 = builder.and(criteria2,
				builder.equal(actividadeRoot2.get("id").get("numExp"), actividadeRoot.get("id").get("numExp")));
		sq.select(builder.greatest(actividadeRoot2.<Date> get("fAct"))).where(criteria2);
		criteria = builder.and(criteria, builder.in(actividadeRoot.get("fAct")).value(sq));

		iopenApplicationCriteria.select(builder.construct(ConnectionScheduledApplication.class,
				iopenApplicationRoot.get(expediente).get(numExp), tipoRoot.get("descTipo"),
				municipioRoot.get("nomMunic"), localidadeRoot.get("nomLocal"), callejeroRoot.get("nomCalle"),
				iopenApplicationRoot.get("housePlot"), iopenApplicationRoot.get("mobileNumber"),
				iopenApplicationRoot.get("codApplication"), actividadeRoot.get("fAct"),
				iopenApplicationRoot.get("connectionScheduledBy"), iopenApplicationRoot.get("connectionScheduledDate"),
				iopenApplicationRoot.get("connectionScheduled"), iopenApplicationRoot.get("coRejectReason"),
				iopenApplicationRoot.get("comments"), tipoRoot2.get("descTipo"))).where(criteria);
		return entityManager.createQuery(iopenApplicationCriteria)
				.setFirstResult((applicationListFilter.getPage() - 1) * applicationListFilter.getBatch())
				.setMaxResults(applicationListFilter.getBatch()).getResultList();

	}

	@Override
	public Long getCountOfUnscheduledConnection(Boolean scheduled, ApplicationListFilter applicationListFilter) {
		final String expediente = "expediente";
		final String numExp = "numExp";
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Long> iopenApplicationCriteria = builder.createQuery(Long.class);
		final Root<IopenApplication> iopenApplicationRoot = iopenApplicationCriteria.from(IopenApplication.class);
		final Root<Tipo> tipoRoot = iopenApplicationCriteria.from(Tipo.class);
		final Root<Tipo> tipoRoot2 = iopenApplicationCriteria.from(Tipo.class);
		final Root<Actividade> actividadeRoot = iopenApplicationCriteria.from(Actividade.class);
		final Root<Callejero> callejeroRoot = iopenApplicationCriteria.from(Callejero.class);
		final Root<Municipio> municipioRoot = iopenApplicationCriteria.from(Municipio.class);
		final Root<Localidade> localidadeRoot = iopenApplicationCriteria.from(Localidade.class);
		Predicate criteria = builder.conjunction();
		criteria = builder.and(criteria,
				builder.equal(tipoRoot.get("tipo"), iopenApplicationRoot.get("applicationType")));
		criteria = builder.and(criteria,
				builder.equal(callejeroRoot.get("codCalle"), iopenApplicationRoot.get("street")));
		criteria = builder.and(criteria,
				builder.equal(municipioRoot.get("codMunic"), iopenApplicationRoot.get("district")));
		criteria = builder.and(criteria,
				builder.equal(localidadeRoot.get("codLocal"), iopenApplicationRoot.get("village")));
		criteria = builder.and(criteria,
				builder.equal(iopenApplicationRoot.get(expediente).get(numExp), actividadeRoot.get("id").get(numExp)));
		if (applicationListFilter.getEstado() != null && !applicationListFilter.getEstado().isEmpty())
			criteria = builder.and(criteria, builder.equal(iopenApplicationRoot.get(expediente).get("estado"),
					builder.parameter(String.class, applicationListFilter.getEstado())));

		if (applicationListFilter.getEstAct() != null && !applicationListFilter.getEstAct().isEmpty())
			criteria = builder.and(criteria,
					builder.equal(actividadeRoot.get("estAct"), applicationListFilter.getEstAct()));
		if (applicationListFilter.getApplicationNumber() != null
				&& !applicationListFilter.getApplicationNumber().isEmpty())
			criteria = builder.and(criteria, builder.equal(iopenApplicationRoot.get(expediente).get(numExp),
					applicationListFilter.getApplicationNumber()));
		if (applicationListFilter.getDistrict() != null && !applicationListFilter.getDistrict().equals(0))
			criteria = builder.and(criteria,
					builder.equal(iopenApplicationRoot.get("district"), applicationListFilter.getDistrict()));
		if (applicationListFilter.getTrackingNumber() != null && !applicationListFilter.getTrackingNumber().isEmpty())
			criteria = builder.and(criteria, builder.equal(iopenApplicationRoot.get("codApplication"),
					applicationListFilter.getTrackingNumber()));
		if (applicationListFilter.getWorkType() != null && !applicationListFilter.getWorkType().isEmpty())
			criteria = builder.and(criteria, builder.equal(tipoRoot2.get("tipo"), applicationListFilter.getWorkType()));
		final Subquery<Date> sq = iopenApplicationCriteria.subquery(Date.class);
		final Root<Actividade> actividadeRoot2 = sq.from(Actividade.class);
		Predicate criteria2 = builder.conjunction();
		criteria2 = builder.and(criteria2,
				builder.equal(actividadeRoot2.get("id").get("numExp"), actividadeRoot.get("id").get("numExp")));
		sq.select(builder.greatest(actividadeRoot2.<Date> get("fAct"))).where(criteria2);
		criteria = builder.and(criteria, builder.in(actividadeRoot.get("fAct")).value(sq));

		iopenApplicationCriteria.select(builder.count(iopenApplicationCriteria.from(IopenApplication.class)));
		return entityManager.createQuery(iopenApplicationCriteria).getSingleResult();
	}
	// SMA/UMESCI-732 -20170506 end
}