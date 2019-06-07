package com.qa.rest;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@Path("/createTrainee")
	@POST
	@Produces({"application/json"})
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
	
	@Path("/deleteTrainee{TraineeId}")
	@DELETE
	@Produces({"application/json"})
	public String deleteTrainee(@PathParam("traineeId") int traineeId) {
		return service.deleteTrainee(traineeId);
	}

}
