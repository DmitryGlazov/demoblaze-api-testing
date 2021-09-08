package tests.Requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tests.DataEntities.Cart;
import tests.TestsContext;
import tests.TestsFixture;
import tests.Utils.EndPoints;
import tests.Utils.RestUtils;

import java.io.IOException;
import static io.restassured.RestAssured.given;

public class CartRequests {

    private TestsContext testsContext = TestsFixture.getTestContext();

    public Cart getCart() throws IOException {
        RestAssured.basePath = EndPoints.viewCart;

        String cookie = testsContext.getCookie();
        String reqBody = "{\"cookie\":" + "\"" + cookie + "\"" + ",\"flag\":false}";

        Response res = given().contentType(ContentType.JSON).body(reqBody).post();
        String body = res.getBody().asString();

        Cart cart = RestUtils.getObjectMapper().readValue(body, Cart.class);
        return cart;
    }

    public void deleteProductFromCart() {
        RestAssured.basePath = EndPoints.deleteItem;

        String id = testsContext.getOperationId();
        String reqBody = "{\"id\":" + "\"" + id + "\"}";

        given().contentType(ContentType.JSON).body(reqBody).post();
    }
}
