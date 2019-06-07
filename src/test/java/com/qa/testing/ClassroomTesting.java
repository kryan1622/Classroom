package com.qa.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistance.domain.Classroom;
import com.qa.persistence.repository.ClassroomMapRepository;

public class ClassroomTesting {
	
	private ClassroomMapRepository cmp;
	private Classroom class1;
	private Classroom class2;
	
	@Before
	public void setup() {
	cmp = new ClassroomMapRepository();
	class1 = new Classroom(1, "Matt Hunt");
	class2 = new Classroom(2, "Chester Gardner");
	}
	
	@Test
	public void addClassroomTest() {
	cmp.createClassroom("{\"classroomId\":1,\"trainerName\":\"Matt Hunt\"}");
	assertEquals("Matt Hunt", cmp.getClassroomMap().get(1).getTrainerName());
	}
	
	
	@Test
	public void add2ClassroomTest() {
		cmp.createClassroom("{\"classroomId\":1,\"trainerName\":\"Matt Hunt\"}");
		cmp.createClassroom("{\"classroomId\":1,\"trainnerName\":\"Chester Gardner\"}");
		assertEquals(2, cmp.getClassroomMap().size());
		assertEquals("Matt Hunt", cmp.getClassroomMap().get(1).getTrainerName());
	}
	
	
	@Test
	public void removeClassroomTest() {

		cmp.getClassroomMap().put(1, class1);
		cmp.deleteClassroom(1);
		assertEquals(0, cmp.getClassroomMap().size());
	}
	
	
	@Test
	public void remove2ClassroomsTest() {

		cmp.getClassroomMap().put(1, class1);
		cmp.getClassroomMap().put(2, class2);
		cmp.deleteClassroom(1);
		cmp.deleteClassroom(2);
		assertEquals(0, cmp.getClassroomMap().size());
	}
	
	@Test
	public void remove2ClassroomsAnd1ThatDoesntExistTest() {

		cmp.getClassroomMap().put(1, class1);
		cmp.getClassroomMap().put(2, class2);
		cmp.deleteClassroom(1);
		cmp.deleteClassroom(2);
		cmp.deleteClassroom(3);
		assertEquals(0, cmp.getClassroomMap().size());
	}

}
