package tests.Steps;

import cucumber.api.java.en.When;
import tests.Requests.ItemRequests;

public class ProductSteps {

    ItemRequests itemRequest;

    @When("Add product with id {int} to cart")
    public void add_product_to_cart(int productId) {
        itemRequest = new ItemRequests();
        itemRequest.addItemToCart(productId);
    }
}
