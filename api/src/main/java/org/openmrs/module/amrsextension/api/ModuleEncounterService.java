package org.openmrs.module.amrsextension.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.amrsextension.models.ModuleEncounter;

public interface ModuleEncounterService extends OpenmrsService {
	
	ModuleEncounter saveEncounter(ModuleEncounter encounter);
	
}
