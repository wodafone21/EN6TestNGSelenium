package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the Destroy the World button
        //driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        //click NO button
        driver.findElement(By.xpath("//*[@id=j_idt303:j_idt308]]")).click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //click for JS Alert Button
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS Alert pop up
        Alert alert = driver.switchTo().alert();

        alert.accept();
        Thread.sleep(3000);

        //click for JS confirm
        driver.findElement(By.xpath("//button[1]")).click();
        Thread.sleep(3000);
        alert.dismiss();

        //click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();

        //send keys to JS Prompt
        alert.sendKeys("Mike Smith");

        //click OK
        alert.accept();

    }
}
