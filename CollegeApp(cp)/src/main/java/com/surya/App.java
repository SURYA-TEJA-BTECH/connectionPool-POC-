package com.surya;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.surya.config.Config;
import com.surya.service.IstudentServiceImpl;


public class App {
	public static void main(String[] args) {
		
		
		//container creation
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		IstudentServiceImpl college = context.getBean(IstudentServiceImpl.class);
		try {
			System.out.println(college.getStudentsCount());
		} catch (Exception e) {
			System.out.println("some problem try again");
			e.printStackTrace();
		}
		
		
		// closing container ( destroying all beans in the container)
		context.close();
	}
}
