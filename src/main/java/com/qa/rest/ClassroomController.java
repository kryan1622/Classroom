package com.qa.rest;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/Classroom")
public class ClassroomController {

	@Inject
	private ClassroomService service;
	
	@Path("/findClassroom/{classroomId}")
	@GET
	@Produces({"application/json"})
	public String findClassroom(@PathParam("classroomId") int classroomId) {
		return service.findClassroom(classroomId);
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({"application/json"})
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/deleteClassroom{classroomId}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClassroom(@PathParam("classroomId") int classroomId) {
		return service.deleteClassroom(classroomId);
	}
	
	
	@Path("/getAllClassroom")
	@GET
	@Produces({"application/json"})
	public String getAllClassroom() {
		return service.getAllClassroom();
	}
	
}
