package com.cybertek.tests.day7_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioButtonTest1(){
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        System.out.println("blueRadioButton.isSelected()= " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected()= " + redRadioButton.isSelected());


        Assert.assertTrue(blueRadioButton.isSelected(),"verify blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(),"verify red is not selected");

        redRadioButton.click();

        Assert.assertFalse(blueRadioButton.isSelected(),"verify blue is not selected");
        Assert.assertTrue(redRadioButton.isSelected(),"verify red is selected");

        driver.quit();


    }


}
