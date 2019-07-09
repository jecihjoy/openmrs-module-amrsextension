package org.openmrs.module.amrsextension.models;

import org.openmrs.BaseOpenmrsData;

import java.util.Date;

public class LabOrder extends BaseOpenmrsData {
	
	private String conceptUuid;
	
	private Date dateActivated;
	
	private String display;
	
	private String familyName;
	
	private String identifiers; //"367420060-9,1234566,0123456"
	
	private String locationUuid;
	
	private int locationId;
	
	private String locationName;
	
	private String middleName;
	
	private String obs_uuid;
	
	private String orderNumber;
	
	private int orderType;
	
	private int patientId;
	
	private String patientUuid;
	
	private String personName;
	
	private String providerName;
	
	private String providerUuid;
	
	private Date sampleCollectioDate;
	
	private String sampleDrawn;
	
	private String uuid;
	
	public String getConceptUuid() {
		return conceptUuid;
	}
	
	public void setConceptUuid(String conceptUuid) {
		this.conceptUuid = conceptUuid;
	}
	
	public Date getDateActivated() {
		return dateActivated;
	}
	
	public void setDateActivated(Date dateActivated) {
		this.dateActivated = dateActivated;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getIdentifiers() {
		return identifiers;
	}
	
	public void setIdentifiers(String identifiers) {
		this.identifiers = identifiers;
	}
	
	public String getLocationUuid() {
		return locationUuid;
	}
	
	public void setLocationUuid(String locationUuid) {
		this.locationUuid = locationUuid;
	}
	
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getObs_uuid() {
		return obs_uuid;
	}
	
	public void setObs_uuid(String obs_uuid) {
		this.obs_uuid = obs_uuid;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getOrderType() {
		return orderType;
	}
	
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientUuid() {
		return patientUuid;
	}
	
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getProviderName() {
		return providerName;
	}
	
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public String getProviderUuid() {
		return providerUuid;
	}
	
	public void setProviderUuid(String providerUuid) {
		this.providerUuid = providerUuid;
	}
	
	public Date getSampleCollectioDate() {
		return sampleCollectioDate;
	}
	
	public void setSampleCollectioDate(Date sampleCollectioDate) {
		this.sampleCollectioDate = sampleCollectioDate;
	}
	
	public String getSampleDrawn() {
		return sampleDrawn;
	}
	
	public void setSampleDrawn(String sampleDrawn) {
		this.sampleDrawn = sampleDrawn;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
