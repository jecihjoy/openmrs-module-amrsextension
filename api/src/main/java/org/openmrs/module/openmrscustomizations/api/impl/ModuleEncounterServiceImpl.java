package org.openmrs.module.openmrscustomizations.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.openmrscustomizations.api.ModuleEncounterService;
import org.openmrs.module.openmrscustomizations.models.ModuleEncounter;
import org.openmrs.module.openmrscustomizations.models.TestEncounter;

import java.util.ArrayList;
import java.util.List;

public class ModuleEncounterServiceImpl extends BaseOpenmrsService implements ModuleEncounterService {
	
	@Override
	public ModuleEncounter saveEncounter(ModuleEncounter encounter) {
		return null;
	}
	
	@Override
    public List<TestEncounter> getAllData() {

        List<TestEncounter> list = new ArrayList<>();

        TestEncounter encounter = new TestEncounter("jecihjoy", 23, new Appointment());
        TestEncounter encounter1 = new TestEncounter("jecihjoy", 23, new Appointment());
//        TestEncounter encounter2 = new TestEncounter("jecihjoy", 23);
//        TestEncounter encounter3 = new TestEncounter("jecihjoy", 23);

        list.add(encounter);
        list.add(encounter1);
        return list;
    }
}
