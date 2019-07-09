package org.openmrs.module.amrsextension.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.amrsextension.api.ModulePatientDataService;
import org.openmrs.module.amrsextension.api.db.ModuleLabOrderDAO;
import org.openmrs.module.amrsextension.models.LabOrder;

import java.util.List;

public class ModulePatientDataServiceImpl extends BaseOpenmrsService implements ModulePatientDataService {
	
	private ModuleLabOrderDAO labOrderDAO;
	
	public ModuleLabOrderDAO getLabOrderDAO() {
		return labOrderDAO;
	}
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	public void setLabOrderDAO(ModuleLabOrderDAO labOrderDAO) {
		this.labOrderDAO = labOrderDAO;
	}
	
	@Override
	public List<LabOrder> getPatientLabOrders(Patient patient) {
		return labOrderDAO.getPatientLabOrders(patient);
	}
}
