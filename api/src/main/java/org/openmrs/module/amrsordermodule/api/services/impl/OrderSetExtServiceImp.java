package org.openmrs.module.amrsordermodule.api.services.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.api.OrderEntryException;
import org.openmrs.api.UnchangeableObjectException;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.amrsordermodule.api.db.hibernate.HibernateOrderSetExtDao;
import org.openmrs.module.amrsordermodule.api.services.OrderSetExtService;
import org.openmrs.module.amrsordermodule.models.*;
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
		failOnExistingOrder(orderSet);
		ensureSetMemberTypeIsSet(orderSet);
		failOnOrderTypeMismatch(orderSet);
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
	
	private void failOnExistingOrder(OrderSetExt setExt) {
		if (setExt.getId() != null) {
			throw new UnchangeableObjectException("OrderSet.cannot.edit.existing");
		}
	}
	
	private void failOnOrderTypeMismatch(OrderSetExt setExt) {
		for (OrderSetMemberExt memberExt : setExt.getOrderSetMembers()) {
			log.error("CLASS NAME" + memberExt.getSetMemberType());
			log.error("CLASS NAME" + memberExt.getSetMemberType());
			log.error("CLASS NAME" + memberExt.getSetMemberType());
			log.error("CLASS NAME" + memberExt.getSetMemberType());
			log.error("CLASS NAME" + memberExt.getSetMemberType());
			if (!memberExt.getSetMemberType().getJavaClass().isAssignableFrom(memberExt.getClass())) {
				throw new OrderEntryException("Order.type.class.does.not.match", new Object[] {
				        memberExt.getSetMemberType().getJavaClass(), memberExt.getClass().getName() });
			}
		}
	}
	
	private void ensureSetMemberTypeIsSet(OrderSetExt setExt) {
		log.error("ORDER INSTANCE OF DRUG ORDER here");
		log.error("ORDER INSTANCE OF DRUG ORDER " + setExt.getOrderSetMembers().toString());
		for (OrderSetMemberExt memberExt : setExt.getOrderSetMembers()) {
			if (memberExt.getSetMemberType() != null) {
				return;
			}
			SetMemberType memberType = null;
			memberType = Context.getService(OrderSetExtService.class).getSetMemberTypeByUuid(
			    "0020b143-397b-11e9-be9d-d47df659d900");
			//			if (memberType == null && memberExt instanceof DrugSetMember) {
			//				memberType = Context.getService(OrderSetExtService.class).getSetMemberTypeByUuid(
			//				    "0020b143-397b-11e9-be9d-d47df659d900");
			//			}
			
			//				if (memberType == null && memberExt instanceof ProcedureSetMember) {
			//					memberType = Context.getService(OrderSetExtService.class).getSetMemberTypeByUuid("");
			//				}
			//
			if (memberType == null) {
				log.error("ORDER NOt INSTANCE OF DRUG ORDER");
				log.error("ORDER INSTANCE OF DRUG ORDER");
				log.error("ORDER INSTANCE OF DRUG ORDER");
				log.error("ORDER INSTANCE OF DRUG ORDER");
				throw new OrderEntryException("SetMember.type.cannot.determine");
			}
			memberExt.setSetMemberType(memberType);
			log.error("SETTING SET MEMBER" + memberType.toString());
			log.error("SETTING SET MEMBER" + memberType.toString());
			log.error("SETTING SET MEMBER" + memberType.toString());
			
		}
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
	@Override
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
	}
}
