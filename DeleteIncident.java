package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseIncidentClass {
@Test
	public void deleteIncident() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(8000);
		driver.switchTo().frame("gsft_main");
		Thread.sleep(8000);
		WebElement filter1 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		filter1.sendKeys(incident);
		filter1.sendKeys(Keys.ENTER);
		System.out.println("search incident is:  Pass");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		System.out.println("Incident # has been selected from Incident table list");
		driver.findElement(By.id("sysverb_delete")).click();
		System.out.println("Delete button selected");
	}

}
