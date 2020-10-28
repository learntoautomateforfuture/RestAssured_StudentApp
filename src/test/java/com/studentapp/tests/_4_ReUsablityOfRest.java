package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.studentapp.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class _4_ReUsablityOfRest extends TestBase{
	
	@DisplayName("ReUsablityOfRest: Get a specific student detail ")
	@Test
	public void passingQueryParam() {
		Response response = RestAssured.given()
				.queryParam("programme","Mechanical Engineering")
				.queryParam("limit","2")
				.when()
				.get("/list");
		response.prettyPrint();
	}
	
	@DisplayName("ReUsablityOfRest: Get a specific student detail by ID")
	@Test
	public void usingPathVariableUsingKV() {
		
		Response response = RestAssured.given()
				.pathParam("id", 2)
				.when()
				.get("/{id}");
		response.prettyPrint();
	}

}
