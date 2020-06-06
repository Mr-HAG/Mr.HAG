package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        System.out.println("Second Test case");
        Assert.assertEquals("url","url");

    }
    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify title start with Cyb");
        Assert.assertTrue(2>1,"I am checking is 2 greater than 1");

    }
    @Test
    public void test4(){
        // verify that email contains @

        String email="mikesmith.com";

        Assert.assertTrue(email.contains("@"),"verify email has @");

    }
    @Test
    public void test5(){

        // verify something is false

        Assert.assertFalse(0>1, "verify o is greater than 1 is false");

    }
}
