package org.openmrs.module.amrsextension.api.impl;

import org.openmrs.Encounter;
import org.openmrs.EncounterProvider;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.amrsextension.models.ModuleEncounter;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.TimeSlot;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.amrsextension.api.ModuleEncounterService;
import org.openmrs.validator.ValidateUtil;

public class ModuleEncounterServiceImpl extends BaseOpenmrsService implements ModuleEncounterService {
	
	@Override
	public ModuleEncounter saveEncounter(ModuleEncounter mencounter) {
		AppointmentService service = Context.getService(AppointmentService.class);
		
		if (mencounter != null) {
			
			Encounter encounter = new Encounter();
			if (mencounter.getEncounterId() != 0) {
				encounter.setUuid(mencounter.getUuid());
				encounter.setId(mencounter.getEncounterId());
			}
			encounter.setEncounterDatetime(mencounter.getEncounterDatetime());
			encounter.setEncounterProviders(mencounter.getEncounterProviders());
			encounter.setLocation(mencounter.getLocation());
			encounter.setPatient(mencounter.getPatient());
			encounter.setVisit(mencounter.getVisit());
			encounter.setEncounterType(mencounter.getEncounterType());
			encounter.setForm(mencounter.getForm());
			encounter.setObs(mencounter.getObs());
			encounter.setOrders(mencounter.getOrders());
			
			Appointment appointment = new Appointment();
			if (mencounter.getAppointmentId() != 0) {
				appointment.setId(mencounter.getAppointmentId());
			}
			appointment.setPatient(mencounter.getPatient());
			appointment.setStatus(mencounter.getAppointmentStatus());
			appointment.setAppointmentType(mencounter.getAppointmentType());
			appointment.setVisit(mencounter.getVisit());
			appointment.setTimeSlot(mencounter.getAppointmentTimeSlot());
			
			TimeSlot timeSlot = service.getTimeslotForAppointment(mencounter.getLocation(),
			    mencounter.getAppointmentProvider(), mencounter.getAppointmentType(), mencounter.getAppointmentDate());
			if (timeSlot == null) {
				timeSlot = service.createTimeSlotUsingProviderSchedule(mencounter.getAppointmentDate(),
				    mencounter.getAppointmentType(), mencounter.getAppointmentProvider(), mencounter.getLocation());
			}
			appointment.setTimeSlot(timeSlot);
			ValidateUtil.validate(appointment);
			
			for (EncounterProvider ep : mencounter.getEncounterProviders()) {
				ep.setEncounter(encounter);
			}
			
			Encounter savedEncounter = Context.getEncounterService().saveEncounter(encounter);
			if (savedEncounter != null) {
				Appointment savedAppointment;
				try {
					savedAppointment = service.saveAppointment(appointment);
					return mencounter;
				}
				catch (Exception e) {
					Context.getEncounterService().voidEncounter(savedEncounter, "Error occured during saving");
					throw e;
				}
			}
			return null;
		}
		
		return null;
	}
	
	@Override
	public Appointment getPatientLastAppointment(Patient patient) {
		return Context.getService(AppointmentService.class).getLastAppointment(patient);
	}
}
