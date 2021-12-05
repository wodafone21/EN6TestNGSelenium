package com.cybertek.tests.day12_properties_driver_test;

import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {
    //By extending our Test to TestBase, we centralize and have clean test by getting rid of all @BeforeTest and @AfterTest

    @Test
    public void AnotherLoginTest() {
        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);


    }


}
