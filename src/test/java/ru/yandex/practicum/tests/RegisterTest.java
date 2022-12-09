package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.RegisterPage;

public class RegisterTest extends BaseTest {

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
        loginPage.waitLoginForm();

        //Проверка видимости формы 'Вход'
        Assert.assertTrue("Форма 'Вход' должна быть видна на странице",
                driver.findElement(loginPage.getLoginForm()).isDisplayed());
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
                .waitIncorrectPasswordMessage();

        // Проверка видимости сообщения об ошибке 'Некорректный пароль'
        Assert.assertTrue("Сообщение об ошибке 'Некорректный пароль' должно быть видно на странице",
                driver.findElement(registerPage.getIncorrectPasswordMessage()).isDisplayed());
    }
}
