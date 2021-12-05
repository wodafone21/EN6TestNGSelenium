package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1 () throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton = driver.findElement(By.cssSelector("#red"));

        System.out.println("blueRadioButton = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton = " + redRadioButton.isSelected());

        //verify that blue is selected and red is NOT selected
        //blue --> true
        Assert.assertTrue(blueRadioButton.isSelected(), "verify the blue button is selected");
        //red --> flase
        Assert.assertFalse(redRadioButton.isSelected(), "verify that red button is not selected");

        //how to click radio button
        //clicking the red radio button
        redRadioButton.click();

        //verify that blue is NOT selected and red is selected
        //blue --> false
        Assert.assertFalse(blueRadioButton.isSelected(), "verify the blue button is selected");
        //red --> false
        Assert.assertTrue(redRadioButton.isSelected(), "verify that red button is not selected");


        Thread.sleep(3000);
        driver.quit();

     }
}
