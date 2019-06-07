package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService{
	
	@Inject
	private TraineeRepository repo;

	@Override
	public String findTrainee(int traineeId) {
		return repo.findTrainee(traineeId);
	}

	@Override
	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}
	
	

}
