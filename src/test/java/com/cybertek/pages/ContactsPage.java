package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    /*@FindBy(xpath = "//td[contains(text(), 'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;*/ //we wont need this anymore

    //more dynamic way for email
    public WebElement getContactEmail(String email) {
        String xpath = "//td[contains(text(), '" + email + "')][@data-column-label='Email'])";
        return Driver.get().findElement(By.xpath(xpath));
    }

}
