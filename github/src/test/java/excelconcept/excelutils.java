package excelconcept;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {

	String projectpath;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public excelutils(String excelfile, String sheetname) {

		try {
			projectpath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath + excelfile);
			sheet = workbook.getSheet(sheetname);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public int getrowcount() {
		int noofrows=0;
		try {

			noofrows = sheet.getPhysicalNumberOfRows();
			System.out.println("number of rows: "+noofrows);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return noofrows;
	}

	public int getcolumncount() {

		int noofcolumns=0;
		try {

			noofcolumns = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("number of columns: "+noofcolumns);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return noofcolumns;
	}

	public String getcelldata(int row, int column) {
		
		String celldata = null;
		try {

			celldata = sheet.getRow(row).getCell(column).getStringCellValue();
			//System.out.println(celldata);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;

	}

	public static void main(String[] args) {
		
		excelutils eu = new excelutils("/excelfiles/login.xlsx", "credentials");
		eu.getrowcount();
		eu.getcolumncount();

	}
}
