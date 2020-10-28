package com.studentapp.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.studentapp.base.TestBase;
import com.studentapp.model.StudentAppPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _6_PayloadAsObject extends TestBase {
	
	@DisplayName("PayloadAsAnObject: Post request with payload as an object")
	@Test
	public void payloadAsAnObject() {
		List<String> courses = new ArrayList<String>();
		courses.add("DBMS");
		courses.add("Java Programming");
		
		StudentAppPojo student = new StudentAppPojo();
		student.setFirstName("Alex");
		student.setLastName("Thomas");
		student.setEmail("alex.thom@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
	}
}
