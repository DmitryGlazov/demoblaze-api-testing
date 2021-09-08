package tests.Utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class RestUtils {

    public static void setRequestSpec(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    public static void setResponseSpec() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();

        RestAssured.responseSpecification = responseSpec;
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new CustomJSONNamingStrategy());
        return mapper;
    }
}
