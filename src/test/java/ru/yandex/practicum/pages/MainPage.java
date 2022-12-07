package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    // Кнопка "Войти в аккаунт"
    private By loginToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // Кнопка "Оформить заказ"
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    // Кнопка "Личный Кабинет"
    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']/..");

    // Вкладка "Булки"
    private By bunsTab = By.xpath(".//span[text()='Булки']/..");

    // Вкладка "Соусы"
    private By saucesTab = By.xpath(".//span[text()='Соусы']/..");

    // Вкладка "Начинки"
    private By fillingsTab = By.xpath(".//span[text()='Начинки']/..");

    // Название раздела "Булки" в списке элементов
    private By bunsTitle = By.xpath(".//h2[text()='Булки']");

    // Название раздела "Соусы" в списке элементов
    private By saucesTitle = By.xpath(".//h2[text()='Соусы']");

    // Название раздела "Начинки" в списке элементов
    private By fillingsTitle = By.xpath(".//h2[text()='Начинки']");

    // Нажатие кнопки "Войти в аккаунт" на главной странице
    public MainPage clickLoginToAccountButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(loginToAccountButton));
        driver.findElement(loginToAccountButton).click();
        return this;
    }

    // Нажатие кнопки "Личный Кабинет" на главной странице
    public MainPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        return this;
    }

    // Проверка видимости кнопки "Оформить заказ" после авторизации
    public void checkVisibilityCreateOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(createOrderButton));
        Assert.assertTrue("Кнопка 'Оформить заказ' должна быть видна на странице",
                driver.findElement(createOrderButton).isDisplayed());
    }

    // Нажатие на раздел "Булки"
    public MainPage clickBunsTab() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunsTab));
        driver.findElement(bunsTab).click();
        return this;
    }

    public MainPage clickSaucesTab() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(saucesTab));
        driver.findElement(saucesTab).click();
        return this;
    }

    public MainPage clickFillingsTab() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(fillingsTab));
        driver.findElement(fillingsTab).click();
        return this;
    }

    // Проверка видимости раздела "Булки" для выбора элементов
    public void checkVisibilityBuns() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunsTitle));
        Assert.assertTrue("Раздел 'Булки' должен быть виден на странице для выбора элементов",
                driver.findElement(bunsTitle).isDisplayed());
    }

    // Проверка видимости раздела "Соусы" для выбора элементов
    public void checkVisibilitySauces() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(saucesTitle));
        Assert.assertTrue("Раздел 'Соусы' должен быть виден на странице для выбора элементов",
                driver.findElement(saucesTitle).isDisplayed());
    }

    // Проверка видимости раздела "Начинки" для выбора элементов
    public void checkVisibilityFillings() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(fillingsTitle));
        Assert.assertTrue("Раздел 'Начинки' должен быть виден на странице для выбора элементов",
                driver.findElement(fillingsTitle).isDisplayed());
    }
}
