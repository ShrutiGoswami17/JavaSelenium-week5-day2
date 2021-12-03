package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readData(String fileName) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook("./Data/"+fileName+".xlsx");
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		int rowCount=ws.getLastRowNum();
		int columnCount=ws.getRow(0).getLastCellNum();
		
		String data[][]=new String[rowCount][columnCount];
		
		for(int i=1; i<=rowCount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				String text=ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]=text;
			}
		}
		
		wb.close();
		return data;
		
	}

}


/*//int physicalNumberOfRows = ws.getPhysicalNumberOfRows(); //count includes the first row
//System.out.println(physicalNumberOfRows);

//step3: get into row
//XSSFRow row = ws.getRow(1);

//step4: get into cell
//XSSFCell cell = row.getCell(0);

//String text  = cell.getStringCellValue();*/