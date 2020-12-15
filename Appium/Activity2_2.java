package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity2_2 {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "realme 5 Pro");
        caps.setCapability("platformName", "android");
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
    public void add() {
        driver.findElementById("digit5").click();
        driver.findElementById("plus").click();
        driver.findElementById("digit9").click();
        driver.findElementById("equal").click();

        // Display Result
        String result = driver.findElementById("edit_result_text").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }
    
    @Test
    public void subtract() {
        driver.findElementById("digit1").click();
        driver.findElementById("digit0").click();
        driver.findElementById("minus").click();
        driver.findElementById("digit5").click();
        // Perform Calculation
        driver.findElementById("equal").click();

        // Display Result
        String result = driver.findElementById("edit_result_text").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiply() {
        driver.findElementById("digit5").click();
        driver.findElementById("mul").click();
        driver.findElementById("digit1").click();
        driver.findElementById("digit0").click();
        driver.findElementById("digit0").click();
        // Perform Calculation
        driver.findElementById("equal").click();

        // Display Result
        String result = driver.findElementById("edit_result_text").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void divide() {
        driver.findElementById("digit5").click();
        driver.findElementById("digit0").click();
        driver.findElementById("div").click();
        driver.findElementById("digit2").click();
        // Perform Calculation
        driver.findElementById("equal").click();

        // Display Result
        String result = driver.findElementById("edit_result_text").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}