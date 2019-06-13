package org.openmrs.module.openmrscustomizations.web.resources;

import org.openmrs.Encounter;
import org.openmrs.api.context.Context;
import org.openmrs.module.openmrscustomizations.api.ModuleEncounterService;
import org.openmrs.module.openmrscustomizations.models.ModuleEncounter;
import org.openmrs.module.openmrscustomizations.web.controller.OpenmrsCustomizationsController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + OpenmrsCustomizationsController.OPENMRS_CUSTOMIZATIONS_REST_NAMESPACE
        + "/moduleencounter", supportedClass = ModuleEncounter.class, supportedOpenmrsVersions = { "1.9.*", "1.10.*",
        "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*" })
public class ModuleEncounterResource extends DataDelegatingCrudResource<ModuleEncounter> {
	
	@Override
	public ModuleEncounter getByUniqueId(String s) {
		return null;
	}
	
	@Override
	protected void delete(ModuleEncounter encounter, String s, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public ModuleEncounter newDelegate() {
		return new ModuleEncounter();
	}
	
	@Override
	public ModuleEncounter save(ModuleEncounter encounter) {
		log.error("reached here " + encounter);
		return Context.getService(ModuleEncounterService.class).saveEncounter(encounter);
	}
	
	@Override
	public void purge(ModuleEncounter encounter, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("encounter.display");
			description.addProperty("encounter.patient", Representation.REF);
			description.addProperty("encounter.location", Representation.REF);
			description.addProperty("encounter.provider", Representation.REF);
			//			description.addProperty("appointment.status");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("encounter.display");
			description.addProperty("encounter.patient", Representation.REF);
			description.addProperty("encounter.location", Representation.REF);
			description.addProperty("encounter.provider", Representation.REF);
			//			description.addProperty("appointment.status");
			description.addSelfLink();
			return description;
		}
		
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("encounter.patient", Representation.REF);
		description.addProperty("encounter.location", Representation.REF);
		description.addProperty("encounter.provider", Representation.REF);
		//		description.addProperty("appointment.status");
		return description;
	}
	
	@PropertyGetter("display")
	public String getDisplayString(Encounter encounter) {
		return "its sunday";
		/*String ret = encounter.getEncounterType() == null ? "?" : encounter.getEncounterType().getName();
		ret += " ";
		ret += encounter.getEncounterDatetime() == null ? "?" : Context.getDateFormat().format(
				encounter.getEncounterDatetime());
		return ret;*/
	}
}
