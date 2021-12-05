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

public class HoverTest_usingLoop {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void oneImage() {
        //Hover over each image in the website
        //verify each name:user text is displayed

        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //creating action method
        Actions actions = new Actions(driver);

        //hovering the mouse to the webElement
        actions.moveToElement(img1).perform();

        //locating the user1
        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        //verify the text
        Assert.assertTrue(text1.isDisplayed(), "verify that text1 is displayed");

        // Assert.assertEquals(text1.isDisplayed(), "true");

    }

    @Test
    //Hover over each image in the website
    //verify each name:user text is displayed
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        //Because we will hover 3 times img1, img2, img3, it is better to use loop and locate them dynamically
        for (int i = 1; i <= 3; i++) {


            String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            //creating action method
            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            //hovering the mouse to the webElement
            actions.moveToElement(img).perform();


            //VERIFICATION
            //locating the "users names" in DYNAMIC WAY
            String textXpath = "//h5[.='name: user"+i+"']";
            WebElement text1 = driver.findElement(By.xpath(textXpath));

            //verify the text
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(), "you can even add +i+ here too: verify user "+i+" is displayed");

        }

    }

}
