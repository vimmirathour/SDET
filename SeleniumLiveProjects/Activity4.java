package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver = new FirefoxDriver();
	//driver = new FirefoxDriver();
  @Test
  
  public void jobTestCase() {
	  String heading= driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
	  System.out.println("Page title is: " + heading);
	  Assert.assertEquals("Quia quis non", heading);
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver.get("https://alchemy.hguy.co/jobs/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  

}