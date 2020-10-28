package com.studentapp.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class _2_PassingQueryParam {

	@DisplayName("QueryParam: Get a specific student detail ")
	@Test
	public void passingQueryParam() {
		Response response = RestAssured.given()
				.queryParam("programme","Mechanical Engineering")
				.queryParam("limit","2")
				.when()
				.get("http://localhost:8080/student/list");
		response.prettyPrint();
	}
	
	@DisplayName("QueryParams: Get a specific student detail")
	@Test
	public void passingQueryParams() {
		Response response = RestAssured.given()
				.queryParams("programme","Mechanical Engineering","limit","2")
				.when()
				.get("http://localhost:8080/student/list");
		response.prettyPrint();
	}
	
	@DisplayName("ParamAsMap: Get a specific student detail")
	@Test
	public void passingQueryParamsAsMap() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("programme","Mechanical Engineering");
		params.put("limit","2");
		
		Response response = RestAssured.given()
				.queryParams(params)
				.when()
				.get("http://localhost:8080/student/list");
		response.prettyPrint();
	}

}
