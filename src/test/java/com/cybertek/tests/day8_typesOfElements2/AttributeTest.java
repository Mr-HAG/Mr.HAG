package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));

        //get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));
        //get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));
        //get the value of checked
        // if the attribute has no value it will return true or false value
        System.out.println(radioButton.getAttribute("checked"));
        //when we use non exist attribute it will returns null
        System.out.println(radioButton.getAttribute("href"));

        System.out.println(radioButton.getAttribute("outerHTML"));

        driver.navigate().to("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button= driver.findElement(By.name("button2"));
        System.out.println(button.getAttribute("outerHTML"));


        driver.quit();

    }
}
