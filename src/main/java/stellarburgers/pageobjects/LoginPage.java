package stellarburgers.pageobjects;

import io.qameta.allure.Step;
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

    public By getLoginForm() {
        return loginForm;
    }

    // Поле ввода "Email"
    private By emailInput = By.xpath(".//label[text()='Email']//ancestor::div/input");

    // Поле ввода "Пароль"
    private By passwordInput = By.xpath(".//label[text()='Пароль']//ancestor::div/input");

    // Кнопка "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");

    @Step("Ожидание наличия формы 'Вход' на странице")
    public void waitLoginForm() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(loginForm));
    }

    @Step("Заполнение поля 'Email' на форме 'Вход'")
    public LoginPage fillInEmailInput(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    @Step("Заполнение поля 'Пароль' на форме 'Вход'")
    public LoginPage fillInPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки 'Войти' на форме 'Вход'")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
}
