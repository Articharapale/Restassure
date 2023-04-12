package Common_method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class get_data {
	
	public static ArrayList<String> getdata_excel(String Testsheetname,String testcasename) throws IOException
	{
		ArrayList<String> Array=new ArrayList<String>();
		//step 1 Access outer file
		FileInputStream fis=new FileInputStream("C:\\Users\\BANGLADESH\\Documents\\Test_data.xlsx");
		
		//step 2 open file
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//count of sheet
		int countofsheet= workbook.getNumberOfSheets();
		
		for(int i=0;i<countofsheet;i++)
		{
			String sheetname=workbook.getSheetName(i);
			
			if(sheetname.equalsIgnoreCase(Testsheetname))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//iterator row and cell
				
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				
				Iterator<Cell> cells=firstrow.cellIterator();
				int tc_column=0;
				int j=0;
				
				while(cells.hasNext())
				{
					Cell cellvalue=cells.next();
					if(cellvalue.getStringCellValue().equalsIgnoreCase("Tcname"))
					{
						tc_column=j;
					}
					j++;
				}
				while(rows.hasNext())
				{
					Row datarow=rows.next();
					if(datarow.getCell(tc_column).getStringCellValue().equalsIgnoreCase(testcasename))
                  {
                	  Iterator<Cell> datacellvalue=datarow.cellIterator();
                	  
                	  while(datacellvalue.hasNext())
                	  {
                		  Cell dataOfcell=datacellvalue.next();
                		  
                		  try
                		  {
                			  String testdata=dataOfcell.getStringCellValue();
                			  Array.add(testdata);
                		  }
                		  catch(IllegalStateException e)
                		  {
                			  int intestdata=(int) dataOfcell.getNumericCellValue();
                			  String stringtestdata=Integer.toString(intestdata);
                			  Array.add(stringtestdata);
                		  }
                		  
                		  /*CellType datatype=dataOfcell.getCellType();
                		  if(datatype.toString()=="Numuric")
                		  {
                			  int intestdata=(int) dataOfcell.getNumericCellValue();
                			  String stringtestdata=Integer.toString(intestdata);
                			  Array.add(stringtestdata);  
                		  }
                		  else if(datatype.toString()=="String")
                		  {
                			  String testdata=dataOfcell.getStringCellValue();
                			  Array.add(testdata);
                		  }*/
                		  
                		  /*String testdata=dataOfcell.toString().replaceAll("//.//$+d", "");
                		  Array.add(testdata);*/
                	  }
                  }
					
				}
			}
			
		}
		
		
		
		return Array;
		
	}

}
