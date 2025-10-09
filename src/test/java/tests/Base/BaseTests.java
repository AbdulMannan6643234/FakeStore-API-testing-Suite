package tests.Base;

import org.testng.annotations.BeforeClass;

import Services.authService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.auth;

public class BaseTests {
    protected RequestSpecification reqSpec;
    protected ResponseSpecification successfulResSpec;
    protected ResponseSpecification failureResSpec;
    protected ResponseSpecification creationResSpec;
    protected String token;
    @BeforeClass(alwaysRun=true)
    public void setUp(){
        var auth = new authService();
        var request = new auth("mor_2314","83r5^_" );
        token = auth.authentication(request).then().extract().asString();
        reqSpec = new RequestSpecBuilder()
        .setBaseUri("https://fakestoreapi.com")
        .addCookie("token", token)
        .setContentType("application/json")
        .addHeader("Accept", "application/json")
        .build();
        successfulResSpec = new ResponseSpecBuilder()
        .expectStatusCode(200)
        .expectContentType("application/json")
        .build();
        failureResSpec = new ResponseSpecBuilder()
        .expectStatusCode(404)
        .expectContentType("application/json")
        .build();
        creationResSpec = new ResponseSpecBuilder()
        .expectStatusCode(201)
        .expectContentType("application/json")
        .build();
        
    }
}
