package tests.DataEntities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> items;

    @JsonProperty("Items")
    public void setItems(ArrayList<Product> Items) {
        this.items = Items;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public int getCount() {
        return getItems().size();
    }
}
