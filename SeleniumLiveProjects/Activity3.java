package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
  @Test
  public void ImageURL() {
	  WebElement Image = driver.findElement(By.className("attachment-large"));
	  String srcURL = Image.getAttribute("src");
	  System.out.println("url of the header image: " +srcURL);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
      driver.get("https://alchemy.hguy.co/jobs");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}