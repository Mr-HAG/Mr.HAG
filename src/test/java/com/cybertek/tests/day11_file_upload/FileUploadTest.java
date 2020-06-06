package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile=driver.findElement(By.name("file"));
        chooseFile.sendKeys("C:\\Users\\MR.HAG\\Desktop\\txt doc.txt");

        driver.findElement(By.id("file-submit")).click();
        String actual= driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual,"txt doc.txt");
    }
}
