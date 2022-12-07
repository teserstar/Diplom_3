package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    // Поле ввода "Имя"
    private By nameInput = By.xpath(".//label[text()='Имя']//ancestor::div/input");

    // Поле ввода "Email"
    private By emailInput = By.xpath(".//label[text()='Email']//ancestor::div/input");

    // Поле ввода "Пароль"
    private By passwordInput = By.xpath(".//label[text()='Пароль']//ancestor::div/input");

    // Кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // Сообщение об ошибке "Некорректный пароль"
    private By incorrectPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    // Кнопка "Войти"
    private By loginButton = By.xpath(".//a[text()='Войти']");

    // Заполнение поля "Имя" на форме "Регистрация"
    public RegisterPage fillInNameInput(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    // Заполнение поля "Email" на форме "Регистрация"
    public RegisterPage fillInEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    // Заполнение поля "Пароль" на форме "Регистрация"
    public RegisterPage fillInPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    // Нажатие кнопки "Зарегистрироваться" на форме "Регистрация"
    public RegisterPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return this;
    }

    // Нажатие кнопки "Войти" на форме "Регистрация"
    public RegisterPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    // Проверка видимости сообщения об ошибке "Некорректный пароль"
    public void checkVisibilityIncorrectPasswordMessage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(incorrectPasswordMessage));
        Assert.assertTrue("Сообщение об ошибке 'Некорректный пароль' должно быть видно на странице",
                driver.findElement(incorrectPasswordMessage).isDisplayed());
    }
}
