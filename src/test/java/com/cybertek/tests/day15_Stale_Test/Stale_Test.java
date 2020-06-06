package com.cybertek.tests.day15_Stale_Test;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Stale_Test extends TestBase {

    @Test
    public void test1(){


        driver.get("https://www.google.com");

        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(results.isDisplayed());

        driver.navigate().back();
        input = driver.findElement(By.name("q")); //after navigate we need to put this line for to find element
        input.sendKeys("Java" +Keys.ENTER);
        results = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(results.isDisplayed());


    }
}
