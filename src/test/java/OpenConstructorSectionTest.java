import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;


public class OpenConstructorSectionTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void checkOpenBunsSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        var result = mainPage.open()
                .waitForLoadMainPage()
                .clickFillingsSection()
                .clickBunsSection()
                .isBunsSectionSelected();

        Assert.assertTrue(result);
    }

    @Test
    public void checkOpenSaucesSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        var result = mainPage.open()
                .waitForLoadMainPage()
                .clickSauceSection()
                .isSaucesSectionSelected();

        Assert.assertTrue(result);
    }

    @Test
    public void checkOpenFillingsSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        var result = mainPage.open()
                .waitForLoadMainPage()
                .clickFillingsSection()
                .isFillingsSectionSelected();

        Assert.assertTrue(result);
    }
}
