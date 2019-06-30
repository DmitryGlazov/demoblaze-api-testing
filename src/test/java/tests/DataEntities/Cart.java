package tests.DataEntities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> items;
    private int count;
    private int scannedCount;

    @JsonProperty("Items")
    public void setItems(ArrayList<Product> Items) {
        this.items = Items;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    @JsonProperty("Count")
    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @JsonProperty("ScannedCount")
    public void setScannedCount(int scannedCount) {
        this.scannedCount = scannedCount;
    }

    public int getScannedCount() {
        return scannedCount;
    }
}
