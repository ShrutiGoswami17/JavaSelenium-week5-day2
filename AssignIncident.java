package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends BaseIncidentClass {
	
@Test (priority=2)
	
	public void assignIncident() throws InterruptedException {
		
		
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
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[@name='lookup.incident.assignment_group']//span[1]")).click();
		System.out.println("Assign gp search button selected");
		Set<String> Handles = driver.getWindowHandles();
		List<String> HandlesList = new ArrayList<String>();
		HandlesList.addAll(Handles);
		driver.switchTo().window(HandlesList.get(1));
		Thread.sleep(5000);
		WebElement filter2 = driver.findElement(By.xpath("(//*[contains(text(),'Search')])[3]"));
		filter2.sendKeys("software");
		filter2.sendKeys(Keys.ENTER);
		System.out.println("search bar is selected");
		Thread.sleep(4000);	
		
		//6. Update the incident with Work Notes
		
		driver.findElement(By.xpath("//*[@id='row_sys_user_group_8a4dde73c6112278017a6a4baf547aa7']/td[3]/a")).click();
		driver.switchTo().window(HandlesList.get(0));
		System.out.println("Assigned gp as software has been entered");
		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Testing");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		System.out.println("Incident has been updated sucessfully");
	}

}
