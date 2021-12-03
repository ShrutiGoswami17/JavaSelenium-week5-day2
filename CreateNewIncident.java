package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewIncident extends BaseIncidentClass{
	
@Test(priority=0)

public void createNewIncident() throws InterruptedException
{
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.id("sysverb_new")).click();
	
	driver.findElement(By.id("lookup.incident.caller_id")).click();

	Set<String> handles = driver.getWindowHandles();
	List<String> handlesList = new ArrayList<String>();
	handlesList.addAll(handles);
	driver.switchTo().window(handlesList.get(1));
	System.out.println("Child window  selected");
	Thread.sleep(5000);
	driver.findElement(By.className("glide_ref_item_link")).click();
	driver.switchTo().window(handlesList.get(0));
	System.out.println("parent window  selected");
	
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.id("incident.short_description")).sendKeys("Added short Description");
	
	String incidentnum = driver.findElement(By.id("incident.number")).getAttribute("value");
	driver.findElement(By.id("sysverb_insert_bottom")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(incidentnum);
	driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	String Incident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

	if (Incident.equals(incidentnum)) {
		System.out.println("Incident Created Successfully");
	} else
		System.out.println("Incident Not Created");
	
	incident=incidentnum;
}
	

}
