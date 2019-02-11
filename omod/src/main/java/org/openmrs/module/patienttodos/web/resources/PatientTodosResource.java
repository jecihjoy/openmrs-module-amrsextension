package org.openmrs.module.patienttodos.web.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.patienttodos.api.services.PatientTodosService;
import org.openmrs.module.patienttodos.models.PatientTodo;
import org.openmrs.module.patienttodos.web.controller.PatienttodosController;
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
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.List;

@Resource(name = RestConstants.VERSION_1 + PatienttodosController.PATIENT_TODOS_NAMESPACE + "/ptodos", supportedClass = PatientTodo.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class PatientTodosResource extends DataDelegatingCrudResource<PatientTodo> {
	
	private static final Log log = LogFactory.getLog(PatientTodosResource.class);
	
	private PatientTodosService service;
	
	@Override
	public PatientTodo getByUniqueId(String patientUuid) {
		service = Context.getService(PatientTodosService.class);
		return service.getPatientTodos(Integer.parseInt(patientUuid));
	}
	
	/*	@Override
		public PatientTodo getByUniqueId(String patientUuid) {
			service = Context.getService(PatientTodosService.class);
			return service.getByPatientUuid(patientUuid);
		}*/
	
	@Override
	public Object retrieve(String uuid, RequestContext context) throws ResponseException {
		return super.retrieve(uuid, context);
	}
	
	@Override
	protected void delete(PatientTodo patientTodo, String s, RequestContext requestContext) throws ResponseException {
	}
	
	@Override
	public PatientTodo newDelegate() {
		return new PatientTodo();
	}
	
	@Override
	public PatientTodo save(PatientTodo patientTodo) {
		service = Context.getService(PatientTodosService.class);
		try {
			return service.saveTodos(patientTodo);
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
			description.addProperty("todo_id");
			description.addProperty("uuid");
			description.addProperty("description");
			description.addProperty("due_date");
			description.addProperty("patient_id", Representation.DEFAULT);
			return description;
		} else {
			return null;
		}
	}
	
	@Override
	protected NeedsPaging doGetAll(RequestContext context) throws ResponseException {
		service = Context.getService(PatientTodosService.class);
		List<PatientTodo> todos = service.getAllTodos();
		log.info("patienttodos");
		log.info(todos);
		return new NeedsPaging<PatientTodo>(todos, context);
	}
}
