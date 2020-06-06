package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsandAlerts {

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

    public void test1() {

        driver.get("http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.='Destroy the World]")).click();

        //locate and click no button
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test

    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[2]")).click();

        //switch to JS alert windows
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK/confirm button on the alert
        alert.accept();

        /*
        //click the cancel/NO button
        alert.dismiss();
        */

        /*
        //write some words and accept this
        alert.sendKeys("Mike Smith");
        alert.accept();
         */

    }



}
