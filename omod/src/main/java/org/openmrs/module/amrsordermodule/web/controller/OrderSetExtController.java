package org.openmrs.module.amrsordermodule.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.amrsordermodule.api.services.OrderSetExtService;
import org.openmrs.module.amrsordermodule.models.OrderSetExt;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/orderset")
public class OrderSetExtController extends BaseRestController {
	
	private final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(method = RequestMethod.GET, value = "alvvl")
	@ResponseBody
	public List<OrderSetExt> getAllSets() {
		OrderSetExtService service = Context.getService(OrderSetExtService.class);
		
		log.error("COTROLLER LOOGGING");
		return service.getOrderSets(false);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{uuid}")
	@ResponseBody
	public OrderSetExt getSetByUuid(@PathVariable("uuid") String param) {
		OrderSetExtService service = Context.getService(OrderSetExtService.class);
		log.error("COTROLLER LOOGGING");
		log.error(service.getOrderSetByUuid(param));
		return service.getOrderSetByUuid(param);
	}
	
	@RequestMapping(value = "/all")
	@ResponseBody
	public Map<String, Object> listOrders() {
		OrderSetExtService service = Context.getService(OrderSetExtService.class);
		Map<String, Object> response = new HashMap<String, Object>();
		List<Object> objects = new ArrayList<Object>();
		for (OrderSetExt orderSetExt : service.getOrderSets(false)) {
			objects.add(orderSetExt);
		}
		
		response.put("objects", objects);
		return response;
	}
}
