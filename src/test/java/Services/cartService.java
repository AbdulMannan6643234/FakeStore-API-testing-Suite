package Services;
import java.util.List;

import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.Cart;

public class cartService {



        public List<Cart> getAllCarts(RequestSpecification reqSpec, ResponseSpecification resSpec){
            return given()
            .spec(reqSpec)
            .when()
            .get("/carts")
            .then()
            .spec(resSpec)
            .extract().as( new TypeRef<List<Cart>>(){});
        }
        public Response getCartById(int id, RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .when()
            .get("/carts/{id}");
        }
        public Response createCart(RequestSpecification reqSpec,Object request){
            return given()
            .spec(reqSpec)
            .body(request)
            .when()
            .post("/carts");
        }
        public Response updateCart(int id, RequestSpecification reqSpec,Object request){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .body(request)
            .when()
            .put("/carts/{id}");
        }
        public Response deleteCart(int id, RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id",id)
            .when()
            .delete("/carts/{id}");
        }
}




