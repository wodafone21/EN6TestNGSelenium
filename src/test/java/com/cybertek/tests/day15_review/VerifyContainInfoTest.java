package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_test.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContainInfoTest extends TestBase {

    /*
    open the chrome
    go to qa1.vytrack
    login as a sale manager
    navigate to customers ---> contacts
    click on email mbrackstone9@example.com
    verify that full name is Mariam Brackstone
    verify that email is mbrackstone9@example.com
    verify that phone number is +18982323434
     */

    @Test
    public void contactDetailsTest() {

        extentLogger = report.createTest("Contact Info Verification");
        LoginPage loginPage = new LoginPage();

        //we get these details from configuration properties
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username: " +username);
        extentLogger.info("password: " +password);
        extentLogger.info("Login as a sale manager");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to ---> Customer --> Contacts");

       dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Costumer", "Contacts");
       // new DashboardPage().navigateToModule("Costumer", "Contacts"); // lazy way

        ContactsPage contactsPage = new ContactsPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullname.getText();

        //Verif the information
        extentLogger.info("Verify full name is " + expectedFullName);
        Assert.assertEquals(actualFullName, expectedFullName, "verify fullname");

        extentLogger.info("Verify emaill is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(), "mbrackstone9@example.com", "verify email");

        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(), "+18982323434", "verify phone number");

        extentLogger.pass("PASSED");


    }


}
