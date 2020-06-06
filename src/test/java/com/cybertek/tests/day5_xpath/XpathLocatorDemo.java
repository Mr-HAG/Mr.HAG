package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class XpathLocatorDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2=driver.findElement(By.xpath("//h3[.='Multiple buttons']"));

        button2.click();

        Thread.sleep(3000);

        driver.navigate().to("http://practice.cybertekschool.com/sign_up");

        WebElement sign_up = driver.findElement(By.xpath("//button[@type='submit']"));

        sign_up.click();





        
    }


}
