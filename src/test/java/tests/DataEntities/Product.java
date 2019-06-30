package tests.DataEntities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private int productId;
    private String operationId;
    private String cookie;
    private boolean flag;

    @JsonProperty("prod_id")
    public int getProd_id() {
        return productId;
    }

    @JsonProperty("prod_id")
    public void setProd_id(int productId) {
        this.productId = productId;
    }

    @JsonProperty("id")
    public String getId() {
        return operationId;
    }

    @JsonProperty("id")
    public void setId(String operationId) {
        this.operationId = operationId;
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
