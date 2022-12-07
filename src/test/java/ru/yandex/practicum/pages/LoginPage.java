package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Форма "Вход"
    private By loginForm = By.xpath(".//h2[text()='Вход']/..");

    // Поле ввода "Email"
    private By emailInput = By.xpath(".//label[text()='Email']//ancestor::div/input");

    // Поле ввода "Пароль"
    private By passwordInput = By.xpath(".//label[text()='Пароль']//ancestor::div/input");

    // Кнопка "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");

    // Проверка видимости формы "Вход"
    public void checkVisibilityLoginForm() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(loginForm));
        Assert.assertTrue("Форма 'Вход' должна быть видна на странице",
                driver.findElement(loginForm).isDisplayed());
    }

    // Заполнение поля "Email" на форме "Вход"
    public LoginPage fillInEmailInput(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    // Заполнение поля "Пароль" на форме "Вход"
    public LoginPage fillInPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    // Нажатие кнопки "Войти" на форме "Вход"
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
}
