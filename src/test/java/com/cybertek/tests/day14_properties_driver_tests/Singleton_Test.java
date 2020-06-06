package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Singleton_Test {

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = Driver.get();

        driver.get("http://www.google.com");

        Thread.sleep(2000);

    }

    @Test
    public void test3(){

        // WebDriver driver = Driver.get();


        Driver.get().get("http://www.amazon.com");
        //first get is coming from Driver class
        //the second one is coming from selenium

    }
}
