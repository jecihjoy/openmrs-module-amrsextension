package org.openmrs.module.amrsextension.web.resources;

import org.openmrs.api.context.Context;
import org.openmrs.module.amrsextension.api.ModuleEncounterService;
import org.openmrs.module.amrsextension.models.ModuleEncounter;
import org.openmrs.module.amrsextension.web.controller.AmrsExtensionController;
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

@Resource(name = RestConstants.VERSION_1 + AmrsExtensionController.AMRS_EXTENSION_REST_NAMESPACE + "/moduleencounter", supportedClass = ModuleEncounter.class, supportedOpenmrsVersions = {
        "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*", "2.3.*" })
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
	public ModuleEncounter save(ModuleEncounter delegate) {
		return Context.getService(ModuleEncounterService.class).saveEncounter(delegate);
	}
	
	@Override
	public void purge(ModuleEncounter encounter, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display", findMethod("getDisplayString"));
			description.addProperty("encounterDatetime"); // has a default value set, hence not required here
			description.addRequiredProperty("patient");
			description.addRequiredProperty("encounterType");
			
			description.addProperty("location");
			description.addProperty("form");
			description.addProperty("encounterProviders");
			description.addProperty("orders");
			description.addProperty("obs");
			description.addRequiredProperty("appointmentTimeSlot");
			description.addProperty("visit");
			description.addRequiredProperty("appointmentStatus");
			description.addProperty("appointmentReason");
			description.addProperty("appointmentCancelReason");
			description.addRequiredProperty("appointmentType");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display", findMethod("getDisplayString"));
			description.addProperty("encounterDatetime"); // has a default value set, hence not required here
			description.addRequiredProperty("patient");
			description.addRequiredProperty("encounterType");
			
			description.addProperty("location");
			description.addProperty("form");
			description.addProperty("encounterProviders");
			description.addProperty("orders");
			description.addProperty("obs");
			description.addRequiredProperty("appointmentTimeSlot");
			description.addProperty("visit");
			description.addRequiredProperty("appointmentStatus");
			description.addProperty("appointmentReason");
			description.addProperty("appointmentCancelReason");
			description.addRequiredProperty("appointmentType");
			description.addSelfLink();
			return description;
		}
		
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("encounterDatetime");
		description.addRequiredProperty("patient");
		description.addRequiredProperty("encounterType");
		
		description.addProperty("location");
		description.addProperty("form");
		description.addProperty("encounterProviders");
		description.addProperty("orders");
		description.addProperty("obs");
		description.addProperty("encounterId");
		description.addRequiredProperty("appointmentTimeSlot");
		description.addProperty("visit");
		description.addRequiredProperty("appointmentStatus");
		description.addProperty("appointmentReason");
		description.addProperty("appointmentCancelReason");
		description.addRequiredProperty("appointmentType");
		description.addProperty("appointmentId");
		description.addProperty("appointmentDate");
		return description;
	}
	
	@PropertyGetter("display")
	public String getDisplayString(ModuleEncounter encounter) {
		String ret = encounter.getEncounterType() == null ? "?" : encounter.getEncounterType().getName();
		ret += " ";
		ret += encounter.getEncounterDatetime() == null ? "?" : Context.getDateFormat().format(
		    encounter.getEncounterDatetime());
		ret += " ";
		ret += encounter.getAppointmentStatus() == null ? "?" : encounter.getAppointmentStatus() + "  Appointment Date  "
		        + Context.getDateFormat().format(encounter.getAppointmentDate());
		return ret;
	}
}
