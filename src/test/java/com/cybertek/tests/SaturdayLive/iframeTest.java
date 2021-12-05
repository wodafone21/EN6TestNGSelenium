package com.cybertek.tests.SaturdayLive;

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

public class iframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void Test() throws InterruptedException {
        // 2. Switch to Iframe  (going inside that frame for web elements)
        // we are going to use ID attribute and switch method
        driver.switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        // locate this web element
        WebElement textToDoubleClick = driver.findElement(By.id("demo"));

        // Double click action create an actions object

        Actions actions = new Actions(driver);

        actions.doubleClick(textToDoubleClick).perform();

        Thread.sleep(3000);

        String expectedStyle = "red";
        String actualStyle = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actualStyle.contains(expectedStyle));
    }

}
