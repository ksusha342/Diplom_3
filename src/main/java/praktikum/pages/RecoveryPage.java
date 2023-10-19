package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;

public class RecoveryPage {
    final String RECOVERY_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    final int DEFAULT_WAIT_INTERVAL = 3;
    final WebDriver driver;

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public RecoveryPage open() {
        driver.get(RECOVERY_PAGE_URL);
        return this;
    }

    public RecoveryPage waitForLoadRecoveryPage() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(RECOVERY_PAGE_SIGN_IN_BUTTON));
        return this;
    }

    public RecoveryPage clickSignUpButton() {
        driver.findElement(RECOVERY_PAGE_SIGN_IN_BUTTON).click();
        return this;
    }
}
