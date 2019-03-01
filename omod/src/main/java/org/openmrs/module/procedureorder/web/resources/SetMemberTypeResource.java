/*
package org.openmrs.module.procedureorder.web.resources;

import org.openmrs.api.context.Context;
import org.openmrs.module.procedureorder.api.services.OrderSetExtService;
import org.openmrs.module.procedureorder.models.SetMemberType;
import org.openmrs.module.procedureorder.web.controller.OrderExtController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE + "/setmembertype", supportedClass = SetMemberType.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class SetMemberTypeResource extends DelegatingCrudResource<SetMemberType> {
	
	@Override
	public SetMemberType getByUniqueId(String uuid) {
		SetMemberType type = Context.getService(OrderSetExtService.class).getSetMemberTypeByUuid(uuid);
		if (type == null) {
			type = Context.getService(OrderSetExtService.class).getSetMemberTypeByName(uuid);
		}
		return type;
	}
	
	@Override
	protected NeedsPaging doGetAll(RequestContext context) throws ResponseException {
		return new NeedsPaging<SetMemberType>(Context.getService(OrderSetExtService.class).getSetMemberTypes(
		    context.getIncludeAll()), context);
		
	}
	
	@Override
	protected void delete(SetMemberType setMemberType, String s, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public SetMemberType newDelegate() {
		return new SetMemberType();
	}
	
	@Override
	public SetMemberType save(SetMemberType setMemberType) {
		return Context.getService(OrderSetExtService.class).saveSetMemberType(setMemberType);
	}
	
	@Override
	public void purge(SetMemberType setMemberType, RequestContext requestContext) throws ResponseException {
		if (setMemberType == null) {
			return;
		}
		Context.getService(OrderSetExtService.class).purgeSetMemberType(setMemberType);
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		return getCreatableProperties();
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("name");
			description.addProperty("javaClassName");
			description.addProperty("voided");
			description.addProperty("description");
			description.addSelfLink();
			if (rep instanceof DefaultRepresentation) {
				description.addProperty("uuid");
				description.addProperty("display");
				description.addProperty("name");
				description.addProperty("javaClassName");
				description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			} else {
				description.addProperty("uuid");
				description.addProperty("display");
				description.addProperty("name");
				description.addProperty("javaClassName");
				description.addProperty("auditInfo");
			}
			return description;
		}
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("name");
		description.addProperty("javaClassName");
		description.addProperty("description");
		return description;
	}
}
*/
