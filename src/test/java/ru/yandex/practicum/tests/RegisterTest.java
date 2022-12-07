package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practicum.pages.LoginPage;
import ru.yandex.practicum.pages.RegisterPage;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
    }

    private String randomString = RandomStringUtils.randomAlphanumeric(6);

    @Test
    @Description("Тест для проверки успешной регистрации")
    public void checkSuccessfulRegistration() {
        // переход на страницу регистрации
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        registerPage.fillInNameInput("user_" + randomString)
                .fillInEmailInput("user_" + randomString + "@yandex.ru")
                .fillInPasswordInput("user_" + randomString)
                .clickRegisterButton();
        loginPage.checkVisibilityLoginForm();
    }

    @Test
    @Description("Тест для проверки сообщения об ошибке регистрации при использовании некорректного пароля")
    public void checkRegisterIncorrectPasswordMessage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillInNameInput("user_" + randomString)
                .fillInEmailInput("user_" + randomString + "@yandex.ru")
                .fillInPasswordInput("12345")
                .clickRegisterButton()
                .checkVisibilityIncorrectPasswordMessage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
