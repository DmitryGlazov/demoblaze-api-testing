package tests.Steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import tests.DataEntities.Cart;
import tests.Requests.CartRequests;
import java.io.IOException;

public class CartSteps {

    private CartRequests cartRequest;
    private Cart cart;

    @When("Delete product from cart")
    public void delete_product_from_cart() {
        cartRequest = new CartRequests();
        cartRequest.deleteProductFromCart();
    }

    @Then("Product with id {int} is in cart")
    public void product_is_in_cart(int productId) throws IOException {
        cartRequest = new CartRequests();
        cart = cartRequest.getCart();
        Assertions.assertEquals(1, cart.getCount());
        Assertions.assertEquals(productId, cart.getItems().get(0).getProd_id());
    }

    @Then("Cart is empty")
    public void cart_is_empty() throws IOException {
        cartRequest = new CartRequests();
        cart = cartRequest.getCart();
        Assertions.assertEquals(0, cart.getCount());
        Assertions.assertEquals(0, cart.getItems().size());
    }
}
