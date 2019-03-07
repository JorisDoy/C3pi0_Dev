package com.indra.iopen.form;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.util.annotation.Phone;

@Component
public class Application {

	private String page;

	private String actionMethod;

	private boolean validateFile = true;

	private Long codApplication;

	private String agreeWayleaves;

	private IopenApplication iopenApplication;

	// Applicants section
	@NotNull(message = "{chooseoneapplicationType.size}")
	@Size(min = 2, message = "{applicationType.size}")
	private String applicationType;

	// Applicants data

	/*
	 * It also stores the company name
	 */
	@NotNull
	@Size(min = 2, max = 50, message = "{surname.size}")
	private String surname;

	@NotNull
	@Size(min = 2, max = 50, message = "{firstname.size}")
	private String firstName;

	@NotNull
	private String middleName;

	/**
	 * Id or passport number
	 */
	@NotNull(message = "{idNumber.size}")
	@Size(min = 2, message = "{idNumber.size}")
	private String idNumber;

	@NotNull(message = "{chooseonedocumentType.size}")
	private String documentType;

	/**
	 * Company Id
	 */
	@NotNull
	private String tinNumber;

	@NotNull
	@Size(min = 10, max = 14, message = "{mobileNumber.size}")
	@Phone
	private String mobileNumber;

	@NotNull
	private String officeNumber;

	@Email(message = "{email.valid}")
	@Size(min = 2, message = "{email.valid}")
	private String emailAddress;

	@NotNull(message = "{customerContactPerson.size}")
	private String customerContactPerson;

	@NotNull
	private String contactName;

	@NotNull
	private String contactNumber;

	// Supply location
	@NotNull(message = "{district.size}")
	private Long district;

	@NotNull(message = "{village.size}")
	private Long village;

	@NotNull(message = "{street.size}")
	private BigDecimal street;

	@NotNull(message = "{housePlot.size}")
	private String housePlot;

	private String streetDesc;

	@NotNull(message = "{subCountyDesc.size}")
	private String subCountyDesc;

	@NotNull(message = "{villageDesc.size}")
	private String villageDesc;

	@NotNull(message = "{townDesc.size}")
	private String townDesc;

	@NotNull(message = "{countyDesc.size}")
	private String countyDesc;

	@NotNull(message = "{directionsDesc.size}")
	private String directionsDesc;

	@NotNull(message = "{districtDesc.size}")
	private String districtDesc;

	private List<MultipartFile> files;

	// Checklist (files to be uploaded)

	// TODO: Add file handler and convert the form to multipart form data

	// iOpen Credentials
	/*
	 * @Email(message = "{email.valid}")
	 *
	 * @Size(min = 2, message = "{email.valid}") private String email;
	 *
	 * @Size( min = 8, max = 30, message = "{password.size}") private String
	 * password;
	 *
	 * @Size(min = 8, max = 30, message = "{password.size}") private String
	 * confirmPassword;
	 */
	@NotNull(message = "{locality.size}")
	private Long locality;

	@NotNull
	private String landmark;

	@NotNull
	@Size(min = 1, message = "{numbermin.size}")
	private String agreeTermsConditions;

	private Long codCli;

	public Application() {
		// TODO Auto-generated constructor stub
		//contactName = " ";
		//contactNumber = " ";
		// districtDesc = " ";
		// townDesc = " ";
		// countyDesc = " ";
		// subCountyDesc = " ";
		// streetDesc = " ";
		// directionsDesc = " ";
		// villageDesc = " ";
		district = 0l;
		locality = 0l;
		street = new BigDecimal(0);
		village = 0l;
		//housePlot = " ";
		codCli = 0L;

		// village = " ";
		// street = " ";
		// housePlot = " ";
		//
		// contactName = " ";
		// contactNumber = " ";
		// customerContactPerson = " ";
		// district = " ";
		// emailAddress = " ";
		// firstName = " ";
		// idNumber = " ";
		// middleName = " ";
		// mobileNumber = " ";
		// officeNumber = " ";
		// surname = " ";
		// agreeTermsConditions = " ";
		// tinNumber = " ";
	}

	public String getVillageDesc() {
		return villageDesc;
	}

	public void setVillageDesc(String villageDesc) {
		this.villageDesc = villageDesc;
	}

	public String getStreetDesc() {
		return streetDesc;
	}

	public void setStreetDesc(String streetDesc) {
		this.streetDesc = streetDesc;
	}

	public String getSubCountyDesc() {
		return subCountyDesc;
	}

	public void setSubCountyDesc(String subCountyDesc) {
		this.subCountyDesc = subCountyDesc;
	}

	public String getTownDesc() {
		return townDesc;
	}

	public void setTownDesc(String townDesc) {
		this.townDesc = townDesc;
	}

	public String getCountyDesc() {
		return countyDesc;
	}

	public void setCountyDesc(String countyDesc) {
		this.countyDesc = countyDesc;
	}

	public String getDirectionsDesc() {
		return directionsDesc;
	}

	public void setDirectionsDesc(String directionsDesc) {
		this.directionsDesc = directionsDesc;
	}

	public String getDistrictDesc() {
		return districtDesc;
	}

	public void setDistrictDesc(String districtDesc) {
		this.districtDesc = districtDesc;
	}

	public String getActionMethod() {
		return actionMethod;
	}

	public String getAgreeTermsConditions() {
		return agreeTermsConditions;
	}

	// public String getConfirmPassword() {
	// return confirmPassword;
	// }

	public String getAgreeWayleaves() {
		return agreeWayleaves;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public Long getCodApplication() {
		return codApplication;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	// public String getEmail() {
	// return email;
	// }

	public String getCustomerContactPerson() {
		return customerContactPerson;
	}

	public Long getDistrict() {
		return district;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getHousePlot() {
		// if (housePlot == null) {
		// housePlot = " ";
		// }
		return housePlot;
	}

	public String getIdNumber() {
		return idNumber;
	}

	// public String getPassword() {
	// return password;
	// }

	public String getMiddleName() {
		return middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public String getPage() {
		return page;
	}

	public BigDecimal getStreet() {
		// if (street == null) {
		// street = " ";
		// }
		return street;
	}

	public String getSurname() {
		return surname;
	}

	// public void setConfirmPassword(String confirmPassword) {
	// if (confirmPassword == null) {
	// confirmPassword = " ";
	// }
	// this.confirmPassword = confirmPassword;
	// }

	public String getTinNumber() {
		if (tinNumber == null) {
			tinNumber = " ";
		}
		return tinNumber;
	}

	public Long getVillage() {
		// if (village == null) {
		// village = " ";
		// }
		return village;
	}

	public void setActionMethod(final String actionMethod) {
		this.actionMethod = actionMethod;
	}

	public void setAgreeTermsConditions(String agreeTermsConditions) {
		if (agreeTermsConditions == null) {
			agreeTermsConditions = " ";
		}
		this.agreeTermsConditions = agreeTermsConditions.toUpperCase();
	}

	public void setAgreeWayleaves(String agreeWayleaves) {
		if (agreeWayleaves == null) {
			agreeWayleaves = " ";
		}
		this.agreeWayleaves = agreeWayleaves;
	}

	// public void setEmail(String email) {
	// if (email == null) {
	// email = " ";
	// }
	// this.email = email;
	// }

	public void setApplicationType(String applicationType) {
		if (applicationType == null) {
			applicationType = " ";
		}
		this.applicationType = applicationType.toUpperCase();
	}

	public void setCodApplication(final Long codApplication) {
		this.codApplication = codApplication;
	}

	public void setContactName(String contactName) {
		if (contactName == null) {
			contactName = " ";
		}
		this.contactName = contactName.toUpperCase();
	}

	public void setContactNumber(String contactNumber) {
		if (contactNumber == null) {
			contactNumber = " ";
		}
		this.contactNumber = contactNumber.toUpperCase();
	}

	public void setCustomerContactPerson(String customerContactPerson) {
		if (customerContactPerson == null) {
			customerContactPerson = " ";
		}
		this.customerContactPerson = customerContactPerson.toUpperCase();
	}

	public void setDistrict(Long district) {

		if (district == null) {
			district = 0L;
		}
		this.district = district;
	}

	public void setDocumentType(String documentType) {
		if (documentType == null) {
			documentType = " ";
		}
		this.documentType = documentType.toUpperCase();
	}

	public void setEmailAddress(String emailAddress) {
		if (emailAddress == null) {
			emailAddress = " ";
		}
		this.emailAddress = emailAddress;
	}

	// public void setPassword(String password) {
	// if (password == null) {
	// password = " ";
	// }
	// this.password = password;
	// }

	public void setFiles(final List<MultipartFile> files) {
		this.files = files;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			firstName = " ";
		}
		this.firstName = firstName.toUpperCase();
	}

	public void setHousePlot(String housePlot) {
		if (housePlot == null) {
			housePlot = " ";
		}
		this.housePlot = housePlot.toUpperCase();
	}

	public void setIdNumber(String idNumber) {
		if (idNumber == null) {
			idNumber = " ";
		}
		this.idNumber = idNumber.toUpperCase();
	}

	public void setMiddleName(String middleName) {
		if (middleName == null) {
			middleName = " ";
		}
		this.middleName = middleName.toUpperCase();
	}

	public void setMobileNumber(String mobileNumber) {
		if (mobileNumber == null) {
			mobileNumber = " ";
		}
		this.mobileNumber = mobileNumber.toUpperCase();
	}

	public void setOfficeNumber(String officeNumber) {
		if (officeNumber == null) {
			officeNumber = " ";
		}
		this.officeNumber = officeNumber.toUpperCase();
	}

	public void setPage(final String page) {
		this.page = page;
	}

	public void setStreet(BigDecimal street) {
		if (street == null) {
			street = new BigDecimal(0);
		}
		this.street = street;
	}

	public void setSurname(String surname) {
		if (surname == null) {
			surname = " ";
		}
		this.surname = surname.toUpperCase();
	}

	public void setTinNumber(String tinNumber) {
		if (tinNumber == null) {
			tinNumber = " ";
		}
		this.tinNumber = tinNumber.toUpperCase();
	}

	public void setVillage(Long village) {

		if (village == null) {
			village = 0L;
		}
		this.village = village;
	}

	public IopenApplication getIopenApplication() {
		return iopenApplication;
	}

	public void setIopenApplication(final IopenApplication iopenApplication) {
		this.iopenApplication = iopenApplication;
	}

	public boolean isValidateFile() {
		return validateFile;
	}

	public void setValidateFile(boolean validateFile) {
		this.validateFile = validateFile;
	}

	public Long getLocality() {
		return locality;
	}

	public void setLocality(Long locality) {
		if (locality == null) {
			locality = 0L;
		}
		this.locality = locality;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {

		if (landmark == null || landmark.equals("")) {
			landmark = " ";
		}

		this.landmark = landmark;
	}

	public Long getCodCli() {
		return codCli;
	}

	public void setCodCli(Long codCli) {
		this.codCli = codCli;
	}

	@Override
	public String toString() {
		return "Application [page=" + page + ", actionMethod=" + actionMethod + ", validateFile=" + validateFile
				+ ", codApplication=" + codApplication + ", agreeWayleaves=" + agreeWayleaves + ", iopenApplication="
				+ iopenApplication + ", applicationType=" + applicationType + ", surname=" + surname + ", firstName="
				+ firstName + ", middleName=" + middleName + ", idNumber=" + idNumber + ", documentType=" + documentType
				+ ", tinNumber=" + tinNumber + ", mobileNumber=" + mobileNumber + ", officeNumber=" + officeNumber
				+ ", emailAddress=" + emailAddress + ", customerContactPerson=" + customerContactPerson
				+ ", contactName=" + contactName + ", contactNumber=" + contactNumber + ", district=" + district
				+ ", village=" + village + ", street=" + street + ", housePlot=" + housePlot + ", files=" + files
				+ ", locality=" + locality + ", landmark=" + landmark + ", agreeTermsConditions=" + agreeTermsConditions
				+ "]";
	}

}
