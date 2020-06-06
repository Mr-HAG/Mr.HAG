package com.cybertek.testCases_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork_Part3 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
    }


   @Test
    public void case9_12 () throws InterruptedException {

        List<WebElement> codes = driver.findElements(By.xpath("//div//ul/li"));
        String [] codesName = new String[codes.size()];

       for (int i = 0; i <codes.size(); i++) {
             codesName[i]=codes.get(i).getText();

       }


        for (int i = 0; i < codes.size(); i++) {

            driver.findElement(By.partialLinkText(codesName[i])).click();

           WebElement result = driver.findElement(By.xpath("//p"));
           String actualResult = result.getText();
           String expectedResult = "This page returned a " + codesName[i] + " status code";
            System.out.println("actualResult = " + actualResult);
            System.out.println("expectedResult = " + expectedResult);
            Assert.assertTrue(actualResult.contains(expectedResult), "verify code");
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }




}
