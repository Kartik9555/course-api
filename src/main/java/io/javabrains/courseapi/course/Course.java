package io.javabrains.courseapi.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="COURSES")
public class Course {

	public Course(Integer id, String name, Integer durationInDays) {
		super();
		this.id = id;
		this.name = name;
		this.durationInDays = durationInDays;
	}

	public Course(Integer id, String name, Integer durationInDays, Integer instructorId) {
		super();
		this.id = id;
		this.name = name;
		this.durationInDays = durationInDays;
		this.instructorId = instructorId;
	}

	@ApiModelProperty(name = "ID", notes = "The id of the course",position = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	@ApiModelProperty(name = "Name", notes = "The name of the course",position = 2)
	@Column(name="NAME")
	private String name;
	
	@ApiModelProperty(name = "Duration In Days", notes = "The duration of the course",position = 3)
	@Column(name="DURATION_IN_DAYS")
	private Integer durationInDays;
	
	@ApiModelProperty(name = "Instructor Id", notes = "The instructor of the course",position = 4)
	@Column(name="INSTRUCTOR_ID")
	private Integer instructorId;
	
	public Course() {
		
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

	public Integer getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(Integer durationInDays) {
		this.durationInDays = durationInDays;
	}

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}	
	
}
