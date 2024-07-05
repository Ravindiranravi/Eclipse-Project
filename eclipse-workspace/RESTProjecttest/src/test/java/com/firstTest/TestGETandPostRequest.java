package com.firstTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.AbstractDocument.Content;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestGETandPostRequest {

	//@Test

	public void GETRequest()

	{

		//1st Validation by ID

		baseURI = "https://reqres.in/api";

		given().get("/unknown").then().statusCode(200).body("data[1].id", equalTo(2)).log().all();

		

		//2nd validation by name

		given().get("/unknown").then().statusCode(200).body("data[1].name", equalTo("fuchsia rose")).

		body("data[1].id",equalTo(2)).log().all();

	}
	
	//@Test
	public void GETRequest2() {
		
		//3rd validation by group
		
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data.firstname",hasItems("Lindsay","Tobias")).log().all();
				
	}

	@Test
	public void POStRequest()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		JSONObject request = new JSONObject(map);
        
		request.put("name","Ravindiran");
        request.put("job","Software Developer");
        
        System.out.println(request.toJSONString());
        
        baseURI = "https://reqres.in/api";
        given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
        body(request.toJSONString()).post("/users").then().statusCode(201).log().all();
	}
	
	
}

