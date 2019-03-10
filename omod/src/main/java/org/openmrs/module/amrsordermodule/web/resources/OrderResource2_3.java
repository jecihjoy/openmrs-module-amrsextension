package org.openmrs.module.amrsordermodule.web.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Order;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs2_2.OrderResource2_2;

@Resource(name = RestConstants.VERSION_1 + "/order", supportedClass = Order.class, supportedOpenmrsVersions = { "2.2.*" })
public class OrderResource2_3 extends OrderResource2_2 {
	
	Log log = LogFactory.getLog(OrderResource2_3.class);
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		return super.getCreatableProperties();
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		return super.getRepresentationDescription(rep);
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		return super.getUpdatableProperties();
	}
	
	@Override
	protected PageableResult doSearch(RequestContext context) {
		return super.doSearch(context);
	}
	
	@Override
	public Order save(Order delegate) {
		log.error("SAVING ORDER 2.3");
		log.error("SAVING ORDER 2.3");
		log.error("SAVING ORDER 2.3");
		log.error("SAVING ORDER 2.3");
		log.error("SAVING ORDER 2.3");
		log.error("SAVING ORDER 2.3");
		return super.save(delegate);
	}
}
