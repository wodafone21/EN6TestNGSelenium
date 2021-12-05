package com.cybertek.tests.HomeWorkProject;
import com.cybertek.utilities.WebDriverFactory;
import com.sun.corba.se.pept.transport.ByteBufferPool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class homeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.quit();
    }

    @Test
    public void testCase1() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input")).sendKeys("05.07.1980");
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();
        String expectedMessage = "The date of birth is not valid";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

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
    public void test3() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("A");
        String actualMessage = driver.findElement(By.xpath("//small[contains(text(), 'first name must be')]")).getText();
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void test4() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("lastname")).sendKeys("A");
        String actualMessage = driver.findElement(By.xpath("//*[@id='registrationForm']/div[2]/div/small[2]")).getText();
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void test5() throws InterruptedException {

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

    @Test
    public void test6() {
        driver.get("https://www.fakemail.net/");

        String email = driver.findElement(By.cssSelector("#email")).getText();
        System.out.println("email = " + email);

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys("Mike Smith");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        //Step 8. Verify that following message is displayed, “Thank you for signing up. Click the button below to
        //return to the home page.
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(driver.findElement(By.name("signup_message")).getText(), expectedMessage);

        //or Assert.assertEquals(expectedMessage, actualMessage);

        //Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com/");

        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        String expectedMsg = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(driver.findElement(By.cssSelector("*[class='odMobil']")).getText(), expectedMsg);
       //Assert.assertEquals(actualMsg, expectedMessage);

        //Step 11. Click on that email to open it.
        driver.findElement(By.cssSelector("[class='odMobil']")).click();

        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        String actualReply = driver.findElement(By.cssSelector("#odesilatel")).getText();
        String expectedReply = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualReply, expectedReply);
        System.out.println("expectedReply = " + expectedReply);

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String actualSubjectMessage = driver.findElement(By.cssSelector("#predmet")).getText();
        String expectedSubjectMessage = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubjectMessage, expectedSubjectMessage);
        System.out.println("expectedSubjectMessage = " + expectedSubjectMessage);

    }

    @Test
    public void test7 () {
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("http://practice-cybertekschool.herokuapp.com");

       //Step 2. And click on “File Upload
        driver.findElement(By.xpath("//a[@href='/upload']")).click();

        //Step 3. Upload any file with .txt extension from your computer.
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys("\u202AC:\\Users\\woda\\OneDrive\\Desktop\\ahmet.txt");

        //Step 4. Click “Upload” button.
        driver.findElement(By.cssSelector("#file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        System.out.println("actualMessage = " + driver.findElement(By.xpath("//h3[.='File Uploaded")));

        //Step 6. Verify that uploaded file name is displayed.
        String expectedMessage = "ahmet.txt";
        String actualMessage = driver.findElement(By.cssSelector("#uploaded-files")).getText();

        Assert.assertEquals(actualMessage, expectedMessage, "verifying if correct document");

    }

    @Test
    public void test8() throws InterruptedException {
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        //WebElement fileUpload = driver.findElement(By.xpath("//a[@href='/upload']"));
        //fileUpload.click();
         driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
         driver.findElement(By.id("myCountry")).sendKeys("United States of America");
         driver.findElement(By.xpath("//input[@type='button']")).click();
         Thread.sleep(3000);
         WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed());

        System.out.println("result.isDisplayed() = " + result.isDisplayed());
        System.out.println("result.getText() = " + result.getText());


    }

    @Test
    public void test9() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Status Codes”

        //Step 3. Then click on “200”
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();

        String expectedMsg = "This page returned a 200 status code.";
        String actualMsg = driver.findElement(By.className("example")).getText();

        Assert.assertEquals(expectedMsg, actualMsg);

        System.out.println("actualMsg = " + actualMsg);
        System.out.println("expectedMsg = " + expectedMsg);

    }

    /*
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “301”
    Step 4. Verify that following message is displayed: “This page returned a 301 status code”
    String Msg301 = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
it would get both texts but you can use this to check if it is displayed
Assert.assertTrue(Msg301.contains("This page returned a 301 status code"));
     */

        @Test
        public void test10 () {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]")).click();
            driver.findElement(By.xpath("//a[normalize-space()='301']")).click();
            String actualMsg = driver.findElement(By.xpath("//div[@class='example']/p")).getText();

            Assert.assertTrue(actualMsg.contains("This page returned a 301 status code"));

            ////*[@id="content"]/div/p/text()[1]

        }

    }

