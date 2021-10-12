package io.javabrains.courseapi.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.courseapi.course.Course;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService courseService; 

	@RequestMapping(value="/course/{courseId}/topic", method=RequestMethod.GET)
	public List<Topic> getTopics(@PathVariable("courseId") Integer courseId){
		return courseService.getAllTopics();
	}
	
	@RequestMapping(value="/course/{courseId}/topic/{topicId}", method=RequestMethod.GET)
	public Topic getTopic(@PathVariable("courseId") Integer courseId, @PathVariable("topicId") Integer topicId){
		return courseService.getTopic(topicId);
	}
	
	@RequestMapping(value="/course/{courseId}/topic", method=RequestMethod.POST)
	public Topic saveTopic(@RequestBody Topic topic, @PathVariable("courseId") Integer courseId){
		Course course=new Course(courseId, "", null);
		topic.setCourse(course);
		return courseService.saveTopic(topic);
	}
	
	@RequestMapping(value="/course/{courseId}/topic/{topicId}", method=RequestMethod.PUT)
	public Topic updateTopic(@PathVariable("courseId") Integer courseId, @PathVariable("topicId") Integer topicId, @RequestBody Topic topic){
		return courseService.updateTopic(topic);
	}
	
	@RequestMapping(value="/course/{courseId}/topic/{topicId}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("courseId") Integer courseId, @PathVariable("topicId") Integer topicId){
		courseService.deleteTopic(topicId);
	}
	
	@RequestMapping(value="/course/{courseId}/allTopics", method=RequestMethod.GET)
	public List<Topic> getTopicsByCourseId(@PathVariable("courseId") Integer courseId){
		return courseService.getTopicsByCourseId(courseId);
	}
	
}
