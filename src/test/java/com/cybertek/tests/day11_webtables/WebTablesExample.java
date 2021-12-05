package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();

    }

    @Test
    public void printTable() {
        //printing the whole table
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        //verify if table contains a specific email address
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com "));

    }

    @Test
    public void getAllHeaders() {
        //How many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void printTableSize() {
        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
    }

    @Test
    public void getRow() {
        //print the second row information
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());
        System.out.println("------------------------------------");

            //print the row3 elements
            WebElement row3 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
            System.out.println(row3.getText());

            System.out.println("-----------------------------------");

            //get all rows dynamically
            //1.find number of rows
            List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

            //2.iterate one by one
            for (int i = 1; i <= numRows.size(); i++) {
                WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
                System.out.println(i + "-" + row.getText());

            }

        }

        @Test
        public void getAllCellInOneRow () {
            List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

            for (WebElement element : allCellsInOneRow) {
                System.out.println(element.getText());
            }

        }

        @Test
        public void getASingleCellByIndex () {
            WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
            System.out.println(singleCell.getText());

        }

        @Test
        public void printAllCellsByIndex () {

            int rowNumber = getNumberOfRows();
            int colNumber = gelNumberOfColumns();

            System.out.println("colNumber = " + colNumber);
            System.out.println("rowNumber = " + rowNumber);

            //iterate through each row in the table
            for (int i = 1; i <= rowNumber; i++) {
                //iterate through each cell in the row
                for (int j = 1; j <= colNumber; j++) {

                    String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                    System.out.println(cellXpath);

                    WebElement cell = driver.findElement(By.xpath(cellXpath));
                    System.out.println(cell.getText());


                }

            }

        }

        @Test
        public void getCellInRelationToAnotherCellInSameRow () {

            String firstName = "Jason";
            String xPath = "//table[@id='table1']//td[.='" + firstName + "']/../td[3]";
            WebElement email = driver.findElement(By.xpath(xPath));
            System.out.println(email.getText());

        }

        private int gelNumberOfColumns () {
            List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
            return headers.size();
        }

        private int getNumberOfRows () {
            List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            return allRowsWithoutHeader.size();
        }

    }




