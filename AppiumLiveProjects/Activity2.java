package testsActivities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {

      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Realme 5 Pro");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationNames", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noReset", true);

      try { 		
          // Initialize driver
          URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
          driver = new AndroidDriver<MobileElement>(appServer, caps);
          System.out.println("Google Keep notes app is open");
      } 
      catch (MalformedURLException e) 
      {
          System.out.println(e.getMessage());
	
      }
  }
  
  @Test
  public void addNewNote() {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	    
      MobileElement newNote = driver.findElement(MobileBy.AccessibilityId("New text note"));
      newNote.click();
      
      MobileElement addTitle = driver.findElementById("com.google.android.keep:id/editable_title");
      addTitle.sendKeys("Appium Activity");
      
      MobileElement addNotes = driver.findElementById("com.google.android.keep:id/edit_note_text");
      addNotes.sendKeys("hello world");
      
      driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      
      // Assertion
      MobileElement addedNewNote = driver.findElementById("com.google.android.keep:id/browse_text_note");
      Assert.assertTrue(addedNewNote.isDisplayed());
      
      
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}