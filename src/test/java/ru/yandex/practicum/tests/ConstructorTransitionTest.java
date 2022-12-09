package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import stellarburgers.pageobjects.MainPage;

public class ConstructorTransitionTest extends BaseTest {

    @Test
    @Description("Тест для проверки перехода к разделу «Начинки»")
    public void checkTransitionToConstructorFillings() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab()
                .waitFillings();

        // Проверка видимости раздела 'Начинки' для выбора элементов
        Assert.assertTrue("Раздел 'Начинки' должен быть виден на странице для выбора элементов",
                driver.findElement(mainPage.getFillingsTitle()).isDisplayed());
    }

    @Test
    @Description("Тест для проверки перехода к разделу «Соусы»")
    public void checkTransitionToConstructorSauces() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab()
                .clickSaucesTab()
                .waitSauces();

        // Проверка видимости раздела 'Соусы' для выбора элементов
        Assert.assertTrue("Раздел 'Соусы' должен быть виден на странице для выбора элементов",
                driver.findElement(mainPage.getSaucesTitle()).isDisplayed());
    }

    @Test
    @Description("Тест для проверки перехода к разделу «Булки»")
    public void checkTransitionToConstructorBuns() {
        // переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab()
                .clickBunsTab()
                .waitBuns();

        // Проверка видимости раздела 'Булки' для выбора элементов
        Assert.assertTrue("Раздел 'Булки' должен быть виден на странице для выбора элементов",
                driver.findElement(mainPage.getBunsTitle()).isDisplayed());
    }
}
