package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebElement UserID = driver.findElement(By.id("user_login"));
	    UserID.sendKeys("root");
	    WebElement Password = driver.findElement(By.id("user_pass"));
	    Password.sendKeys("pa$$w0rd");	    
	    driver.findElement(By.id("wp-submit")).click();
	    WebElement element = driver.findElement(By.tagName("h1"));
	    String LoginPage = element.getText();
	    if (LoginPage.equals("Dashboard")) {
	    	System.out.println("User logged in successfully");
	    }
	    else {
	    	System.out.println("User is unable to login");
	    }
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
	    driver.findElement(By.linkText("Add New")).click();
	    driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[1]/button")).click();
	    driver.findElement(By.xpath("//div[starts-with(@id,'editor-')]")).sendKeys("Associate System Engineer");
	    driver.findElement(By.id("_company_website")).sendKeys("https://www.ibm.com/in-en");
	    driver.findElement(By.id("_company_twitter")).sendKeys("https://twitter.com/IBM%20INDIA%20Pvt%20Ltd");
	    driver.findElement(By.id("_job_location")).sendKeys("Pune");
	    driver.findElement(By.id("_company_name")).sendKeys("IBM India PVT.LTD.");
	    driver.findElement(By.id("_company_tagline")).sendKeys("THINK");
	    driver.findElement(By.xpath("//button[contains(@class,'components-button editor-post-publish')]")).click();
	    
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("View Job")).click();
	    WebElement ApplyjobButton = driver.findElement(By.xpath("//input[@class = 'application_button button']"));
	    if (ApplyjobButton != null) {
	    	System.out.println("the job listing was posted ");
	    	driver.close();
	    }
	    else {
	    	System.out.println("the job listing was not posted ");	
	    }
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
      driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }

  @AfterMethod
  public void afterMethod() {
  }

}