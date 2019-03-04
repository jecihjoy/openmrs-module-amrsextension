package org.openmrs.module.amrsordermodule.web.resources;

import io.swagger.models.Model;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.models.DrugSetMember;
import org.openmrs.module.amrsordermodule.models.OrderSetMemberExt;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
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

@SubClassHandler(supportedClass = DrugSetMember.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class DrugSetMemberSubclassHandler extends BaseDelegatingSubclassHandler<OrderSetMemberExt, DrugSetMember> implements DelegatingSubclassHandler<OrderSetMemberExt, DrugSetMember> {
	
	@Override
	public String getTypeName() {
		return "drugsetmember";
	}
	
	@Override
	public PageableResult getAllByType(RequestContext requestContext) throws ResourceDoesNotSupportOperationException {
		throw new ResourceDoesNotSupportOperationException();
	}
	
	@Override
	public DrugSetMember newDelegate() {
		return new DrugSetMember();
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
			        .getResourceBySupportedClass(OrderSetMemberExt.class);
			DelegatingResourceDescription description = setm.getRepresentationDescription(rep);
			//            description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("doseUnits", Representation.REF);
			description.addProperty("dose");
			description.addProperty("frequency", Representation.REF);
			//            description.addProperty("asNeeded");
			description.addProperty("quantity");
			description.addProperty("quantityUnits", Representation.REF);
			description.addProperty("drug", Representation.REF);
			description.addProperty("asNeededCondition");
			//            description.addProperty("dosingType", Representation.REF);
			description.addProperty("numRefills", Representation.REF);
			description.addProperty("dosingInstructions");
			description.addProperty("duration");
			description.addProperty("durationUnits");
			description.addProperty("brandName");
			//            description.addProperty("dispenseAsWritten");
			description.addProperty("drugNonCoded");
			description.addProperty("route", Representation.REF);
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
			        .getResourceBySupportedClass(OrderSetMemberExt.class);
			DelegatingResourceDescription description = setm.getRepresentationDescription(rep);
			//            description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("doseUnits", Representation.REF);
			description.addProperty("dose");
			description.addProperty("frequency", Representation.REF);
			//            description.addProperty("asNeeded");
			description.addProperty("quantity");
			description.addProperty("quantityUnits", Representation.REF);
			description.addProperty("drug", Representation.REF);
			description.addProperty("asNeededCondition");
			//            description.addProperty("dosingType", Representation.REF);
			description.addProperty("numRefills", Representation.REF);
			description.addProperty("dosingInstructions");
			description.addProperty("duration");
			description.addProperty("durationUnits");
			description.addProperty("brandName");
			//            description.addProperty("dispenseAsWritten");
			description.addProperty("drugNonCoded");
			description.addProperty("route", Representation.REF);
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		}
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
		        .getResourceBySupportedClass(OrderSetMemberExt.class);
		DelegatingResourceDescription description = setm.getCreatableProperties();
		description.addProperty("doseUnits", Representation.REF);
		description.addProperty("dose");
		description.addProperty("frequency", Representation.REF);
		description.addProperty("asNeeded");
		description.addProperty("quantity");
		description.addProperty("quantityUnits", Representation.REF);
		description.addProperty("drug", Representation.REF);
		description.addProperty("asNeededCondition");
		description.addProperty("dosingType", Representation.REF);
		description.addProperty("numRefills", Representation.REF);
		description.addProperty("dosingInstructions");
		description.addProperty("duration");
		description.addProperty("durationUnits");
		description.addProperty("brandName");
		description.addProperty("dispenseAsWritten");
		description.addProperty("drugNonCoded");
		description.addProperty("route", Representation.REF);
		return description;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		OrderSetMemberExtResource setm = (OrderSetMemberExtResource) Context.getService(RestService.class)
		        .getResourceBySupportedClass(OrderSetMemberExt.class);
		return setm.getUpdatableProperties();
	}
	
	@PropertyGetter("display")
	public static String getDisplay(DrugSetMember orderSetMember) {
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
