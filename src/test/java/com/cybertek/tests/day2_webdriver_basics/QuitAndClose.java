package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitAndClose {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.get("http://practice.cybertekschool.com");
//        //wait 2 seconds
//        Thread.sleep(2000);
//
//        //close the current tab/window
//        driver.close();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        //close all tabs doesn't matter one or more
        driver.quit();

    }
}
