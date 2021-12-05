package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browser full screen
        driver.manage().window().maximize();

        driver.get("http//practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //Task
        //put some email and click sign up button

        //proper way
       /* WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@smith.com"); */

        // lazy way
        driver.findElement(By.name("wooden_spoon")).click();






    }
}
