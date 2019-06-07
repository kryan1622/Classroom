package com.qa.persistance.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int traineeId;
	@Column(length=200)
	private String traineeName;
	
	public Trainee() {
		
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Trainee(int traineeId, String traineeName) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
	}

	

}
