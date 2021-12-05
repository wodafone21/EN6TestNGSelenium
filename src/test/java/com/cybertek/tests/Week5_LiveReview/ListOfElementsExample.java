package com.cybertek.tests.Week5_LiveReview;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListOfElementsExample {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Faker faker = new Faker();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {

        WebElement listOfElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        listOfElement.click();


        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(By.cssSelector(".form-check-label"));//alt+enter


        //1. method to create a String list
            /*Assert.assertEquals(elements.get(0).getText(), "C++");
            Assert.assertEquals(elements.get(1).getText(), "Java");
            Assert.assertEquals(elements.get(2).getText(), "JavaScript");*/

        //2. method
        List<String> expectedCodeNames = Arrays.asList("C++", "Java", "Javascript"); // java lazy way of creating a list of String
        System.out.println("expectedCodeNames = " + expectedCodeNames);

     /*   //3. method to create a String list
        List<String> actualElementStrings = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            actualElementStrings.add(elements.get(i).getText());*/

        }

        @Test
        public void test5 () throws InterruptedException {

            //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            //Step 2. Click on “Registration Form”
            driver.findElement(By.xpath("//a[contains(text(),'Registration Form')]")).click();
            //Step 3. Enter any valid first name, lastname,username,email,password,phone,gender,
            driver.findElement(By.name("firstname")).sendKeys("Ahmet");
            driver.findElement(By.name("lastname")).sendKeys("Alver");
            driver.findElement(By.name("username")).sendKeys("wodafone21");
            driver.findElement(By.name("email")).sendKeys("mikesmith@gmail.com");
            driver.findElement(By.name("password")).sendKeys("Alperen2021");
            driver.findElement(By.name("phone")).sendKeys("456-986-1234");
            WebElement genderBox = driver.findElement(By.name("gender"));
            WebElement tickBox = driver.findElement(By.xpath("//input[@value='female']"));
            tickBox.click();

            driver.findElement(By.xpath("//input[@value= 'male']")).sendKeys("Male");
            driver.findElement(By.name("birthday")).sendKeys("05/07/1978");

        Thread.sleep(2000);
        //Step 10. Select any department.
        WebElement dropdownOffice = driver.findElement(By.name("department"));
        Select departmentDropDown = new Select(dropdownOffice);
        departmentDropDown.selectByVisibleText("Tourism Office");

        Thread.sleep(2000);

            //select dropdown for JobTitle
            WebElement jobTitleLocator = driver.findElement(By.name("job_title"));
            //Step 11. Enter any job title.
            Select jobTitleDropDown = new Select(jobTitleLocator);
            jobTitleDropDown.selectByVisibleText("SDET");
            //Step 12. Select java as a programming language.
            List<WebElement> elements = driver.findElements(By.cssSelector(".form-check-label"));//alt+enter

            elements.get(1).click();

            driver.findElement(By.id("wooden_spoon")).click();
            //Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
            String expectedMessage = "You've successfully completed registration!";
            String actualMessage = driver.findElement(By.xpath("//div/p")).getText();

            Assert.assertEquals(actualMessage, expectedMessage);


    }

}


