package com_edl_api_testcases;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.edlapi.utilities.RestUtils;

import Lib.XLUtil;
import com_edl_api_testing.TestBase;
import io.restassured.RestAssured;

public class TC009_shareclasses_id_perf_rolling extends TestBase {
	String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\API_Test_Cases.xlsx";
	@BeforeClass
	void shareclasses_id_perf_rolling() throws Exception
	{
		logger.info("*******Started TC009_shareclasses_id_perf_rolling*****");
		//Response response;
		
		String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\API_Test_Cases.xlsx";
		XLUtil.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
		String s1=XLUtil.getCellData(path, "Sheet1", 11, 2);
		
		String s3=XLUtil.getCellData(path, "Sheet1", 11, 3);
		
		int totalNoOfRows=XLUtil.getRowCount(path, "Sheet4");
		for(int row=1;row<=totalNoOfRows;row++) 
			
		{
		String s2=XLUtil.getCellData(path, "Sheet4", row, 0);
		
		String s4=s1+s2+s3;
		
		response=RestAssured.given().header("x-api-key","sXbHNF3oQjatjqg8CoeyvBqGbBjTzlf8Y50LAzpc")
				.when().get(s4)
				.then().extract().response();
		
	/*	String responseBody=response.getBody().asString();
		System.out.println("Reponse body is:"+responseBody);
		Assert.assertTrue(responseBody!=null);*/
		String responseString=response.asString();
		
		//XLUtil.setCellData(path, "Sheet4", row, 4, responseString);
		int statusCode=response.getStatusCode();
		//System.out.println("status code is"+statusCode);
		//Assert.assertEquals(statusCode, 200);*/
		
		if(statusCode==200) {
		try {
			System.out.println("Success API URL:"+s4);
			String s5=s2+RestUtils.empName();
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\"+s5+"share_perf_rolling.json"));
			XLUtil.setCellData(path, "Sheet4", row, 5, "pass");
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}}else
		{
			System.out.println("Failed API URL:"+s4);
			XLUtil.setCellData(path, "Sheet4", row, 5, "404 Error");
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
	void ExtractallData() throws Exception {
		logger.info("********Extracting all parameters from response*******");
		String responseString=response.asString();
		//XLUtil.setCellData(path, "Sheet3", 9, 1, responseString);
		try {
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\abc9.json"));
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}
		Thread.sleep(3000);
	}
	@AfterClass
	void tearDown(){
		logger.info("**********Finished TC009_shareclasses_id_perf_rolling");
	}
}
