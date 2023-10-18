import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;


public class OpenSectionTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void openBunsSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitForLoadMainPage()
                .clickFillingsSection()
                .clickBunsSection()
                .isBunsSectionSelected();
    }

    @Test
    public void openSaucesSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitForLoadMainPage()
                .clickSauceSection()
                .isSaucesSectionSelected();
    }

    @Test
    public void openFillingsSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitForLoadMainPage()
                .clickFillingsSection()
                .isFillingsSectionSelected();
    }
}
