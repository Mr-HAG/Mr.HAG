package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void printTable() {

        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
    }

    @Test
    public void printTableSize() {
        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());


        //number of rows without header (we prefer this most of time)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
    }

    @Test
    public void getRow() {

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());

        //get all the rows dynamically

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= allRows.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(row.getText());
        }
    }

    @Test
    public void getAllCellinOneRow() {

        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }

    }

    @Test
    public void getASingleCell() {
        WebElement justCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(justCell.getText());
    }

    @Test
    public void printAllCellsByIndex() {
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {
            //iterate through each cell for each row
            for (int j = 1; j <= colNumber; j++) {

                String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                //System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }
        }
    }

    @Test
    public void getCellinRelationToAnotherCellInSameRow () {

        //to find the one column or cell based the other column or cell
        // we need to use siblings relations

        String firstName = "John";
        String xpath = "//table[@id='table1']//td[.='" + firstName + "']/../td[3]"; //sibling relaations
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }

}
