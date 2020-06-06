package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void Test1() {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1=driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[2]"));

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //how to verify checkbox is selected or not
        Assert.assertFalse(checkbox1.isSelected(),"verify checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");

    // how to click checkbox
    checkbox1.click();

    // verify again
        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");



    driver.quit();

    }

}
