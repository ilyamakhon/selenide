package com.framework.selenide.test;

import com.framework.selenide.pages.LoginPage;
import com.framework.selenide.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.framework.selenide.utils.PropertyManager.getUserPropertyValue;

public class TestOnliner {

    private static final String BASE_URL = "https://onliner.by";

    public static final String USER_NAME = getUserPropertyValue("user.name");
    public static final String USER_PASSWORD = getUserPropertyValue("user.password");

    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void init() {
        mainPage = new MainPage();
        mainPage.openPage(BASE_URL);
    }

    @Test
    public void testSignIn() {
        loginPage = mainPage.openSignInForm();
        loginPage.fillSingInForm(USER_NAME, USER_PASSWORD);
        loginPage.submitForm();
        mainPage.openUserMenu();

        Assert.assertEquals(mainPage.getUsernameFromUserBar(), USER_NAME, "Wrong username");
    }

    @Test
    public void testSignOut() {
        mainPage.signOut();
        Assert.assertEquals(mainPage.getSignInBtnText(), "Вход");
    }
}
