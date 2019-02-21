package org.openmrs.module.procedureorder.api.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.procedureorder.api.db.hibernate.HibernatePatientTodoDao;
import org.openmrs.module.procedureorder.api.services.PatientTodosService;
import org.openmrs.module.procedureorder.models.PatientTodo;

import java.util.Date;
import java.util.List;

public class PatientTodosServiceImpl extends BaseOpenmrsService implements PatientTodosService {
	
	Log log = LogFactory.getLog(PatientTodosServiceImpl.class);
	
	public HibernatePatientTodoDao dao;
	
	public PatientTodosServiceImpl(HibernatePatientTodoDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<PatientTodo> getAllTodos() throws APIException {
		return dao.getAllTodos();
	}
	
	@Override
	public PatientTodo saveOrUpdate(PatientTodo patientTodo) throws APIException {
		if (patientTodo.getPatient_id() == null) {
			log.info(("patient info is null"));
			patientTodo.setPatient_id(Context.getService(PatientService.class).getPatient(7));
		}
		dao.saveOrUpdate(patientTodo);
		return patientTodo;
	}
	
	@Override
	public PatientTodo getByTodoUuid(String uuid) throws APIException {
		return dao.getByTodoUuid(uuid);
	}
	
	@Override
	public void voidTodos(PatientTodo patientTodo, String voidReason) throws APIException {
		patientTodo.setVoided(true);
		patientTodo.setVoidedBy(Context.getAuthenticatedUser());
		patientTodo.setVoidReason(voidReason);
		patientTodo.setDateVoided(new Date());
		dao.saveOrUpdate(patientTodo);
	}
	
	@Override
	public PatientTodo getByPatientUuid(String patientUuid) throws APIException {
		return dao.getByPatientUuid(patientUuid);
	}
	
	@Override
	public PatientTodo update(PatientTodo patientTodo) throws APIException {
		log.info(patientTodo);
		return dao.update(patientTodo);
	}
	
	@Override
	public void delete(PatientTodo patientTodo) throws APIException {
		dao.delete(patientTodo);
	}
	
}
