package org.openmrs.module.patienttodos.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.patienttodos.models.PatientTodo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernatePatientTodoDao {
	
	Log log = LogFactory.getLog(HibernatePatientTodoDao.class);
	
	@Autowired
	private DbSessionFactory sessionFactory;
	
	public DbSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<PatientTodo> getPatients() {
		List<PatientTodo> todos = new ArrayList<PatientTodo>();
		PatientTodo t1 = new PatientTodo();
		t1.setTodo_id(1);
		t1.setDescription("my todo");
		t1.setPatient_id(new Patient());
		t1.setDue_date(new Date());
		todos.add(t1);
		log.info("logging pattients");
		return todos;
	}
	
	public List<PatientTodo> getAllTodos() {
		
		log.error(sessionFactory.getCurrentSession().createCriteria(PatientTodo.class).list());
		return sessionFactory.getCurrentSession().createCriteria(PatientTodo.class).list();
	}
	
	public PatientTodo getPatientTodos(Integer id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientTodo.class);
		criteria.add(Restrictions.eq("todo_id", id));
		return (PatientTodo) criteria.uniqueResult();
	}
	
	public PatientTodo getByPatientUuid(String uuid) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientTodo.class);
		criteria.add(Restrictions.eq("patient.uuid", uuid));
		return (PatientTodo) criteria.uniqueResult();
	}
	
	public Patient getPatientByUuid(String uuid) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Patient.class);
		criteria.add(Restrictions.eq("uuid", uuid));
		return (Patient) criteria.uniqueResult();
	}
	
	public PatientTodo saveTodos(PatientTodo patientTodo) {
		sessionFactory.getCurrentSession().save(patientTodo);
		return patientTodo;
	}
	
	public void update(PatientTodo patientTodo) {
		sessionFactory.getCurrentSession().update(patientTodo);
	}
	
	public void delete(PatientTodo patientTodo) {
		sessionFactory.getCurrentSession().delete(patientTodo);
	}
}
