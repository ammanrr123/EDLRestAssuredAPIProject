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

public class TC007_shareclasses_id_NAV extends TestBase {
	String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
	@BeforeClass
	void getShareclassdetail() throws Exception
	{
		logger.info("*******Started TC007_getShareclassdetail*****");
		//Response response;
		
		String path="C:\\Users\\ammanrr\\eclipse-workspace\\API_Test_Cases_UAT.xlsx";
		String s1=XLUtil.getCellData(path, "All_APIs", 9, 2);
		
		String s3=XLUtil.getCellData(path, "All_APIs", 9, 3);
		
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
		Assert.assertTrue(responseBody!=null)*/;
		String responseString=response.asString();
		
		
		int statusCode=response.getStatusCode();
		//System.out.println("status code is"+statusCode);
		//Assert.assertEquals(statusCode, 200);*/
		if(statusCode==200) {
		XLUtil.setCellData(path, "ShareClass_APIs", row, 3, responseString);
		String s5=s2+RestUtils.empName();
		String s6="C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"NAV.json";
		
		try {
			
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response_UAT\\"+s5+"NAV.json"));
			out.print(responseString);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println("no file found");
		}
		XLUtil.setCellData(path, "ShareClass_APIs", row,11, s6);
		}else {
			XLUtil.setCellData(path, "ShareClass_APIs", row, 3, statusCode+"Error");
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
	//	XLUtil.setCellData(path, "Token", 7, 1, responseString);
		try {
			PrintStream out =new PrintStream(new FileOutputStream("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\abc7.json"));
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
		logger.info("**********TC007_getShareclassdetail****");
	}
}
