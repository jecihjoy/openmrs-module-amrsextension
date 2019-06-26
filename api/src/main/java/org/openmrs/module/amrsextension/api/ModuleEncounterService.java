package org.openmrs.module.amrsextension.api;

import org.openmrs.Patient;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.amrsextension.models.ModuleEncounter;
import org.openmrs.module.appointmentscheduling.Appointment;

public interface ModuleEncounterService extends OpenmrsService {
	
	ModuleEncounter saveEncounter(ModuleEncounter encounter);
	
	Appointment getPatientLastAppointment(Patient patient);
	
}
