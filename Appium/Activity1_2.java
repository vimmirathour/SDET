package tests;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Activity1_2 {
	AppiumDriver<MobileElement> driver = null;
	
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException  {
	  
      // Set the Desired Capabilities
		
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Vivo1714");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationNames", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.bbkcalculator");
      caps.setCapability("appActivity", ".Calculator");
      caps.setCapability("noReset", true);
      
      try { 		
          // Initialize driver
          URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
          driver = new AndroidDriver<MobileElement>(appServer, caps);
          System.out.println("Calculator is open");
      } 
      catch (MalformedURLException e) 
      {
          System.out.println(e.getMessage());
	
      }
  }
  
  @Test
  public void multiply() {
	  
	  driver.findElementById("digit7").click();
	  driver.findElementById("mul").click();
	  driver.findElementById("digit6").click();
	  driver.findElementById("equal").click();
	  
	  //Display Result
	  String result = driver.findElementById("edit_result_text").getText();
	  System.out.println(result);
	  
  }
  
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
	  
  }

}