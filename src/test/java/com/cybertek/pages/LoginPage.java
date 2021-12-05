package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //driver.findElement(By.id("prependedInput"));
    /*@FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })*/
    //driver.findElement(By.id("_prependedInput")); instead of this, we now use @FindBy for the login locators
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    //driver.findElement(By.id("_prependedInput2"));
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"));
    @FindBy(id = "_submit")
    public WebElement loginBtn;


    //We create this method in login page. Inside the method we have our 3 elements. Then, when we automate our test
    //we can use shortcut by putting LoginPage.login(username, password); instead of
    //loginPage.usernameInput.sendKeys(username);
    //loginPage.passwordInput.sendKeys(password);
    //loginPage.loginBtn.click();
    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

       // loginPage.login(username, password);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsSalesManager() {

        String username = ConfigurationReader.get("salesmanager120");
        String password = ConfigurationReader.get("UserUser123");

        // loginPage.login(username, password);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}

