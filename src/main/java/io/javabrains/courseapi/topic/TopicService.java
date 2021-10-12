package io.javabrains.courseapi.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList =new ArrayList<>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}
	
	public Topic getTopic(Integer id) {
		return topicRepository.findById(id).get();
	}

	public Topic saveTopic(Topic topic) {
		System.out.println(topic);
		return topicRepository.save(topic);
	}

	public Topic updateTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public void deleteTopic(Integer id) {
		topicRepository.deleteById(id);
	}

	public List<Topic> getTopicsByCourseId(Integer courseId) {
		return topicRepository.findAllByCourseId(courseId);
	}

}
