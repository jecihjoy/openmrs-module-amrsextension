/*
package org.openmrs.module.amrsordermodule.web.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.DrugOrder;
import org.openmrs.Order;
import org.openmrs.OrderType;
import org.openmrs.TestOrder;
import org.openmrs.api.OrderContext;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.web.controller.OrderExtController;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_10.OrderResource1_10;

@Resource(name = RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE + "/order", supportedClass = Order.class, supportedOpenmrsVersions = {
        "2.0.*", "2.1.*", "2.2.*", "2.4.*", "2.8.*" })
public class OrderResource2_3 extends OrderResource1_10 {
	
	Log log = LogFactory.getLog(OrderResource2_3.class);
	
	@Override
	public Order save(Order delegate) {
		return Context.getOrderService().saveOrder(delegate, setOrderContext(delegate));
	}
	
	private OrderContext setOrderContext(Order order) {
		log.error("SAVING CALLED");
		log.error("SAVING CALLED");
		log.error("SAVING CALLED");
		log.error("SAVING CALLED");
		OrderContext orderContext = new OrderContext();
		
		OrderType orderType = null;
		
		if (orderType == null) {
			orderType = Context.getOrderService().getOrderTypeByConcept(order.getConcept());
		}
		if (orderType == null && order instanceof DrugOrder) {
			orderType = Context.getOrderService().getOrderTypeByUuid(OrderType.DRUG_ORDER_TYPE_UUID);
			
		} else if (orderType == null && order instanceof TestOrder) {
			orderType = Context.getOrderService().getOrderTypeByUuid(OrderType.TEST_ORDER_TYPE_UUID);
			
			////this is for checking if the order is an instance of procedure order
		} else {//if (orderType == null && order instanceof ProcedureOrder) {
			orderType = Context.getOrderService().getOrderTypeByUuid("4237a01f-29c5-4167-9d8e-96d6e590aa33");
		}
		
		orderContext.setCareSetting(null);
		orderContext.setOrderType(orderType);
		return orderContext;
	}
}
*/
