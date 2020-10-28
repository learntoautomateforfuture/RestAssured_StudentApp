package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.base.TestBase;
import com.studentapp.model.StudentAppPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _9_PatchRequest extends TestBase {

	@DisplayName("PatchRequest: Update email address for a specific student")
	@Test
	public void patchEmailAddress() {
		Faker fake = new Faker();
		StudentAppPojo student = new StudentAppPojo();
		student.setEmail(fake.internet().emailAddress());
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/104")
		.then()
		.statusCode(200);
	}
}
