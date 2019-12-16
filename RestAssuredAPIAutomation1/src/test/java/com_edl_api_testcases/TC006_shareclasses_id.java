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

public class TC006_shareclasses_id extends TestBase {
	String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases.xlsx";
	@BeforeClass
	void getShareClassdetails() throws Exception
	{
		logger.info("*******Started TC006_getShareClassdetails*****");
		//Response response;
		
		String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases.xlsx";
		//XLUtil.setExcelFile("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
		String s1=XLUtil.getCellData(path, "Sheet1", 8, 2);
		
		int totalNoOfRows=XLUtil.getRowCount(path, "Sheet4");
		for(int row=1;row<=totalNoOfRows;row++) 
			
		{
		String s2=XLUtil.getCellData(path, "Sheet4", row, 0);
		//String s3=XLUtil.getCellData(path, "Sheet1", 8, 3);
		String s4=s1+s2;
		
		response=RestAssured.given().header("x-api-key","sXbHNF3oQjatjqg8CoeyvBqGbBjTzlf8Y50LAzpc")
				.when().get(s4)
				.then().extract().response();
		
	
	String responseString=response.asString();
		
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is"+statusCode);
		if(statusCode==200) {
	XLUtil.setCellData(path, "Sheet4", row,2, responseString);
	String s5=s2+RestUtils.empName();
	String s6="C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\";
	String s7="shareclass.json";
	String s8=s6+s5+s7;
	//XLUtil.setCellData(path, "Sheet5", row,0, s8);
		
	try {
			PrintStream out =new PrintStream(new FileOutputStream(s8));
			//PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\"+s5+"shareclass.json"));
			out.print(responseString);
			out.flush();
			out.close();
			
		}
		catch(Exception e) {
			System.out.println("no file found");
			
			
		}
		

	XLUtil.setCellData(path, "Sheet4", row,10, s8);
		}else {
			XLUtil.setCellData(path, "Sheet4", row,2, "404 Error");
		}
		
		}
		Thread.sleep(3000);
	
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
		//XLUtil.setCellData(path, "Sheet3", 6, 1, responseString);
		Thread.sleep(3000);
		
		try {
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\abc6.json"));
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
		logger.info("**********Finished TC006_getShareClassdetails****");
	}
}
