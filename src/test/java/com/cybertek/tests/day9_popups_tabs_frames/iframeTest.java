package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        //How to switch frames
        //1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");
        Thread.sleep(3000);

        //goes back to first frame(main html)
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2. switching with INDEX
        driver.switchTo().frame(0);
        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with INDEX");

        //second way to go back to switch parent
        driver.switchTo().parentFrame();


        //3. USING WEBELEMENT
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        Thread.sleep(3000);
        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MIKE SMITH WITH WEBELEMENT");

    }

    @Test
    public void test2 () {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //firstly, switching to frame top
        driver.switchTo().frame("frame-top");

        //top has 3 frames under left, middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //goes back to top frame
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main HTML to switch bottom
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());



    }



}
