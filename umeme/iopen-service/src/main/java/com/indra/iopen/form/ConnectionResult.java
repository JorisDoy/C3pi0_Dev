package com.indra.iopen.form;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.indra.iopen.model.IopenApplication;

public class ConnectionResult {

	private IopenApplication iopenApplication;

	// connection details
	private Date connectionDate;
	private String connectionDateString;
	private double connectionTime;
	private String connectionComment;

	private long connectionByEmployeeCode;

	// meter installation data
	private String floorNumber;
	private long meterInitialReading;
	private String meterNumber;
	private long noOfDials;

	// network mapping installation code imsInstallationCode = circuit
	private Long subStation;
	private Long feeder;
	private Long transformer;
	private Long imsInstallationCode;

	private String readingNature; // tipNatur
	private long mrDiv; // numMrsp
	private long rso;
	private long meterConstant;
	private long lossCoefficient;

	private String meterMake;

	// service point data
	private String connectionType;
	private String associationType;
	private String voltageType;
	private String phaseType;
	private String recommendedTariff;
	private String estimationMethod;
	private String readingPeriod;
	private String servicePointStatus;
	private String servicePointType;

	private long contPower;

	private long depositPaid = 0;
	//	SMA/UMESCI-732 -20170506
	//	private double xCoordinate;
	//	private double yCoordinate;
	//	private double zCoordinate;
	private long fuseOrMcb = -1; /* FUSE - 1, MCB - 2 */
	private BigDecimal tariffItemGroup = null;

	public ConnectionResult() {
		// TODO: remove when selection added to UI
		tariffItemGroup = new BigDecimal(1);
	}

	public ConnectionResult(IopenApplication iopenApplication) {
		this.iopenApplication = iopenApplication;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public long getMeterInitialReading() {
		return meterInitialReading;
	}

	public void setMeterInitialReading(long meterInitialReading) {
		this.meterInitialReading = meterInitialReading;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getMeterMake() {
		return meterMake;
	}

	public void setMeterMake(String meterMake) {
		this.meterMake = meterMake;
	}

	public long getNoOfDials() {
		return noOfDials;
	}

	public void setNoOfDials(long noOfDials) {
		this.noOfDials = noOfDials;
	}

	public Long getImsInstallationCode() {
		return imsInstallationCode;
	}

	public void setImsInstallationCode(Long imsInstallationCode) {
		this.imsInstallationCode = imsInstallationCode;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getVoltageType() {
		return voltageType;
	}

	public void setVoltageType(String voltageType) {
		this.voltageType = voltageType;
	}

	public String getPhaseType() {
		return phaseType;
	}

	public void setPhaseType(String phaseType) {
		this.phaseType = phaseType;
	}

	public long getContPower() {
		return contPower;
	}

	public void setContPower(long contPower) {
		this.contPower = contPower;
	}

	public String getReadingPeriod() {
		return readingPeriod;
	}

	public void setReadingPeriod(String readingPeriod) {
		this.readingPeriod = readingPeriod;
	}

	public String getEstimationMethod() {
		return estimationMethod;
	}

	public void setEstimationMethod(String estimationMethod) {
		this.estimationMethod = estimationMethod;
	}

	public String getServicePointStatus() {
		return servicePointStatus;
	}

	public void setServicePointStatus(String servicePointStatus) {
		this.servicePointStatus = servicePointStatus;
	}

	public String getServicePointType() {
		return servicePointType;
	}

	public void setServicePointType(String servicePointType) {
		this.servicePointType = servicePointType;
	}

	public long getDepositPaid() {
		return depositPaid;
	}

	public void setDepositPaid(long depositPaid) {
		this.depositPaid = depositPaid;
	}

	public Date getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}

	public double getConnectionTime() {
		return connectionTime;
	}

	public void setConnectionTime(double connectionTime) {
		this.connectionTime = connectionTime;
	}

	public long getConnectionByEmployeeCode() {
		return connectionByEmployeeCode;
	}

	public void setConnectionByEmployeeCode(long connectionByEmployeeCode) {
		this.connectionByEmployeeCode = connectionByEmployeeCode;
	}

	public IopenApplication getIopenApplication() {
		return iopenApplication;
	}

	public void setIopenApplication(IopenApplication iopenApplication) {
		this.iopenApplication = iopenApplication;
	}

	public String getConnectionComment() {
		return connectionComment;
	}

	public void setConnectionComment(String connectionComment) {
		this.connectionComment = connectionComment;
	}

	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	public String getRecommendedTariff() {
		return recommendedTariff;
	}

	public void setRecommendedTariff(String recommendedTariff) {
		this.recommendedTariff = recommendedTariff;
	}

	public long getFuseOrMcb() {
		return fuseOrMcb;
	}

	public void setFuseOrMcb(long fuseOrMcb) {
		this.fuseOrMcb = fuseOrMcb;
	}

	public String getReadingNature() {
		return readingNature;
	}

	public void setReadingNature(String readingNature) {
		this.readingNature = readingNature;
	}

	public long getMrDiv() {
		return mrDiv;
	}

	public void setMrDiv(long mrDiv) {
		this.mrDiv = mrDiv;
	}

	public long getRso() {
		return rso;
	}

	public void setRso(long rso) {
		this.rso = rso;
	}

	public long getMeterConstant() {
		return meterConstant;
	}

	public void setMeterConstant(long meterConstant) {
		this.meterConstant = meterConstant;
	}

	public long getLossCoefficient() {
		return lossCoefficient;
	}

	public void setLossCoefficient(long lossCoefficient) {
		this.lossCoefficient = lossCoefficient;
	}

	public BigDecimal getTariffItemGroup() {
		return tariffItemGroup;
	}

	public void setTariffItemGroup(BigDecimal tariffItemGroup) {
		this.tariffItemGroup = tariffItemGroup;
	}

	public String getConnectionDateString() {

		if (connectionDate != null) {
			final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			connectionDateString = formatter.format(connectionDate);
		}

		return connectionDateString;
	}

	public void setConnectionDateString(String connectionDateString) {
		this.connectionDateString = connectionDateString;

		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			connectionDate = formatter.parse(connectionDateString);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public Long getSubStation() {
		return subStation;
	}

	public void setSubStation(Long subStation) {
		this.subStation = subStation;
	}

	public Long getFeeder() {
		return feeder;
	}

	public void setFeeder(Long feeder) {
		this.feeder = feeder;
	}

	public Long getTransformer() {
		return transformer;
	}

	public void setTransformer(Long transformer) {
		this.transformer = transformer;
	}

}
