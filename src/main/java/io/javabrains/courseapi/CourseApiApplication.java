package io.javabrains.courseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class CourseApiApplication implements ApplicationListener<ContextRefreshedEvent> {

	public static void main(String[] args) {
		System.out.println("Main method execution in process...");
		SpringApplication.run(CourseApiApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Application Listener method execution in process...");
	}
}
