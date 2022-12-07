package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practicum.pages.AccountPage;
import ru.yandex.practicum.pages.LoginPage;
import ru.yandex.practicum.pages.MainPage;

public class LogoutTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

    }

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
        loginPage.checkVisibilityLoginForm();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
