package apiutils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ResponseHandler {

    private static Response validateResponse(Response response, String responseBodyContent, int statusCode) {
        return response
                .then()
                .body(containsString(responseBodyContent))
                .statusCode(statusCode)
                .extract()
                .response();
    }

    private static RequestSpecification prepareRequest(String acceptHeader) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", acceptHeader);
    }

    public static Response getPostApiResponse(String acceptHeader, String payloadBody, String url, String responseBodyContent,
                                              int statusCode) {
        Response response = null;
        response = prepareRequest(acceptHeader)
                .body(payloadBody)
                .when()
                .post(url);
        return validateResponse(response, responseBodyContent, statusCode);
    }
}