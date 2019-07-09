package org.openmrs.module.amrsextension.api;

import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.module.amrsextension.models.LabOrder;

import java.util.List;

public interface ModulePatientDataService {
	
	@Authorized
	List<LabOrder> getPatientLabOrders(Patient patient);
	
}
