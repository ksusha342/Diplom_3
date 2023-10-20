import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.UserRegistrationPage;
import praktikum.user.*;


@RunWith(Parameterized.class)
public class UserRegistrationTest {

    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();

    private User user;
    private final String password;
    private final boolean result;

    public UserRegistrationTest(String password, boolean result) {
        this.password = password;
        this.result = result;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][] {
                {"Qwerty_123", true},
                {"Qwerty", true},
                {"Qwert", false},
                {"Q", false},
                {"", false},
        };
    }

    @Before
    public void createUser() {
        user = UserGenerator.random();
    }

    @Test
    @DisplayName("Check user registration with different password lengths")
    @Description("User registration with different password lengths")
    public void checkUserRegistration() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(driverRule.getDriver());

        var actual = userRegistrationPage.open()
                .waitForLoadRegistrationPage()
                .typeName(user.getName())
                .typeEmail(user.getEmail())
                .typePassword(password)
                .clickSignUpButton()
                .isRegistrationSuccessful();

        Assert.assertEquals(result, actual);
    }

    @After
    public void tearDown() {
        if (result) {
            deleteRegistrationUser();
        }
    }

    private void deleteRegistrationUser() {
        ValidatableResponse response = client.login(new Credentials(user.getEmail(), password));
        String accessToken = check.createdUserSuccessfully(response);
        check.deletedUserSuccessfully(client.delete(accessToken));
    }
}
