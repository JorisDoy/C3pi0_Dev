package com.indra.iopen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the IOPEN_APPLICATIONS database table.
 */
@Entity
@Table(name = "IOPEN_APPLICATIONS")
@NamedQuery(name = "IopenApplication.findAll", query = "SELECT i FROM IopenApplication i")
public class IopenApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "IOPEN_APPLICATIONS_CODAPPLICATION_GENERATOR", sequenceName = "COD_APPLICATION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IOPEN_APPLICATIONS_CODAPPLICATION_GENERATOR")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COD_APPLICATION")
	private Long codApplication;

	@Column(name = "APPLICATION_TYPE")
	private String applicationType;

	@Column(name = "CLIENT_USERNAME")
	private String clientUsername;

	@Column(name = "COD_CLI")
	private java.math.BigDecimal codCli;

	private BigDecimal complete;
	private String comments;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "CUSTOMER_CONTACT_PERSON")
	private String customerContactPerson;

	private Long district;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "EST_STATUS")
	private String estStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ACTUAL")
	private Date fActual;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "HOUSE_PLOT")
	private String housePlot;

	@Column(name = "ID_NUMBER")
	private String idNumber;

	@Column(name = "INSPECTION_SCHEDULED")
	private Boolean inspectionScheduled = Boolean.FALSE;

	@Column(name = "INSPECTION_SCHEDULED_DATE")
	private Date inspectionScheduledDate;

	@Column(name = "INSPECTION_SCHEDULED_BY")
	private String inspectionScheduledBy;

	@Column(name = "CONNECTION_SCHEDULED")
	private Boolean connectionScheduled = Boolean.FALSE;

	@Column(name = "CONNECTION_SCHEDULED_DATE")
	private Date connectionScheduledDate;

	@Column(name = "CONNECTION_SCHEDULED_BY")
	private String connectionScheduledBy;

	@Column(name = "ID_TYPE")
	private String idType;

	@Column(name = "INSPECTION_FEE")
	private BigDecimal inspectionFee;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "OFFICE_NUMBER")
	private String officeNumber;
	// SMA/UMESCI - 713
	@Column(name = "GPS")
	private String gps;

	private String programa;

	private Long street;

	@Column(name = "LOCALITY")
	private Long locality;

	private String surname;

	@Column(name = "TERMS_AGREE")
	private String termsAgree;

	@Column(name = "TIN_NUMBER")
	private String tinNumber;

	private String usuario;

	private Long village;

	// bi-directional many-to-one association to IopenApplicationDoc
	@OneToMany(mappedBy = "iopenApplication", fetch = FetchType.EAGER)
	private List<IopenApplicationDoc> iopenApplicationDocs;

	// bi-directional many-to-one association to Expediente
	@OneToOne
	@JoinColumn(name = "NUM_EXP")
	private Expediente expediente;

	@Column(name = "AGREE_WAYLEAVES")
	private String agreeWayleaves;

	@Column(name = "CO_REJECT_REASON")
	private String coRejectReason;

	@Column(name = "LANDMARK")
	private String landmark;

	/* Inspection rejection fields */
	@Column(name = "INSPECTION_REJECT_BY")
	private String inspectionRejectBy;

	@Column(name = "INSPECTION_REJECT_CODE")
	private String inspectionRejectCode;

	@Column(name = "INSPECTION_REJECT_COMMENT")
	private String inspectionRejectComment;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSPECTION_REJECT_DATE")
	private Date inspectionRejectDate;

	@Column(name = "INSPECTION_REJECTED")
	private Boolean inspectionRejected = Boolean.FALSE;

	@Column(name = "STREET_DESC")
	private String streetDesc;

	@Column(name = "SUB_COUNTY_DESC")
	private String subCountyDesc;

	@Column(name = "TOWN_DESC")
	private String townDesc;

	@Column(name = "COUNTY_DESC")
	private String countyDesc;

	@Column(name = "DIRECTIONS_DESC")
	private String directionsDesc;

	@Column(name = "DISTRICT_DESC")
	private String districtDesc;

	@Column(name = "VILLAGE_DESC")
	private String villageDesc;

	public IopenApplication() {
	}

	public IopenApplicationDoc addIopenApplicationDoc(final IopenApplicationDoc iopenApplicationDoc) {
		getIopenApplicationDocs().add(iopenApplicationDoc);
		iopenApplicationDoc.setIopenApplication(this);

		return iopenApplicationDoc;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public String getClientUsername() {
		return clientUsername;
	}

	public Long getCodApplication() {
		return codApplication;
	}

	public java.math.BigDecimal getCodCli() {
		return codCli;
	}

	public String getComments() {
		return comments;
	}

	public BigDecimal getComplete() {
		return complete;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getCustomerContactPerson() {
		return customerContactPerson;
	}

	public Long getDistrict() {
		return district;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getEstStatus() {
		return estStatus;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public Date getfActual() {
		return fActual;
	}

	public Date getFActual() {
		return fActual;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getHousePlot() {
		return housePlot;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getIdType() {
		return idType;
	}

	public BigDecimal getInspectionFee() {
		return inspectionFee;
	}

	public List<IopenApplicationDoc> getIopenApplicationDocs() {
		return iopenApplicationDocs;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public String getPrograma() {
		return programa;
	}

	public Long getStreet() {
		return street;
	}

	public String getSurname() {
		return surname;
	}

	public String getTermsAgree() {
		return termsAgree;
	}

	public String getTinNumber() {
		return tinNumber;
	}

	public String getUsuario() {
		return usuario;
	}

	public Long getVillage() {
		return village;
	}

	public Long getLocality() {
		return locality;
	}

	public void setLocality(Long locality) {
		// SMA 20160222 UMESCI-444
		if (locality == null) {
			locality = 0l;
		}
		this.locality = locality;
	}

	public IopenApplicationDoc removeIopenApplicationDoc(final IopenApplicationDoc iopenApplicationDoc) {
		getIopenApplicationDocs().remove(iopenApplicationDoc);
		iopenApplicationDoc.setIopenApplication(null);

		return iopenApplicationDoc;
	}

	public void setApplicationType(String applicationType) {
		// SMA 20160315
		if (applicationType == null || applicationType.isEmpty()) {
			applicationType = " ";
		}
		this.applicationType = applicationType;
	}

	public void setClientUsername(String clientUsername) {
		// SMA 20160315
		if (clientUsername == null || clientUsername.isEmpty()) {
			clientUsername = " ";
		}
		this.clientUsername = clientUsername;
	}

	public void setCodApplication(final Long codApplication) {
		this.codApplication = codApplication;
	}

	public void setCodCli(final java.math.BigDecimal codCli) {
		this.codCli = codCli;
	}

	public void setComments(String comments) {
		// SMA 20160315
		if (comments == null || comments.isEmpty()) {
			comments = " ";
		}
		this.comments = comments;
	}

	public void setComplete(final BigDecimal complete) {
		this.complete = complete;
	}

	public void setContactName(String contactName) {
		// SMA 20160315
		if (contactName == null || contactName.isEmpty()) {
			contactName = " ";
		}
		this.contactName = contactName;
	}

	public void setContactNumber(String contactNumber) {
		// SMA 20160315
		if (contactNumber == null || contactNumber.isEmpty()) {
			contactNumber = " ";
		}
		this.contactNumber = contactNumber;
	}

	public void setCustomerContactPerson(String customerContactPerson) {
		// SMA 20160315
		if (customerContactPerson == null || customerContactPerson.isEmpty()) {
			customerContactPerson = " ";
		}
		this.customerContactPerson = customerContactPerson;
	}

	public void setDistrict(Long district) {
		// SMA 20160222 UMESCI-444
		if (district == null) {
			district = 0l;
		}
		this.district = district;
	}

	public void setEmailAddress(String emailAddress) {
		// SMA 20160315
		if (emailAddress == null || emailAddress.isEmpty()) {
			emailAddress = " ";
		}
		this.emailAddress = emailAddress;
	}

	public void setEstStatus(String estStatus) {
		if (estStatus == null || estStatus.isEmpty()) {
			estStatus = " ";
		}
		this.estStatus = estStatus;
	}

	public void setExpediente(final Expediente expediente) {
		this.expediente = expediente;
	}

	public void setFActual(final Date fActual) {
		this.fActual = fActual;
	}

	public void setFirstName(String firstName) {
		// SMA 20160315
		if (firstName == null || firstName.isEmpty()) {
			firstName = " ";
		}
		this.firstName = firstName;
	}

	public void setHousePlot(String housePlot) {
		// SMA 20160315
		if (housePlot == null || housePlot.isEmpty()) {
			housePlot = " ";
		}
		this.housePlot = housePlot;
	}

	public void setIdNumber(String idNumber) {
		// SMA 20160315
		if (idNumber == null || idNumber.isEmpty()) {
			idNumber = " ";
		}
		this.idNumber = idNumber;
	}

	public void setIdType(String idType) {
		// SMA 20160315
		if (idType == null || idType.isEmpty()) {
			idType = " ";
		}
		this.idType = idType;
	}

	public void setInspectionFee(final BigDecimal inspectionFee) {
		this.inspectionFee = inspectionFee;
	}

	public void setIopenApplicationDocs(final List<IopenApplicationDoc> iopenApplicationDocs) {
		this.iopenApplicationDocs = iopenApplicationDocs;
	}

	public void setMiddleName(String middleName) {
		// SMA 20160315
		if (middleName == null || middleName.isEmpty()) {
			middleName = " ";
		}
		this.middleName = middleName;
	}

	public void setMobileNumber(String mobileNumber) {
		// SMA 20160315
		if (mobileNumber == null || mobileNumber.isEmpty()) {
			mobileNumber = " ";
		}
		this.mobileNumber = mobileNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		// SMA 20160315
		if (officeNumber == null || officeNumber.isEmpty()) {
			officeNumber = " ";
		}
		this.officeNumber = officeNumber;
	}

	public void setPrograma(String programa) {
		if (programa == null || programa.isEmpty()) {
			programa = " ";
		}
		this.programa = programa;
	}

	public void setStreet(Long street) {
		// SMA 20160222 UMESCI-444
		if (street == null) {
			street = 0l;
		}
		this.street = street;
	}

	public void setSurname(String surname) {
		// SMA 20160315
		if (surname == null || surname.isEmpty()) {
			surname = " ";
		}
		this.surname = surname;
	}

	public void setTermsAgree(String termsAgree) {
		// SMA 20160315
		if (termsAgree == null || termsAgree.isEmpty()) {
			termsAgree = " ";
		}
		this.termsAgree = termsAgree;
	}

	public void setTinNumber(String tinNumber) {
		// SMA 20160315
		if (tinNumber == null || tinNumber.isEmpty()) {
			tinNumber = " ";
		}
		this.tinNumber = tinNumber;
	}

	public void setUsuario(String usuario) {
		// SMA 20160315
		if (usuario == null || usuario.isEmpty()) {
			usuario = " ";
		}
		this.usuario = usuario;
	}

	public void setVillage(Long village) {
		// SMA 20160222 UMESCI-444
		if (village == null) {
			village = 0l;
		}
		this.village = village;
	}

	public String getAgreeWayleaves() {
		return agreeWayleaves;
	}

	public void setAgreeWayleaves(final String agreeWayleaves) {
		this.agreeWayleaves = agreeWayleaves;
	}

	public Boolean getInspectionScheduled() {
		return inspectionScheduled;
	}

	public void setInspectionScheduled(final Boolean inspectionScheduled) {
		this.inspectionScheduled = inspectionScheduled;
	}

	public Date getInspectionScheduledDate() {
		return inspectionScheduledDate;
	}

	public void setInspectionScheduledDate(final Date inspectionScheduledDate) {
		this.inspectionScheduledDate = inspectionScheduledDate;
	}

	public String getInspectionScheduledBy() {
		return inspectionScheduledBy;
	}

	public void setInspectionScheduledBy(final String inspectionScheduledBy) {
		this.inspectionScheduledBy = inspectionScheduledBy;
	}

	public String getCoRejectReason() {
		return coRejectReason;
	}

	public void setCoRejectReason(final String coRejectReason) {
		this.coRejectReason = coRejectReason;
	}

	public Boolean getConnectionScheduled() {
		return connectionScheduled;
	}

	public void setConnectionScheduled(final Boolean connectionScheduled) {
		this.connectionScheduled = connectionScheduled;
	}

	public Date getConnectionScheduledDate() {
		return connectionScheduledDate;
	}

	public void setConnectionScheduledDate(final Date connectionScheduledDate) {
		this.connectionScheduledDate = connectionScheduledDate;
	}

	public String getConnectionScheduledBy() {
		return connectionScheduledBy;
	}

	public void setConnectionScheduledBy(final String connectionScheduledBy) {
		this.connectionScheduledBy = connectionScheduledBy;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		// SMA 20160315
		if (landmark == null || landmark.isEmpty()) {
			landmark = " ";
		}
		this.landmark = landmark;
	}

	public String getInspectionRejectBy() {
		return inspectionRejectBy;
	}

	public void setInspectionRejectBy(final String inspectionRejectBy) {
		this.inspectionRejectBy = inspectionRejectBy;
	}

	public String getInspectionRejectCode() {
		return inspectionRejectCode;
	}

	public void setInspectionRejectCode(final String inspectionRejectCode) {
		this.inspectionRejectCode = inspectionRejectCode;
	}

	public String getInspectionRejectComment() {
		return inspectionRejectComment;
	}

	public void setInspectionRejectComment(final String inspectionRejectComment) {
		this.inspectionRejectComment = inspectionRejectComment;
	}

	public Date getInspectionRejectDate() {
		return inspectionRejectDate;
	}

	public void setInspectionRejectDate(final Date inspectionRejectDate) {
		this.inspectionRejectDate = inspectionRejectDate;
	}

	public Boolean getInspectionRejected() {
		return inspectionRejected;
	}

	public void setInspectionRejected(final Boolean inspectionRejected) {
		this.inspectionRejected = inspectionRejected;
	}

	public String getStreetDesc() {
		return streetDesc;
	}

	public void setStreetDesc(String streetDesc) {
		// SMA 20160315
		if (streetDesc == null || streetDesc.isEmpty()) {
			streetDesc = " ";
		}
		this.streetDesc = streetDesc;
	}

	public String getSubCountyDesc() {
		return subCountyDesc;
	}

	public void setSubCountyDesc(String subCountyDesc) {
		if (subCountyDesc == null || subCountyDesc.isEmpty()) {
			subCountyDesc = " ";
		}
		this.subCountyDesc = subCountyDesc;
	}

	public String getTownDesc() {
		return townDesc;
	}

	public void setTownDesc(String townDesc) {
		if (townDesc == null || townDesc.isEmpty()) {
			townDesc = " ";
		}
		this.townDesc = townDesc;
	}

	public String getCountyDesc() {
		return countyDesc;
	}

	public void setCountyDesc(String countyDesc) {
		if (countyDesc == null || countyDesc.isEmpty()) {
			countyDesc = " ";
		}
		this.countyDesc = countyDesc;
	}

	public String getDirectionsDesc() {
		return directionsDesc;
	}

	public void setDirectionsDesc(String directionsDesc) {
		if (directionsDesc == null || directionsDesc.isEmpty()) {
			directionsDesc = " ";
		}
		this.directionsDesc = directionsDesc;
	}

	public String getDistrictDesc() {
		return districtDesc;
	}

	public void setDistrictDesc(String districtDesc) {
		if (districtDesc == null || districtDesc.isEmpty()) {
			districtDesc = " ";
		}
		this.districtDesc = districtDesc;
	}

	public String getVillageDesc() {
		return villageDesc;
	}

	public void setVillageDesc(String villageDesc) {
		if (villageDesc == null || villageDesc.isEmpty()) {
			villageDesc = " ";
		}
		this.villageDesc = villageDesc;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	@Override
	public String toString() {
		return "IopenApplication [codApplication=" + codApplication + ", applicationType=" + applicationType
				+ ", clientUsername=" + clientUsername + ", codCli=" + codCli + ", complete=" + complete + ", comments="
				+ comments + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", customerContactPerson=" + customerContactPerson + ", district=" + district + ", emailAddress="
				+ emailAddress + ", estStatus=" + estStatus + ", fActual=" + fActual + ", firstName=" + firstName
				+ ", housePlot=" + housePlot + ", idNumber=" + idNumber + ", inspectionScheduled=" + inspectionScheduled
				+ ", inspectionScheduledDate=" + inspectionScheduledDate + ", inspectionScheduledBy="
				+ inspectionScheduledBy + ", connectionScheduled=" + connectionScheduled + ", connectionScheduledDate="
				+ connectionScheduledDate + ", connectionScheduledBy=" + connectionScheduledBy + ", idType=" + idType
				+ ", inspectionFee=" + inspectionFee + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber
				+ ", officeNumber=" + officeNumber + ", gps=" + gps + ", programa=" + programa + ", street=" + street
				+ ", locality=" + locality + ", surname=" + surname + ", termsAgree=" + termsAgree + ", tinNumber="
				+ tinNumber + ", usuario=" + usuario + ", village=" + village + ", iopenApplicationDocs="
				+ iopenApplicationDocs + ", expediente=" + expediente + ", agreeWayleaves=" + agreeWayleaves
				+ ", coRejectReason=" + coRejectReason + ", landmark=" + landmark + ", inspectionRejectBy="
				+ inspectionRejectBy + ", inspectionRejectCode=" + inspectionRejectCode + ", inspectionRejectComment="
				+ inspectionRejectComment + ", inspectionRejectDate=" + inspectionRejectDate + ", inspectionRejected="
				+ inspectionRejected + ", streetDesc=" + streetDesc + ", subCountyDesc=" + subCountyDesc + ", townDesc="
				+ townDesc + ", countyDesc=" + countyDesc + ", directionsDesc=" + directionsDesc + ", districtDesc="
				+ districtDesc + ", villageDesc=" + villageDesc + "]";
	}

}