package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;


public class MainPage {

    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    final int DEFAULT_WAIT_INTERVAL = 3;
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
                .until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_HEADER));
        return this;
    }

    public boolean isMainPageLoadedSuccessfully() {
        return driver.findElement(MAIN_PAGE_HEADER).isDisplayed();
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

    public void clickSignUpButton() {
        driver.findElement(MAIN_PAGE_SIGN_IN_BUTTON).click();
    }

    public ProfilePage clickUserProfileButtonWithAuthorization() {
        driver.findElement(USER_PROFILE_BUTTON).click();
        return new ProfilePage(driver);
    }

    public AuthPage clickUserProfileButtonWithoutAuthorization() {
        driver.findElement(USER_PROFILE_BUTTON).click();
        return new AuthPage(driver);
    }
}