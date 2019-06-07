package com.qa.persistence.repository;

public interface TraineeRepository {
	
	
	String findTrainee(int traineeId);
	String createTrainee(String Trainee);
	String deleteTrainee(int traineeId);
	String getAllTrainees();
	String updateTrainee(int classroomId, String classroom);

}
