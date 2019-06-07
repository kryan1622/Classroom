package com.qa.persistence.repository;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import com.qa.persistance.domain.Trainee;
import com.qa.util.JSONUtil;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional(SUPPORTS)
public class TraineeDatabaseRepository implements TraineeRepository{

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil j1;
	
	@Override
	public String findTrainee(int traineeId) {
		return j1.getJSONForObject(manager.find(Trainee.class, traineeId));
	}
		
}