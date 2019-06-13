package org.openmrs.module.openmrscustomizations.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + OpenmrsCustomizationsController.OPENMRS_CUSTOMIZATIONS_REST_NAMESPACE)
public class OpenmrsCustomizationsController extends MainResourceController {
	
	public static final String OPENMRS_CUSTOMIZATIONS_REST_NAMESPACE = "/openmrscustomizations";
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + OpenmrsCustomizationsController.OPENMRS_CUSTOMIZATIONS_REST_NAMESPACE;
	}
}
