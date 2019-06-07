package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;
import com.qa.util.JSONUtil;

@Alternative
public class TraineeMapRepository {
	
	private Map<Integer, Trainee> traineeMap = new HashMap<Integer, Trainee>();
	
	@Inject
	JSONUtil j1;

	public Map<Integer, Trainee> getTraineeMap() {
		return traineeMap;
	}

	
	public String getAllTrainees() {
		return j1.getJSONForObject(traineeMap.values());
	}
	
	public String deleteTrainee(int traineeId) {
		traineeMap.remove(traineeId);
		return "Trainee successfully deleted";
	}
	
	public String updateTrainee(int traineeId, Trainee Trainee) {
		traineeMap.replace(traineeId, Trainee);
		return "Trainee successfully updated";
	}
	
	public String createTrainee(String trainee) {
		Trainee trainee1= j1.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(trainee1.getTraineeId(), trainee1);
		return "Trainee was successfully created";
		}

}
