package stepDefinitions;

import java.util.List;

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

public class ApplyingforJobSteps {
	WebDriver driver;
    WebDriverWait wait;
    @Given("^Browser is open with Alchemy jobs site$")
    public void loginPage() {
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
     // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Website title is: " + title);
    }
    @When("^User is navigated to jobs page and find the keyword for search input field$")	
    public void JobsPage() {	
        //Navigate to jobs page	
        driver.findElement(By.linkText("Jobs")).click();
        //Find the search field	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("entry-title")));
        driver.findElement(By.id("search_keywords")).click();        	
    }
    @And("^Search for Jobs$")
    public void SearchforJob() {
    	//Search for job
    	driver.findElement(By.id("search_keywords")).sendKeys("Selenium expereienced");
    }
     @And("^Set the filter job type to show only fulltime job$")
     public void ChangeJobType() {
    	//Set the filter only for fulltime jobs
     	WebElement checkBoxFullTime = driver.findElement
     			(By.xpath("//input[@id='job_type_full-time']"));
     	if(!checkBoxFullTime.isSelected()) {
     		checkBoxFullTime.click();
     	}
     	
     	WebElement checkBoxFreelance = driver.findElement
     			(By.xpath("//input[@id='job_type_freelance']"));
     	WebElement checkBoxInternship = driver.findElement
     			(By.xpath("//input[@id='job_type_internship']"));
     	WebElement checkBoxPartTime = driver.findElement
     			(By.xpath("//input[@id='job_type_part-time']"));
     	WebElement checkBoxTemporary = driver.findElement
     			(By.xpath("//input[@id='job_type_temporary']"));
     	
     	if(checkBoxFreelance.isSelected()) {
     		checkBoxFreelance.click();    		
     	}
     	if(checkBoxInternship.isSelected()) {
     		checkBoxInternship.click();
     	}
     	if(checkBoxPartTime.isSelected()) {
     		checkBoxPartTime.click();
     	}
     	if(checkBoxTemporary.isSelected()) {
     		checkBoxTemporary.click();
     	}
    	
    }
     @And("^Find a job listing and check the job details and print the title to the console$")
     public void FindJobListing() {
 	    // Waiting for search results to load
 		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'showing_jobs')]"))));
 		// Passing the search results into a web elements list
 		List <WebElement> jobsList = driver.findElements(By.xpath("//ul[@class='job_listings']//li"));
 	// Finding which job listed is available and then clicking it
		
 			for (int i=0; i<jobsList.size(); i++) {
 			    WebElement job = jobsList.get(i);
 			    if (job.getAttribute("class").toString().contains("job") && !job.getAttribute("class").toString().contains("filled")) {
 			    	job.click();
 			    	break;
 			        }         
 			    }
 			 // Check the title of the page
 	        String jobtitle = driver.getTitle();
 	            
 	        //Print the title of the page
 	        System.out.println("Job title is: " + jobtitle);
     }
     @Then("^Click on Apply for Job button$")
     public void ApplyforJob() { 
    	// Waiting for job page to load 
 		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class = 'application_button button']"))));
 		// Clicking on "Apply for job" button
 		driver.findElement(By.xpath("//input[@class = 'application_button button']")).click();
 		String emailId = driver.findElement(By.xpath("//a[@class = 'job_application_email']")).getText();
	    System.out.println("To apply for this job email your details to : " + emailId);
    	 
     }
     @And("^Close browser$")
     public void closeBrowser() {
         //Close browser
         driver.close();
     }
    
    
}