package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        //How to verify checkbox is selected or not
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //verify checkbox 1 is not selected checkbox 2 is selected
        Assert.assertFalse(checkbox1.isSelected(), "verify that checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify that checkbox2 is selected");

        //how to check checkboxes
        //just like a radio button we use .click method
        checkbox1.click();

        //verify after click the checkbox1
        Assert.assertTrue(checkbox1.isSelected(), "verify that checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify that checkbox2 is selected");

       Thread.sleep(3000);
       driver.quit();


    }
}
