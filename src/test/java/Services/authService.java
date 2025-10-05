package Services;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.auth;

        
public class authService {
    private RequestSpecification reqSpec = new RequestSpecBuilder()
        .setBaseUri("https://fakestoreapi.com")
        .setContentType("application/json")
        .build();    
    public Response authentication(auth request){
            return given()
            .spec(reqSpec)
            .body(request)
            .when()
            .post("/auth/login");
        }
}
