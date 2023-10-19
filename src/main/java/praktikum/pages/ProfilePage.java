package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;


public class ProfilePage {
    final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account";
    final String AUTH_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    final int DEFAULT_WAIT_INTERVAL = 3;
    final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage open() {
        driver.get(PROFILE_PAGE_URL);
        return this;
    }

    public ProfilePage waitForLoadProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
        return this;
    }

    public ProfilePage clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
        return this;
    }

    public boolean isLogoutSuccessful() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.urlToBe(AUTH_PAGE_URL));
        return driver.getCurrentUrl().equals(AUTH_PAGE_URL);
    }
}