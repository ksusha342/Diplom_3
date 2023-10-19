import io.restassured.response.ValidatableResponse;
import org.junit.*;

import praktikum.pages.AuthPage;
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
    public void checkUserLogout() {
        AuthPage authPage = new AuthPage(driverRule.getDriver());
        var result = authPage.open()
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton()
                .open()
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
