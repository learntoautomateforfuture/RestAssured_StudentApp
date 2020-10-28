package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.studentapp.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _5_PostReq_PayloadUsage extends TestBase {

	@DisplayName("PostReq_PayloadUsage: Create a new Student detail")
	@Test
	public void postReqPayloadUsage() {
		String payload ="{\"firstName\":\"Preethi\",\"lastName\":\"Rajaram\",\"email\":\"pr@gmail.com\",\"programme\":\"Artificial Intelligence\",\"courses\":[\"Scala\",\"Calculus & Linear Algebra I \"]}";

		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post()
		.then()
		.statusCode(201);
	}

}
