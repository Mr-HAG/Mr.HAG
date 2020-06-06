package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
       // Thread.sleep(5000);

        //wait up to 20 second,whenever it-findElement- finds it will return element
        //if web element isn't part of the HTML, this method works,
        //but if it is part of the HTML even it is hidden, this method doesn't work because findElement finds the element
        //This method comes from Selenium
        // We can put implicitly wait set anywhere but not after element what we want to find.

       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        String message = driver.findElement(By.cssSelector("#finish")).getText();
        System.out.println(message);
    }
}
