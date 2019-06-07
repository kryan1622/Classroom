package com.qa.persistence.repository;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;
import com.qa.util.JSONUtil;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional(SUPPORTS)
public class TraineeDatabaseRepository implements TraineeRepository{

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil j1;
	
	@Override
	@Transactional(SUPPORTS)
	public String findTrainee(int traineeId) {
		return j1.getJSONForObject(manager.find(Trainee.class, traineeId));
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
    Trainee aTrainee = j1.getObjectForJSON(trainee, Trainee.class);
    manager.persist(aTrainee);
    return "{\"message\": \"Trainee has been successfully added\"}";
	}
	
	@Override 
	@Transactional(REQUIRED)
	public String deleteTrainee(int traineeId) {
		Trainee trainee = manager.find(Trainee.class, traineeId);

        if (manager.contains(trainee)) {
            manager.remove(trainee);
            return "{\"message\": \"Account sucessfully deleted " + traineeId + " \"}";
        }
        return "{\"message\": \"No account found with this id.\"}";
	}
	
	@Override
	@Transactional(SUPPORTS)
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT a FROM Trainee");
		return j1.getJSONForObject(query.getResultList());
	}
	
	public String updateTrainee(int traineeId, String trainee) {
		Trainee traineeDetails = j1.getObjectForJSON(trainee, Trainee.class);
		Trainee oldTrainee = manager.find(Trainee.class, trainee);
		if (oldTrainee != null) {
			oldTrainee.setTraineeName(traineeDetails.getTraineeName());
			manager.persist(oldTrainee);
			}
		
		 return "{\"message\": \"Trainee sucessfully updated\"}"; 
		
		}
	}
	
		
