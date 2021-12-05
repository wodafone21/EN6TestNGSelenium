package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class file_upload_test {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        chooseFile.sendKeys("C:\\Users\\wodaf\\OneDrive\\Desktop\\Ahmet.txt.txt");
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is Ahmet.txt.txt
        Assert.assertEquals(actualFileName, "Ahmet.txt.txt");

        Thread.sleep(2000);
       // driver.quit();





    }

}
