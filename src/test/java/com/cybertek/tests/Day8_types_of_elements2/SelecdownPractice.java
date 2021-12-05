package com.cybertek.tests.Day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelecdownPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("dropdown")));
        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");

    }

    @Test
    public void test2() {
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("CA");
        String expected = "California";
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);

    }

    @Test
    public void test3() {
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(8);
        String expected = "Delaware";
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);

    }

    @Test
    public void test4() {
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByVisibleText("Alabama");
        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();

        String expectedValue = "AL";
        String actualValue = select.getFirstSelectedOption().getAttribute("value");

        System.out.println("expectedValue = " + expectedValue);
        System.out.println("actualValue = " + actualValue);

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
    }

    @Test
    public void test5() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            select.selectByVisibleText(option.getText());
        }
        Thread.sleep(3000);
        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

        for (WebElement option : allSelectedOptions) {
            System.out.println("option.getText() = " + option.getText());
        }

    }

        @Test
        public void test6() {

        WebElement dropdown = driver.findElement(By.id("dropdownMenuLink"));
        WebElement option = driver.findElement(By.linkText("https://www.google.com/"));
        option.click();

    }



    }

