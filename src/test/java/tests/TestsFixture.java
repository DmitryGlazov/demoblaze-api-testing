package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import tests.Utils.RestUtils;

public final class TestsFixture {

    private static final String baseUri = System.getProperty("URI");

    private static TestsContext testContext = null;

    public static synchronized TestsContext getTestContext() {
        if (testContext == null) {
            throw new IllegalArgumentException("Initialize test context!");
        }
        return testContext;
    }

    @Before
    public void setUp() {
        testContext = new TestsContext();
        testContext.setCookie(RandomStringUtils.randomAlphanumeric(5));

        RestUtils.setRequestSpec(baseUri);
        RestUtils.setResponseSpec();
    }

    @After
    public void tearDown() {
        RestAssured.baseURI = RestAssured.DEFAULT_URI;
        RestAssured.basePath = RestAssured.DEFAULT_PATH;
//        testContext = null;
    }
}
