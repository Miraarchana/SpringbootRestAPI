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
	private CourseRepository topicRepository;
	
	public List<Course> getAllTopics(){
//		return topics;
		List<Course> topics = new ArrayList<Course>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Course> getTopic(String id) {
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}
	
	public void addTopic(Course topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Course topic, String id) {
		/*for(int i=0; i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}*/
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
//		topics.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}
