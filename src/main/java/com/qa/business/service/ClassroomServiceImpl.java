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

}