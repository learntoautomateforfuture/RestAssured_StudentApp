package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class _3_PathVariable {

	@DisplayName("PathVariable: Get a specific student detail by ID")
	@Test
	public void usingPathVariable() {
		Response response = RestAssured.given()
				.when()
				.get("http://localhost:8080/student/3");
		response.prettyPrint();
	}
	
	@DisplayName("PathVariable with <K,V>: Get a specific student detail by ID")
	@Test
	public void usingPathVariableUsingKV() {
		
		Response response = RestAssured.given()
				.pathParam("id", 2)
				.when()
				.get("http://localhost:8080/student/{id}");
		response.prettyPrint();
	}
}
