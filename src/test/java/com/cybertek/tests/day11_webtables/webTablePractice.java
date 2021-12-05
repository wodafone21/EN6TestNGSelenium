package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class webTablePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        String header = "Last Name";
        String name = "Daniel";

        for (int i = 1; i <= 4; i++) {
            if(driver.findElement(By.xpath("//table[@class = 'table']//th["+i+"]/input")).getAttribute("placeholder").equals(header)){
                System.out.println(driver.findElement(By.xpath("//td[text()='"+name+"']/../td["+i+"]")).getText());

    }

        }



    }
}





