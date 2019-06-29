package tests;

public final class TestsContext {

    private String cookie;
    private String operationId;

    public void setCookie(String newCookie) {
        this.cookie = newCookie;
    }

    public String getCookie() {
        return this.cookie;
    }

    public void setOperationId(String newOperationId) {
        this.operationId = newOperationId;
    }

    public String getOperationId() {
        return this.operationId;
    }
}
