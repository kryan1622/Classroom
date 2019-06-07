package com.qa.persistence.repository;

	import static javax.transaction.Transactional.TxType.REQUIRED;
	import static javax.transaction.Transactional.TxType.SUPPORTS;
	import javax.inject.Inject;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
	import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;
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

		@Override
		@Transactional(REQUIRED)
		public String createClassroom(String classroom) {
			Classroom aClassroom = j1.getObjectForJSON(classroom, Classroom.class);
	        manager.persist(aClassroom);
	        return "{\"message\": \"Classroom has been successfully added\"}";	
		}
		
		@Override 
		@Transactional(REQUIRED)
		public String deleteClassroom(int classroomId) {
			Classroom classroom = manager.find(Classroom.class, classroomId);

	        if (manager.contains(classroom)) {
	            manager.remove(classroom);
	            return "{\"message\": \"Account sucessfully deleted " + classroomId + " \"}";
	        }
	        return "{\"message\": \"No account found with this id.\"}";
		}
		
		@Override
		@Transactional(SUPPORTS)
		public String getAllClassrooms() {
			Query query = manager.createQuery("SELECT a FROM Classroom");
			return j1.getJSONForObject(query.getResultList());
		}
		
		
		public String updateClassroom(int classroomId ,String classroom) {
			Classroom classroomDetails = j1.getObjectForJSON(classroom, Classroom.class);
			Classroom oldClassroom = manager.find(Classroom.class, classroom);
			if (oldClassroom!= null) {
				oldClassroom.setTrainerName(classroomDetails.getTrainerName());
				manager.persist(oldClassroom);
			}
			return "{\"message\": \"Trainee sucessfully updated\"}"; 
		}
		
		
		
		}

	

