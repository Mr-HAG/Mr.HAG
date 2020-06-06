package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilePathExample {

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
    public void test(){
        //getting project location/path dynamically
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\Resources\\testfile.txt";

        System.out.println("projectPath = " + projectPath);
        System.out.println("relativePath = " + relativePath);

        String filePath = projectPath + "\\" + relativePath;
        System.out.println("filePath = " + filePath);
    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/upload");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\Resources\\testfile.txt";
        String filePath = projectPath + "\\" + relativePath;

        WebElement chooseFile=driver.findElement(By.name("file"));
        chooseFile.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();
        String actual= driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual,"testfile.txt");

    }
}
