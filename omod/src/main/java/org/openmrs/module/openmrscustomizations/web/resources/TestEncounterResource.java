package org.openmrs.module.openmrscustomizations.web.resources;

import org.openmrs.api.context.Context;
import org.openmrs.module.openmrscustomizations.api.ModuleEncounterService;
import org.openmrs.module.openmrscustomizations.models.TestEncounter;
import org.openmrs.module.openmrscustomizations.web.controller.OpenmrsCustomizationsController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + OpenmrsCustomizationsController.OPENMRS_CUSTOMIZATIONS_REST_NAMESPACE
        + "/testencounter", supportedClass = TestEncounter.class, supportedOpenmrsVersions = { "1.9.*", "1.10.*", "1.11.*",
        "1.12.*", "2.0.*", "2.1.*", "2.2.*" })
public class TestEncounterResource extends DataDelegatingCrudResource<TestEncounter> {
	
	@Override
	public TestEncounter getByUniqueId(String s) {
		return null;
	}
	
	@Override
	protected void delete(TestEncounter testEncounter, String s, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public TestEncounter newDelegate() {
		return new TestEncounter();
	}
	
	@Override
	public TestEncounter save(TestEncounter testEncounter) {
		return null;
	}
	
	@Override
	public void purge(TestEncounter testEncounter, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("name");
			description.addProperty("age");
			description.addProperty("appointment");
			description.addProperty("display", findMethod("getDisplayString"));
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("name");
			description.addProperty("age");
			description.addProperty("appointment");
			description.addProperty("display", findMethod("getDisplayString"));
			description.addSelfLink();
			return description;
		}
		return null;
	}
	
	@Override
	protected NeedsPaging<TestEncounter> doGetAll(RequestContext context) {
		return new NeedsPaging<TestEncounter>(Context.getService(ModuleEncounterService.class).getAllData(), context);
	}
	
	public String getDisplayString(TestEncounter encounter) {
		return "its 4:50 am ";
	}
}
