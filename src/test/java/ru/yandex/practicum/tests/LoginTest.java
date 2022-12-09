package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import stellarburgers.pageobjects.ForgotPasswordPage;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;
import stellarburgers.pageobjects.RegisterPage;

public class LoginTest extends BaseTest {

    // Авторизация через форму "Вход"
    public void login(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInEmailInput(email)
                .fillInPasswordInput(password)
                .clickLoginButton();
    }

    // Предварительно создан пользователь ("user_test") с email ("user_test@yandex.ru") и с паролем ("test123")
    private final String USER_EMAIL = "user_test@yandex.ru";
    private final String USER_PASSWORD = "test123";

    @Test
    @Description("Тест для проверки входа по кнопке «Войти в аккаунт» на главной странице")
    public void checkLoginThroughButtonLoginToAccount() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickLoginToAccountButton();
        login(USER_EMAIL, USER_PASSWORD);
        mainPage.waitCreateOrderButton();

        // Проверка видимости кнопки 'Оформить заказ' после авторизации
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(mainPage.getCreateOrderButton()).isDisplayed());
    }

    @Test
    @Description("Тест для проверки входа через кнопку «Личный кабинет»")
    public void checkLoginThroughButtonPersonalAccount() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickPersonalAccountButton();
        login(USER_EMAIL, USER_PASSWORD);
        mainPage.waitCreateOrderButton();

        // Проверка видимости кнопки 'Оформить заказ' после авторизации
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(mainPage.getCreateOrderButton()).isDisplayed());
    }

    @Test
    @Description("Тест для проверки входа через кнопку в форме регистрации")
    public void checkLoginThroughButtonRegisterLogin() {
        // переход на страницу регистрации
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegisterPage registerPage = new RegisterPage(driver);
        MainPage mainPage = new MainPage(driver);

        registerPage.clickLoginButton();
        login(USER_EMAIL, USER_PASSWORD);
        mainPage.waitCreateOrderButton();

        // Проверка видимости кнопки 'Оформить заказ' после авторизации
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(mainPage.getCreateOrderButton()).isDisplayed());
    }

    @Test
    @Description("Тест для проверки входа через кнопку в форме восстановления пароля")
    public void checkLoginThroughButtonForgotPasswordLogin() {
        // переход на страницу "Восстановление пароля"
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        MainPage mainPage = new MainPage(driver);

        forgotPasswordPage.clickLoginButton();
        login(USER_EMAIL, USER_PASSWORD);
        mainPage.waitCreateOrderButton();

        // Проверка видимости кнопки 'Оформить заказ' после авторизации
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(mainPage.getCreateOrderButton()).isDisplayed());
    }
}
