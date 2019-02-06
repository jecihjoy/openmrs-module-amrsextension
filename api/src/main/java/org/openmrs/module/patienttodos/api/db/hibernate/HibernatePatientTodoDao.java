package org.openmrs.module.patienttodos.api.db.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.patienttodos.api.db.PatientTodoDao;
import org.openmrs.module.patienttodos.models.PatientTodo;

import java.util.List;

public class HibernatePatientTodoDao implements PatientTodoDao {
	
	private DbSessionFactory sessionFactory;
	
	public DbSession getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<PatientTodo> getAllTodos() {
		return getSessionFactory().createCriteria(PatientTodo.class).list();
	}
	
	@Override
	public PatientTodo getPatientTodos(String patientUuid) {
		Criteria criteria = getSessionFactory().createCriteria(PatientTodo.class);
		criteria.add(Restrictions.eq("patient_id", patientUuid));
		return (PatientTodo) criteria.uniqueResult();
	}
	
	@Override
	public PatientTodo saveTodos(PatientTodo patientTodo) {
		getSessionFactory().save(patientTodo);
		return patientTodo;
	}
	
	@Override
	public void update(PatientTodo patientTodo) {
		getSessionFactory().update(patientTodo);
	}
	
	@Override
	public void delete(PatientTodo patientTodo) {
		getSessionFactory().delete(patientTodo);
	}
}
