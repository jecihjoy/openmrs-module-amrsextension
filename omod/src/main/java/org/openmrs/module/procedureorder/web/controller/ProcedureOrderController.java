package org.openmrs.module.procedureorder.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/rest/" + RestConstants.VERSION_1 + ProcedureOrderController.PROCEDURE_ORDER_NAMESPACE)
public class ProcedureOrderController extends MainResourceController {
	
	public static final String PROCEDURE_ORDER_NAMESPACE = "/procedureorder";
	
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + "/procedureorder";
	}
}
//kc143house
