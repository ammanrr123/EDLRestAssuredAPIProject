import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request {

	@Test
	void RegisteredSuccesful()
	{
		//specify base url
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		
		
		//Request Payload sending along with post request
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("FirstName", "JakaohnXYZ1");
		requestParams.put("LastName", "jaXYZJohn1");
		requestParams.put("UserName", "JakkaassaahnXYZ1");
		requestParams.put("Password", "JohnXYZxyz");
		requestParams.put("Email", "JaksaabeakkaXYZ1xyz@gmail.com");
		
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParams.toJSONString());
		
		
		//Response object
		Response response=httprequest.request(Method.POST,"/register");
		
		String responsebody=response.getBody().asString();
		System.out.println("response body is:"+responsebody);
		
		int statuscode=response.getStatusCode();
		System.out.println("status code is:"+statuscode);
		
		Assert.assertEquals(statuscode, 201);
		
		
		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
	}
}