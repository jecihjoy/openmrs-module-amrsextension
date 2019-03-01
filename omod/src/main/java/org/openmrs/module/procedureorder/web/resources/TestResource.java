/*
package org.openmrs.module.procedureorder.web.resources;

import org.openmrs.api.context.Context;
import org.openmrs.module.procedureorder.api.services.OrderSetExtService;
import org.openmrs.module.procedureorder.models.OrderSetExt;
import org.openmrs.module.procedureorder.models.OrderSetMemberExt;
import org.openmrs.module.procedureorder.web.controller.OrderExtController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.ArrayList;
import java.util.List;

@Resource(name = RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE + "/setmembers", supportedClass = OrderSetMemberExt.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class TestResource extends DelegatingCrudResource<OrderSetMemberExt> {
	
	@Override
	public OrderSetMemberExt getByUniqueId(String uuid) {
		return Context.getService(OrderSetExtService.class).getOrderSetMemberByUuid(uuid);
	}
	
	@Override
	public PageableResult doGetAll(RequestContext requestContext) throws ResponseException {
		List<OrderSetMemberExt> orderSetMembers = Context.getService(OrderSetExtService.class).getAllOrderSetMember();
		return new NeedsPaging<OrderSetMemberExt>(orderSetMembers, requestContext);
	}
	
	@Override
	protected void delete(OrderSetMemberExt setMemberExt, String s, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public OrderSetMemberExt newDelegate() {
		return null;
	}
	
	@Override
	public OrderSetMemberExt save(OrderSetMemberExt setMemberExt) {
		return null;
	}
	
	@Override
	public void purge(OrderSetMemberExt setMemberExt, RequestContext requestContext) throws ResponseException {
		
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		if (rep instanceof DefaultRepresentation) {
			description.addProperty("orderSetMemberId");
			description.addProperty("uuid");
			description.addProperty("orderType", Representation.REF);
			description.addProperty("orderTemplate");
			description.addProperty("orderTemplateType");
			description.addProperty("concept", Representation.REF);
			description.addSelfLink();
			description.addLink("full", ".?v=" + "full");
			return description;
		} else if (rep instanceof FullRepresentation) {
			description.addProperty("orderSetMemberId");
			description.addProperty("uuid");
			description.addProperty("orderType");
			description.addProperty("orderTemplate");
			description.addProperty("orderTemplateType");
			description.addProperty("concept", Representation.FULL);
			description.addSelfLink();
			description.addProperty("auditInfo");
			return description;
		} else if (rep instanceof RefRepresentation) {
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("concept", Representation.REF);
			description.addSelfLink();
			return description;
		}
		return null;
	}
}
*/
