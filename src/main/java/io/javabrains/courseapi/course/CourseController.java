package io.javabrains.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService; 

	@ApiOperation(value = "View a list of all the available courses", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrived the list of courses"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/course", method=RequestMethod.GET)
	public List<Course> getCourses(){
		return courseService.getAllCourses();
	}
	
	@ApiOperation(value = "View a course by course id", response = Course.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrived the course"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/course/{id}", method=RequestMethod.GET)
	public Course getCourse(@PathVariable("id") Integer id){
		return courseService.getCourse(id);
	}
	
	@ApiOperation(value = "Add a course", response = Course.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully saved courses"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/course", method=RequestMethod.POST)
	public Course saveCourse(@RequestBody Course course){
		return courseService.saveCourse(course);
	}

	@ApiOperation(value = "Update a courses", response = Course.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated the courses"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/course/{id}", method=RequestMethod.PUT)
	public Course updateCourse(@PathVariable("id") Integer id, @RequestBody Course course){
		return courseService.updateCourse(course);
	}

	@ApiOperation(value = "Delete a courses by course id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrived the list of courses"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/course/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") Integer id){
		courseService.deleteCourse(id);
	}
	
}
