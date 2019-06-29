package tests.DataEntities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> items;
    private int count;
    private int scannedCount;

    public Cart() {
        this.count = 0;
        this.scannedCount = 0;

        Item item = new Item();
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);

        this.items = items;
    }

    @JsonProperty("Items")
    public void setItems(ArrayList<Item> Items) {
        this.items = Items;
    }

    public ArrayList<Item> getItems() {
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
