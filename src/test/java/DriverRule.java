import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class DriverRule extends ExternalResource {
    WebDriver driver;
    final String CHROME_DRIVER_URL = "D:\\java_course\\Browsers and Drivers\\chromedriver-win64\\chromedriver.exe";
    final String CHROME_URL = "D:\\java_course\\Browsers and Drivers\\chrome-win64\\chrome.exe";
    final String YANDEX_DRIVER_URL = "D:\\java_course\\Browsers and Drivers\\yandexdriver-win64\\yandexdriver.exe";
    final String YANDEX_URL = "D:\\java_course\\Browsers and Drivers\\yandex-win64\\new_browser.exe";

    @Override
    protected void before() {
        if ("chrome".equals(System.getProperty("browser"))) {
            setUpChrome();
        } else {
            setUpYandex();
        }
    }

    public void setUpChrome () {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(CHROME_DRIVER_URL))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(CHROME_URL);

        driver = new ChromeDriver(service, options);
        }

    public void setUpYandex() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(YANDEX_DRIVER_URL))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(YANDEX_URL);

        driver = new ChromeDriver(service, options);
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
