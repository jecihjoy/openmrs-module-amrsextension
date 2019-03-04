package org.openmrs.module.amrsordermodule.web.resources;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.api.services.OrderSetExtService;
import org.openmrs.module.amrsordermodule.models.OrderSetExt;
import org.openmrs.module.amrsordermodule.models.OrderSetMemberExt;
import org.openmrs.module.amrsordermodule.web.controller.OrderExtController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertySetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.List;

@Resource(name = RestConstants.VERSION_1 + OrderExtController.MODULE_ORDER_NAMESPACE + "/orderset", supportedClass = OrderSetExt.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.2.*, 2.4.*, 2.8.*" })
public class OrderSetExtResource extends MetadataDelegatingCrudResource<OrderSetExt> {
	
	@Override
	protected NeedsPaging doGetAll(RequestContext context) throws ResponseException {
		return new NeedsPaging<OrderSetExt>(Context.getService(OrderSetExtService.class).getOrderSets(
		    context.getIncludeAll()), context);
		
	}
	
	@Override
	public OrderSetExt getByUniqueId(String uuid) {
		return Context.getService(OrderSetExtService.class).getOrderSetByUuid(uuid);
	}
	
	@Override
	public OrderSetExt newDelegate() {
		return new OrderSetExt();
	}
	
	@Override
	public OrderSetExt save(OrderSetExt orderSet) {
		if (CollectionUtils.isNotEmpty(orderSet.getOrderSetMembers())) {
			for (OrderSetMemberExt orderSetMember : orderSet.getOrderSetMembers()) {
				if (null != orderSetMember.getConcept() && StringUtils.isNotEmpty(orderSetMember.getConcept().getUuid())) {
					orderSetMember.setConcept(Context.getConceptService().getConceptByUuid(
					    orderSetMember.getConcept().getUuid()));
				}
				if (null != orderSetMember.getOrderType() && StringUtils.isNotEmpty(orderSetMember.getOrderType().getUuid())) {
					orderSetMember.setOrderType(Context.getOrderService().getOrderTypeByUuid(
					    orderSetMember.getOrderType().getUuid()));
				}
			}
		}
		return Context.getService(OrderSetExtService.class).saveOrderSet(orderSet);
	}
	
	@Override
	public void purge(OrderSetExt orderSetExt, RequestContext requestContext) throws ResponseException {
		throw new ResourceDoesNotSupportOperationException();
	}
	
	@PropertySetter("orderSetMembers")
	public static void setOrderSetMembers(OrderSetExt instance, List<OrderSetMemberExt> orderSetMembers) {
		instance.setOrderSetMembers(orderSetMembers);
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("orderSetId");
			description.addProperty("operator");
			description.addProperty("name");
			description.addProperty("description");
			description.addProperty("uuid");
			description.addProperty("orderSetMembers", Representation.DEFAULT);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("orderSetId");
			description.addProperty("operator");
			description.addProperty("name");
			description.addProperty("description");
			description.addProperty("uuid");
			description.addProperty("orderSetMembers", Representation.DEFAULT);
			return description;
		} else {
			return null;
		}
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("orderSetId");
		description.addProperty("operator");
		description.addProperty("name");
		description.addProperty("description");
		description.addProperty("uuid");
		description.addProperty("orderSetMembers", Representation.DEFAULT);
		return description;
	}
	
}
