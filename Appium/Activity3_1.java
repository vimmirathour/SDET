package tests;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity3_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "realme 5 Pro");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationNames", "UiAutomator2");
        caps.setCapability("noReset", true);
        
        // Use your own device's messaging app
        caps.setCapability("appPackage", "com.android.mms");
        caps.setCapability("appActivity", ".ui.ConversationList");

        // Instantiate Appium Driver
        try { 		
            // Initialize driver
            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(appServer, caps);
            System.out.println("Message app is open");
        } 
        catch (MalformedURLException e) 
        {
            System.out.println(e.getMessage());
  	
        }
    }

    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
    	driver.findElements(By.className("android.widget.Button")).get(1).click();
        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.android.mms:id/compose_recipients_name\")";
        // Enter your own phone number
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("7838370416");

        // Focus on the message text box
        String messageBoxLocator = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();

        // Type in a message
        messageBoxLocator = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        composeMessageInput.sendKeys("Hello from Appium");

        // Send the message
        driver.findElement(MobileBy.AccessibilityId("JioSend")).click();

        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.mms:id/text_view")));

        // Assertion
        String messageLocator = "resourceId(\"com.android.mms:id/text_view\")";
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}