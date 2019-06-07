package com.qa.persistence.repository;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.qa.persistance.domain.Classroom;

import com.qa.util.JSONUtil;


@Alternative
public class ClassroomMapRepository {

	
	private Map<Integer, Classroom> classroomMap = new HashMap<Integer, Classroom>();
	
	@Inject 
	JSONUtil j1;
	
	
	public Map<Integer, Classroom> getClassroomMap() {
		return classroomMap;
	}

	public String getAllClassrooms() {
		return j1.getJSONForObject(classroomMap.values());
	}
	
	
	public String createClassroom(String classroom) {
	Classroom class1= j1.getObjectForJSON(classroom, Classroom.class);
	classroomMap.put(class1.getClassroomId(), class1);
	return "Classroom was successfully created";
	}
	
	public String deleteClassroom(int classroomId) {
		classroomMap.remove(classroomId);
		return "Classroom successfully deleted";
	}

	
	public String updateClassroom(int classroomId, Classroom Classroom) {
		classroomMap.replace(classroomId, Classroom);
		return "Classroom successfully updated";
	}

}
