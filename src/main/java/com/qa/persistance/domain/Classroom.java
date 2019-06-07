package com.qa.persistance.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int classroomId;
	@Column(length=200)
	private String trainerName;
	
	public Classroom() {
		
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Classroom(int classroomId, String trainerName) {
		super();
		this.classroomId = classroomId;
		this.trainerName = trainerName;
	}
	
	

}
