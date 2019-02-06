package org.openmrs.module.patienttodos.api.db;

import org.openmrs.module.patienttodos.models.PatientTodo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patienttodos.PatientTodoDao")
public interface PatientTodoDao {
	
	List<PatientTodo> getAllTodos();
	
	PatientTodo getPatientTodos(String patientUuid);
	
	PatientTodo saveTodos(PatientTodo patientTodo);
	
	void update(PatientTodo patientTodo);
	
	void delete(PatientTodo patientTodo);
}
