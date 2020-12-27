package testsActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity4 {
	
	 AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Realme 5 Pro");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationNames", "UiAutomator2");
	        caps.setCapability("appPackage", "com.android.chrome");
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	        caps.setCapability("noReset", true);

	     // Instantiate Appium Driver
	        try { 		
	            // Initialize driver
	            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	            driver = new AndroidDriver<MobileElement>(appServer, caps);
	            System.out.println("Chrome is open");
	        } 
	        catch (MalformedURLException e) 
	        {
	            System.out.println(e.getMessage());
	  	
	        }
	        driver.get("https://www.training-support.net/selenium");
	    }

	
  @Test
  public void testToDoListPage() {
	  
	// wait for page to load
	 // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  MobileElement getStartedBtn = driver.findElementByXPath("//android.widget.Button[@text='Get Started!']");
	  getStartedBtn.click();
	  
      // Scroll to to-Do list
     
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Training Support - Selenium\"))")).click();
      
	  // TO-DO LIST 
	  MobileElement toDoListOption = driver.findElement(MobileBy.AccessibilityId("To-Do List Elements get added at run time"));
	  toDoListOption.click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Dynamically add and remove elements.']")));
	  
	  // Add tasks to list
	  
	  MobileElement taskName1 = driver.findElementById("taskInput");
	  taskName1.sendKeys("Add tasks to list");
	  
	  MobileElement addTaskBtn = driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Add Task']"));
	  addTaskBtn.click();
	  
	  MobileElement taskName2 = driver.findElementById("taskInput");
	  taskName2.sendKeys("Get number of tasks");
	  addTaskBtn.click();
	  
	  MobileElement taskName3 = driver.findElementById("taskInput");
	  taskName3.sendKeys("Clear the list");
	  addTaskBtn.click();
	  
	  //to strike 
	  List<MobileElement> tasksList = driver.findElementsById("tasksList");
	  tasksList.get(0).click();
	  tasksList.get(1).click();
	  tasksList.get(2).click();
	  
	  // clear tasks
	  
	  MobileElement clearBtn = driver.findElement(MobileBy.xpath("//android.view.View/android.widget.TextView[@text='Clear List']"));
	  clearBtn.click();
	  
	// Assertion
     
      Assert.assertTrue(tasksList.isEmpty());
	  
  }
 
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
  
}