package JobBoardProject;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;


public class Activity5 {
WebDriver driver;
@BeforeMethod
public void beforeMethod() {
    //Create a new instance of the Firefox driver
    driver = new FirefoxDriver();
    //Open browser
	driver.get("https://alchemy.hguy.co/jobs");
}
@Test
public void pageTitleTestCase() {
		driver.findElement(By.xpath("//a[text()='Jobs']")).click();	
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);		
		String expectedTitle = "Jobs – Alchemy Jobs";
		Assert.assertEquals(expectedTitle,actualTitle);
}
@AfterMethod
public void afterMethod() {
    //Close the browser
    driver.quit();
}
}