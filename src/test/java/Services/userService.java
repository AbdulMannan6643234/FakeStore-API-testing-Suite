package Services;

import java.util.List;

import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.User;

public class userService {
        public List<User> getAllUsers(RequestSpecification reqSpec, ResponseSpecification resSpec){
            return given()
            .spec(reqSpec)
            .when()
            .get("/users")
            .then()
            .spec(resSpec)
            .extract().as( new TypeRef<List<User>>(){});
        }
        public Response getUserById(int id, RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .when()
            .get("/users/{id}");
        }
        public Response createUser(RequestSpecification reqSpec,Object request){
            return given()
            .spec(reqSpec)
            .body(request)
            .when()
            .post("/users");
        }
        public Response updateUser(int id, RequestSpecification reqSpec,Object request){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .body(request)
            .when()
            .put("/users/{id}");
        }
        public Response deleteUser(int id, RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id",id)
            .when()
            .delete("/users/{id}");
        }
}
