package tests.Utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static void setRequestSpec(String baseUri) {
//        RequestSpecification requestSpec = new RequestSpecBuilder().
//                setBaseUri(baseUri).
//                setContentType(ContentType.JSON).
//                build();
//
//        RestAssured.requestSpecification = requestSpec;

//        Cookie myCookie = new Cookie.Builder("user","555").
//                build();

        RestAssured.baseURI = baseUri;
        RestAssured.given().contentType(ContentType.JSON);
    }

    public static void setResponseSpec() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();

        RestAssured.responseSpecification = responseSpec;
    }

    public static void sendRequest(Object requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new CustomJSONNamingStrategy());
        //TODO: remove logs

        given().body(requestBody).log().body().post();
    }

    //TODO: remove method
    public static Class sendRequestWithResponse(Object requestBody, Class _class) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new CustomJSONNamingStrategy());
        given().body(requestBody).log().body().post();

        Response res = given().body(requestBody).log().body().post();
        String body = res.getBody().asString();

        _class = mapper.readValue(body, Class.class);
        return _class;
    }
}
