package com.cybertek.tests.SaturdayLive;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void TestWithActionClass() throws InterruptedException {
        // Scroll down to "Powered By Cybertek School"
        Actions actions = new Actions(driver);

        // Locate the element that you will scrool to
        WebElement cybertekSchoolElement = driver.findElement(By.linkText("Cybertek School"));

        //scroll using the actions object, using moveToElement method

        actions.moveToElement(cybertekSchoolElement).perform();

        Thread.sleep(4000);

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();


        }

    @Test
    public void TestWithActionClass1() {
        // Scroll down to "Powered By Cybertek School"
        Actions actions = new Actions(driver);

        // Locate the element that you will scrool to
        WebElement cybertekSchoolElement = driver.findElement(By.linkText("Cybertek School"));

        //scroll using the actions object, using moveToElement method

        actions.moveToElement(cybertekSchoolElement).perform();

        //Thread.sleep(4000);

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

       // Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        }

    }

