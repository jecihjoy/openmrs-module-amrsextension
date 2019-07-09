package org.openmrs.module.amrsextension.api.db;

import org.openmrs.Patient;
import org.openmrs.module.amrsextension.models.LabOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModuleLabOrderDAO {
	
	@Transactional(readOnly = true)
	List<LabOrder> getPatientLabOrders(Patient patient);
	
}
