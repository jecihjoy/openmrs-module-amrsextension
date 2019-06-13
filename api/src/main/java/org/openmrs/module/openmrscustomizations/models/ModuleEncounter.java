package org.openmrs.module.openmrscustomizations.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Encounter;

//import org.openmrs.module.appointmentscheduling.Appointment;

public class ModuleEncounter extends BaseOpenmrsData {
	
	//	private Appointment appointment;
	
	private Encounter encounter;
	
	public ModuleEncounter() {
	}
	
	//	public ModuleEncounter(Appointment appointment, Encounter encounter) {
	//		this.appointment = appointment;
	//		this.encounter = encounter;
	//	}
	//
	//	public Appointment getAppointment() {
	//		return appointment;
	//	}
	//
	//	public void setAppointment(Appointment appointment) {
	//		this.appointment = appointment;
	//	}
	//
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
