package com.qa.persistence.repository;

public interface ClassroomRepository{
	
	String findClassroom(int classroomId);
	String createClassroom(String classroom);
	String deleteClassroom(int classroomId);

}
