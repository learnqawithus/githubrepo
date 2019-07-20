package excelconcept;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class excelfile {

	static WebDriver driver;

	public static void readexcel() throws IOException, InterruptedException {

		File file = new File("C:/Users/Fawad Anwar/Documents/login.xlsx");

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("credentials");

		int rowcount = sheet.getPhysicalNumberOfRows();
		// sheet.getLastRowNum();

		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();

		System.out.println(rowcount);

		System.out.println(colcount);

		System.setProperty("webdriver.chrome.driver", "C:/Users/Fawad Anwar/Documents/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		for (int i = 1; i < rowcount; i++) {

			String row = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(row);

			for (int j = 1; j < colcount; j++) {

				String column = sheet.getRow(i).getCell(j).getStringCellValue();
				driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(column);
				driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
				Thread.sleep(2000);
				
				//This method will clear the username and password fields
				
				driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
				driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
				
				System.out.println("The username for the user " + (i) + " is: " + row);
				System.out.println("The password for the user " + (i) + " is: " + column);

			}
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		readexcel();

	}

}
