package org.openmrs.module.openmrscustomizations.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.openmrscustomizations.models.ModuleEncounter;
import org.openmrs.module.openmrscustomizations.models.TestEncounter;

import java.util.List;

public interface ModuleEncounterService extends OpenmrsService {
	
	ModuleEncounter saveEncounter(ModuleEncounter encounter);
	
	List<TestEncounter> getAllData();
	
}
