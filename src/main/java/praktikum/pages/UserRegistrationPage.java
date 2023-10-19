package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;


public class UserRegistrationPage {

    final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    final String AUTH_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    final int DEFAULT_WAIT_INTERVAL = 3;
    final WebDriver driver;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegistrationPage open() {
        driver.get(REGISTRATION_PAGE_URL);
        return this;
    }

    public UserRegistrationPage waitForLoadRegistrationPage() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGO));
        return this;
    }

    public UserRegistrationPage typeName(String name) {
        driver.findElement(NEW_USER_NAME_FIELD).click();
        driver.findElement(NEW_USER_NAME_FIELD).sendKeys(name);
        return this;
    }

    public UserRegistrationPage typeEmail(String email) {
        driver.findElement(NEW_USER_EMAIL_FIELD).click();
        driver.findElement(NEW_USER_EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public UserRegistrationPage typePassword(String password) {
        driver.findElement(NEW_USER_PASSWORD_FIELD).click();
        driver.findElement(NEW_USER_PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public UserRegistrationPage clickSignUpButton() {
        driver.findElement(SIGN_UP_BUTTON).click();
        return this;
    }

    public boolean isRegistrationSuccessful() {
        if (isIncorrectPasswordTextDisplayed()) {
            return false;
        } else {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                    .until(ExpectedConditions.urlToBe(AUTH_PAGE_URL));
            return driver.getCurrentUrl().equals(AUTH_PAGE_URL);
        }
    }

    private boolean isIncorrectPasswordTextDisplayed() {
        try {
            return driver.findElement(INCORRECT_PASSWORD_TEXT).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
