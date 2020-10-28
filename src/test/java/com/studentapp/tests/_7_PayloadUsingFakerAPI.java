package com.studentapp.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.base.TestBase;
import com.studentapp.model.StudentAppPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _7_PayloadUsingFakerAPI extends TestBase {

	@DisplayName("FakePayload: Post request with payload as an object")
	@Test
	public void fakePayloadAsAnObject() {
		Faker fake = new Faker();
		
		List<String> courses = new ArrayList<String>();
		courses.add("DBMS");
		courses.add("Java Programming");
		
		StudentAppPojo student = new StudentAppPojo();
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
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
