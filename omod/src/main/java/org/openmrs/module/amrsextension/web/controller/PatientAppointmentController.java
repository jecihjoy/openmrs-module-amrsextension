package org.openmrs.module.amrsextension.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsextension.api.ModuleEncounterService;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + AmrsExtensionController.AMRS_EXTENSION_REST_NAMESPACE
        + "/lastappointment")
public class PatientAppointmentController {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Appointment getPatientLastAppointment(@RequestParam(value = "patient", required = true) Patient patient) {
		Appointment appointment = Context.getService(ModuleEncounterService.class).getPatientLastAppointment(patient);
		appointment.getTimeSlot().setCreator(null);
		appointment.getTimeSlot().getAppointmentBlock().setCreator(null);
		appointment.setCreator(null);
		return appointment;
	}
}
