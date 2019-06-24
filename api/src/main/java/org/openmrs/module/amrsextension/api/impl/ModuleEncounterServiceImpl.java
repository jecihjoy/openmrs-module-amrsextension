package org.openmrs.module.amrsextension.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.EncounterProvider;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.amrsextension.models.ModuleEncounter;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.amrsextension.api.ModuleEncounterService;

public class ModuleEncounterServiceImpl extends BaseOpenmrsService implements ModuleEncounterService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public ModuleEncounter saveEncounter(ModuleEncounter mencounter) {
		
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
			
			Appointment appointment = new Appointment(); //cb385ffa-9cf5-4d52-bda6-2d8a4d84e2aa
			if (mencounter.getAppointmentId() != 0) {
				appointment.setId(mencounter.getAppointmentId());
			}
			appointment.setPatient(mencounter.getPatient());
			appointment.setStatus(mencounter.getAppointmentStatus());
			appointment.setAppointmentType(mencounter.getAppointmentType());
			appointment.setVisit(mencounter.getVisit());
			appointment.setTimeSlot(mencounter.getAppointmentTimeSlot());
			
			for (EncounterProvider ep : mencounter.getEncounterProviders()) {
				ep.setEncounter(encounter);
			}
			
			Encounter savedEncounter = Context.getEncounterService().saveEncounter(encounter);
			if (savedEncounter != null) {
				Appointment savedAppointment;
				try {
					savedAppointment = Context.getService(AppointmentService.class).saveAppointment(appointment);
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
}
