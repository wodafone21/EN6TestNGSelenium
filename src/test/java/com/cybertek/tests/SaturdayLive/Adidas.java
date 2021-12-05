package com.cybertek.tests.SaturdayLive;

import com.cybertek.tests.day12_properties_driver_test.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Adidas {

    /*Customer navigation through product categories: Phones, Laptops and Monitors
    Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
            • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
            • Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
            • Click on "Place order".
            • Fill in all web form fields.
            • Click on "Purchase"
            • Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok */

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //
        driver.findElement(By.xpath("//a[.='Laptops']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[.='Sony vaio i5']")).click();
        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        Thread.sleep(2000);
        ////click(accepting) on popUp
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        //adding items in the shopping cart(basket)
        driver.findElement(By.xpath("//a[.='Laptops']")).click();
        driver.findElement(By.xpath("//a[.='Dell i7 8gb']")).click();
        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        Thread.sleep(2000);
        //click(accepting) on popUp
        alert.accept();
        //click on cart
        driver.findElement(By.xpath("//a[.='Cart']")).click();
        //click on Delete button
        driver.findElement(By.xpath("//a[.='Delete']")).click();
        Thread.sleep(2000);
        //save all the items in one List Collection
        List<WebElement> prices = driver.findElements(By.xpath("//tr/td[3]"));

        //create one dummy variable and then add product price on the variable
        int ExpectedtotalPrice = 0;

        for (WebElement price : prices) {
            //persInt to convert a string to integer
            ExpectedtotalPrice += Integer.parseInt(price.getText());

        }

        //click on place order button
        driver.findElement(By.xpath("//button[.='Place Order']")).click();
        //create JS object to use its methods to locate elements ect.
        //example of polymorphism
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        Thread.sleep(3000);
        //filling out popUp form
        jse.executeScript("arguments[0].setAttribute('value','" + "Mike" + "')", driver.findElement(By.xpath("//input[@id = 'name']")));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].setAttribute('value','" + "UK" + "')", driver.findElement(By.xpath("//input[@id = 'country']")));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].setAttribute('value','" + "London" + "')", driver.findElement(By.xpath("//input[@id = 'city']")));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].setAttribute('value','" + "GB" + "')", driver.findElement(By.xpath("//input[@id = 'card']")));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].setAttribute('value','" + "10" + "')", driver.findElement(By.xpath("//input[@id = 'month']")));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].setAttribute('value','" + "2027" + "')", driver.findElement(By.xpath("//input[@id = 'year']")));

        Thread.sleep(3000);
        //clicking on purchase button
        WebElement purchaseBtn = driver.findElement(By.xpath("//button[.='Purchase']"));
        jse.executeScript("arguments[0].click();", purchaseBtn);

        Thread.sleep(3000);
        //getting the details from the purchase confirmation popUp tab
        String Info = driver.findElement(By.xpath("//p[starts-with(text(),'Id')]")).getText();
        //  System.out.println(Info);
        //  String Id = Info.split("Id")[0].split(" ")[1];
        //  String Amount = Info.split("Amount")[0].split(" ")[1];
        //  System.out.println(Info.split("Amount: ")[1].split(" ")[0]);

        //saving the actual amount from purchase confirmation popUp tab
        /*String ActualtotalPrice = Info.split("Amount: ")[1].split(" ")[0];
        //saving the amount in primitive data type (int)
        int ActualTotalPrice = Integer.parseInt(ActualtotalPrice);*/


        Assert.assertTrue(Info.contains("Amount: 790 USD"));

        //verifying the actual and expected price
        //verifying the actual and expected price
      //  Assert.assertEquals(ActualTotalPrice,ExpectedtotalPrice,"checking the price matching");


    }

}