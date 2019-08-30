package com.framework.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement btnSignIn;

    private SelenideElement userBar;
    private SelenideElement lnkUserIcon;

    private By loc_btnSignIn = By.xpath("//div[@class='auth-bar__item auth-bar__item--text']");
    private String loc_userBar = "#userbar";
    private By loc_lnkUserIcon = By.cssSelector("a.b-top-profile__preview.js-toggle-bar");
    private By loc_userMenu = By.xpath(".//div[contains(@class, 'b-top-profile__dropdown')]");
    private By loc_lnkProfile = By.xpath(".//div[@class='b-top-profile__name']/a");
    private By loc_lnkSignOut = By.linkText("Выйти");

    public void openPage(String url) {
        open(url);
    }

    public LoginPage openSignInForm() {
        btnSignIn = $(loc_btnSignIn);

        //only for sanbox page level testing
        btnSignIn.shouldHave(exactText("Вход"));
        btnSignIn.click();

        return new LoginPage();
    }

    public void openUserMenu() {
        userBar = $(loc_userBar);
        lnkUserIcon = userBar.find(loc_lnkUserIcon);
        lnkUserIcon.click();
    }

    public String getUsernameFromUserBar() {
        return $(loc_userMenu).find(loc_lnkProfile).getText();
    }

    public void signOut() {
        openUserMenu();
        $(loc_userMenu).find(loc_lnkSignOut).click();
        $(loc_btnSignIn).should(exist);
    }

    public String getSignInBtnText() {
        return $(loc_btnSignIn).getText();
    }
}
