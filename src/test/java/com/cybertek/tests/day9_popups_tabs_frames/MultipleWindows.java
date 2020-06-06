package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void SwitchWindowsTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println(driver.getTitle());
        Thread.sleep(1000);

        driver.findElement(By.linkText("Click Here")).click();
        //driver.findElement(By.xpath("//a[@target='_blank']"));
        Thread.sleep(1000);
        System.out.println(driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles.size() = " + windowHandles.size());

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after switching window = " + driver.getTitle());

    }

    @Test
    public void moreThan2Window() {

        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Before to switch window = " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

            // loop through each window
        for (String handle : windowHandles) {
            //one by one changed
            driver.switchTo().window(handle);
            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }

        System.out.println("After to switch window = " + driver.getTitle());



    }

}
