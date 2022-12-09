package stellarburgers.pageobjects;

import io.qameta.allure.Step;
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

    public By getAccountLoginField() {
        return accountLoginField;
    }

    // Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//p[text()='Конструктор']/..");

    // Интерактивный логотип
    private By logoButton = By.xpath(".//div[contains(@class,'logo')]");

    // Кнопка "Выход"
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    @Step("Ожидание наличия поля с логином аккаунта")
    public void waitAccountLoginField() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(accountLoginField));
    }

    @Step("Нажатие кнопки 'Конструктор' в личном кабинете")
    public AccountPage clickConstructorButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(constructorButton));
        driver.findElement(constructorButton).click();
        return this;
    }

    @Step("Нажатие на логотип в личном кабинете")
    public AccountPage clickLogoButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(logoButton));
        driver.findElement(logoButton).click();
        return this;
    }

    @Step("Нажатие кнопки 'Выход' в личном кабинете")
    public AccountPage clickLogoutButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
        return this;
    }
}
