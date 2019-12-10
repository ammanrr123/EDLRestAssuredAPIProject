import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request3 {
	@Test
	
	//to verify the json body response this example contains the code
	public void GET_WeatherDetails()
	{
		//specify base url
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/hyderabad");
		
		String responsebody=response.getBody().asString();
		System.out.println("response body is:"+responsebody);
		
		Assert.assertEquals(responsebody.contains("Hyderabad"), true);
}
}