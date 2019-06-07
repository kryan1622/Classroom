package com.qa.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;
import com.qa.persistence.repository.TraineeMapRepository;


public class TraineeTesting {
	
	private TraineeMapRepository tmr;
	private Trainee train1;
	private Trainee train2;



@Before 
public void setup() {
tmr = new TraineeMapRepository();
train1 = new Trainee(1,"Joe Bloggs");
train2 = new Trainee(2,"Jane Bloggs");

}

@Ignore
@Test
public void addTraineeTest() {
tmr.createTrainee("{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}");
assertEquals("Joe Bloggd", tmr.getTraineeMap().get(1).getTraineeName());
}

@Ignore
@Test
public void add2TraineesTest() {
	tmr.createTrainee("{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}");
	tmr.createTrainee("{\"traineeId\":2,\"traineeName\":\"Jane Bloggs\"}");
	assertEquals(2, tmr.getTraineeMap().size());
	assertEquals("Matt Hunt", tmr.getTraineeMap().get(1).getTraineeName());
}


@Test
public void removeTraineeTest() {

	tmr.getTraineeMap().put(1, train1);
	tmr.deleteTrainee(1);
	assertEquals(0, tmr.getTraineeMap().size());
}


@Test
public void remove2TraineesTest() {

	tmr.getTraineeMap().put(1, train1);
	tmr.getTraineeMap().put(2, train2);
	tmr.deleteTrainee(1);
	tmr.deleteTrainee(2);
	assertEquals(0, tmr.getTraineeMap().size());
}

@Test
public void remove2TraineesAnd1ThatDoesntExistTest() {

	tmr.getTraineeMap().put(1, train1);
	tmr.getTraineeMap().put(2, train2);
	tmr.deleteTrainee(1);
	tmr.deleteTrainee(2);
	tmr.deleteTrainee(3);
	assertEquals(0, tmr.getTraineeMap().size());
}

}