package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

     LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPasswordTest(){

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }

    @Test
    public void wrongUserNameTest() {


        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }

}
