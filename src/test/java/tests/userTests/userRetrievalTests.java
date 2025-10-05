package tests.userTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.userService;
import models.User;
import tests.Base.BaseTests;
import util.userData;

public class userRetrievalTests extends BaseTests {
    @Test(groups="smoke")
    public void request_getAllUsers(){
        var getUsers = new userService();
        var response = getUsers.getAllUsers(reqSpec,successfulResSpec);
        
        assertTrue(response.size()>0, "No Users Exist");
    }
    @Test(dataProviderClass=userData.class,dataProvider="userIdAndName",groups="smoke")
    public void request_userById(int id, String name){
        var getUser = new userService();
        var response = getUser.getUserById(id, reqSpec)
        .then()
            .spec(successfulResSpec)
            .extract().as(User.class);
        assertTrue(response.getUsername().equals(name), "User not fOund");
    }
    @Test(groups="regression")
    public void request_userByNegativeId(){
        var getUser = new userService();
        var response = getUser.getUserById(-1, reqSpec)
        .then()
        .spec(successfulResSpec)
        .extract().asString();
        assertTrue(response.equals("null"), "User found With Negative Id");
    }

}
