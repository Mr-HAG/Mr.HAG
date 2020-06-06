package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox= driver.findElement(By.name("full_name"));

        fullNameInputBox.sendKeys("Mike Smith");

        WebElement emailName= driver.findElement(By.name("email"));

        emailName.sendKeys("mike@gmail.com");

        // proper way
        WebElement buttonClick= driver.findElement(By.name("wooden_spoon"));
        buttonClick.click();

        Thread.sleep(3000);

        // lazy way
       // driver.findElement(By.name("wooden_spoon")).click(); --> you can use as well

        WebElement message = driver.findElement(By.name("signup_message"));
        String actualMessage = message.getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        if(actualMessage.equals(expectedMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        WebElement homeAgain = driver.findElement(By.id("wooden_spoon"));

        homeAgain.click();

    }
}
