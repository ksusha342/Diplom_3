package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;


public class AuthPage {
    final String AUTH_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    final int DEFAULT_WAIT_INTERVAL = 3;
    final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthPage open() {
        driver.get(AUTH_PAGE_URL);
        return this;
    }

    public AuthPage waitForLoadAuthPage() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGO));
        return this;
    }

    public AuthPage typeEmail(String email) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public AuthPage typePassword(String password) {
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public MainPage clickSignInButton() {
        driver.findElement(AUTH_PAGE_SIGN_IN_BUTTON).click();
        return new MainPage(driver);
    }
}
