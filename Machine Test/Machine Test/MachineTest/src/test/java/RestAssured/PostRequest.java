package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRequest {

	@Test
	public void postReq() {
		JSONObject data= new JSONObject();
		
		data.put("Name", "Hitesh Valechha");
		data.put("Job", "Automation Tester");
		
		 given().body(data.toJSONString())
		 .header("Content-type","application/json")
		.post("https://reqres.in/api/users")
		.then().statusCode(201);
		
		System.out.println();
	}
	

}
