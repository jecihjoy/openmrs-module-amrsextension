package org.openmrs.module.procedureorder.web.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedureorder.api.services.PatientTodosService;
import org.openmrs.module.procedureorder.models.PatientTodo;
import org.openmrs.module.procedureorder.web.controller.ProcedureOrderController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.List;

@Resource(name = RestConstants.VERSION_1 + ProcedureOrderController.PROCEDURE_ORDER_NAMESPACE + "/ptodos", supportedClass = PatientTodo.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class PatientTodosResource extends DataDelegatingCrudResource<PatientTodo> {
	
	private static final Log log = LogFactory.getLog(PatientTodosResource.class);
	
	private PatientTodosService service = Context.getService(PatientTodosService.class);
	
	@Override
	public PatientTodo getByUniqueId(String uuid) {
		return service.getByTodoUuid(uuid);
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		return getCreatableProperties();
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description;
		
		description = new DelegatingResourceDescription();
		description.addProperty("todoId");
		description.addProperty("uuid");
		description.addProperty("description");
		description.addProperty("dueDate");
		//		description.addProperty("patient_id", Representation.DEFAULT); needs uncommenting
		return description;
	}
	
	@Override
	public Object retrieve(String uuid, RequestContext context) throws ResponseException {
		return super.retrieve(uuid, context);
	}
	
	@Override
	protected void delete(PatientTodo patientTodo, String s, RequestContext requestContext) throws ResponseException {
		s = "needs deleting";
		service.voidTodos(patientTodo, s);
	}
	
	@Override
	public PatientTodo newDelegate() {
		return new PatientTodo();
	}
	
	@Override
	public PatientTodo save(PatientTodo patientTodo) {
		log.info("resource");
		log.info(patientTodo);
		try {
			service.saveOrUpdate(patientTodo);
		}
		catch (Exception e) {
			log.error(e);
		}
		return patientTodo;
	}
	
	@Override
	public void purge(PatientTodo patientTodo, RequestContext requestContext) throws ResponseException {
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		DelegatingResourceDescription description;
		
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation || rep instanceof RefRepresentation) {
			description = new DelegatingResourceDescription();
			description.addProperty("todoId");
			description.addProperty("uuid");
			description.addProperty("description");
			description.addProperty("dueDate");
			description.addProperty("patient_id", Representation.DEFAULT);
			/*		description.addProperty("changed_by");
					description.addProperty("creator");
					description.addProperty("date_created");
					description.addProperty("date_changed");
					description.addProperty("date_voided");
					description.addProperty("void_reason");
					description.addProperty("voided");
					description.addProperty("voided_by");*/
			return description;
		} else {
			return null;
		}
		
	}
	
	@Override
	protected NeedsPaging doGetAll(RequestContext context) throws ResponseException {
		List<PatientTodo> todos = service.getAllTodos();
		log.info("procedureorder");
		log.info(todos);
		return new NeedsPaging<PatientTodo>(todos, context);
	}
}
