import io.restassured.response.ValidatableResponse;
import org.junit.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.AuthSource;
import praktikum.pages.AuthPage;
import praktikum.pages.MainPage;
import praktikum.user.*;


@RunWith(Parameterized.class)
public class LoginTest {

    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();

    private User user;
    private String accessToken;
    private AuthSource authSource;
    private boolean result;

    public LoginTest(AuthSource authSource, boolean result) {
        this.authSource = authSource;
        this.result = result;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {AuthSource.main, true},
                {AuthSource.profile, true},
//                {AuthSource.registration, true},
//                {AuthSource.recovery, true},
                {AuthSource.link, true}
        };
    }

    @Before
    public void createUser() {
        user = UserGenerator.random();

        ValidatableResponse response = client.create(user);
        accessToken = check.createdUserSuccessfully(response);
    }

    @Test
    public void checkUserLogin() {
        AuthPage authPage = new AuthPage(driverRule.getDriver());

        openAuthPage(authSource);

        var actual = authPage
                .waitForLoadAuthPage()
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton()
                .waitForLoadMainPage()
                .isMainPageLoadedSuccessful();

        Assert.assertEquals(result, actual);
    }

    private void openAuthPage(AuthSource source) {
        switch (source) {

            case main:
                openMainPageAuth();
            case profile:
                openProfilePageAuth();
            case registration:
                openRegistrationPageAuth();
            case recovery:
                openRecoveryPageAuth();
            case link:
                openLinkAuth();
        }
    }

    private void openMainPageAuth() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitForLoadMainPage()
                .clickSignUpButton();
    }

    private void openProfilePageAuth() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitForLoadMainPage()
                .clickUserProfileButton();
    }

    private void openRegistrationPageAuth() {
        // TODO: to be done
    }

    private void openRecoveryPageAuth() {
        // TODO: to be done
    }

    private void openLinkAuth() {
        AuthPage authPage = new AuthPage(driverRule.getDriver());
        authPage.open();
    }

    @After
    public void tearDown() {
        user = null;
        check.deletedUserSuccessfully(client.delete(accessToken));
    }
}
