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

public class CreateNewUserSteps {
	WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
    public void loginPage() {
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    } 
    @When("^User enters \"(.*)\" and \"(.*)\"$")	
    public void user_enters_and(String username, String password) throws Throwable {	
        //Enter username from Feature file	
        driver.findElement(By.id("user_login")).sendKeys(username);	
        //Enter password from Feature file	
        driver.findElement(By.id("user_pass")).sendKeys(password);	
        //Click Login	
        driver.findElement(By.xpath("//input[@type='submit']")).click();
	
    }
    @And("^Read the page title$")
    public void readTitle() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("wp-menu-name")));        
        //Read the page title and heading
        String pageTitle = driver.getTitle();        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
    }
    @And("^Locate the left hand menu and click the menu item that says Users$")
    public void ClickonUser() {
    	WebElement User =driver.findElement(By.linkText("Users"));
    	User.click();
    	// Fetching the header object of new loaded page into a web element
    	WebElement UsersPageTitle = driver.findElement(By.tagName("h1"));
        // Asking selenium to wait until the new page is loaded along with it's header element
    	wait.until(ExpectedConditions.visibilityOf(UsersPageTitle));
    	 	
    	
    }
    @And("^Locate the Add New button and click it$")
    public void AddNew() {
    	//Clicking on add new button
    	WebElement Addnewbutton = driver.findElement(By.linkText("Add New"));
    	Addnewbutton.click();      	
    }
    @And("^Fill in the necessary details and click add new user button$")
    public void NewUserDetails() throws InterruptedException {
    	//wait until add new user page loaded
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("add-new-user")));
    	driver.findElement(By.id("user_login")).sendKeys("vimmi123");
    	driver.findElement(By.id("email")).sendKeys("vimmi123@email.com");
    	Thread.sleep(1000);
    	WebElement Passwordbutton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[6]/td/button"));
    	Passwordbutton.click();
    	Thread.sleep(1000);
    	driver.findElement(By.id("createusersub")).click();
    	      	
    }
    
	@Then("^Verify that the user was created$")
    public void readMessage() {        
        //Read the page title and confirmation message
    	String ConfirmationMessage = driver.findElement(By.xpath("//div[@id='message']/p")).getText();
    	System.out.println(ConfirmationMessage);
    	Assert.assertEquals("New user created. Edit user", ConfirmationMessage);
    }
    
    @And("^Close the browser$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
    
    
    

}