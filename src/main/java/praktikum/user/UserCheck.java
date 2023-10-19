package praktikum.user;

import io.restassured.response.ValidatableResponse;

import javax.net.ssl.HttpsURLConnection;

import static org.hamcrest.Matchers.is;

public class UserCheck {

    public String createdUserSuccessfully(ValidatableResponse response) {
        return response
                .assertThat()
                .statusCode(HttpsURLConnection.HTTP_OK)
                .body("success", is(true))
                .extract()
                .path("accessToken");
    }

    public void deletedUserSuccessfully(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpsURLConnection.HTTP_ACCEPTED)
                .body("success", is(true));
    }
}
