package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData()throws IOException{
		
		String path = "C:/Users/kamal/OneDrive/Desktop/DDT/Opencart_LoginData.xlsx";
		//C:\Users\kamal\OneDrive\Desktop\DDT
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalRows=xlutil.getRowCount("sheet1");
		int totalCols =xlutil.getCellCount("sheet1",1);
		
		String[][] loginData = new String[totalRows][totalCols]; 
		
		for(int i =1; i<=totalRows;i++) {
			for(int j =0; j<totalCols;j++) {
				loginData[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		return loginData; //returning two dimension array 
		
		
	}

}
