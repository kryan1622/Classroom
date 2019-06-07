package com.qa.business.service;

public interface ClassroomService {
	
	String findClassroom(int classroomId);
	String createClassroom(String classroom);
	String deleteClassroom(int classroomId);

}
