package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public  ArrayList<String> getData(String testcaseName) throws Exception {
		// TODO Auto-generated method stub
		
		//identify testcase column by scanning  entire  1st row
		// column is identified the scan scan entire testcases coloumn to identify to purchase testcase row 
		//after you grab purchase testcase row pull all data from that row and feed into test
		//
		
		ArrayList<String>a = new ArrayList<String>();
		//FileInputStream
		
		FileInputStream fis  = new FileInputStream("C:\\Users\\VidyaDevi\\Documents\\datademo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		System.out.println("Sheet "+sheets);
		for(int i =0;i<sheets;i++) {
			if(workbook.getSheetName(i).equals("testdata"))
			{
			XSSFSheet sheet = workbook.getSheetAt(i);//sheet is the collection of rows
			//identify testcase column by scanning  entire  1st row
	        Iterator<Row> rows = sheet.iterator();//
	        Row firstrow = rows.next();
	        Iterator<Cell> cell = firstrow.cellIterator();
	        int k =0;
	        int column=0;
	        while(cell.hasNext()) {
	        	Cell value = cell.next();
	        	if(value.getStringCellValue().equalsIgnoreCase(testcaseName))
	        	{
	        		column = k;
	        	}
	        	k++;
	        	
	        }
	        System.out.println("cloum name " +column);
	        
	        while(rows.hasNext()) {
	        	Row row = rows.next();
	        	if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) 
	        	{
	        	Iterator<Cell> cv = row.cellIterator();
	        	while(cv.hasNext()) {
	        		Cell c = cv.next();
	        		  if(c.getCellType()==CellType.STRING)
	        		  {
	        		    String value = c.getStringCellValue();
	        		     a.add(value);
	        		  }
	        		  else
	        		  {
	        			 String value = NumberToTextConverter.toText(c.getNumericCellValue());
	        			 a.add(value);
	        		  }
	        		
	        	}
	        	System.out.println(a);
	        	
	        	}
	        	
	        }
			}
			
			
		}
		return a;
		
	}

}
