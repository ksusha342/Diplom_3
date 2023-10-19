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
    final String YANDEX_DRIVER_URL = "...";
    final String YANDEX_URL = "...";

    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(CHROME_DRIVER_URL))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(CHROME_URL);

        driver = new ChromeDriver(service, options);
    }

//    protected void before() throws Throwable {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("/opt/chromedriver/chromedriver-114"))
//                .build();
//        ChromeOptions options = new ChromeOptions()
//                .setBinary("/usr/bin/yandex-browser");
//
//        driver = new ChromeDriver(service, options);
//    }

    @Override
    protected void after() {
//        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
