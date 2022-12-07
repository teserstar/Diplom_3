package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    // Поле с логином аккаунта
    private By accountLoginField = By.xpath(".//label[text()='Логин']/..");

    // Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//p[text()='Конструктор']/..");

    // Интерактивный логотип
    private By logoButton = By.xpath(".//div[contains(@class,'logo')]");

    // Кнопка "Выход"
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    // Проверка видимости кнопки поля с логином аккаунта
    public void checkVisibilityAccountLoginField() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(accountLoginField));
        Assert.assertTrue("Поле 'Логин' должно быть видно на странице",
                driver.findElement(accountLoginField).isDisplayed());
    }

    // Нажатие кнопки "Конструктор" в личном кабинете
    public AccountPage clickConstructorButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(constructorButton));
        driver.findElement(constructorButton).click();
        return this;
    }

    // Нажатие на логотип в личном кабинете
    public AccountPage clickLogoButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(logoButton));
        driver.findElement(logoButton).click();
        return this;
    }

    // Нажатие кнопки "Выход" в личном кабинете
    public AccountPage clickLogoutButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
        return this;
    }
}
