package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsText {

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
        driver.quit();

    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the user interactions
        //how to create actions object-->passing driver as a constructor
        Actions actions = new Actions(driver);

        //perform() --> perform the action, complete the action
        //moveToElement --> move your mouse to webElement(hover over
        Thread.sleep(3000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        //verify that the message is displayed
        Assert.assertTrue(viewLink.isDisplayed(), "verify view link is displayed");
        //optional verification
        System.out.println("viewLink.isDisplayed() = " + viewLink.isDisplayed());

    }

    @Test
    public void DragAndDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source, target).perform();


    }

    @Test
    public void DragAndDropChains() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(3000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();


    }


}
