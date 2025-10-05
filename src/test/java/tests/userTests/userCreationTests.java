package tests.userTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.userService;
import models.User;
import tests.Base.BaseTests;
import util.userData;

public class userCreationTests extends BaseTests {
        @Test(dataProviderClass=userData.class,dataProvider="userCreationData",groups="smoke")
        public void request_createUser_WithValidCreds(int id, String username, String email, String password){
            var request = new User(id, username, email, password);
            var createUser = new userService();
            var response = createUser.createUser(reqSpec, request)
            .then()
            .spec(creationResSpec)
            .extract().as(User.class);

            assertTrue(response.getId()>0, "User Creation Failed");
        }
        @Test(groups="knownBug")
        public void request_createUser_WithBlankCreds(){
            var request = new User(7, "", "", "");
            var createUser = new userService();
            var response = createUser.createUser(reqSpec, request);

            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject blank Creation but returned 201");
        }
        @Test(groups="knownBug")
        public void request_createUser_WithNegativeId(){
            var request = new User(-4, "jack12", "anna@gmail.com", "annabethe");
            var createUser = new userService();
            var response = createUser.createUser(reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject negative id but returned 201");
        }
        @Test(groups="knownBug")
        public void request_createUser_WithInvalidEmail(){
            var request = new User(12, "jack12", "jackson", "annabethe");
            var createUser = new userService();
            var response = createUser.createUser(reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject invalid email but returned 201");
        }
        
        
}
