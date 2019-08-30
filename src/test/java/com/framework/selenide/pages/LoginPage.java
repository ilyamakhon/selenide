package com.framework.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement signInFormWrapper;

    private By loc_txtLogin = By.xpath(".//input[@type='text']");
    private By loc_txtPassword = By.xpath(".//input[@type='password']");
    private By loc_btnSubmit = By.xpath(".//button[@type='submit']");
    private By loc_signInFormWrapper = By.id("auth-container");

    public void fillSingInForm(String username, String password) {
        signInFormWrapper = $(loc_signInFormWrapper);

        signInFormWrapper.find(loc_txtLogin).setValue(username);
        signInFormWrapper.find(loc_txtPassword).setValue(password);
    }

    public void submitForm() {
        $(loc_signInFormWrapper).find(loc_btnSubmit).click();
    }

}
