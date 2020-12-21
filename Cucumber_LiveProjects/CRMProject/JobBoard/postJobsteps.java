package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostaJobSteps {
	WebDriver driver;
    WebDriverWait wait;
    @Given("^Browser is open with Alchemy jobs and User is navigated to Post a job page  and signing in$")
    public void PostaJob() {
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
     // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Website title is: " + title);    
    	
    	// Clicking on "Post a Job" menu button
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
	    // Instantiating webdriver wait
            wait = new WebDriverWait(driver,10); 
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class= 'entry-title']"))));
            driver.findElement(By.linkText("Sign in")).click();
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='user_login']"))));
        	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        	driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        	driver.findElement(By.id("wp-submit")).click();
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("job_title"))));
    }
    
    @When("^User enters\"(.*)\"and\"(.*)\"and\"(.*)\"$")	
    public void user_enters_and(String jobtitle, String location, String Description) throws Throwable {
    	// Entering job title
	    WebElement jobTitle = driver.findElement(By.xpath("//input[@id = 'job_title']"));	    
	    jobTitle.sendKeys(jobtitle);
	    // Entering job location
        WebElement  jobLocation= driver.findElement(By.xpath("//input[@id='job_location']"));
        jobLocation.sendKeys(location);
     // Switching to iframe for entering Description of job
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")));
        // Entering description and switching back to main page
        WebElement  descriptionPage= driver.findElement(By.xpath("//body[@id='tinymce']"));
        descriptionPage.sendKeys(Description);
        driver.switchTo().defaultContent();
    }
    @And("^Click submit$")
    public void SubmitJob() {
    	// Clicking on "Preview" button
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        // Clicking on "Submit Listing" button
        driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
    }
    
	@Then("^Go to jobs page and confirm the job listing$")
    public void JobVerification() {
    	// Verifying the listed job by clicking on "click here" link
        driver.findElement(By.linkText("click here")).click();
        // Assertion for verifying if job is listed       
        Assert.assertTrue(driver.getTitle().toString().contains("System Engineer"));
        System.out.println("\n"+ "System Engineer" + ": Job has been posted successfully"); 
	    
    }
	@And("^Close the browser.$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
    
}