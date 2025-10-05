package Services;

import java.util.List;

import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.Product;


public class productService {

        public List<Product> getAllProducts(RequestSpecification reqSpec, ResponseSpecification resSpec){
            return given()
            .spec(reqSpec)
            .when()
            .get("/products")
            .then()
            .spec(resSpec)
            .extract().as( new TypeRef<List<Product>>(){});
        }
        public Response getProductById(int id, RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .when()
            .get("/products/{id}");
        }
        public Response createProduct(RequestSpecification reqSpec,Object request){
            return given()
            .spec(reqSpec)
            .body(request)
            .when()
            .post("/products");
        }
        public Response updateProduct(int id, RequestSpecification reqSpec,Object request){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .body(request)
            .when()
            .put("/products/{id}");
        }
        public Response deleteProduct(int id, RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id",id)
            .when()
            .delete("/products/{id}");
        }
}


