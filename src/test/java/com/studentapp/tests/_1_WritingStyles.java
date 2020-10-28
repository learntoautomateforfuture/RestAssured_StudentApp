package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class _1_WritingStyles {

	@DisplayName("Style1: Get all the student details from the DB")
	@Test
	void getAllStudents() {		
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get("http://localhost:8080/student/list");
		response.prettyPrint();
		ValidatableResponse validateableRes = response.then();
		validateableRes.statusCode(200);	
	}

	@DisplayName("ReadableFormat: Get all the student details from the DB")
	@Test
	void getAllStudents_ReadableFormat() {
		RestAssured.given()
		.when()
		.get("http://localhost:8080/student/list")
		.then()
		.statusCode(200);

		RestAssured.given()
		.expect()
		.statusCode(200)
		.when()
		.get("http://localhost:8080/student/list");

	}

}
