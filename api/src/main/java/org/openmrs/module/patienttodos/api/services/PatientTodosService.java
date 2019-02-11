package org.openmrs.module.patienttodos.api.services;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.patienttodos.models.PatientTodo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientTodosService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	@Authorized
	List<PatientTodo> getAllTodos() throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized
	PatientTodo getPatientTodos(Integer patientUuid) throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized
	PatientTodo getByPatientUuid(String patientUuid) throws APIException;
	
	@Transactional
	@Authorized
	PatientTodo saveTodos(PatientTodo patientTodo) throws APIException;
	
	@Transactional
	@Authorized
	void update(PatientTodo patientTodo) throws APIException;
	
	@Transactional
	@Authorized
	void delete(PatientTodo patientTodo) throws APIException;
}
