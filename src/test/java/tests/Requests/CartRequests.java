package tests.Requests;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.DataEntities.Cart;
import tests.TestsContext;
import tests.TestsFixture;
import tests.Utils.CustomJSONNamingStrategy;
import tests.Utils.EndPoints;
import tests.Utils.RestUtils;

import java.io.IOException;
import static io.restassured.RestAssured.given;

public class CartRequests {

    private TestsContext testsContext = TestsFixture.getTestContext();

    public Cart getCart() throws IOException {
        RestAssured.basePath = EndPoints.viewCart;

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new CustomJSONNamingStrategy());

        String cookie = testsContext.getCookie();

        String reqBody = "{\"cookie\":" + "\"" + cookie + "\"" + ",\"flag\":false}";

        //TODO: remove logs
        Response res = given().body(reqBody).log().body().post();
        String body = res.getBody().asString();

        Cart cart = mapper.readValue(body, Cart.class);
        return cart;
    }

    public void deleteItemFromCart() {
        RestAssured.basePath = EndPoints.deleteItem;

        String id = testsContext.getOperationId();
        String reqBody = "{\"id\":" + "\"" + id + "\"}";
        RestUtils.sendRequest(reqBody);
    }
}
