package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemoTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        Assert.assertFalse(usernameInput.isDisplayed(),"verify username is not displayed");

        driver.findElement(By.tagName("button")).click(); //#start>button da kullanılabilir css olarak

        //wait until it appearance

        Thread.sleep(6000);
        Assert.assertTrue(usernameInput.isDisplayed(),"verify username is displayed");

    }
}
