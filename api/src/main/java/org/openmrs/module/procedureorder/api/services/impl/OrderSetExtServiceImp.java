package org.openmrs.module.procedureorder.api.services.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.procedureorder.api.db.hibernate.HibernateOrderSetExtDao;
import org.openmrs.module.procedureorder.api.services.OrderSetExtService;
import org.openmrs.module.procedureorder.models.OrderSetExt;
import org.openmrs.module.procedureorder.models.OrderSetMemberExt;
import org.openmrs.module.procedureorder.models.SetMemberType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class OrderSetExtServiceImp extends BaseOpenmrsService implements OrderSetExtService {
	
	Log log = LogFactory.getLog(OrderSetExtServiceImp.class);
	
	public HibernateOrderSetExtDao dao;
	
	public OrderSetExtServiceImp(HibernateOrderSetExtDao dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional(readOnly = false)
	public OrderSetExt saveOrderSet(OrderSetExt orderSet) throws APIException {
		return saveOrderSetInternal(orderSet);
	}
	
	@Override
	@Transactional(readOnly = false)
	public OrderSetExt retireOrderSet(OrderSetExt orderSet, String retireReason) throws APIException {
		if (StringUtils.isBlank(retireReason)) {
			throw new IllegalArgumentException("retire reason cannot be empty or null");
		}
		for (OrderSetMemberExt orderSetMember : orderSet.getOrderSetMembers()) {
			orderSet.retireOrderSetMember(orderSetMember);
		}
		return saveOrderSetInternal(orderSet);
	}
	
	@Override
	@Transactional(readOnly = false)
	public OrderSetExt unretireOrderSet(OrderSetExt orderSet) throws APIException {
		return saveOrderSetInternal(orderSet);
	}
	
	private synchronized OrderSetExt saveOrderSetInternal(OrderSetExt orderSet) throws APIException {
		if (CollectionUtils.isEmpty(orderSet.getOrderSetMembers())) {
			return dao.save(orderSet);
		}
		
		//setting orderSet to OrderSetMember
		for (OrderSetMemberExt orderSetMember : orderSet.getOrderSetMembers()) {
			if (null == orderSetMember.getOrderSet()) {
				orderSetMember.setOrderSet(orderSet);
			}
			
			//			dao.saveOrderSetMember(orderSetMember);
		}
		
		//retiring
		for (OrderSetMemberExt orderSetMember : orderSet.getOrderSetMembers()) {
			if (orderSetMember.getRetired()) {
				orderSetMember.setRetiredBy(Context.getAuthenticatedUser());
				orderSetMember.setDateRetired(new Date());
			}
		}
		
		return dao.save(orderSet);
	}
	
	/**
	 * @see org.openmrs.api.OrderSetService#getOrderSets(boolean)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<OrderSetExt> getOrderSets(boolean includeRetired) throws APIException {
		return dao.getOrderSets(includeRetired);
	}
	
	/**
	 * @see org.openmrs.api.OrderSetService#getOrderSet(Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public OrderSetExt getOrderSet(Integer orderSetId) throws APIException {
		return dao.getOrderSetById(orderSetId);
	}
	
	/**
	 * @see org.openmrs.api.OrderSetService#getOrderSetByUuid(String)
	 */
	@Override
	@Transactional(readOnly = true)
	public OrderSetExt getOrderSetByUuid(String orderSetUuid) throws APIException {
		return dao.getOrderSetByUniqueUuid(orderSetUuid);
	}
	
	/**
	 * @see org.openmrs.api.OrderSetService#getOrderSetMemberByUuid(String)
	 */
	@Override
	@Transactional(readOnly = true)
	public OrderSetMemberExt getOrderSetMemberByUuid(String uuid) {
		return dao.getOrderSetMemberByUuid(uuid);
	}
	
	@Override
	public List<OrderSetMemberExt> getAllOrderSetMember() {
		return dao.getAllOrderMembers();
	}
	
	//setmember crud operations
	/*	@Override
		public SetMemberType getSetMemberTypeByName(String orderTypeName) throws APIException {
			return dao.getSetMemberTypeByName(orderTypeName);
		}
		
		@Override
		public SetMemberType getSetMemberType(Integer orderTypeId) throws APIException {
			return dao.getSetMemberType(orderTypeId);
		}
		
		@Override
		public SetMemberType getSetMemberTypeByUuid(String uuid) throws APIException {
			return dao.getSetMemberTypeByUuid(uuid);
		}
		
		@Override
		public List<SetMemberType> getSetMemberTypes(boolean includeRetired) throws APIException {
			return dao.getSetMemberTypes(includeRetired);
		}
		
		@Override
		public SetMemberType saveSetMemberType(SetMemberType orderType) throws APIException {
			return dao.saveSetMemberType(orderType);
		}
		
		@Override
		public void purgeSetMemberType(SetMemberType orderType) throws APIException {
			dao.purgeSetMemberType(orderType);
		}*/
}
