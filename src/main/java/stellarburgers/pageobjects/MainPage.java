package stellarburgers.pageobjects;

import io.qameta.allure.Step;
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

    public By getCreateOrderButton() {
        return createOrderButton;
    }

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

    public By getBunsTitle() {
        return bunsTitle;
    }

    // Название раздела "Соусы" в списке элементов
    private By saucesTitle = By.xpath(".//h2[text()='Соусы']");

    public By getSaucesTitle() {
        return saucesTitle;
    }

    // Название раздела "Начинки" в списке элементов
    private By fillingsTitle = By.xpath(".//h2[text()='Начинки']");

    public By getFillingsTitle() {
        return fillingsTitle;
    }

    @Step("Нажатие кнопки 'Войти в аккаунт' на главной странице")
    public MainPage clickLoginToAccountButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(loginToAccountButton));
        driver.findElement(loginToAccountButton).click();
        return this;
    }

    @Step("Нажатие кнопки 'Личный Кабинет' на главной странице")
    public MainPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        return this;
    }

    @Step("Ожидание наличия кнопки 'Оформить заказ' после авторизации на странице")
    public void waitCreateOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(createOrderButton));
    }

    @Step("Нажатие на раздел 'Булки'")
    public MainPage clickBunsTab() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunsTab));
        driver.findElement(bunsTab).click();
        return this;
    }

    @Step("Нажатие на раздел 'Соусы'")
    public MainPage clickSaucesTab() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(saucesTab));
        driver.findElement(saucesTab).click();
        return this;
    }

    @Step("Нажатие на раздел 'Начинки'")
    public MainPage clickFillingsTab() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(fillingsTab));
        driver.findElement(fillingsTab).click();
        return this;
    }

    @Step("Ожидание наличия раздела 'Булки' для выбора элементов")
    public void waitBuns() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunsTitle));
    }

    @Step("Проверка видимости раздела 'Соусы' для выбора элементов")
    public void waitSauces() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(saucesTitle));
    }

    @Step("Проверка видимости раздела 'Начинки' для выбора элементов")
    public void waitFillings() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(fillingsTitle));
    }
}
