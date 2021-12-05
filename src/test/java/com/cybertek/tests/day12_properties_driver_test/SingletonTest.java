package com.cybertek.tests.day12_properties_driver_test;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

   @Test
    public void test1 () {
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void Test2() throws InterruptedException {
        /*This is old style
         WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("web adress");*/

        WebDriver driver = Driver.get();//it is picking up the browser information from configuration properties
        Thread.sleep(2000);
        driver.get("https://www.google.com");

       // Driver.closeDriver(); //from now on, we will use Driver.closeDriver(); for closing the browser

    }

    @Test
    public void test3() {
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test4() {
      WebDriver driver = Driver.get();
      driver.get("https://www.yahoo.com");



    }
}











