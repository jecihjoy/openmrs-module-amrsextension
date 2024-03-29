package org.openmrs.module.amrsextension.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + AmrsExtensionController.AMRS_EXTENSION_REST_NAMESPACE)
public class AmrsExtensionController extends MainResourceController {
	
	public static final String AMRS_EXTENSION_REST_NAMESPACE = "/amrsextension";
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + AmrsExtensionController.AMRS_EXTENSION_REST_NAMESPACE;
	}
}
