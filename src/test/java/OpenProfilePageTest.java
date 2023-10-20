import io.restassured.response.ValidatableResponse;
import org.junit.*;

import praktikum.pages.AuthPage;
import praktikum.pages.MainPage;
import praktikum.user.*;


public class OpenProfilePageTest {

    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();

    private User user;
    private String accessToken;

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    public void checkOpeningProfilePageWithAuthorization() {
        user = UserGenerator.random();

        ValidatableResponse response = client.create(user);
        accessToken = check.createdUserSuccessfully(response);

        AuthPage authPage = new AuthPage(driverRule.getDriver());

        var result = authPage.open()
                .waitForLoadAuthPage()
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton()
                .waitForLoadMainPage()
                .clickUserProfileButtonWithAuthorization()
                .waitForLoadProfilePage()
                .isProfilePageLoadedSuccessfully();
        Assert.assertTrue(result);
    }

    @Test
    public void checkOpeningProfilePageWithoutAuthorization() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        var result = mainPage.open()
                .waitForLoadMainPage()
                .clickUserProfileButtonWithoutAuthorization()
                .waitForLoadAuthPage()
                .isAuthPageLoadedSuccessfully();

        Assert.assertTrue(result);
    }

    @After
    public void tearDown() {
        user = null;
        if (accessToken == null) {
            return;
        }
        check.deletedUserSuccessfully(client.delete(accessToken));
    }
}
