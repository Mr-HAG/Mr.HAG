package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
       // driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the user interactions
        //how to create actions object / passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform() --> perform the action, complete the action
        //moveToElement--> move your mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement link = driver.findElement(By.xpath("//a[.='View profile']"));

        Assert.assertTrue(link.isDisplayed(),"verify View profile link is displayed");

    }

    @Test
    public void DragAndDrop() throws InterruptedException {


        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);


        //Clicking accept cookies
        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source, target).perform();

    }

        @Test
        public void DragAndDropChaining() {
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
            driver.manage().window().maximize();

            Actions action = new Actions(driver);
            WebElement source1 = driver.findElement(By.id("draggable"));
            WebElement target1 = driver.findElement(By.id("droptarget"));

            driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

            // drag and drop without draganddrop method
            //if your are chaining actions we add build before perform method
            action.moveToElement(source1).clickAndHold().moveToElement(target1).pause(2000).release().build().perform();






    }


}
