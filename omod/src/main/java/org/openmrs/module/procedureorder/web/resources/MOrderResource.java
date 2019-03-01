package org.openmrs.module.procedureorder.web.resources;

import org.openmrs.Order;
import org.openmrs.api.OrderContext;
import org.openmrs.api.OrderService;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_10.OrderResource1_10;

@Resource(name = RestConstants.VERSION_1 + "/morder", supportedClass = Order.class, supportedOpenmrsVersions = { "1.10.*",
        "1.11.*", "1.12.*", "2.0.*", "2.1.*" })
public class MOrderResource extends OrderResource1_10 {
	
	@Override
	public Order save(Order order) {
		if (order.getOrderType().equals(
		    Context.getService(OrderService.class).getOrderTypeByUuid("4237a01f-29c5-4167-9d8e-96d6e590aa33"))) {
			OrderContext context = new OrderContext();
			context.setOrderType(order.getOrderType());
			return Context.getOrderService().saveOrder(order, context);
		}
		return Context.getOrderService().saveOrder(order, (OrderContext) null);
	}
}
