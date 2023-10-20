import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;

import praktikum.pages.AuthPage;
import praktikum.pages.ProfilePage;
import praktikum.user.*;


public class OpenConstructorTest {

    private static final UserClient client = new UserClient();
    private static final UserCheck check = new UserCheck();

    private static User user;
    private static String accessToken;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @BeforeClass
    public static void createUser() {
        user = UserGenerator.random();

        ValidatableResponse response = client.create(user);
        accessToken = check.createdUserSuccessfully(response);
    }

    @Before
    public void authUser() {
        AuthPage authPage = new AuthPage(driverRule.getDriver());
        authPage.open()
                .waitForLoadAuthPage()
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton()
                .waitForLoadMainPage()
                .clickUserProfileButtonWithAuthorization()
                .waitForLoadProfilePage();
    }

    @Test
    @DisplayName("Check opening constructor through logo")
    @Description("Check that it is possible to open constructor through logo")
    public void checkOpeningConstructorThroughLogo() {
        ProfilePage profilePage = new ProfilePage(driverRule.getDriver());

        var result = profilePage.clickLogo()
                .waitForLoadMainPage()
                .isMainPageLoadedSuccessfully();

        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Check opening constructor through constructor button")
    @Description("Check that it is possible to open constructor through constructor button")
    public void checkOpeningConstructorThroughConstructorButton() {
        ProfilePage profilePage = new ProfilePage(driverRule.getDriver());

        var result = profilePage.open()
                .waitForLoadProfilePage()
                .clickConstructorButton()
                .waitForLoadMainPage()
                .isMainPageLoadedSuccessfully();

        Assert.assertTrue(result);
    }

    @AfterClass
    public static void tearDown() {
        user = null;
        check.deletedUserSuccessfully(client.delete(accessToken));
    }
}
