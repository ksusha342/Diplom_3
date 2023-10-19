package praktikum.user;

import io.restassured.response.ValidatableResponse;
import praktikum.Client;

public class UserClient extends Client {
    public static final String USER_CREATE_PATH = "/auth/register";
    public static final String USER_LOGIN_PATH = "/auth/login";
    public static final String USER_DELETE_PATH = "/auth/user";

    public ValidatableResponse create(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_CREATE_PATH)
                .then().log().all();
    }

    public ValidatableResponse login(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(USER_LOGIN_PATH)
                .then().log().all();
    }

    public ValidatableResponse delete(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_DELETE_PATH)
                .then().log().all();
    }
}
