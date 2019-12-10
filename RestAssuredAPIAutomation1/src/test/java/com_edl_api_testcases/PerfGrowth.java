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

public class PerfGrowth {

	@Test
	public static void main(String[] args) throws Exception {
		int count=1;
		JSONParser parser = new JSONParser();
		//JsonParser to convert JSON string into Json Object
		String path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Test_Case_Validation.xlsx";
		XLUtil.setExcelFile(path);

		int rowcount=XLUtil.getRowCount(path, "Perf_Growth_URLs");
		for(int row=1;row<=rowcount;row++) 
			
		{
		try {
			
			Object obj = parser.parse(new FileReader(XLUtil.getCellData(path, "Perf_Growth_URLs", row, 0)));
			
		
			JSONObject jsonObject = (JSONObject) obj;
			

			JSONArray performance=(JSONArray)jsonObject.get("performance");
			
		
			int size=performance.size();
			System.out.println(size);
			int col=count+0;
			int displayorder=1;
			for(int i=0;i<size;i++)
						
			{
				
			String effectiveDate = (String) jsonObject.get("effectiveDate");
			XLUtil.setCellData(path, "Perf_Growth_Ext", 0, col, effectiveDate);
				
			String masterEntityId = (String) jsonObject.get("masterEntityId");
			XLUtil.setCellData(path, "Perf_Growth_Ext", 2, col, masterEntityId);
				
			JSONObject perf1 = (JSONObject)performance.get(i);
			
		
			String entityName=perf1.get("entityName").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext", 3, col, entityName);
			
			String masterEntityId1=perf1.get("masterEntityId").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext", 4, col, masterEntityId1);
			 
			String grossNet=perf1.get("grossNet").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext", 5, col, grossNet);
			
			
			String performanceType=perf1.get("performanceType").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext", 6, col, performanceType);
			
			
			String IsBenchmark=perf1.get("entityType").toString();
			//System.out.println(IsBenchmark);
			
			if(IsBenchmark.equals("BENCHMARK")) {
				
				int x=1;
				String x1=Integer.toString(x);
						
				XLUtil.setCellData(path, "Perf_Growth_Ext", 7, col, x1);
			}
			else {
				int y=0;
				String y1=Integer.toString(y);
				XLUtil.setCellData(path, "Perf_Growth_Ext", 7, col, y1);
			}
			
			if(IsBenchmark.equals("BENCHMARK")) {
				

				String benchmarkOrdinal=perf1.get("benchmarkOrdinal").toString();
				XLUtil.setCellData(path, "Perf_Growth_Ext", 8, col, benchmarkOrdinal);
			}
			else {
				int y=0;
				String y1=Integer.toString(y);
				XLUtil.setCellData(path, "Perf_Growth_Ext", 7, col, y1);
			}
			XLUtil.setCellData(path, "Perf_Growth_Ext",9, col, displayorder);
			displayorder++;
			
			String currencyCode=perf1.get("currencyCode").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext", 10, col, currencyCode);
			
			String performanceCommitFlag=perf1.get("performanceCommitFlag").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",11, col, performanceCommitFlag);
			
			JSONObject cumulative = (JSONObject)perf1.get("cumulative");
			
			String m1=cumulative.get("m1").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",12, col, m1);
			
			String m3=cumulative.get("m3").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",13, col, m3);
			
			String m6=cumulative.get("m6").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",14, col, m6);
			
			
			String qtd=cumulative.get("qtd").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",15, col, qtd);
			
			String ytd=cumulative.get("ytd").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",16, col, ytd);
			
			String fytd=cumulative.get("fytd").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",17, col, fytd);
			
			
			String CumulativeSinceInception=cumulative.get("itd").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",18, col, CumulativeSinceInception);
			
		
			JSONObject annualized = (JSONObject)perf1.get("annualized");
			
			String AnnualSinceInception=annualized.get("itd").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",19, col, AnnualSinceInception);
			
			String y2=annualized.get("y2").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",20, col, y2);
			
			
			String y3=annualized.get("y3").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",21, col, y3);
			
			
			/*String y4=annualized.get("y4").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",22, col, y4);*/
			
			String y5=annualized.get("y5").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",23, col, y5);
			
			/*String y7=annualized.get("y7").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",24, col, y7);*/
			
			String y10=annualized.get("y10").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",25, col, y10);
			
			String cy2=cumulative.get("y2").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",26, col, cy2);
			
			
			String cy3=cumulative.get("y3").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",27, col, cy3);
			
			String cy5=cumulative.get("y5").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",28, col, cy5);
			
			String cy10=cumulative.get("y10").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",29, col, cy10);
			
			String y1=annualized.get("y1").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",30, col, y1);
			
			/*String cy4=cumulative.get("y4").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",31, col, cy4);
			
			String cy7=cumulative.get("y7").toString();
			XLUtil.setCellData(path, "Perf_Growth_Ext",32, col, cy7);*/
			
			
		col++;
		count++;
			} 
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	System.out.println("Json data extracted successfully");}

}}