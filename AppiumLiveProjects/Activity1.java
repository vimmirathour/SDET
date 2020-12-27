package testsActivities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity1 {
	
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
  
  
  @BeforeClass
  public void setup() throws MalformedURLException {

      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Realme 5 Pro");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationNames", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      try { 		
          // Initialize driver
          URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
          driver = new AndroidDriver<MobileElement>(appServer, caps);
          System.out.println("Google Tasks app is open");
      } 
      catch (MalformedURLException e) 
      {
          System.out.println(e.getMessage());
	
      }
  }

  
  @Test
  public void addTasks() {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	    
      MobileElement addNewTask = driver.findElement(MobileBy.AccessibilityId("Create new task"));
      addNewTask.click();
      
      
   // Save the task
      MobileElement saveTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
    
      MobileElement firstTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
      firstTask.sendKeys("Complete Activity with Google Tasks");
      saveTask.click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/task_item_layout")));
      
     addNewTask.click();
     MobileElement secondTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
     secondTask.sendKeys("Complete Activity with Google Keep");
     saveTask.click(); 
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/task_item_layout")));
     
     addNewTask.click();
     MobileElement thirdTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
     thirdTask.sendKeys("Complete the second Activity Google Keep");
     saveTask.click(); 
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/task_item_layout")));
          
     
     List<MobileElement> numberOfTasks = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout");
     System.out.println("Number of image shown currently: " + numberOfTasks.size());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     
     //numberOfTasks = driver.findElementById("com.google.android.apps.tasks:id/tasks_list");
     //System.out.println("Number of image shown currently: " + numberOfTasks.size());
     
     // Assertion to ensure all three tasks
     Assert.assertEquals(numberOfTasks.size(), 3);
  }

  @AfterClass
  public void tearDown() {
      driver.quit();
  }

}