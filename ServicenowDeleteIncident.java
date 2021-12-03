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

public class ServicenowDeleteIncident extends BaseServicenow {
	
	@Test(dependsOnMethods = "week5.day1assignments.ServicenowAssignIncident.servicenowAssignIncident")
	public void servicenowDeleteIncident() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010018");
		Actions builder2 = new Actions(driver);
		builder2.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		
		driver.findElement(By.id("sysverb_delete")).click();
		
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		/*
		 * driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(
		 * "INC0010016"); Actions builder4 = new Actions(driver);
		 * builder4.sendKeys(Keys.ENTER).perform(); Thread.sleep(2000);
		 * 
		 * String result =
		 * driver.findElement(By.cssSelector("table#incident_table>tbody>tr>td")).
		 * getText(); System.out.println("Result :" +result);
		 */

	}

}
