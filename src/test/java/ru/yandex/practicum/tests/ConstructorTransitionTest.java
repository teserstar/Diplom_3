package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practicum.pages.MainPage;

public class ConstructorTransitionTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
    }

    @Test
    @Description("Тест для проверки перехода к разделу «Начинки»")
    public void checkTransitionToConstructorFillings() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab()
                .checkVisibilityFillings();
    }

    @Test
    @Description("Тест для проверки перехода к разделу «Соусы»")
    public void checkTransitionToConstructorSauces() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab()
                .clickSaucesTab()
                .checkVisibilitySauces();
    }

    @Test
    @Description("Тест для проверки перехода к разделу «Булки»")
    public void checkTransitionToConstructorBuns() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab()
                .clickBunsTab()
                .checkVisibilityBuns();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
