package com.cybertek.testCases_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork_Part1 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
      //  driver.quit();
    }

    @Test
    public void case1(){

        WebElement birthday = driver.findElement(By.xpath("//input[@name='birthday']"));

        birthday.sendKeys("wrong_dob");

        WebElement invalid = driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));

        Assert.assertTrue(invalid.isDisplayed());
    }

    @Test
    public void case2(){


        List<WebElement> languages = driver.findElements(By.xpath("//*[@class = 'form-check form-check-inline']"));

        for (WebElement language : languages) {

            Assert.assertTrue(language.isDisplayed());

        }
    }

    @Test
    public void case3(){


        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("a");

        WebElement invalidData = driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(invalidData.isDisplayed());
    }

    @Test
    public void case4(){

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("a");

        WebElement invalidLast = driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(invalidLast.isDisplayed());
    }

    @Test
    public void case5() throws InterruptedException {

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mike");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("MikeSmith");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mike@smith.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mikesmithpass");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("571-000-0000");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("02/04/1991");

        Select selectDepartment = new Select(driver.findElement(By.name("department")));
        selectDepartment.selectByValue("DE");


        Select selectJob = new Select(driver.findElement(By.name("job_title")));
        selectDepartment.selectByIndex(2);



        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

       WebElement expected= driver.findElement(By.tagName("p"));

       Assert.assertTrue(expected.isDisplayed());


    }


}

