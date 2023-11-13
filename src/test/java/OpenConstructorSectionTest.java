import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;


public class OpenConstructorSectionTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Check opening Buns Section")
    @Description("Check that it is possible to open buns section")
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
    @DisplayName("Check opening sauces Section")
    @Description("Check that it is possible to open sauces section")
    public void checkOpenSaucesSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        var result = mainPage.open()
                .waitForLoadMainPage()
                .clickSauceSection()
                .isSaucesSectionSelected();

        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Check opening fillings Section")
    @Description("Check that it is possible to open fillings section")
    public void checkOpenFillingsSection() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        var result = mainPage.open()
                .waitForLoadMainPage()
                .clickFillingsSection()
                .isFillingsSectionSelected();

        Assert.assertTrue(result);
    }
}
