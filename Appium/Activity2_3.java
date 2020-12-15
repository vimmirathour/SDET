package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Activity2_3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "realme 5 Pro");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationNames", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".DialtactsContactsEntryActivity");
        caps.setCapability("noReset", true);

        try { 		
            // Initialize driver
            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(appServer, caps);
            System.out.println("Contacts app is open");
        } 
        catch (MalformedURLException e) 
        {
            System.out.println(e.getMessage());
  	
        }
    }

    @Test
    public void addContact() {
    	
        // Click on add new contact floating button
    
       MobileElement addNewContact = driver.findElements(By.className("android.widget.Button")).get(1);
       addNewContact.click();
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       // Find the first name, last name, and phone number fields
       
        MobileElement expandIcon = driver.findElementById("expansion_view");
        
     // Expand to get firstname,lastname fields
        
        expandIcon.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        firstName.sendKeys("Aaditya");
        
        // Scroll to get last name element

       MobileElement lastNameElement = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.android.contacts:id/editors\")).getChildByText("
				+ "new UiSelector().className(\"android.widget.EditText\"), \"Last name\")"));
     
        lastNameElement.click();
        
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
        lastName.sendKeys("Varma");
        
        // scroll to get phone number element
        MobileElement phoneNumberElement = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.android.contacts:id/sect_fields\")).getChildByText("
				+ "new UiSelector().className(\"android.widget.EditText\"), \"Phone\")"));
    
        phoneNumberElement.click();
        
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");        
        phoneNumber.sendKeys("9991284782");
        
        
        // Save the contact
        driver.findElementByXPath("//android.widget.Button[@text='Done']").click();
        
        
        // Wait for contact card to appear
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/list_container")));

        // Assertion
        MobileElement mobileCard = driver.findElementByXPath("//android.widget.TextView[@text='Vimmi rathore']");
        Assert.assertTrue(mobileCard.isDisplayed());
        
        
        String contactName = driver.findElementsByXPath("//android.widget.TextView[@text='Vimmi rathore']").get(0).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}