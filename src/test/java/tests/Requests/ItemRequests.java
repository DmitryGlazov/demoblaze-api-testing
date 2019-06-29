package tests.Requests;

import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import tests.DataEntities.Item;
import tests.TestsContext;
import tests.TestsFixture;
import tests.Utils.EndPoints;
import tests.Utils.RestUtils;

public class ItemRequests {

    private TestsContext testsContext = TestsFixture.getTestContext();

    public void addItemToCart(int productId) {
        RestAssured.basePath = EndPoints.addToCart;

        testsContext.setOperationId(RandomStringUtils.randomAlphanumeric(5));

        Item item = new Item();
        item.setCookie(testsContext.getCookie());
        item.setId(testsContext.getOperationId());
        item.setProd_id(productId);

        RestUtils.sendRequest(item);
    }
}
