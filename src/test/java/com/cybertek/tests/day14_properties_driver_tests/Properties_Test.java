package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Properties_Test {

    @Test
    public void test1(){

        String browser = ConfigurationReader.get("browser");

        System.out.println(browser);

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        System.out.println(ConfigurationReader.get("driver_username"));

    }
}
