package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void jobTestCase() {
    	
    	String heading= driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
            
        System.out.println("Heading is: " + heading.trim());
        
        try {
        Assert.assertEquals("Welcome to Alchemy Jobs", heading.trim());
        driver.close();
        }
        
        catch(Exception ex){
        	
        	ex.printStackTrace();
        }
                  
    }

    }