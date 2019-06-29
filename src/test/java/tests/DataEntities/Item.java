package tests.DataEntities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    //TODO: change names to more identifiable

    private int productId;
    private String id;
    private String cookie;
    private boolean flag;

    public Item() {
        this.productId = 0;
        this.id = "0";
        this.cookie = "abcde";
        this.flag = false;
    }

    @JsonProperty("prod_id")
    public int getProd_id() {
        return productId;
    }

    @JsonProperty("prod_id")
    public void setProd_id(int prod_id) {
        this.productId = prod_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
