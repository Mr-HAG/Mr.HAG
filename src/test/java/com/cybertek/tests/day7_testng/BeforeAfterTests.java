package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {


    @Test
    public void test1(){

        System.out.println("This is my test 1");
    }

    @Test
    public void test2(){

        System.out.println("This is my test 2");

    }

    @Test
    public void test3(){

        System.out.println("This is my test 3");

    }
    @BeforeMethod
    public void setUp(){
        //WebDriver part
        System.out.println("Before Method Here");
        System.out.println("WebDriver Part");
    }

    @AfterMethod
    public void tearDown(){
        //close browser,quit
        System.out.println("After Method here");
        System.out.println("Driver Quit");
    }

    @BeforeClass
    public void setUpClass(){

        System.out.println("Before Class");
        System.out.println("Test Cases");

    }

    @AfterClass
    public void setUpAfter(){
        System.out.println("After Class");
        System.out.println("General Report here");
    }





}
