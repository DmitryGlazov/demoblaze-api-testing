package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class test {

    Response res;
    @Test
    public void test(){
        res = get("https://api.demoblaze.com/entries");
        Assertions.assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        Assertions.assertEquals(9, jp.get("Count"));
    }

    @Test
    public void test2(){
        RestAssured.baseURI = "https://api.demoblaze.com/";
        RestAssured.basePath = "addtocart";
        res = given().contentType(ContentType.JSON).body("{\"id\":\"4b55feb49d0e\",\"cookie\":\"user=456\",\"prod_id\":8,\"flag\":false}").
                post();
        res = given().contentType(ContentType.JSON).body("{\"id\":\"4b55feb4944e\",\"cookie\":\"user=456\",\"prod_id\":8,\"flag\":false}").
                post();
        Assertions.assertEquals(200, res.getStatusCode());

        //check cart
        RestAssured.basePath = "viewcart";
        res = given().contentType(ContentType.JSON).body("{\"cookie\":\"user=456\",\"flag\":false}").
                post();
        String body = res.getBody().asString();
        System.out.println(body);
    }

}
