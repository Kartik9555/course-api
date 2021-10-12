package io.javabrains.courseapi.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

	public Topic findByName(String name);
	public List<Topic> findAllByCourseId(Integer id);
	
}
