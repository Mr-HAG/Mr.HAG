package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        // create select object by passing that element as a constructor
        Select stateDropDown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown List
        List<WebElement> options = stateDropDown.getOptions();

        System.out.println("options.size() = " + options.size());

        //print options by one by
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        //verify that first selection is Select  a state
        String expectedOption = "Select a State";
        String actualSelection = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelection,expectedOption,"verify first selection");

        // how to select options from dropdown
        //1. select using visible text

        Thread.sleep(2000);
        stateDropDown.selectByVisibleText("Texas");

        expectedOption = "Texas";
        actualSelection = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelection,expectedOption);

        //2. select using index
        Thread.sleep(2000);

        stateDropDown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualSelection = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelection,expectedOption);

        //3.Select by value
        Thread.sleep(2000);

        stateDropDown.selectByValue("DC");


        expectedOption = "District Of Columbia";
        actualSelection = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelection,expectedOption);

        Thread.sleep(2000);
        driver.quit();


    }
}
