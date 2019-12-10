import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request_Demo {

	@Test
	void getshareclassdetails()
	{
		//specify base url
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/hyderabad");
		
		String responsebody=response.getBody().asString();
		System.out.println("response body is:"+responsebody);
		
		int statuscode=response.getStatusCode();
		System.out.println("status code is:"+statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		String statusLine=response.getStatusLine();
		
		System.out.println("Status line is:"+statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
