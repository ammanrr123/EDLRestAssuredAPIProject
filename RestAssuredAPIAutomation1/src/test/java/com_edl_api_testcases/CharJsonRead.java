package com_edl_api_testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Lib.XLUtil;

public class CharJsonRead {

	@Test
	public static void main(String[] args) throws Exception {
		
		JSONParser parser = new JSONParser();
		//JsonParser to convert JSON string into Json Object
		
			
		{
		try {
			String path="C:\\Users\\ammanrr\\eclipse-workspace\\Test_Case_Validation.xlsx";
			XLUtil.setExcelFile(path);
		System.out.println("started extracting the Shareclass json files");

			int rowcount=XLUtil.getRowCount(path, "ShareClassURLs");
			for(int row=1;row<=rowcount;row++) {
			//Object obj = parser.parse(new FileReader("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\09TBEQQQXXSCETFACCcshareclass.json"));
			
			Object obj = parser.parse(new FileReader(XLUtil.getCellData(path, "ShareClassURLs", row, 0)));
			//parsing the JSON string inside the file that we created earlier.
			
			//Object obj1 = parser.parse(new FileReader(XLUtil.getCellData(path, "Sheet5", row, 1)));
			JSONObject jsonObject = (JSONObject) obj;
			
				
			int col=row+2;
			
			XLUtil.setCellData(path, "Char_analytics", 1, col, "2019-09-30");
			
		
			
			String name1 = (String) jsonObject.get("edlMasterShareClassIdentifier");
			XLUtil.setCellData(path, "Char_analytics", 3, col, name1);
		
			
			
			String ukReportingStatus = (String) jsonObject.get("ukReportingStatus");
			XLUtil.setCellData(path, "Char_analytics", 7, col, ukReportingStatus);
			
			String dividendSchedule = (String) jsonObject.get("dividendSchedule");
			XLUtil.setCellData(path, "Char_analytics", 8, col, dividendSchedule);
			 
			String dividendTreatment = (String) jsonObject.get("dividendTreatment");
			XLUtil.setCellData(path, "Char_analytics", 9, col, dividendTreatment);
			
			
			String isaEligible = (String) jsonObject.get("isaEligible");
			XLUtil.setCellData(path, "Char_analytics", 10, col, isaEligible);
				
			JSONArray aliases=(JSONArray)jsonObject.get("aliases");
		
				
			JSONArray shareClassCharges=(JSONArray)jsonObject.get("shareClassCharges");
			
			for(Object objee:shareClassCharges) {
				
				JSONObject tempObj=(JSONObject)objee;
				if(tempObj.get("shareClassChargeType").equals("Ongoing Charges")) {
					String OngoingCharges=tempObj.get("shareClassChargePercentage").toString();
					XLUtil.setCellData(path, "Char_analytics", 17, col, OngoingCharges);
				}
				else if(tempObj.get("shareClassChargeType").equals("Net Expense Ratio")) {
					String Net_Expense_Ratio=tempObj.get("shareClassChargePercentage").toString();
					XLUtil.setCellData(path, "Char_analytics", 25, col, Net_Expense_Ratio);
				}
				else if(tempObj.get("shareClassChargeType").equals("Total Expense Ratio")) {
					String Total_Expense_Ratio=tempObj.get("shareClassChargePercentage").toString();
					XLUtil.setCellData(path, "Char_analytics", 29, col, Total_Expense_Ratio);
				}
				else if(tempObj.get("shareClassChargeType").equals("Fund Management Fee")) {
					String Fund_Management_Fee=tempObj.get("shareClassChargePercentage").toString();
					XLUtil.setCellData(path, "Char_analytics", 40, col, Fund_Management_Fee);
				}
			}
			
			JSONObject yields=(JSONObject)jsonObject.get("yields");
			String secUnsubsidizedYield30Day =  yields.get("secUnsubsidizedYield30Day").toString();
			XLUtil.setCellData(path, "Char_analytics", 22, col, secUnsubsidizedYield30Day);
			
			String secYield30Day =  yields.get("secYield30Day").toString();
			XLUtil.setCellData(path, "Char_analytics", 23, col, secYield30Day);
			
			for(Object objee:aliases) {
				JSONObject tempObj=(JSONObject)objee;
				
				if(tempObj.get("aliasType").equals("iNAV")) {
					String iNAV=tempObj.get("aliasValue").toString();
					XLUtil.setCellData(path, "Char_analytics", 24, col, iNAV);
				}
				}
			
			
			
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		try {
			
			System.out.println("Started extracting the Analystics json files");
			String path="C:\\Users\\ammanrr\\eclipse-workspace\\Test_Case_Validation.xlsx";
			XLUtil.setExcelFile(path);
			int rowcount=XLUtil.getRowCount(path, "AnalysticsURLs");
			
			for(int Arow=1;Arow<=rowcount;Arow++) {
			//Object obj = parser.parse(new FileReader("C:\\Users\\ammanrr\\eclipse-workspace\\RestAssuredAPIAutomation1\\Extracts_Response\\09TBEQQQXXSCETFACCcshareclass.json"));
			
				int ccol=Arow+2;
			
				Object obj1 = parser.parse(new FileReader(XLUtil.getCellData(path, "AnalysticsURLs", Arow, 0)));
			
				JSONObject jsonObject2 = (JSONObject) obj1;
			
			
				String access_token = (String) jsonObject2.get("accountId");
				System.out.println(access_token);
				JSONObject Analytics=(JSONObject)jsonObject2.get("Analytics");
		
			try {
				JSONArray FixedIncome=(JSONArray)Analytics.get("FixedIncome");
			
			
				System.out.println(FixedIncome.size());
			
			
				JSONObject FI1=(JSONObject)FixedIncome.get(1);
			
				JSONObject FIPortfolioAnalytics=(JSONObject)FI1.get("FIPortfolioAnalytics");
				String portfolioOptionAdjustedDuration=FIPortfolioAnalytics.get("portfolioOptionAdjustedDuration").toString();
				System.out.println(portfolioOptionAdjustedDuration);
				XLUtil.setCellData(path, "Char_analytics", 13, ccol, portfolioOptionAdjustedDuration);

				String portfolioNominalYield=FIPortfolioAnalytics.get("portfolioNominalYield").toString();
				System.out.println(portfolioNominalYield);
				XLUtil.setCellData(path, "Char_analytics", 20, ccol, portfolioNominalYield);

				String portfolioYieldToMaturity=FIPortfolioAnalytics.get("portfolioYieldToMaturity").toString();
				System.out.println(portfolioYieldToMaturity);
				XLUtil.setCellData(path, "Char_analytics", 32, ccol, portfolioYieldToMaturity);
				
				String portfolioSpRating=FIPortfolioAnalytics.get("portfolioSpRating").toString();
				System.out.println(portfolioSpRating);
		
				XLUtil.setCellData(path, "Char_analytics", 35, ccol, portfolioSpRating);
				
				String portfolioNominalWeightedAverageLife=FIPortfolioAnalytics.get("portfolioNominalWeightedAverageLife").toString();
				System.out.println(portfolioNominalWeightedAverageLife);
				XLUtil.setCellData(path, "Char_analytics", 36, ccol, portfolioNominalWeightedAverageLife);
			
	
				
			
				
				JSONObject FI2 = (JSONObject)FixedIncome.get(0);
				String netAssetValue=FI2.get("netAssetValue").toString();
				System.out.println(netAssetValue);
				XLUtil.setCellData(path, "Char_analytics", 14, ccol, netAssetValue);
				
				String portfolioAverageCoupon=FI2.get("portfolioAverageCoupon").toString();
				System.out.println(portfolioAverageCoupon);
				XLUtil.setCellData(path, "Char_analytics", 30, ccol, portfolioAverageCoupon);
				
				String weightedAverageMaturity=FI2.get("weightedAverageMaturity").toString();
				System.out.println(weightedAverageMaturity);
				XLUtil.setCellData(path, "Char_analytics", 31, ccol, weightedAverageMaturity);
				
				String portfolioAverageSharePrice=FI2.get("portfolioAverageSharePrice").toString();
				System.out.println(portfolioAverageSharePrice);
				XLUtil.setCellData(path, "Char_analytics", 38, ccol, portfolioAverageSharePrice);
			
			
			
				
			
				
				JSONObject FI3 = (JSONObject)FixedIncome.get(2);
				JSONObject FIBenchmarkAnalytics=(JSONObject)FI3.get("FIBenchmarkAnalytics");
				String benchmarkYieldToMaturity=FIBenchmarkAnalytics.get("benchmarkYieldToMaturity").toString();
				System.out.println(benchmarkYieldToMaturity);
				XLUtil.setCellData(path, "Char_analytics", 19, ccol, benchmarkYieldToMaturity);
				
				String benchmarkCurrentYield=FIBenchmarkAnalytics.get("benchmarkCurrentYield").toString();
				System.out.println(benchmarkCurrentYield);
				XLUtil.setCellData(path, "Char_analytics", 37, ccol, benchmarkCurrentYield);
			
			}catch(Exception e) {
				System.out.println("Fixed Income not present");
			}
			
			try {
			JSONArray Equity=(JSONArray)Analytics.get("Equity");
				JSONObject equity = (JSONObject)Equity.get(0);
			
				String priceToBookRatio=equity.get("priceToBookRatio").toString();
				System.out.println(priceToBookRatio);
				XLUtil.setCellData(path, "Char_analytics", 26, ccol, priceToBookRatio);
				
				String peTrailing12MonthRatio=equity.get("peTrailing12MonthRatio").toString();
				System.out.println(peTrailing12MonthRatio);
				XLUtil.setCellData(path, "Char_analytics", 27, ccol, peTrailing12MonthRatio);
				
				String roe5YearPercent=equity.get("roe5YearPercent").toString();
				System.out.println(roe5YearPercent);
				XLUtil.setCellData(path, "Char_analytics", 28, ccol, roe5YearPercent);
				
				String marketCapitalizationWeightedAverage=equity.get("marketCapitalizationWeightedAverage").toString();
				System.out.println(marketCapitalizationWeightedAverage);
				XLUtil.setCellData(path, "Char_analytics", 33, ccol, marketCapitalizationWeightedAverage);
				
				String dividendYieldTrailing12MonthPercent=equity.get("dividendYieldTrailing12MonthPercent").toString();
				System.out.println(dividendYieldTrailing12MonthPercent);
				XLUtil.setCellData(path, "Char_analytics", 12, ccol, dividendYieldTrailing12MonthPercent);
			}catch(Exception e) {
				System.out.println("Equity is not present");
			}
			
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		try {
			String path="C:\\Users\\ammanrr\\eclipse-workspace\\Test_Case_Validation.xlsx";
			XLUtil.setExcelFile(path);
			System.out.println("Started extracting the Shareclass Nav json files");
			int rowcount=XLUtil.getRowCount(path, "Share_NAVURLS");
	
			for(int crow=1;crow<=rowcount;crow++) {
	
				int ccol=crow+2;
	
				Object obj1 = parser.parse(new FileReader(XLUtil.getCellData(path, "Share_NAVURLS", crow, 0)));
	
				JSONArray jsonObject = (JSONArray) obj1;
	
				JSONObject nav=(JSONObject)jsonObject.get(0);
				String sharesInIssueFromTPA=nav.get("sharesInIssueFromTPA").toString();
				System.out.println(sharesInIssueFromTPA);
				XLUtil.setCellData(path, "Char_analytics", 18, ccol, sharesInIssueFromTPA);
	
	
				String midFundTotalAmount=nav.get("midFundTotalAmount").toString();
				System.out.println(midFundTotalAmount);
				XLUtil.setCellData(path, "Char_analytics", 34, ccol, midFundTotalAmount);
			}}catch(FileNotFoundException e) {
	
			}


		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	System.out.println("Json data extracted successfully");}

}}