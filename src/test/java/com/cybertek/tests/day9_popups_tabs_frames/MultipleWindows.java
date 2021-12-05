package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void SwitchWindowTest() {

        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("title before new window: " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Title after new window: " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
    }

}
