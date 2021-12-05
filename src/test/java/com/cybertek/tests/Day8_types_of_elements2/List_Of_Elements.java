package com.cybertek.tests.Day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class List_Of_Elements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
      // driver.quit();
    }

    @Test
    public void test1() {

        // the steps of finding multiple elements
        //1 - find common locator for the elements that you want to locate
        //2 - pass your locator to findElements method
        //3 - List<WebElement> buttons = driver.findElements(yourLocator)
        // After this point, buttons keep list of elements, we have to reach them to apply selenium methods either with
        // loop or .get() list method
        //FindElements() method does not throw NoSuchElementsException, if your locator is wrong it will return you empty list

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    // save our web elements inside the list
        //Alt+Enter to get shortcut of List<WebElement>
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());
        // verify button size
        Assert.assertEquals(buttons.size(), 6, "verify buttons size");

        // iter + enter to get each loop with shortcut
        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            //verify if each button is displayed
            Assert.assertTrue(button.isDisplayed(), "verify buttons are displayed");

        }

        //click second button
        buttons.get(1).click();

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //passing wrong locator but it will not throw NoSuchElement
        //Alt+enter
        List<WebElement> buttons = driver.findElements(By.tagName("buttonuyr"));

        System.out.println("buttons.size() = " + buttons.size());

        // the steps of finding multiple elements
        //1 - find common locator for the elements that you want to locte
        //2 - pass your locator to findElements method
        //3 - List<WebElement> buttons = driver.findElements(yourLocator)
        // After this point, buttons keep list of elements, we have to reach them to apply selenium methods either with
        // loop or .get() list method
        //FindElements() method does not throw NoSuchElementsException, if your locator is wrong it will return you empty list



    }


}
