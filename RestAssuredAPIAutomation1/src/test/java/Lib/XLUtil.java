package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtil {

	public static FileInputStream fi;
	public static final String Path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\RestAssuredApiTesting.xlsx";;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static void setExcelFile(String Path) throws Exception {

		try {

		// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream(Path);

		//Access the required test data sheet

		wb = new XSSFWorkbook(ExcelFile);

	//	ws = wb.getSheet(SheetName);

		} catch (Exception e){

		throw (e);

		}

		}
	
/*	static void writeToFile(Map<String,String> map, String pathToFile)
	{                                 
	  Iterator<Map.Entry<String,String>> itr = map.entrySet().iterator();
	  File path = new File(pathToFile);
	  while(itr.hasNext())    {
	    Map.Entry<String,String> pairs = (Map.Entry<String,String>)itr.next();
	    FileUtils.writeStringToFile(path,pairs.getKey() + "=" + pairs.getValue(), true);// append rather than overwrite
	  }
	}*/
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new  XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e){
			data="";
			
			
		}
		wb.close();
		fi.close();
		return data;
		
		
	}
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fo.close();
		
		
	}
		
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,int data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fo.close();
		
		
	}
		
		
	}
