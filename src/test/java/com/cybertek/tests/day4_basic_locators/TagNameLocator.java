package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith Tag Name");

        WebElement emailName = driver.findElement(By.tagName("input"));
        emailName.sendKeys("mikesmith@gmail.com");

        // this is a problem with tagName locator. when selenium find tagName it stops in the first one.
        // So you can use tagName only one time, once as well.

        // one of the laziest way
        System.out.println(driver.findElement(By.tagName("h3")).getText());

    }
}
