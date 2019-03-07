/*
package org.openmrs.module.amrsordermodule.web.resources;

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.StringProperty;
import org.openmrs.Order;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.models.ProcedureOrder;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

public class ProcedureOrderResource extends DataDelegatingCrudResource<ProcedureOrder> {


    public boolean hasTypesDefined() {
        return true;
    }

    public Order getByUniqueId(String uniqueId) {
        return Context.getOrderService().getOrderByUuid(uniqueId);
    }


    public ProcedureOrder newDelegate() {
        return new ProcedureOrder();
    }


    public ProcedureOrder save(ProcedureOrder delegate) {
        return Context.getOrderService().saveOrder(delegate);
    }


    @Override
    protected void delete(ProcedureOrder delegate, String reason, RequestContext context) throws ResponseException {
        if (delegate.isVoided()) {
            // DELETE is idempotent, so we return success here
            return;
        }
        Context.getOrderService().voidOrder(delegate, reason);

    }


    @Override
    public void purge(ProcedureOrder delegate, RequestContext context) throws ResponseException {
        Context.getOrderService().purgeOrder(delegate);
    }


    @Override
    protected PageableResult doGetAll(RequestContext context) throws ResponseException {
        //ORDER_STATUS.ANY is used to specify that all orders, including voided ones should be retrieved
        ORDER_STATUS orderStatus = context.getIncludeAll() ? ORDER_STATUS.ANY : null;

        return new NeedsPaging<ProcedureOrder>(Context.getOrderService().getOrders(Order.class, null, null, orderStatus, null, null,
                null), context);
    }


    @PropertyGetter("display")
    public String getDisplayString(Order order) {
        if (order.getConcept() == null)
            return "[No Concept]";
        return order.getConcept().getName().getName();
    }


    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        if (rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("display");
            description.addProperty("orderType", Representation.REF);
            description.addProperty("patient", Representation.REF);
            description.addProperty("concept", Representation.REF);
            description.addProperty("instructions");
            description.addProperty("startDate");
            description.addProperty("autoExpireDate");
            description.addProperty("encounter", Representation.REF);
            description.addProperty("orderer", Representation.REF);
            description.addProperty("accessionNumber");
            description.addProperty("discontinuedBy", Representation.REF);
            description.addProperty("discontinuedDate");
            description.addProperty("discontinuedReason");
            description.addProperty("discontinuedReasonNonCoded");
            description.addProperty("voided");
            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (rep instanceof FullRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("display");
            description.addProperty("orderType");
            description.addProperty("patient");
            description.addProperty("concept");
            description.addProperty("instructions");
            description.addProperty("startDate");
            description.addProperty("autoExpireDate");
            description.addProperty("encounter");
            description.addProperty("orderer");
            description.addProperty("accessionNumber");
            description.addProperty("discontinuedBy");
            description.addProperty("discontinuedDate");
            description.addProperty("discontinuedReason");
            description.addProperty("discontinuedReasonNonCoded");
            description.addProperty("voided");
            description.addProperty("auditInfo");
            description.addSelfLink();
            return description;
        } else {
            return null;
        }
    }

    */
/**
 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getCreatableProperties()
 */
/*

@Override
public DelegatingResourceDescription getCreatableProperties() {
 DelegatingResourceDescription d = new DelegatingResourceDescription();
 d.addRequiredProperty("orderType");
 d.addRequiredProperty("patient");
 d.addRequiredProperty("concept");
 d.addProperty("instructions");
 d.addProperty("startDate");
 d.addProperty("autoExpireDate");
 d.addProperty("encounter");
 d.addProperty("orderer");
 d.addProperty("discontinuedBy");
 d.addProperty("discontinuedDate");
 d.addProperty("discontinuedReason");
 d.addProperty("discontinuedReasonNonCoded");
 d.addProperty("accessionNumber");
 return d;
}

@Override
public Model getGETModel(Representation rep) {
 ModelImpl model = (ModelImpl) super.getGETModel(rep);
 if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
     model
             .property("uuid", new StringProperty())
             .property("display", new StringProperty())
             .property("instructions", new StringProperty())
             .property("startDate", new DateProperty())
             .property("autoExpireDate", new DateProperty())
             .property("accessionNumber", new StringProperty())
             .property("discontinuedDate", new DateProperty())
             .property("discontinuedReasonNonCoded", new StringProperty())
             .property("voided", new BooleanProperty());
 }
 if (rep instanceof DefaultRepresentation) {
     model
             .property("orderType", new RefProperty("#/definitions/OrdertypeGetRef"))
             .property("patient", new RefProperty("#/definitions/PatientGetRef"))
             .property("concept", new RefProperty("#/definitions/ConceptGetRef"))
             .property("encounter", new RefProperty("#/definitions/EncounterGetRef"))
             .property("orderer", new RefProperty("#/definitions/UserGetRef"))
             .property("discontinuedBy", new RefProperty("#/definitions/UserGetRef"))
             .property("discontinuedReason", new RefProperty("#/definitions/ConceptGetRef"));
 } else if (rep instanceof FullRepresentation) {
     model
             .property("orderType", new RefProperty("#/definitions/OrdertypeGet"))
             .property("patient", new RefProperty("#/definitions/PatientGet"))
             .property("concept", new RefProperty("#/definitions/ConceptGet"))
             .property("encounter", new RefProperty("#/definitions/EncounterGet"))
             .property("orderer", new RefProperty("#/definitions/UserGet"))
             .property("discontinuedBy", new RefProperty("#/definitions/UserGet"))
             .property("discontinuedReason", new RefProperty("#/definitions/ConceptGet"));
 }
 return model;
}

@Override
public Model getCREATEModel(Representation rep) {
 ModelImpl model = new ModelImpl()
         .property("orderType", new StringProperty().example("uuid"))
         .property("patient", new StringProperty().example("uuid"))
         .property("concept", new StringProperty().example("uuid"))
         .property("instructions", new StringProperty())
         .property("startDate", new DateProperty())
         .property("autoExpireDate", new DateProperty())
         .property("encounter", new StringProperty().example("uuid"))
         .property("orderer", new StringProperty().example("uuid"))
         .property("discontinuedBy", new StringProperty().example("uuid"))
         .property("discontinuedDate", new DateProperty())
         .property("discontinuedReason", new RefProperty("#/definitions/ConceptCreate"))
         .property("discontinuedReasonNonCoded", new StringProperty())
         .property("accessionNumber", new StringProperty())

         .required("orderType").required("patient").required("concept");
 if (rep instanceof FullRepresentation) {
     model
             .property("orderType", new RefProperty("#/definitions/OrdertypeCreate"))
             .property("patient", new RefProperty("#/definitions/PatientCreate"))
             .property("concept", new RefProperty("#/definitions/ConceptCreate"))
             .property("encounter", new RefProperty("#/definitions/EncounterCreate"))
             .property("orderer", new RefProperty("#/definitions/UserCreate"))
             .property("discontinuedBy", new RefProperty("#/definitions/UserCreate"))
             .property("discontinuedReason", new RefProperty("#/definitions/ConceptCreate"));
 }
 //FIXME missing prop: type
 return model;
}

@Override
public Model getUPDATEModel(Representation rep) {
 return new ModelImpl(); //FIXME missing props
}


@Override
protected PageableResult doSearch(RequestContext context) {
 String patientUuid = context.getRequest().getParameter("patient");
 if (patientUuid != null) {
     Patient patient = ((PatientResource1_8) Context.getService(RestService.class).getResourceBySupportedClass(
             Patient.class)).getByUniqueId(patientUuid);
     if (patient == null)
         return new EmptySearchResult();

     // if the user indicated a specific type, try to delegate to the appropriate subclass handler
     if (context.getType() != null) {
         PageableResult ret = (PageableResult) findAndInvokeSubclassHandlerMethod(context.getType(),
                 "getOrdersByPatient", patient, context);
         if (ret != null)
             return ret;
     }

     List<Order> orders = Context.getOrderService().getOrdersByPatient(patient);
     // if the user indicated a specific type, and we couldn't delegate to a subclass handler above, filter here
     if (context.getType() != null) {
         filterByType(orders, context.getType());
     }
     return new NeedsPaging<Order>(orders, context);
 }

 //currently this is not supported since the superclass throws an exception
 return super.doSearch(context);
}

}

*/
