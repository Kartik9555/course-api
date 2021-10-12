package io.javabrains.courseapi.topic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.javabrains.courseapi.course.Course;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Topic")
public class Topic {

	@ApiModelProperty(name = "ID", notes = "The id of the topic",position = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@ApiModelProperty(name = "Name", notes = "The name of the topic",position = 2)
	private String name;
	
	@ApiModelProperty(name = "Description", notes = "The description of the topic",position = 3)
	private String description;
	
	@ManyToOne
	private Course course;
	
	public Topic() {
		
	}
	
	public Topic(Integer id, String name, String description, Integer courseId) {
		this.id = id;
		this.name = name;
		this.description = description;
		course=new Course(courseId, "", null);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Topic [name=" + name + ", description=" + description + "]";
	}
	
	
}
