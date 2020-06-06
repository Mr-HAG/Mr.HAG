package com.cybertek.testCases_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork_DataPro {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @DataProvider
    public Object[] codesName() throws InterruptedException {

        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        driver1.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        List<WebElement> codes = driver1.findElements(By.xpath("//div//ul/li"));
        String[] codesName = new String[codes.size()];

        for (int i = 0; i < codes.size(); i++) {
            codesName[i] = codes.get(i).getText();

        }

        Thread.sleep(2000);
        driver1.quit();
        return codesName;
    }

    @Test (dataProvider = "codesName")
    public void case9_12(String status) {

        driver.findElement(By.partialLinkText(status)).click();
        WebElement result = driver.findElement(By.xpath("//p"));
        String actualResult = result.getText();
        String expectedResult = "This page returned a " + status + " status code";
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertTrue(actualResult.contains(expectedResult), "verify code");

    }



}




