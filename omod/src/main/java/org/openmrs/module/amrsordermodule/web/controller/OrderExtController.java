package org.openmrs.module.amrsordermodule.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/rest/" + RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE)
public class OrderExtController extends MainResourceController {
	
	public static final String MODULE_ORDER_NAMESPACE = "/order";
	
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + "/order";
	}
}
