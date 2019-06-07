package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService{
	
	@Inject
	private ClassroomRepository repo;
	

	@Override
	public String findClassroom(int classroomId) {
		return repo.findClassroom(classroomId);
	}


	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
		

}


	@Override
	public String deleteClassroom(int classroomId) {
	return repo.deleteClassroom(classroomId);
}


	@Override
	public String getAllClassroom() {
		return repo.getAllClassrooms();
	}


	@Override
	public String updateClassroom(int classroomId, String classroom) {
		return repo.updateClassroom(classroomId, classroom);
	}
}