package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import stellarburgers.pageobjects.AccountPage;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;

public class PageTransitionTest extends BaseTest {

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
    @Description("Тест для проверки перехода по клику на «Личный кабинет» после авторизации")
    public void checkTransitionToPersonalAccount() {
        // переход на страницу "Вход"
        driver.get("https://stellarburgers.nomoreparties.site/login");

        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        login(USER_EMAIL, USER_PASSWORD);
        mainPage.clickPersonalAccountButton();
        accountPage.waitAccountLoginField();

        // Проверка видимости поля с логином аккаунта
        Assert.assertTrue("Поле 'Логин' должно быть видно на странице",
                driver.findElement(accountPage.getAccountLoginField()).isDisplayed());
    }

    @Test
    @Description("Тест для проверки после авторизации перехода из личного кабинета в конструктор" +
            "по клику на «Конструктор» и на логотип Stellar Burgers")
    public void checkTransitionFromPersonalAccountToMainPage() {
        // переход на страницу "Вход"
        driver.get("https://stellarburgers.nomoreparties.site/login");

        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        login(USER_EMAIL, USER_PASSWORD);
        mainPage.clickPersonalAccountButton();
        accountPage.clickConstructorButton();
        mainPage.waitCreateOrderButton();

        // Проверка видимости кнопки 'Оформить заказ' после авторизации
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(mainPage.getCreateOrderButton()).isDisplayed());

        mainPage.clickPersonalAccountButton();
        accountPage.clickLogoButton();
        mainPage.waitCreateOrderButton();

        // Проверка видимости кнопки 'Оформить заказ' после авторизации
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(mainPage.getCreateOrderButton()).isDisplayed());
    }
}
