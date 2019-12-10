import org.testng.annotations.Test;

import Lib.XLUtil;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import junit.framework.Assert;

public class GET_Request4 {
	@Test
	
	//to verify the json body response and extract each node and print this example contains the code
	public void GET_WeatherDetails() throws Exception
	{
		//specify base url
		
	Response response;
				
	String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\API_Test_Cases.xlsx";
	XLUtil.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
	String s1=XLUtil.getCellData(path, "Sheet1", 3, 2);
	String s2=XLUtil.getCellData(path, "Sheet2", 1, 0);
	
	String s3=s1+s2;
	
	response=RestAssured.given().header("x-api-key","sXbHNF3oQjatjqg8CoeyvBqGbBjTzlf8Y50LAzpc")
			.when().get(s3)
			.then().extract().response();
				
				
	String responseBody=response.getBody().asString();
	System.out.println("Reponse body is:"+responseBody);
				
	int statusCode=response.getStatusCode();
	System.out.println("status code is"+statusCode);
	Assert.assertEquals(statusCode, 200);
				
				
}
}