/*
package org.openmrs.module.amrsordermodule.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.amrsordermodule.models.OrderSetMemberExt;
import org.openmrs.module.amrsordermodule.models.SetMemberType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateOrderSetExtDao {
	
	Log log = LogFactory.getLog(HibernateOrderSetExtDao.class);
	
	@Autowired
	private DbSessionFactory sessionFactory;
	
	public DbSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public OrderSetExt save(OrderSetExt orderSet) throws DAOException {
		DbSession session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orderSet);
		return orderSet;
	}
	
	public void saveOrderSetMember(OrderSetMemberExt setMemberExt) {
		DbSession session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(setMemberExt);
	}
	
	public List<OrderSetMemberExt> getAllOrderMembers() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(OrderSetExt.class, "orderSetMemberExt");
		
		return crit.list();
	}
	
	public List<OrderSetExt> getOrderSets(boolean includeRetired) throws DAOException {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(OrderSetExt.class, "orderSetExt");
		
		if (!includeRetired) {
			crit.add(Restrictions.eq("voided", Boolean.FALSE));
		}
		return crit.list();
	}
	
	public OrderSetExt getOrderSetById(Integer orderSetId) throws DAOException {
		return (OrderSetExt) sessionFactory.getCurrentSession().get(OrderSetExt.class, orderSetId);
	}
	
	public OrderSetExt getOrderSetByUniqueUuid(String orderSetUuid) throws DAOException {
		return (OrderSetExt) sessionFactory.getCurrentSession().createQuery("from OrderSetExt o where o.uuid = :uuid")
		        .setString("uuid", orderSetUuid).uniqueResult();
	}
	
	public OrderSetMemberExt getOrderSetMemberByUuid(String uuid) throws DAOException {
		return (OrderSetMemberExt) sessionFactory.getCurrentSession()
		        .createQuery("from OrderSetMemberExt osm where osm.uuid = :uuid").setString("uuid", uuid).uniqueResult();
	}
	
	public SetMemberType getSetMemberTypeByName(String orderTypeName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SetMemberType.class);
		criteria.add(Restrictions.eq("name", orderTypeName));
		return (SetMemberType) criteria.uniqueResult();
	}
	
	public SetMemberType getSetMemberType(Integer orderTypeId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SetMemberType.class);
		criteria.add(Restrictions.eq("setMemberTypeId", orderTypeId));
		return (SetMemberType) criteria.uniqueResult();
	}
	
	public SetMemberType getSetMemberTypeByUuid(String uuid) {
		return (SetMemberType) sessionFactory.getCurrentSession().createQuery("from SetMemberType o where o.uuid = :uuid")
		        .setString("uuid", uuid).uniqueResult();
	}
	
	public List<SetMemberType> getSetMemberTypes(boolean includeRetired) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(SetMemberType.class);
		if (!includeRetired) {
			c.add(Restrictions.eq("voided", false));
		}
		return c.list();
	}
	
	public SetMemberType saveSetMemberType(SetMemberType orderType) {
		log.error("SAVING SET MEMBER TYPE" + orderType.toString());
		sessionFactory.getCurrentSession().saveOrUpdate(orderType);
		return orderType;
	}
	
	public void purgeSetMemberType(SetMemberType orderType) {
		sessionFactory.getCurrentSession().delete(orderType);
	}
}
*/
