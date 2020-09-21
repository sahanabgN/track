package com_trackflow_generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exceldata 
{
    
	public  static Object[][] getexceldata(String path, String sheetname)
	{	
	    Object[][] data=null;
	    FileInputStream file=null;
	    Workbook book = null;
	    
		try
		{
		    
			file=new FileInputStream(path);
		}
		catch(FileNotFoundException e)
		{
		    e.printStackTrace();
		}
		try
		{
		     book = WorkbookFactory.create(file);
		}
		catch(IllegalFormatException e)
		{
		    e.printStackTrace();
		 }
		catch(IOException e)
		{
		    e.printStackTrace();
		}
			int sheetnumber=book.getNumberOfSheets();
			
            for(int i=0;i<sheetnumber;i++)
			{
				if(book.getSheetName(i).equalsIgnoreCase(sheetname))
				{
					Sheet sheet = book.getSheetAt(i);
                    data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
					for(int j=0;j<sheet.getLastRowNum();j++)
					{
						for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
						{
							data[j][k]=sheet.getRow(j+1).getCell(k).toString();
							//System.out.println(data[j][k]);
				                            //WebDriverWait wait= new WebDriverWait(driver,5);
							}
					}
					
				}

	                /*else
	                {
	                    System.out.println("sheet not present");
	                }*/
				//System.out.println(data);
	            	
              }
           // this.data=data;
			
            return data;	
			}

    
}
			
		
		
		
		
     


