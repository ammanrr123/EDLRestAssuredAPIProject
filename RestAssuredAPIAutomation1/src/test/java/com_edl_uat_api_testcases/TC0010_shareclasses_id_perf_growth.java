package com_edl_uat_api_testcases;


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

public class TC0010_shareclasses_id_perf_growth extends TestBase {
	String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
	@BeforeClass
	void shareclasses_id_perf_growth() throws Exception
	{
		logger.info("*******Started TC0010_shareclasses_id_perf_growth*****");
		//Response response;
		
		String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
		String s1=XLUtil.getCellData(path, "All_APIs", 12, 2);
		
		String s3=XLUtil.getCellData(path, "All_APIs", 12, 3);
		
		int totalNoOfRows=XLUtil.getRowCount(path, "ShareClass_APIs");
		for(int row=1;row<=totalNoOfRows;row++) 
			
		{
			String s2=XLUtil.getCellData(path, "ShareClass_APIs", row, 0);
		
		String s4=s1+s2+s3;
		
		String token=XLUtil.getCellData(path, "Token", 1, 3);
		response=RestAssured.given().header("Authorization","Bearer "+token)
				.when().get(s4)
				.then().extract().response();
		
		/*String responseBody=response.getBody().asString();
		System.out.println("Reponse body is:"+responseBody);
		Assert.assertTrue(responseBody!=null);*/
		String responseString=response.asString();
		
		//XLUtil.setCellData(path, "ShareClass_APIs", row, 5, responseString);
		int statusCode=response.getStatusCode();
		//System.out.println("status code is"+statusCode);
		//Assert.assertEquals(statusCode, 200);*/
		if(statusCode==200) {
			//System.out.println("Success API URL:"+s4);
			
			String s5=s2+RestUtils.empName();
			String s6="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"share_perf_growth.json";
		try {
			
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"share_perf_growth.json"));
			XLUtil.setCellData(path, "ShareClass_APIs", row, 6, "pass");
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}
		XLUtil.setCellData(path, "ShareClass_APIs", row,14, s6);
		}else {
			System.out.println("Failed API URL:"+s4);
			XLUtil.setCellData(path, "ShareClass_APIs", row, 6, statusCode+"Error");
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
		//XLUtil.setCellData(path, "Token", 10, 1, responseString);
		try {
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\abc10.json"));
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
		logger.info("**********Finished TC0010_shareclasses_id_perf_growth");
	}
}
