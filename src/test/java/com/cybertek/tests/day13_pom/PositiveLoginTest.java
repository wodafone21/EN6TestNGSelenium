package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_test.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginAsDriver() {

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");


    }
    @Test
    public void loginAsStoreManager(){

       // LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        /**loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();*/

        //shortcut instead of three elements above
        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");


    }

    @Test
    public void loginAsStoreManager2() {  // shortest cut because we create another method in LoginPage with no parameter
        // and put all necessary information there


        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }



    }



