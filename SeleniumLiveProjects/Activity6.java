package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs");
	
	  }
  @Test
  public void f() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement JobsMenuItem = driver.findElement(By.linkText("Jobs"));
    JobsMenuItem.click();
    WebElement JobsPageTitle = driver.findElement(By.tagName("h1"));
    wait.until(ExpectedConditions.visibilityOf(JobsPageTitle));
    System.out.println ("Title of the webpage is: " +JobsPageTitle.getText());
    WebElement Search =driver.findElement(By.id("search_keywords"));
    Search.sendKeys("Associate system Engineer");
    driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[1]/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@class = 'application_button button']")).click();
    WebElement Email = driver.findElement(By.xpath("//a[@class = 'job_application_email']"));
    String EmailDetails = Email.getText();
    System.out.println("To apply for this job email your details to : " +EmailDetails);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}