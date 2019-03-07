package com.indra.iopen.form.ims;

import com.indra.iopen.pojo.PowerOutageIncidentInfo;
import com.indra.iopen.pojo.PowerOutageInstallationInfo;

public class PowerOutage {
	
	private Integer outageType;
	private String region = null;
	private String voltage = null;
	private String scope = null;
	
	private PowerOutageInstallationInfo powerOutageInstallationInfo = null;
	private PowerOutageIncidentInfo powerOutageIncidentInfo = null;
	private Long incidentId = null;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	public Integer getOutageType() {
		return outageType;
	}

	public void setOutageType(Integer outageType) {
		this.outageType = outageType;
	}

	public PowerOutageInstallationInfo getPowerOutageInstallationInfo() {
		return powerOutageInstallationInfo;
	}

	public void setPowerOutageInstallationInfo(PowerOutageInstallationInfo powerOutageInstallationInfo) {
		this.powerOutageInstallationInfo = powerOutageInstallationInfo;
	}

	public PowerOutageIncidentInfo getPowerOutageIncidentInfo() {
		return powerOutageIncidentInfo;
	}

	public void setPowerOutageIncidentInfo(PowerOutageIncidentInfo powerOutageIncidentInfo) {
		this.powerOutageIncidentInfo = powerOutageIncidentInfo;
	}

	public Long getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(Long incidentId) {
		this.incidentId = incidentId;
	}

}
