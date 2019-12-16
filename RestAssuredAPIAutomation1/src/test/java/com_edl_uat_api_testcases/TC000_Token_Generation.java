package com_edl_uat_api_testcases;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.edlapi.utilities.RestUtils;

import Lib.XLUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC000_Token_Generation {

	@Test
	void RegisteredSuccesful() throws Exception
	{
		//specify base url
		String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
		//XLUtil.setExcelFile("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
		RestAssured.baseURI="https://login.microsoftonline.com/c73bf3ef-87e9-48e0-ac85-9c723e6cca39/oauth2/token";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		
		
		//Request Payload sending along with post request
		
		String s2="token";
		
	 httprequest.header("Content-Type","application/x-www-form-urlencoded")
	 .body("grant_type=client_credentials&client_id=3970a694-5223-484f-9e24-620290006620&client_secret=8zPS05UuC8q=gMBd[ZFxY]eVsNsZ-Q12");
		
		//httprequest.body(requestParams.toJSONString());
		
		
		//Response object
		Response response=httprequest.request(Method.POST);
		
		String responsebody=response.getBody().asString();
		System.out.println("response body is:"+responsebody);
		
		int statuscode=response.getStatusCode();
		System.out.println("status code is:"+statuscode);
		
		if(statuscode==200) {
			
			String s5=s2+RestUtils.empName();
			XLUtil.setCellData(path, "Token", 1, 1, responsebody);
			try {
				
				PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"_Extract.json"));
				out.print(responsebody);
				out.flush();
				out.close();
			}
			
			catch(Exception e) {
				System.out.println("no file found");
			}
			XLUtil.setCellData(path, "Token", 1, 2, "C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"_Extract.json");
		}else {
				XLUtil.setCellData(path, "Token", 1, 0, "404 Error");
			}
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader(XLUtil.getCellData(path, "Token", 1, 2)));
		JSONObject jsonObject = (JSONObject) obj;
		
		String access_token = (String) jsonObject.get("access_token");
		XLUtil.setCellData(path, "Token", 1, 3, access_token);
		
	}
}
