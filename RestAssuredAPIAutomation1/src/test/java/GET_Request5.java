import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GET_Request5 {
	@Test
	
	//to verify the json body response and extract each node and print this example contains the code
	public void AutherizationTest()
	{
		//specify base url
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		PreemptiveBasicAuthScheme  authscheme= new PreemptiveBasicAuthScheme();
		
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
		 
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/");
		
		
		String responseBody=response.getBody().asString();
		System.out.println("Reponse body is:"+responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
	
		
}}