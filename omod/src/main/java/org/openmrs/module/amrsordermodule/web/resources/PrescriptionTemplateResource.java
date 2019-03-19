package org.openmrs.module.amrsordermodule.web.resources;

import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.api.services.PrescriptionTemplateService;
import org.openmrs.module.amrsordermodule.models.PrescriptionTemplate;
import org.openmrs.module.amrsordermodule.web.controller.OrderExtController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE + "/ordertemplates", supportedClass = PrescriptionTemplate.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.2.*, 2.4.*, 2.8.*" })
public class PrescriptionTemplateResource extends MetadataDelegatingCrudResource<PrescriptionTemplate> {
	
	@Override
	public PrescriptionTemplate getByUniqueId(String uniqueId) {
		
		return Context.getService(PrescriptionTemplateService.class).getByUuuid(uniqueId);
	}
	
	@Override
	public PrescriptionTemplate newDelegate() {
		return null;
	}
	
	@Override
	public PrescriptionTemplate save(PrescriptionTemplate delegate) {
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		return getCreatableProperties();
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("uuid");
		description.addProperty("name");
		description.addProperty("description");
		description.addProperty("concept", Representation.REF);
		description.addProperty("orderTemplate");
		description.addProperty("orderTemplateType");
		description.addProperty("type");
		description.addProperty("version");
		description.addProperty("published");
		description.addProperty("retired");
		return description;
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("name");
			description.addProperty("description");
			description.addProperty("concept", Representation.REF);
			description.addProperty("orderTemplate");
			description.addProperty("orderTemplateType");
			description.addProperty("type");
			description.addProperty("version");
			description.addProperty("published");
			description.addProperty("retired");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("name");
			description.addProperty("description");
			description.addProperty("concept");
			description.addProperty("orderTemplate");
			description.addProperty("orderTemplateType");
			description.addProperty("type");
			description.addProperty("version");
			description.addProperty("published");
			description.addProperty("retired");
			description.addSelfLink();
			return description;
		} else {
			return null;
		}
	}
	
	@Override
	public void purge(PrescriptionTemplate delegate, RequestContext context) throws ResponseException {
		
	}
}
