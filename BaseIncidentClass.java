package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseIncidentClass {
	public static String incident;

	public ChromeDriver driver;
@Parameters({"url","username","password"})
@BeforeMethod
	public void setup(String url,String uName,String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Thread.sleep(8000);
		driver.switchTo().frame("gsft_main");
		System.out.println("frame has been selected");
		driver.findElement(By.id("user_name")).sendKeys(uName);
		driver.findElement(By.id("user_password")).sendKeys(pass);
		driver.findElement(By.id("sysverb_login")).click();
		
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

	}
@AfterMethod
	public void teardown()
	{
		driver.close();
	}


}
