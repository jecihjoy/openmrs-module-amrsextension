package org.openmrs.module.amrsextension.web.resources;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsextension.api.ModulePatientDataService;
import org.openmrs.module.amrsextension.models.LabOrder;
import org.openmrs.module.amrsextension.web.controller.AmrsExtensionController;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + AmrsExtensionController.AMRS_EXTENSION_REST_NAMESPACE + "/laborder", supportedClass = LabOrder.class, supportedOpenmrsVersions = {
        "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*", "2.3.*" })
public class LabOrderResource extends DataDelegatingCrudResource<LabOrder> {
	
	@Override
	public LabOrder getByUniqueId(String s) {
		return null;
	}
	
	@Override
	protected void delete(LabOrder labOrder, String s, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public LabOrder newDelegate() {
		return null;
	}
	
	@Override
	public LabOrder save(LabOrder labOrder) {
		return null;
	}
	
	@Override
	public void purge(LabOrder labOrder, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	protected PageableResult doSearch(RequestContext context) {
		Patient patient = context.getParameter("patient") != null ? Context.getPatientService().getPatientByUuid(
		    context.getParameter("patient")) : null;
		ModulePatientDataService service = Context.getService(ModulePatientDataService.class);
		return new NeedsPaging<LabOrder>(service.getPatientLabOrders(patient), context);
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display", findMethod("getDisplayString"));
			description.addProperty("conceptUuid"); // has a default value set, hence not required here
			description.addProperty("dateActivated");
			description.addProperty("familyName");
			
			description.addProperty("identifiers");
			description.addProperty("locationUuid");
			description.addProperty("locationId");
			
			description.addProperty("locationName");
			description.addProperty("middleName");
			description.addProperty("obs_uuid");
			description.addProperty("orderNumber");
			description.addProperty("orderType");
			description.addProperty("patientId");
			description.addProperty("patientUuid");
			description.addProperty("personName");
			description.addProperty("providerName");
			description.addProperty("providerUuid");
			description.addProperty("sampleCollectioDate");
			description.addProperty("sampleDrawn");
			description.addProperty("uuid");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display", findMethod("getDisplayString"));
			description.addProperty("conceptUuid"); // has a default value set, hence not required here
			description.addProperty("dateActivated");
			description.addProperty("familyName");
			
			description.addProperty("identifiers");
			description.addProperty("locationUuid");
			description.addProperty("locationId");
			
			description.addProperty("locationName");
			description.addProperty("middleName");
			description.addProperty("obs_uuid");
			description.addProperty("orderNumber");
			description.addProperty("orderType");
			description.addProperty("patientId");
			description.addProperty("patientUuid");
			description.addProperty("personName");
			description.addProperty("providerName");
			description.addProperty("providerUuid");
			description.addProperty("sampleCollectioDate");
			description.addProperty("sampleDrawn");
			description.addProperty("uuid");
			description.addSelfLink();
			return description;
		}
		
		return null;
	}
	
	@PropertyGetter("display")
	public String getDisplayString(LabOrder labOrder) {
		return "yaay its thursday" + labOrder;
	}
}
