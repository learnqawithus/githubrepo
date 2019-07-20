package excelconcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exceldataprovider {
	
	WebDriver driver;
	
	//Step 4
	
	@BeforeTest
	public void setup () {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Fawad Anwar/Documents/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	//Step 3
	
	@Test (dataProvider = "test")
	public void datatest (String Username, String Password) throws InterruptedException {
		
		System.out.println(Username+" | "+Password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
		//driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);
		
	}
	
	//Step 2
	
	@DataProvider (name = "test")
	public Object[][] getdata () {
		
		Object [][] data = testdata("/excelfiles/login.xlsx","credentials");
		return data;
		
	}
	
	//Step 1

	public static Object[][] testdata(String excelfile , String sheetname) {

		excelutils eu = new excelutils(excelfile, sheetname);

		int rowcount = eu.getrowcount();
		int colcount = eu.getcolumncount();
		
		Object[][] data = new Object[rowcount-1][colcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {

				String celldata = eu.getcelldata(i, j);
				//System.out.print(celldata+" | ");
				data[i-1][j] = celldata;
			}
			//System.out.println();
		}
		return data;
		
		

	}
	
}
