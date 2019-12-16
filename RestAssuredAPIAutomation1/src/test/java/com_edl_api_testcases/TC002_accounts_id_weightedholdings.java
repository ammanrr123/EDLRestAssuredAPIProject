package com_edl_api_testcases;

//import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
//import java.util.List;

//import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.edlapi.utilities.RestUtils;

import Lib.XLUtil;
import com_edl_api_testing.TestBase;
import io.restassured.RestAssured;
//import io.restassured.mapper.ObjectMapper;

public class TC002_accounts_id_weightedholdings extends TestBase {
	
	String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases.xlsx";
	@BeforeClass
	void accounts_id_weightedholdings() throws Exception
	{
		logger.info("*******Started TC002_accounts_id_weightedholdings*****");
		//Response response;
		
		String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases.xlsx";
		XLUtil.setExcelFile("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
		String s1=XLUtil.getCellData(path, "Sheet1", 4, 2);
		String s3=XLUtil.getCellData(path, "Sheet1", 4, 3);
		
		int totalNoOfRows=XLUtil.getRowCount(path, "Sheet2");
		for(int row=1;row<=totalNoOfRows;row++) 
			
		{
		String s2=XLUtil.getCellData(path, "Sheet2", row, 0);
		//String s2=XLUtil.getCellData(path, "Sheet2", 1, 0);
		
		String s4=s1+s2+s3;
		
		response=RestAssured.given().header("x-api-key","sXbHNF3oQjatjqg8CoeyvBqGbBjTzlf8Y50LAzpc")
				.when().get(s4)
				.then().extract().response();
		

		String responseBody=response.getBody().asString();
		System.out.println("Reponse body is:"+responseBody);
		Assert.assertTrue(responseBody!=null);
		String responseString=response.asString();
		
		
					
		int statusCode=response.getStatusCode();
		
					
		System.out.println("status code is"+statusCode);
		//Assert.assertEquals(statusCode, 200);
		if(statusCode==200) {
			
			XLUtil.setCellData(path, "Sheet2", row, 3, responseString);
		try {
			String s5=s2+RestUtils.empName();
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\"+s5+"_Weightedholdings.json"));
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}}else {
			XLUtil.setCellData(path, "Sheet2", row, 3, "404 Error");
		}
		Thread.sleep(3000);
	}}
	
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
	void ExtractallData() throws Exception {
		logger.info("********Extracting all parameters from response*******");
		String responseString=response.asString();
		/*String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases.xlsx";
		XLUtil.setExcelFile("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
		XLUtil.setCellData(path, "Sheet3", 2, 1, responseString);*/
		try {
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\abc2.json"));
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}
		//Thread.sleep(3000);
	
	}
	@AfterClass
	void tearDown(){
		logger.info("**********Finished TC002_accounts_id_weightedholdings****");
	}
}
