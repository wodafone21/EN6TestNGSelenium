package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_test.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
    /**
     * Test Case
     * Open Chrome Browser
     * Login as a Driver
     * Verify that page subtitle is quick Launchpad
     * Go to Activities --> Calendar Events
     */

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubTitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubTitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle, expectedSubTitle);

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        /*String expectedCalendarSubTitle = "Calendar Events";
        String actualCalendarSubTitle = calendarEventsPage.getPageSubTitle();*/

        //lazy way
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "Verify subtitle Calendar Events");


    }

}