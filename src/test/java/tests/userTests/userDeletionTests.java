package tests.userTests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Services.userService;
import tests.Base.BaseTests;

public class userDeletionTests extends BaseTests {
    @Test(groups="knownBug")
    public void request_deleteExistingUser(){
        var deleteUser = new userService();
        var response = deleteUser.deleteUser(3, reqSpec);
        assertEquals(response.getStatusCode(), 200, "Request Failed");
        response = deleteUser.getUserById(3, reqSpec);
        assertEquals(response.getStatusCode(),404,"Known Bug: User should not exist after deletion");
    }
    @Test(groups="knownBug")
    public void request_deleteUser_WithNegativeId(){
        var deleteUser = new userService();
        var response = deleteUser.deleteUser(-6, reqSpec);
        assertEquals(response.getStatusCode(), 400, "Known Bug: Delete request should fail with 400 (Bad Request) but got 200 (Success) with negative ids");
        
    }
    @Test(groups="smoke")
        public void request_deleteUser_withValidId(){
            int id = 7;
            var deleteUser = new userService();
            var response = deleteUser.deleteUser(id, reqSpec);
            assertEquals(response.getStatusCode(),200,"User not Found");
        }
}
