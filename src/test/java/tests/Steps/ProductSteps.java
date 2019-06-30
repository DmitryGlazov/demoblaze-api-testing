package tests.Steps;

import cucumber.api.java.en.When;
import tests.Requests.ProductRequests;

public class ProductSteps {

    private ProductRequests productRequest;

    @When("Add product with id {int} to cart")
    public void add_product_to_cart(int productId) {
        productRequest = new ProductRequests();
        productRequest.addItemToCart(productId);
    }
}
