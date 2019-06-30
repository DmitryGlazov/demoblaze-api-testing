package tests.Requests;

import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import tests.DataEntities.Product;
import tests.TestsContext;
import tests.TestsFixture;
import tests.Utils.EndPoints;

import static io.restassured.RestAssured.given;

public class ProductRequests {

    private TestsContext testsContext = TestsFixture.getTestContext();

    public void addItemToCart(int productId) {
        RestAssured.basePath = EndPoints.addToCart;

        testsContext.setOperationId(RandomStringUtils.randomAlphanumeric(5));

        Product item = new Product();
        item.setCookie(testsContext.getCookie());
        item.setId(testsContext.getOperationId());
        item.setProd_id(productId);

        given().body(item).post();
    }
}
