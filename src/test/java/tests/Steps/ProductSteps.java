package tests.Steps;

import cucumber.api.java.en.When;
import tests.Requests.ItemRequests;

public class ProductSteps {

    @When("Add product with id {int} to cart")
    public void add_product_to_cart(int productId) {
        ItemRequests itemRequest = new ItemRequests();
        itemRequest.addItemToCart(productId);
    }
}
