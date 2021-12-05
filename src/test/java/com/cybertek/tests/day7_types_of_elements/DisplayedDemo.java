package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.id("username"));
        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        //Task
        //Verify username inputBox is not displayed on the screen
        Assert.assertFalse(userNameInput.isDisplayed(), "verify inputBox is not selected");
        //click start button
        //find start button and click
        driver.findElement(By.cssSelector("#start>button")).click();
        //wait until element is displayed
        Thread.sleep(3000);

        //verify userName displayed on the screen
        Assert.assertTrue(userNameInput.isDisplayed(), "verify username inputBoz is displayed");





    }
}
