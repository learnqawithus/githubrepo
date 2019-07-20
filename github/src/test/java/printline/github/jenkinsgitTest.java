package printline.github;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jenkinsgitTest {
	
	WebDriver driver;
	
	@Test
	public void GoogleTest () {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Fawad Anwar/Documents/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Assert.assertTrue(driver.getTitle().contains("xyz"));
	}

}
