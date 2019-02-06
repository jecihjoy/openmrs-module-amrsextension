package org.openmrs.module.patienttodos.api.services.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.patienttodos.api.db.PatientTodoDao;
import org.openmrs.module.patienttodos.api.services.PatientTodosService;
import org.openmrs.module.patienttodos.models.PatientTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class PatientTodosServiceImpl extends BaseOpenmrsService implements PatientTodosService {
	
	public PatientTodoDao dao;
	
	public PatientTodoDao getDao() {
		return dao;
	}
	
	public void setDao(PatientTodoDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<PatientTodo> getAllTodos() throws APIException {
		return dao.getAllTodos();
	}
	
	@Override
	public PatientTodo getPatientTodos(String patientUuid) throws APIException {
		return dao.getPatientTodos(patientUuid);
	}
	
	@Override
	public PatientTodo saveTodos(PatientTodo patientTodo) throws APIException {
		return dao.saveTodos(patientTodo);
	}
	
	@Override
	public void update(PatientTodo patientTodo) throws APIException {
		dao.update(patientTodo);
	}
	
	@Override
	public void delete(PatientTodo patientTodo) throws APIException {
		dao.delete(patientTodo);
	}
}
