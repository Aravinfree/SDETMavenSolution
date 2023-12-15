package com.SDET.programs.SDETAllProgramsinMaven;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcepts {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\WorkSpace\\SDET_Comprehensive_Assignment_JavaPythonProject\\Drivers\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        findAcceptCookiesButton(driver);
    }
    
    private static void findAcceptCookiesButton(WebDriver driver) {
    	// Check if the "Accept All Cookies" button exists
    	try {
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[text()='Accept All Cookies']")); 
        if (acceptCookiesButton != null) {
            // Click the "Accept All Cookies" button
            acceptCookiesButton.click();
        } else {
            System.out.println("Accept All Cookies button not found or already accepted.");
            // Handle the case where the button is not found or has already been accepted
        }
        } catch (Exception e) {
            // Handle the exception or return null
            System.out.println(e.getMessage());
        }
    }
    
   

    @Test(priority = 1, enabled = true, timeOut = 5000)
    public void testLogoPresence() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        Assert.assertTrue(logo.isDisplayed(), "Automation Anywhere logo is not present.");
    }
    
    @Test(priority = 2, enabled = false, timeOut = 5000)
    public void testmethod() {
    	System.out.println("Test Method");
    }
    
    @Test(priority = 3, enabled = true, timeOut = 5000)
    public void testRequestDemoButton() {
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[@title='Request demo']"));
        Assert.assertTrue(requestDemoButton.isDisplayed(), "Request demo button is not present.");
        Assert.assertTrue(requestDemoButton.isEnabled(), "Request demo button is not clickable.");
    }

    @Test(priority = 4, enabled = true, timeOut = 120000)
    public void testNavigationLinks() {
        String[] links = {"Products", "Solutions", "Resources", "Beyond RPA", "Company"};
        WebElement link = null;
        for (String linkText : links) {
        	if(linkText == "Beyond RPA"){
        		link = driver.findElement(By.xpath("//a[@title='" + linkText + "']"));
        	}else{
        		link = driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]"));
        	}
            Assert.assertTrue(link.isDisplayed(), linkText + " link is not present.");

            link.click();

            System.out.println("URL of the page: "+driver.getCurrentUrl());
        	String getCurrentURL = driver.getCurrentUrl();
        	if(linkText.equalsIgnoreCase("Beyond RPA")) {
        		Assert.assertEquals(getCurrentURL, "https://www.automationanywhere.com/rpa/robotic-process-automation");
        	}else if(linkText.equalsIgnoreCase("Products")) {
        		Assert.assertEquals(getCurrentURL, "https://www.automationanywhere.com/products");
        	}else if(linkText.equalsIgnoreCase("Solutions")){
        		Assert.assertEquals(getCurrentURL, "https://www.automationanywhere.com/solutions");
        	}else if(linkText.equalsIgnoreCase("Company")) {
        		Assert.assertEquals(getCurrentURL, "https://www.automationanywhere.com/company/about-us");
        	}else if(linkText.equalsIgnoreCase("Resources")) {
        		Assert.assertEquals(getCurrentURL, "https://www.automationanywhere.com/resources");
        	}
        	
        	// Verify navigation to the proper page
            System.out.println("Verifying navigation to the proper page after clicking " + linkText + " link...");
           


            // Navigate back to the home page for the next link verification
            driver.navigate().back();
        }
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}
