package com.qa.rest;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/Trainee")
public class TraineeController {
	
	@Inject
	private TraineeService service;
	
	@Path("/findTrainee/{traineeId}")
	@GET
	@Produces({"application/json"})
	public String findTrainee(@PathParam("traineeId") int traineeId) {
		return service.findTrainee(traineeId);
	}

}
