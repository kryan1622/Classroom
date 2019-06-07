package com.qa.persistence.repository;

	import static javax.transaction.Transactional.TxType.REQUIRED;
	import static javax.transaction.Transactional.TxType.SUPPORTS;
	import javax.inject.Inject;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.transaction.Transactional;
	import com.qa.persistance.domain.Classroom;
	import com.qa.util.JSONUtil;


	@Transactional(SUPPORTS)
	public class ClassroomDatabaseRepository implements ClassroomRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil j1;

		@Transactional(SUPPORTS)
		@Override
		public String findClassroom(int classroomId) {
			return j1.getJSONForObject(manager.find(Classroom.class, classroomId));
		}

	}

