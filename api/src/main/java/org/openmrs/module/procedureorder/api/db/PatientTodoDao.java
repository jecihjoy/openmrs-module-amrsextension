package org.openmrs.module.procedureorder.api.db;

import org.openmrs.module.procedureorder.models.PatientTodo;

import java.util.List;

public interface PatientTodoDao {
	
	List<PatientTodo> getAllTodos();
	
	PatientTodo getPatientTodos(String patientUuid);
	
	PatientTodo saveTodos(PatientTodo patientTodo);
	
	void update(PatientTodo patientTodo);
	
	void delete(PatientTodo patientTodo);
}
