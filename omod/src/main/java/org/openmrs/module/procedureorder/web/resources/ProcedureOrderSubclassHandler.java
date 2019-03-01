package org.openmrs.module.procedureorder.web.resources;

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
import org.apache.commons.lang.StringUtils;
import org.openmrs.CareSetting;
import org.openmrs.Order;
import org.openmrs.OrderType;
import org.openmrs.Patient;
import org.openmrs.api.OrderService;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedureorder.models.ProcedureOrder;
import org.openmrs.module.webservices.docs.swagger.core.property.EnumProperty;
import org.openmrs.module.webservices.rest.web.ConversionUtil;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.SubClassHandler;
import org.openmrs.module.webservices.rest.web.api.RestService;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.*;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_10.CareSettingResource1_10;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_10.OrderResource1_10;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_10.OrderUtil;

import java.util.*;

@SubClassHandler(supportedClass = ProcedureOrder.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class ProcedureOrderSubclassHandler extends BaseDelegatingSubclassHandler<Order, ProcedureOrder> implements DelegatingSubclassHandler<Order, ProcedureOrder> {
	
	@Override
	public ProcedureOrder save(ProcedureOrder delegate) {
		return super.save(delegate);
	}
	
	@Override
	public String getTypeName() {
		return "procedureorder";
	}
	
	@Override
	public PageableResult getAllByType(RequestContext requestContext) throws ResourceDoesNotSupportOperationException {
		throw new ResourceDoesNotSupportOperationException();
	}
	
	@Override
	public ProcedureOrder newDelegate() {
		return new ProcedureOrder();
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		OrderResource1_10 orderResource1_10 = (OrderResource1_10) Context.getService(RestService.class);
		return orderResource1_10.getUpdatableProperties();
	}
	
	@Override
	public Model getGETModel(Representation rep) {
		
		OrderResource1_10 orderResource = (OrderResource1_10) Context.getService(RestService.class)
		        .getResourceBySupportedClass(Order.class);
		ModelImpl orderModel = (ModelImpl) orderResource.getGETModel(rep);
		orderModel.property("laterality", new EnumProperty(ProcedureOrder.Laterality.class))
		        .property("clinicalHistory", new StringProperty()).property("numberOfRepeats", new IntegerProperty());
		
		if (rep instanceof DefaultRepresentation) {
			orderModel.property("specimenSource", new RefProperty("#/definitions/ConceptGetRef")).property("frequency",
			    new RefProperty("#/definitions/OrderfrequencyGetRef"));
		} else if (rep instanceof FullRepresentation) {
			orderModel.property("specimenSource", new RefProperty("#/definitions/ConceptGet")).property("frequency",
			    new RefProperty("#/definitions/OrderfrequencyGet"));
		}
		return orderModel;
	}
	
	@Override
	public Model getCREATEModel(Representation rep) {
		OrderResource1_10 orderResource = (OrderResource1_10) Context.getService(RestService.class)
		        .getResourceBySupportedClass(Order.class);
		ModelImpl orderModel = (ModelImpl) orderResource.getCREATEModel(rep);
		return orderModel.property("specimenSource", new StringProperty().example("uuid"))
		        .property("laterality", new EnumProperty(ProcedureOrder.Laterality.class))
		        .property("clinicalHistory", new StringProperty())
		        .property("frequency", new StringProperty().example("uuid"))
		        .property("numberOfRepeats", new IntegerProperty());
	}
	
	@PropertyGetter("display")
	public static String getDisplay(ProcedureOrder delegate) {
		OrderResource1_10 orderResource = (OrderResource1_10) Context.getService(RestService.class)
		        .getResourceBySupportedClass(Order.class);
		return orderResource.getDisplayString(delegate);
	}//Procedure Order
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			OrderResource1_10 orderResource = (OrderResource1_10) Context.getService(RestService.class)
			        .getResourceBySupportedClass(Order.class);
			DelegatingResourceDescription d = orderResource.getRepresentationDescription(rep);
			d.addProperty("clinicalHistory");
			d.addProperty("procedureName", Representation.REF);
			d.addProperty("frequency");
			d.addProperty("requiresSpecimen");
			d.addProperty("specimenSource", Representation.REF);
			d.addProperty("numberOfRepeats");
			d.addProperty("laterality");
			d.addProperty("testNotes");
			return d;
		} else if (rep instanceof FullRepresentation) {
			OrderResource1_10 orderResource = (OrderResource1_10) Context.getService(RestService.class)
			        .getResourceBySupportedClass(Order.class);
			DelegatingResourceDescription d = orderResource.getRepresentationDescription(rep);
			d.addProperty("clinicalHistory");
			d.addProperty("procedureName", Representation.REF);
			d.addProperty("frequency");
			d.addProperty("requiresSpecimen");
			d.addProperty("specimenSource", Representation.REF);
			d.addProperty("numberOfRepeats");
			d.addProperty("laterality");
			d.addProperty("testNotes");
			return d;
		}
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		OrderResource1_10 orderResource1_10 = (OrderResource1_10) Context.getService(RestService.class);
		DelegatingResourceDescription d = orderResource1_10.getCreatableProperties();
		d.addProperty("clinicalHistory");
		d.addProperty("procedureName", Representation.REF);
		d.addProperty("frequency");
		d.addProperty("requiresSpecimen");
		d.addProperty("specimenSource", Representation.REF);
		d.addProperty("numberOfRepeats");
		d.addProperty("laterality");
		d.addProperty("testNotes");
		return d;
	}
	
	public PageableResult getActiveOrders(Patient patient, RequestContext context) {
		String careSettingUuid = context.getRequest().getParameter("careSetting");
		String asOfDateString = context.getRequest().getParameter("asOfDate");
		String sortParam = context.getRequest().getParameter("sort");
		CareSetting careSetting = null;
		java.util.Date asOfDate = null;
		if (StringUtils.isNotBlank(asOfDateString)) {
			asOfDate = (java.util.Date) ConversionUtil.convert(asOfDateString, java.util.Date.class);
		}
		if (StringUtils.isNotBlank(careSettingUuid)) {
			careSetting = ((CareSettingResource1_10) Context.getService(RestService.class).getResourceBySupportedClass(
			    CareSetting.class)).getByUniqueId(careSettingUuid);
		}
		
		String status = context.getRequest().getParameter("status");
		OrderService os = Context.getOrderService();
		OrderType orderType = os.getOrderTypeByName("Procedure Order");
		List<Order> testOrders = OrderUtil.getOrders(patient, careSetting, orderType, status, asOfDate,
		    context.getIncludeAll());
		OrderResource1_10 orderResource = (OrderResource1_10) Context.getService(RestService.class)
		        .getResourceBySupportedClass(Order.class);
		
		if (StringUtils.isNotBlank(sortParam)) {
			List<Order> sortedOrder = sortOrdersBasedOnDateActivatedOrDateStopped(testOrders, sortParam, status);
			return new NeedsPaging<Order>(sortedOrder, context);
		} else {
			return new NeedsPaging<Order>(testOrders, context);
		}
	}
	
	private static Date getUsableDate(Order order) {
		return order.getDateStopped() != null ? order.getDateStopped() : (order.getAutoExpireDate() != null ? order
		        .getAutoExpireDate() : order.getDateCreated());
	}
	
	private static Date getActiveOrderSortDate(Order order) {
		return order.getDateActivated() != null ? order.getDateActivated() : order.getDateCreated();
	}
	
	public List<Order> sortOrdersBasedOnDateActivatedOrDateStopped(List<Order> orders, final String sortOrder,
	        final String status) {
		List<Order> sortedList = new ArrayList<Order>(orders);
		Collections.sort(sortedList, new Comparator<Order>() {
			
			@Override
			public int compare(Order o1, Order o2) {
				if (status.equalsIgnoreCase("inactive")) {
					return sortOrder.equalsIgnoreCase("ASC") ? getUsableDate(o1).compareTo(getUsableDate(o2))
					        : getUsableDate(o2).compareTo(getUsableDate(o1));
				} else {
					
					return sortOrder.equalsIgnoreCase("asc") ? getActiveOrderSortDate(o1).compareTo(
					    getActiveOrderSortDate(o2)) : getActiveOrderSortDate(o2).compareTo(getActiveOrderSortDate(o1));
				}
			}
		});
		return sortedList;
	}
	
}
