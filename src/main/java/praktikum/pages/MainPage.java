package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;


public class MainPage {

    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    final int DEFAULT_WAIT_INTERVAL = 5;
    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public MainPage waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(MAIN_TITLE));
        return this;
    }

    public MainPage clickBunsSection() {
        driver.findElement(BUNS_SECTION).click();
        return this;
    }

    public boolean isBunsSectionSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_SECTION_SELECTED));
        return driver.findElement(BUNS_SECTION_SELECTED).isDisplayed();
    }

    public MainPage clickSauceSection() {
        driver.findElement(SAUCES_SECTION).click();
        return this;
    }

    public boolean isSaucesSectionSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCES_SECTION_SELECTED));
        return driver.findElement(SAUCES_SECTION_SELECTED).isDisplayed();
    }

    public MainPage clickFillingsSection() {
        driver.findElement(FILLINGS_SECTION).click();
        return this;
    }

    public boolean isFillingsSectionSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(FILLINGS_SECTION_SELECTED));
        return driver.findElement(FILLINGS_SECTION_SELECTED).isDisplayed();
    }



}