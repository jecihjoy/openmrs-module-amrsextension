package org.openmrs.module.amrsordermodule.api.services;

import org.openmrs.Concept;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.amrsordermodule.models.PrescriptionTemplate;
import org.springframework.transaction.annotation.Transactional;

public interface PrescriptionTemplateService extends OpenmrsService {
	
	@Transactional
	@Authorized
	PrescriptionTemplate saveTemplate(PrescriptionTemplate template) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate getByUuuid(String uuid) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate getAllTemplates(boolean retired) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate getSetMemberTemplate(Concept concept, String dosageForm, boolean includRetired) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate getTemplateByName(String name) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate getTemplateByName(String name, String version) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate retireTemplate(PrescriptionTemplate template, String retireReason) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate unretireOrderSet(PrescriptionTemplate template) throws APIException;
	
	@Transactional
	@Authorized
	PrescriptionTemplate delete(PrescriptionTemplate template) throws APIException;
	
}
