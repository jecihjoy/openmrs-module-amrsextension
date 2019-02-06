package org.openmrs.module.patienttodos.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/rest/" + RestConstants.VERSION_1 + PatienttodosController.PATIENT_TODOS_NAMESPACE)
public class PatienttodosController extends MainResourceController {
	
	public static final String PATIENT_TODOS_NAMESPACE = "/patienttodos";
	
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + "/patienttodos";
	}
}
