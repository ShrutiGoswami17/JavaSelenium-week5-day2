package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseIncidentClass{
	
@Test(priority=1)	
	public void updateIncident() throws InterruptedException
	{	
		
		System.out.println("Incident value from UpdateIncident:"+incident);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(incident);
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);
		System.out.println("incident searched");
		Thread.sleep(3000);
		//driver.findElement(By.className("linked formlink")).click();
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		//driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		WebElement incidenturgency = driver.findElement(By.id("incident.urgency")); 
		new Select(incidenturgency).selectByIndex(0); 
		WebElement incidentstate = driver.findElement(By.id("incident.state")); 
		new Select(incidentstate).selectByIndex(1); 
		String InciStateVerify =driver.findElement(By.id("incident.state")).getText();
		
		if (InciStateVerify.contains ("In Progress")) {
			System.out.println("Displayed State is Correct");
		} else
			System.out.println("Displayed State is Not Correct");
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
			
		System.out.println("Incident has been updated sucessfully");

		
		
		
	
}
}
