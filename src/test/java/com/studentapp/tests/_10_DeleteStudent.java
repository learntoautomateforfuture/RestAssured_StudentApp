package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.studentapp.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _10_DeleteStudent extends TestBase {

	@DisplayName("DeleteRequest: Delete a student")
	@Test
	public void deleteStudent() {
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.delete("/104")
		.then()
		.statusCode(204);
	}
}
