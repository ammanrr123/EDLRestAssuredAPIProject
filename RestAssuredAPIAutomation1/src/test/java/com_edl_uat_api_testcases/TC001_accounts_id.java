package com_edl_uat_api_testcases;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.edlapi.utilities.RestUtils;

import Lib.XLUtil;
import com_edl_api_testing.TestBase;
import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;

//import com_edl_api_testing.TestBase;
public class TC001_accounts_id extends TestBase {
	String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
	@BeforeClass
	void getallaccounts() throws Exception
	{
		logger.info("*******Started TC001_getaccounts_id*****");
		//Response response;
		
		String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
		
		
		String s1=XLUtil.getCellData(path, "All_APIs", 3, 2);
		String s4=XLUtil.getCellData(path, "All_APIs", 3, 3);
		int totalNoOfRows=XLUtil.getRowCount(path, "Account_APIs");
		
		for(int row=1;row<=totalNoOfRows;row++) 
		
		{
		String s2=XLUtil.getCellData(path, "Account_APIs", row, 0);
		
		String s3=s1+s2+s4;
		
		String token=XLUtil.getCellData(path, "Token", 1, 3);
		response=RestAssured.given().header("Authorization","Bearer "+token)
				.when().get(s3)
				.then().extract().response();
		
		String responseBody=response.getBody().asString();
		//System.out.println("Reponse body is:"+responseBody);
		Assert.assertTrue(responseBody!=null);
		String responseString=response.asString();
			
		XLUtil.setCellData(path, "Account_APIs", row, 2, responseString);
					
		int statusCode=response.getStatusCode();
		System.out.println("status code is"+statusCode);
		//Assert.assertEquals(statusCode, 200);
		if(statusCode==200) {
		
			String s5=s2+RestUtils.empName();
			String s6="C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"_Account.json";
		XLUtil.setCellData(path, "Account_APIs", row, 2, responseString);
		try {
			
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"_Account.json"));
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}
		XLUtil.setCellData(path, "Account_APIs", row,6, s6);
		}else {
			XLUtil.setCellData(path, "Account_APIs", row, 2, statusCode+"Error");
		}
		Thread.sleep(3000);
		}
	}
	@Test
	void checkResponseBody()
	{
		logger.info("********Checking Reponse Body*****");
		
		String responseBody=response.getBody().asString();
		logger.info("Reponse body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("********Checking status code********");
		int statuscode=response.getStatusCode();
		logger.info("Status code is--"+statuscode);
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	void ExtractallData() throws IOException {
		logger.info("********Extracting all parameters from response*******");
		String responseString=response.asString();
	
		try {
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\abc1.json"));
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}
		
		
	}
	@AfterClass
	void tearDown(){
		logger.info("**********Finished TC001_getaccounts_id****");
	}
}
