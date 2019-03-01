/*
package org.openmrs.module.procedureorder.web.resources;

import io.swagger.models.Model;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedureorder.models.OrderSetMemberExt;
import org.openmrs.module.procedureorder.models.ProcedureSetMember;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.SubClassHandler;
import org.openmrs.module.webservices.rest.web.api.RestService;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingSubclassHandler;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubclassHandler;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;

@SubClassHandler(supportedClass = ProcedureSetMember.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class ProcedureSetMemberSubclassHandler extends BaseDelegatingSubclassHandler<OrderSetMemberExt, ProcedureSetMember> implements DelegatingSubclassHandler<OrderSetMemberExt, ProcedureSetMember> {
	
	@Override
	public String getTypeName() {
		return "proceduresetmember";
	}
	
	@Override
	public PageableResult getAllByType(RequestContext requestContext) throws ResourceDoesNotSupportOperationException {
		throw new ResourceDoesNotSupportOperationException();
	}
	
	@Override
	public ProcedureSetMember newDelegate() {
		return new ProcedureSetMember();
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
			        .getResourceBySupportedClass(OrderSetMemberExt.class);
			DelegatingResourceDescription d = setm.getRepresentationDescription(rep);
			d.addProperty("specimenSource", Representation.REF);
			d.addProperty("laterality");
			d.addProperty("clinicalHistory");
			d.addProperty("frequency", Representation.REF);
			d.addProperty("numberOfRepeats");
			return d;
		} else if (rep instanceof FullRepresentation) {
			OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
			        .getResourceBySupportedClass(OrderSetMemberExt.class);
			DelegatingResourceDescription d = setm.getRepresentationDescription(rep);
			d.addProperty("specimenSource", Representation.REF);
			d.addProperty("laterality");
			d.addProperty("clinicalHistory");
			d.addProperty("frequency", Representation.DEFAULT);
			d.addProperty("numberOfRepeats");
			return d;
		}
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
		        .getResourceBySupportedClass(OrderSetMemberExt.class);
		DelegatingResourceDescription d = setm.getCreatableProperties();
		d.addProperty("specimenSource");
		d.addProperty("laterality");
		d.addProperty("clinicalHistory");
		d.addProperty("frequency");
		d.addProperty("numberOfRepeats");
		return d;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
		        .getResourceBySupportedClass(OrderSetMemberExt.class);
		return setm.getUpdatableProperties();
	}
	
	@PropertyGetter("display")
	public static String getDisplay(ProcedureSetMember orderSetMember) {
		OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
		        .getResourceBySupportedClass(OrderSetMemberExt.class);
		return setm.getDisplayString(orderSetMember);
	}
	
	@Override
	public Model getGETModel(Representation representation) {
		return null;
	}
	
	@Override
	public Model getCREATEModel(Representation representation) {
		return null;
	}
}
*/
