package week5.day1assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ServicenowUpdateIncident extends BaseServicenow {

	@Test(dependsOnMethods = "week5.day1assignments.ServicenowNewIncident.servicenowNewIncident")
	public void servicenowUpdateIncident() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010018");
		Actions builder2 = new Actions(driver);
		builder2.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement dd = driver.findElement(By.id("incident.urgency"));
		Select urgency = new Select(dd);
		urgency.selectByValue("1");
		
		WebElement dd2 = driver.findElement(By.id("incident.state"));
		Select state = new Select(dd2);
		state.selectByValue("2");
		
		driver.findElement(By.id("sysverb_update")).click();
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010018");
		Actions builder3 = new Actions(driver);
		builder3.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		String incstate = driver.findElement(By.xpath("//span[text()='Incident state']/following-sibling::span/span")).getText();
		System.out.println("Updated incident state: " + incstate);

	}

}
