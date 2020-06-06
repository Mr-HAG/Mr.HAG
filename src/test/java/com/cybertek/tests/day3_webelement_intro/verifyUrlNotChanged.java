package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChanged {
    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // go to this page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // save url before we click retrieve password button
        String expectedUrl = driver.getCurrentUrl();

        // click on retrieve password
        // WebElement --> interface that represent elements on the webpage
        // findElement--> method used to find element on a webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        // clicking this element
        retrievePasswordButton.click();

       // save url after click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        // verify that url and not changed
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }

}
