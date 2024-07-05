package com.firstTest;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class OrganicProject {
	//@Test
	
	public void HomeApiTest() {
		
		Response response = get("http://localhost:3000/");
		  System.out.println(response.getStatusCode());
		  System.out.println(response.getTime());
		  System.out.println(response.getBody().asString());
		  System.out.println(response.getStatusLine());
		  System.out.println(response.getHeader("content-type"));
		  
		  int statuscode = response.getStatusCode();
		  Assert.assertEquals(statuscode,200);
	}

	@Test
	 public void UserApiTest()
	  {
		  baseURI = "http://localhost:8888";
		  given().get("/foodMenu/3").then().statusCode(200).body("id",equalTo("3")).log().all();
		 // given().get("/users?page=2").then().statusCode(200).body("data[1].email",equalTo("lindsay.ferguson@reqres.in"));
		  
		
	  }
}

