package com.cybertek.tests.day19_ddf;

import com.cybertek.pages.DashBoard;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil qa3short = new ExcelUtil("src\\test\\Resources\\Vytracktestdata.xlsx","QA3-short");

        String[][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test (dataProvider = "userData")
    public void loginTestDDF(String userName,String password,String firstName,String lastName) throws InterruptedException {
        extentLogger = report.createTest("Test " + firstName + " " + lastName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);

        DashBoard dashBoard = new DashBoard();
        dashBoard.waitUntilLoaderScreenDisappear();
        Thread.sleep(2000);

        String actualFullName = dashBoard.getUserName();
        String expectedFullName = firstName + " " + lastName;

        Assert.assertEquals(actualFullName,expectedFullName);
        extentLogger.pass("PASS");



    }
}
