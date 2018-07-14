package com.scp.service.CrudeHibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.hibernateUtil.VerifyUser;

import junit.framework.Assert;

public class DataProviderClass {
	
	//@DataProvider(name="getProvider")
	@Test(dataProvider="getProvider")
	public void authentication(String username,String password,String flag)
	{
		boolean myflag=false;
		if(flag.equalsIgnoreCase("success"))
		{
			myflag=true;
		}
		boolean actualvalue=VerifyUser.authenticateUser(username, password);
		Assert.assertEquals(myflag, actualvalue);
	}
	@DataProvider(name="getProvider")
	public Object[][] getProvider() throws IOException, InterruptedException
	{
		File file=new File("C:\\Users\\Tanmayeee\\Desktop\\Users_Info.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Object[][]data=new Object[sheet.getPhysicalNumberOfRows()][3];
		Iterator<Row>rowiterator=sheet.iterator();
		while(rowiterator.hasNext())
		{
			
			for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
			{
				Row row=rowiterator.next();
				Iterator<Cell>celliterator=row.iterator();
				Thread.sleep(2000);
				
				for(int j=0;j<3;j++)
				{
					Thread.sleep(2000);
					Cell cell=celliterator.next();
					
					System.out.println("Inside i'th row "+i +" j "+j+" cell :"+cell.getStringCellValue());
					data[i][j]=cell.getStringCellValue();
				}
			}
		}
		return data;
	}
	
	
}
