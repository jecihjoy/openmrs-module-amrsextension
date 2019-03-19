package org.openmrs.module.amrsordermodule.api.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.amrsordermodule.api.db.hibernate.HibernatePrescriptionTemplateDao;
import org.openmrs.module.amrsordermodule.api.services.PrescriptionTemplateService;
import org.openmrs.module.amrsordermodule.models.PrescriptionTemplate;

public class PrescriptionTemplateServiceImpl extends BaseOpenmrsService implements PrescriptionTemplateService {
	
	Log log = LogFactory.getLog(PrescriptionTemplateServiceImpl.class);
	
	public HibernatePrescriptionTemplateDao dao;
	
	public PrescriptionTemplateServiceImpl(HibernatePrescriptionTemplateDao dao) {
		this.dao = dao;
	}
	
	@Override
	public PrescriptionTemplate saveTemplate(PrescriptionTemplate template) throws APIException {
		return null;
	}
	
	@Override
	public PrescriptionTemplate getByUuuid(String uuid) throws APIException {
		return dao.getByUuuid(uuid);
	}
	
	@Override
	public PrescriptionTemplate getAllTemplates(boolean retired) throws APIException {
		return null;
	}
	
	@Override
	public PrescriptionTemplate getSetMemberTemplate(Concept concept, String dosageForm, boolean includRetired)
	        throws APIException {
		return dao.getSetMemberTemplate(concept, dosageForm, false);
	}
	
	@Override
	public PrescriptionTemplate getTemplateByName(String name) throws APIException {
		return null;
	}
	
	@Override
	public PrescriptionTemplate getTemplateByName(String name, String version) throws APIException {
		return null;
	}
	
	@Override
	public PrescriptionTemplate retireTemplate(PrescriptionTemplate template, String retireReason) throws APIException {
		return null;
	}
	
	@Override
	public PrescriptionTemplate unretireOrderSet(PrescriptionTemplate template) throws APIException {
		return null;
	}
	
	@Override
	public PrescriptionTemplate delete(PrescriptionTemplate template) throws APIException {
		return null;
	}
}
