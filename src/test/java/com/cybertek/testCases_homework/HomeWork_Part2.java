package com.cybertek.testCases_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork_Part2 {

    @Test
    public void case6() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement emailName = driver.findElement(By.id("email"));
        String name = emailName.getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys("HAG");
        driver.findElement(By.name("email")).sendKeys(name);
        driver.findElement(By.name("wooden_spoon")).click();

        WebElement signUp = driver.findElement(By.className("subheader"));
        Assert.assertTrue(signUp.isDisplayed());

        driver.navigate().to("https://www.tempmailaddress.com/");


        driver.findElement(By.xpath("//td[contains(.,' do-not-reply@practice.cybertekschool.com’)]")).click();

        WebElement cyber = driver.findElement(By.id("odesilatel"));
        String expected= "do-not-reply@practice.cybertekschool.com";
        String actual = cyber.getText();
        Assert.assertEquals(actual,expected);
        cyber.click();

        WebElement subs = driver.findElement(By.id("predmet"));
        String expectedResult = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualResult = subs.getText();
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void case7() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys("C:\\Users\\MR.HAG\\Desktop\\txt doc.txt");

        driver.findElement(By.id("file-submit")).click();

        WebElement uploaded = driver.findElement(By.xpath("//h3"));
        String actual= uploaded.getText();
        Assert.assertEquals(actual,"File Uploaded!");

        WebElement uploaded1 = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploaded1.isDisplayed());

    }

    @Test
    public void case8(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        WebElement displayMessage = driver.findElement(By.id("result"));

        Assert.assertTrue(displayMessage.isDisplayed());
    }


}
