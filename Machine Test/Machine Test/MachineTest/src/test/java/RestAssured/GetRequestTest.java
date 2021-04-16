package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetRequestTest {
	String api="https://corona.lmao.ninja/v2/continents?yesterday=true&sort";
	@Test
	public void getRequest() {
		try {
			Response response= given()
			        .when()
			        .get("https://corona.lmao.ninja/v2/continents?yesterday=true&sort")
			        .then().assertThat().log().all()
			        .statusCode(200).and()
			         .extract().response();
			
				System.out.println(response.getStatusCode());
				System.out.println(response.getStatusLine());
				System.out.println(response.getContentType());
				System.out.println(response.getTime());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
