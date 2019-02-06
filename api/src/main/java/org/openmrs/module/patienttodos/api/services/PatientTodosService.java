package org.openmrs.module.patienttodos.api.services;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.patienttodos.models.PatientTodo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PatientTodosService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<PatientTodo> getAllTodos() throws APIException;
	
	@Transactional(readOnly = true)
	PatientTodo getPatientTodos(String patientUuid) throws APIException;
	
	@Transactional
	PatientTodo saveTodos(PatientTodo patientTodo) throws APIException;
	
	@Transactional
	void update(PatientTodo patientTodo) throws APIException;
	
	@Transactional
	void delete(PatientTodo patientTodo) throws APIException;
}
