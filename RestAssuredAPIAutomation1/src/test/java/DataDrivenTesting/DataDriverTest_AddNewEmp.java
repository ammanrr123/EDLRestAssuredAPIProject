package DataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.XLUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDriverTest_AddNewEmp {

	@Test(dataProvider="empdataprovider")
	void postNewEmployess(String ename,String esal ,String eage) {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject requestparamas=new JSONObject();
		requestparamas.put("name", ename);
		requestparamas.put("salary", esal);
		requestparamas.put("age", eage);
		
		httpRequest.header("content-Type","application/json");
		
		httpRequest.body(requestparamas.toJSONString());
		
		Response response =httpRequest.request(Method.POST,"/create");
		
		String responsebody=response.getBody().asString();
		
		
		System.out.println("Response body is:"+responsebody);
		
		Assert.assertEquals(responsebody.contains(ename), true);
		Assert.assertEquals(responsebody.contains(esal), true);
		Assert.assertEquals(responsebody.contains(eage), true);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	
	@DataProvider(name="empdataprovider")
		String [][] getEmpData() throws Exception
		{
			
		String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredApiTesting.xlsx";
		XLUtil.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredApiTesting.xlsx");
		int rownum=XLUtil.getRowCount(path, "Sheet1");
		int colcount=XLUtil.getCellCount(path, "Sheet1", 1);
		
		String empdata[][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				empdata[i-1][j]=XLUtil.getCellData(path, "Sheet1", i, j);
			}
		}
		
			//String empdata[][]= {{"kasa3","30000","30"},{"kasa4","40000","40"},{"kasa5","50000","50"}};
			return(empdata);
		}
	}

