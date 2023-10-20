import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;

import praktikum.pages.AuthPage;
import praktikum.pages.ProfilePage;
import praktikum.user.*;


public class LogoutTest {

    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();

    private User user;
    private String accessToken;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void createUser() {
        user = UserGenerator.random();

        ValidatableResponse response = client.create(user);
        accessToken = check.createdUserSuccessfully(response);
    }

    @Test
    @DisplayName("Check user logout")
    @Description("Check that it is possible to user logout")
    public void checkUserLogout() {
        AuthPage authPage = new AuthPage(driverRule.getDriver());
        ProfilePage profilePage = new ProfilePage(driverRule.getDriver());

        authPage.open()
                .waitForLoadAuthPage()
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton()
                .waitForLoadMainPage();

        var result = profilePage.open()
                .waitForLoadProfilePage()
                .clickLogoutButton()
                .isLogoutSuccessful();

        Assert.assertTrue(result);
    }

    @After
    public void tearDown() {
        user = null;
        check.deletedUserSuccessfully(client.delete(accessToken));
    }
}
