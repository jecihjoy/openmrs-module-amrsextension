package org.openmrs.module.procedureorder.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.procedureorder.models.PatientTodo;
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
	
	public List<PatientTodo> getValues() {
		List<PatientTodo> todos = new ArrayList<PatientTodo>();
		PatientTodo t1 = new PatientTodo();
		t1.setTodoId(1);
		t1.setDescription("my todo");
		t1.setPatient_id(new Patient());
		t1.setDueDate(new Date());
		todos.add(t1);
		log.info("logging pattients");
		return todos;
	}
	
	public List<PatientTodo> getAllTodos() {
		
		log.error(sessionFactory.getCurrentSession().createCriteria(PatientTodo.class).list());
		return sessionFactory.getCurrentSession().createCriteria(PatientTodo.class).list();
	}
	
	public PatientTodo getByTodoUuid(String uuid) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientTodo.class);
		criteria.add(Restrictions.eq("uuid", uuid));
		return (PatientTodo) criteria.uniqueResult();
	}
	
	//save, update, delete
	public PatientTodo saveOrUpdate(PatientTodo patientTodo) {
		sessionFactory.getCurrentSession().saveOrUpdate(patientTodo);
		return patientTodo;
	}
	
	public PatientTodo getByPatientUuid(String uuid) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientTodo.class);
		criteria.add(Restrictions.eq("patient.uuid", uuid));
		return (PatientTodo) criteria.uniqueResult();
	}
	
	public PatientTodo update(PatientTodo patientTodo) {
		sessionFactory.getCurrentSession().update(patientTodo);
		return patientTodo;
	}
	
	public void delete(PatientTodo patientTodo) {
		sessionFactory.getCurrentSession().delete(patientTodo);
	}
}
