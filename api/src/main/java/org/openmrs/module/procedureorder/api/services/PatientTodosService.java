package org.openmrs.module.procedureorder.api.services;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.procedureorder.models.PatientTodo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientTodosService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	@Authorized
	List<PatientTodo> getAllTodos() throws APIException;
	
	@Transactional
	@Authorized
	PatientTodo getByTodoUuid(String uuid) throws APIException;
	
	@Transactional
	@Authorized
	PatientTodo saveOrUpdate(PatientTodo patientTodo) throws APIException;
	
	@Authorized("Delete todos privelege")
	@Transactional
	void voidTodos(PatientTodo patientTodo, String voidReason) throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized
	PatientTodo getByPatientUuid(String patientUuid) throws APIException;
	
	@Transactional
	@Authorized
	PatientTodo update(PatientTodo patientTodo) throws APIException;
	
	@Transactional
	@Authorized
	void delete(PatientTodo patientTodo) throws APIException;
	
}
