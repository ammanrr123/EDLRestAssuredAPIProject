package com_edl_api_testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Lib.XLUtil;

public class JsonRead {

	@Test
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		
		JSONParser parser = new JSONParser();
		//JsonParser to convert JSON string into Json Object
		String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Test_Case_Validation.xlsx";
		XLUtil.setExcelFile(path);

		int rowcount=XLUtil.getRowCount(path, "ShareClassURLs");
		for(int row=1;row<=rowcount;row++) 
			
		{
		try {
			//Object obj = parser.parse(new FileReader("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\09TBEQQQXXSCETFACCcshareclass.json"));
			
			Object obj = parser.parse(new FileReader(XLUtil.getCellData(path, "ShareClassURLs", row, 0)));
			//parsing the JSON string inside the file that we created earlier.
			
		
			JSONObject jsonObject = (JSONObject) obj;
			
			//int rowcount1=XLUtil.getRowCount(path, "ShareClass_Ext");
			
			int col=row+1;
			
			XLUtil.setCellData(path, "ShareClass_Ext", 1, col, "ShareClass");
			
			
			String name = (String) jsonObject.get("edlMasterAccountIdentifier");
			XLUtil.setCellData(path, "ShareClass_Ext", 2, col, name);
			
			String name1 = (String) jsonObject.get("edlMasterShareClassIdentifier");
			XLUtil.setCellData(path, "ShareClass_Ext", 3, col, name1);
		
			
						
			Map account = ((Map)jsonObject.get("account")); 
			System.out.println(account.size());

			JSONObject jsonObject1 = (JSONObject) account;
			String accountName = (String) jsonObject1.get("accountName");
			XLUtil.setCellData(path, "ShareClass_Ext", 4, col, accountName);
			 //System.out.println(name3);
			 
			String accountShortName = (String) jsonObject1.get("accountShortName");
			XLUtil.setCellData(path, "ShareClass_Ext", 5, col, accountShortName);
			 
			 
			String shareClassFullName = (String) jsonObject.get("shareClassFullName");
			XLUtil.setCellData(path, "ShareClass_Ext", 6, col, shareClassFullName);
			 
				
			String shareClassShortName = (String) jsonObject.get("shareClassShortName");
			XLUtil.setCellData(path, "ShareClass_Ext", 7, col, shareClassShortName);
				
			String clientName = (String) jsonObject1.get("clientName");
			XLUtil.setCellData(path, "ShareClass_Ext", 8, col, clientName);
			
			
			String primaryShareClassIndicator = (String) jsonObject.get("primaryShareClassIndicator");
			XLUtil.setCellData(path, "ShareClass_Ext", 9, col, primaryShareClassIndicator);
			
			String accountLevelOfService = (String) jsonObject1.get("accountLevelOfService");
			XLUtil.setCellData(path, "ShareClass_Ext", 10, col, accountLevelOfService);
			
			String investmentVehicleType = (String) jsonObject1.get("investmentVehicleType");
			XLUtil.setCellData(path, "ShareClass_Ext", 11, col, investmentVehicleType);
			
			String accountOpenDate = (String) jsonObject1.get("accountOpenDate");
			XLUtil.setCellData(path, "ShareClass_Ext", 13, col, accountOpenDate);
			
			/****FundRegistration***/
			
			String performanceInceptionDate = (String) jsonObject.get("performanceInceptionDate");
			XLUtil.setCellData(path, "ShareClass_Ext", 14, col, performanceInceptionDate);
			
			
			String shareClassInceptionDate = (String) jsonObject.get("shareClassInceptionDate");
			XLUtil.setCellData(path, "ShareClass_Ext", 15, col, shareClassInceptionDate);
			
			
			String accountStatus = (String) jsonObject1.get("accountStatus");
			XLUtil.setCellData(path, "ShareClass_Ext", 16, col, accountStatus);
			
			
			//JSONObject jsonObject2 = (JSONObject)jsonObject.get("investmentStrategy");
			 
			 
			
			JSONObject oParse=(JSONObject)account.get("investmentStrategy");
			
			String strategyCodeRowId = (String) oParse.get("strategyCodeRowId");
			XLUtil.setCellData(path, "ShareClass_Ext", 17, col, strategyCodeRowId);
			
			
			String domicileCountryCode = (String) jsonObject1.get("domicileCountryCode");
			XLUtil.setCellData(path, "ShareClass_Ext", 18, col, domicileCountryCode);
			
			String shareClassCurrency = (String) jsonObject.get("shareClassCurrency");
			XLUtil.setCellData(path, "ShareClass_Ext", 20, col, shareClassCurrency);
			
			
			
			String hedgedIndicator = (String) jsonObject.get("hedgedIndicator");
			XLUtil.setCellData(path, "ShareClass_Ext", 22, col, hedgedIndicator);
			
			

			String ucitsCompliant = (String) jsonObject.get("ucitsCompliant");
			XLUtil.setCellData(path, "ShareClass_Ext", 24, col, ucitsCompliant);
			
			String accountNumber = (String) jsonObject1.get("accountNumber");
			XLUtil.setCellData(path, "ShareClass_Ext", 33, col, accountNumber);
			 
			String dividendTreatment = (String) jsonObject.get("dividendTreatment");
			XLUtil.setCellData(path, "ShareClass_Ext", 46, col, dividendTreatment);
			
				
			String shareClassStatus = (String) jsonObject.get("shareClassStatus");
			XLUtil.setCellData(path, "ShareClass_Ext", 48, col, shareClassStatus);
				
			String emirLeiInvestmentManager = (String) jsonObject1.get("emirLeiInvestmentManager");
			XLUtil.setCellData(path, "ShareClass_Ext",39, col, emirLeiInvestmentManager);
				
			JSONArray aliases=(JSONArray)jsonObject.get("aliases");
			
			for(Object objee:aliases) {
				JSONObject tempObj=(JSONObject)objee;
				
				if(tempObj.get("aliasType").equals("ISIN")) {
					String isin=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "ShareClass_Ext", 27, col, isin);
				}
				else if(tempObj.get("aliasType").equals("Valor")) {
					String valor=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "ShareClass_Ext", 29, col, valor);
				}
				else if(tempObj.get("aliasType").equals("Sedol")) {
					String sedol=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "ShareClass_Ext", 31, col, sedol);
				}
				else if(tempObj.get("aliasType").equals("Bloomberg")) {
					String bloomberg=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "ShareClass_Ext", 35, col, bloomberg);
				}
				else if(tempObj.get("aliasType").equals("CUSIP")) {
					String CUSIP=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "ShareClass_Ext", 26, col, CUSIP);
				}
				else if(tempObj.get("aliasType").equals("WKN")) {
					String WKN=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "ShareClass_Ext", 28, col, WKN);
				}
			}
			
			JSONArray benchmarkRelationships=(JSONArray)jsonObject.get("benchmarkRelationships");
			
			for(Object objee:benchmarkRelationships) {
				JSONObject tempObj=(JSONObject)objee;
				JSONObject benchmarkObj = (JSONObject)tempObj.get("benchmark");
				JSONArray crossReferencesArray = (JSONArray)benchmarkObj.get("crossReferences");
				for (int i = 0; i < crossReferencesArray.size(); i++) {
					JSONObject crossReferenceObj= (JSONObject)crossReferencesArray.get(i);
					if (crossReferenceObj.get("crossReferenceType") != null && crossReferenceObj.get("crossReferenceType").equals("BLOOMBERG")) {
						String crossReferenceCode= crossReferenceObj.get("crossReferenceCode").toString();
						XLUtil.setCellData(path, "ShareClass_Ext", 36, col, crossReferenceCode);
					}
				}
			}
			
			//JSONArray benchmarkRelationships=(JSONArray)jsonObject.get("benchmarkRelationships");
			
			for(Object objee:benchmarkRelationships) {
				JSONObject tempObj=(JSONObject)objee;
				//System.out.println(tempObj.get("benchmarkOrdinalNumber").toString());
				JSONObject benchmarkObj = (JSONObject)tempObj.get("benchmark");
			String indexprovider=	benchmarkObj.get("indexProvider").toString();
			
			XLUtil.setCellData(path, "ShareClass_Ext", 37, col, indexprovider);
			
			String indexCurrencyCode=	benchmarkObj.get("indexCurrencyCode").toString();
			
			XLUtil.setCellData(path, "ShareClass_Ext", 38, col, indexCurrencyCode);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	System.out.println("Json data extracted successfully");}

}}