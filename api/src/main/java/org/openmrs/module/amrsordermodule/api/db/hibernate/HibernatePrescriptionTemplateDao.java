package org.openmrs.module.amrsordermodule.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Concept;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.amrsordermodule.models.PrescriptionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePrescriptionTemplateDao {
	
	Log log = LogFactory.getLog(HibernatePrescriptionTemplateDao.class);
	
	@Autowired
	private DbSessionFactory sessionFactory;
	
	public DbSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Authorized
	PrescriptionTemplate saveTemplate(PrescriptionTemplate template) throws DAOException {
		sessionFactory.getCurrentSession().saveOrUpdate(template);
		return template;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate getByUuuid(String uuid) throws DAOException {
		return (PrescriptionTemplate) sessionFactory.getCurrentSession()
		        .createQuery("from PrescriptionTemplate pt where pt.uuid = :uuid").setString("uuid", uuid).uniqueResult();
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate getAllTemplates(boolean retired) throws DAOException {
		return null;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate getSetMemberTemplate(Concept concept, String dosageForm, boolean includeRetired)
	        throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrescriptionTemplate.class);
		if (dosageForm == null) {
			criteria.add(Restrictions.eq("concept_id", concept));
			criteria.add(Restrictions.eq("retired", includeRetired));
			return (PrescriptionTemplate) criteria.uniqueResult();
		} else if (dosageForm != null) {
			criteria.add(Restrictions.eq("concept_id", concept));
			criteria.add(Restrictions.eq("type", dosageForm));
			return (PrescriptionTemplate) criteria.add(Restrictions.eq("retired", includeRetired));
		}
		return null;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate getTemplateByName(String name) throws DAOException {
		return null;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate getTemplateByName(String name, String version) throws DAOException {
		return null;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate retireTemplate(PrescriptionTemplate template, String retireReason) throws DAOException {
		return null;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate unretireOrderSet(PrescriptionTemplate template) throws DAOException {
		return null;
	}
	
	@Transactional
	@Authorized
	public PrescriptionTemplate delete(PrescriptionTemplate template) throws DAOException {
		return null;
	}
	
}
