package org.openmrs.module.amrsordermodule.web.resources;

import org.openmrs.Order;
import org.openmrs.OrderType;
import org.openmrs.api.OrderContext;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.web.controller.OrderExtController;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_10.*;

@Resource(name = RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE + "/morder", supportedClass = Order.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*,2.2.*, 2.4.*, 2.8.*" })
public class MOrderResource extends OrderResource1_10 {
	
	@Override
	public Order save(Order order) {
		OrderType procedureOrder = Context.getOrderService().getOrderTypeByUuid("4237a01f-29c5-4167-9d8e-96d6e590aa33");
		if (order.getOrderType() != null) {
			if (order.getOrderType().equals(procedureOrder)) {
				OrderContext context = new OrderContext();
				context.setOrderType(procedureOrder);
				return Context.getOrderService().saveOrder(order, context);
			} else {
				return Context.getOrderService().saveOrder(order, null);
			}
			
		} else {
			log.error("	ORDERTYPE IS NULL");
		}
		return null;
	}
	
}
