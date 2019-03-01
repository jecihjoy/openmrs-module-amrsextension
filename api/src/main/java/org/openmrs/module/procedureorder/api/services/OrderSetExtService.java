package org.openmrs.module.procedureorder.api.services;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.procedureorder.models.OrderSetExt;
import org.openmrs.module.procedureorder.models.OrderSetMemberExt;
import org.openmrs.module.procedureorder.models.SetMemberType;
import org.openmrs.util.PrivilegeConstants;

import java.util.List;

public interface OrderSetExtService extends OpenmrsService {
	
	/**
	 * Save or update the given <code>orderSet</code> in the database. If the OrderSet is retired it
	 * will set retired by and retired date. If OrderSetMembers are retired, it will set retired by
	 * and retired date.
	 * 
	 * @param orderSet the OrderSet to save
	 * @return the OrderSet that was saved
	 * @throws APIException
	 */
	@Authorized({ PrivilegeConstants.MANAGE_ORDER_SETS })
	OrderSetExt saveOrderSet(OrderSetExt orderSet) throws APIException;
	
	/**
	 * Gets all OrderSets that match the specified parameters excluding discontinuation orderSets.
	 * 
	 * @param includeRetired Specifies whether retired orders should be included or not
	 * @return list of OrderSets matching the parameters
	 * @throws APIException
	 */
	@Authorized(PrivilegeConstants.GET_ORDER_SETS)
	List<OrderSetExt> getOrderSets(boolean includeRetired) throws APIException;
	
	/**
	 * Gets a specific OrderSet with the matched orderSet Id.
	 * 
	 * @param orderSetId Specifies a saved orderSet id.
	 * @return OrderSet
	 * @throws APIException
	 */
	@Authorized(PrivilegeConstants.GET_ORDER_SETS)
	OrderSetExt getOrderSet(Integer orderSetId) throws APIException;
	
	/**
	 * Gets a specific OrderSet with the matched orderSet uuid.
	 * 
	 * @param orderSetUuid Specifies a saved orderSet uuid.
	 * @return an orderSet
	 * @throws APIException
	 */
	@Authorized(PrivilegeConstants.GET_ORDER_SETS)
	OrderSetExt getOrderSetByUuid(String orderSetUuid) throws APIException;
	
	/**
	 * Retires and OrderSet, with matched OrderSet
	 * 
	 * @param orderSet Specifies the OrderSet to be retired
	 * @param retireReason Specifies the reason why the OrderSet has to be retired
	 * @return an orderSet
	 * @throws APIException
	 */
	@Authorized({ PrivilegeConstants.MANAGE_ORDER_SETS })
	OrderSetExt retireOrderSet(OrderSetExt orderSet, String retireReason) throws APIException;
	
	/**
	 * UnRetires and OrderSet, with matched OrderSet
	 * 
	 * @param orderSet Specifies the OrderSet to be retired
	 * @return an orderSet
	 * @throws APIException
	 */
	@Authorized({ PrivilegeConstants.MANAGE_ORDER_SETS })
	OrderSetExt unretireOrderSet(OrderSetExt orderSet) throws APIException;
	
	/**
	 * Get OrderSetMember by uuid
	 * 
	 * @param uuid
	 * @return
	 * @should find object given valid uuid
	 * @should return null if no object found with given uuid
	 */
	@Authorized(PrivilegeConstants.GET_ORDER_SETS)
	OrderSetMemberExt getOrderSetMemberByUuid(String uuid);
	
	@Authorized(PrivilegeConstants.GET_ORDER_SETS)
	List<OrderSetMemberExt> getAllOrderSetMember();
	
	/*	public SetMemberType getSetMemberTypeByName(String orderTypeName) throws APIException;
		
		public SetMemberType getSetMemberType(Integer orderTypeId) throws APIException;
		
		public SetMemberType getSetMemberTypeByUuid(String uuid) throws APIException;
		
		public List<SetMemberType> getSetMemberTypes(boolean includeRetired) throws APIException;
		
		public SetMemberType saveSetMemberType(SetMemberType orderType) throws APIException;
		
		public void purgeSetMemberType(SetMemberType orderType) throws APIException;*/
}
