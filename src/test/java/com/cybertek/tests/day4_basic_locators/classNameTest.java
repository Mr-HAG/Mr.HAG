package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        // if there is a space in the class attribute value we can not use it. Because it means there are two class in there.

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.quit();
    }
}
