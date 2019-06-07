package com.qa.business.service;

public interface TraineeService {
	
	String findTrainee(int traineeId);
	String createTrainee(String trainee);
	String deleteTrainee(int traineeId);
	String getAllTrainees();
	String updateTrainee(int classId,String trainee);

}
