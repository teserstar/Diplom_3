package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    // Кнопка "Войти"
    private By loginButton = By.xpath(".//a[text()='Войти']");

    // Нажатие кнопки "Войти" на форме "Восстановление пароля"
    public ForgotPasswordPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
}
