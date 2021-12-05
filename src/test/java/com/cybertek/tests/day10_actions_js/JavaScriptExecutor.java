package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.quit();
    }

    @Test
    public void clickWithJS() {
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        //Why do we need JavaScript? Sometimes our click button doesn't work so we use JS
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", dropDownLink);

    }


    @Test
    public void typeWithJavaScript() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        //We create JSExecutor object
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //String message that we want to put in disabledInput Box
        String text = "Hello Disabled Input";

        //How to send message to disabled inputBox
        // We use JavaScript Executor
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);

    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(3000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(3000);
            jse.executeScript("window.scroll(0, -250);");

        }

    }

    @Test
    public void scrollToElement () throws InterruptedException {
        driver.get("https://amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);", eng);


    }



}


