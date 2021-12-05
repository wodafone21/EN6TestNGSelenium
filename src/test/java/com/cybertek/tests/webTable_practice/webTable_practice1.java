package com.cybertek.tests.webTable_practice;

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

public class webTable_practice1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void Test1 () {

        WebElement table = driver.findElement(By.xpath("//table[@id='task-table']"));
        System.out.println(table.getText());
        //Verify if table contains Bug fixing element
        Assert.assertTrue(table.getText().contains("Bug fixing"));
    }

    @Test
    public void Test2() {
        //How many columns we have in the table
        WebElement row1 = driver.findElement(By.xpath("//table[@id='task-table']//tbody/tr"));
        System.out.println(row1.getText());

        }

    @Test
    public void Test3() {
        //get size of column1
        List<WebElement> numRow1 = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr"));
        System.out.println(numRow1.size());

        for (WebElement element : numRow1) {
            System.out.println(element.getText());
        }

    }

    @Test
    public void Test4() {
        //get the list of row2
        WebElement row2 = driver.findElement(By.xpath("//table[@id='task-table']//tbody/tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());

    }

    @Test
    public void Test5() {
        //get one cell from row2
        WebElement oneCellInRow2 = driver.findElement(By.xpath("//table[@id='task-table']//tbody/tr[2]/td[3]"));
        System.out.println("oneCellInRow2.getText() = " + oneCellInRow2.getText());
    }

    @Test
    public void Test6() {

        List<WebElement> numRow1 = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr"));
        for (int i = 1; i <=numRow1.size(); i++) {

        WebElement row = driver.findElement(By.xpath("//table[@id='task-table']//tbody/tr["+i+"]"));
            System.out.println(i+ "-" + "row = " + row);


        }

    }

}
