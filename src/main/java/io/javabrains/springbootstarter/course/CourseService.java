package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Business Service @Service - marks the class as Spring Business Service
 * Spring creates an instance of this service and lets other application to use it.
 * Singleton
 */
@Service
public class CourseService {
	
//	private List<Topic> topics =new ArrayList<>(Arrays.asList( // this creates a immutable list(we cant modify) by making a copy as
//			//arraylist we can modify
//			new Topic("spring","Spring Framework","Spring Framework Description")
//			,new Topic("java","Core Java","Core Java Description")
//				,new Topic("javascript","Java Script","JS Description")));
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
//		return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);//fetch list of courses for specific topicId
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course course) {
//		topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		/*for(int i=0; i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}*/
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
//		topics.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(id);
	}

}
