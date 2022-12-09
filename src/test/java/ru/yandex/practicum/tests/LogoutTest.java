package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import stellarburgers.pageobjects.AccountPage;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;

public class LogoutTest extends  BaseTest {

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
    @Description("Тест для проверки выхода по кнопке «Выйти» в личном кабинете")
    public void checkLogoutFromAccount() {
        // переход на страницу "Вход"
        driver.get("https://stellarburgers.nomoreparties.site/login");

        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        login(USER_EMAIL, USER_PASSWORD);
        mainPage.clickPersonalAccountButton();
        accountPage.clickLogoutButton();
        loginPage.waitLoginForm();

        //Проверка видимости формы 'Вход'
        Assert.assertTrue("Форма 'Вход' должна быть видна на странице",
                driver.findElement(loginPage.getLoginForm()).isDisplayed());
    }
}
