package io.javabrains.courseapi.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){
		List<Course> courseList =new ArrayList<>();
		courseRepository.findAll().forEach(courseList::add);
		return courseList;
	}
	
	public Course getCourse(Integer id) {
		return courseRepository.findById(id).get();
	}

	public Course saveCourse(Course course) {
		System.out.println(course);
		return courseRepository.save(course);
	}

	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}

}
