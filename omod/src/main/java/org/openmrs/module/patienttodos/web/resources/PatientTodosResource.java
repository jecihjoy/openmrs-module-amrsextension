package org.openmrs.module.patienttodos.web.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Resource(name = RestConstants.VERSION_1 + PatienttodosController.PATIENT_TODOS_NAMESPACE + "/ptodos", supportedClass = PatientTodo.class, supportedOpenmrsVersions = { "2.0.*, 2.1.*, 2.4.*, 2.8.*" })
public class PatientTodosResource extends DataDelegatingCrudResource<PatientTodo> {
	
	private static final Log log = LogFactory.getLog(PatientTodosResource.class);
	
	@Autowired
	private PatientTodosService service;
	
	@Override
	public PatientTodo getByUniqueId(String patientUuid) {
		return service.getPatientTodos(patientUuid);
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
		DelegatingResourceDescription description = null;
		
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation || rep instanceof RefRepresentation) {
			description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("id");
			description.addProperty("description");
			description.addProperty("todo_date");
			description.addProperty("patient_id");
		}
		return description;
	}
	
	@Override
	protected NeedsPaging doGetAll(RequestContext context) throws ResponseException {
		PatientTodo ob1 = new PatientTodo("todo1", new Date(), new Patient());
		PatientTodo ob2 = new PatientTodo("todo2", new Date(), new Patient());
		PatientTodo ob3 = new PatientTodo("todo2", new Date(), new Patient());
//		List<PatientTodo> todo = service.getAllTodos();
		List<PatientTodo> todos = new ArrayList<PatientTodo>();
		todos.add(ob1);
		todos.add(ob2);
		todos.add(ob3);
		log.info("patienttodos");
		log.info(todos);
		return new NeedsPaging<PatientTodo>(todos, context);
	}
}
