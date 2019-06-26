package org.openmrs.module.amrsextension.models;

import org.openmrs.*;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.AppointmentType;
import org.openmrs.module.appointmentscheduling.TimeSlot;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class ModuleEncounter extends BaseOpenmrsData {
	
	private Date encounterDatetime;
	
	private Patient patient;
	
	private Location location;
	
	private Form form;
	
	private EncounterType encounterType;
	
	private Set<Order> orders;
	
	private Set<Obs> obs;
	
	private Visit visit;
	
	private Integer encounterId;
	
	private TimeSlot appointmentTimeSlot;
	
	private Appointment.AppointmentStatus appointmentStatus;
	
	private String appointmentReason;
	
	private String appointmentCancelReason;
	
	private AppointmentType appointmentType;
	
	private Date appointmentDate;
	
	private Provider appointmentProvider;
	
	private Integer appointmentId;
	
	private Set<EncounterProvider> encounterProviders = new LinkedHashSet();
	
	public ModuleEncounter() {
	}
	
	public Date getEncounterDatetime() {
		return encounterDatetime;
	}
	
	public void setEncounterDatetime(Date encounterDatetime) {
		this.encounterDatetime = encounterDatetime;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Form getForm() {
		return form;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}
	
	public EncounterType getEncounterType() {
		return encounterType;
	}
	
	public void setEncounterType(EncounterType encounterType) {
		this.encounterType = encounterType;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public Set<Obs> getObs() {
		return obs;
	}
	
	public void setObs(Set<Obs> obs) {
		this.obs = obs;
	}
	
	public Visit getVisit() {
		return visit;
	}
	
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}
	
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	
	public Set<EncounterProvider> getEncounterProviders() {
		return encounterProviders;
	}
	
	public void setEncounterProviders(Set<EncounterProvider> encounterProviders) {
		this.encounterProviders = encounterProviders;
	}
	
	public Integer getEncounterId() {
		return encounterId;
	}
	
	public void setEncounterId(Integer encounterId) {
		this.encounterId = encounterId;
	}
	
	public Integer getAppointmentId() {
		return appointmentId;
	}
	
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public TimeSlot getAppointmentTimeSlot() {
		return appointmentTimeSlot;
	}
	
	public void setAppointmentTimeSlot(TimeSlot appointmentTimeSlot) {
		this.appointmentTimeSlot = appointmentTimeSlot;
	}
	
	public Appointment.AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}
	
	public void setAppointmentStatus(Appointment.AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
	public String getAppointmentReason() {
		return appointmentReason;
	}
	
	public void setAppointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}
	
	public String getAppointmentCancelReason() {
		return appointmentCancelReason;
	}
	
	public void setAppointmentCancelReason(String appointmentCancelReason) {
		this.appointmentCancelReason = appointmentCancelReason;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public Provider getAppointmentProvider() {
		return appointmentProvider;
	}
	
	public void setAppointmentProvider(Provider appointmentProvider) {
		this.appointmentProvider = appointmentProvider;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
