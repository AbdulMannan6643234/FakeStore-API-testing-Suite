package tests.userTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.userService;
import models.User;
import tests.Base.BaseTests;
import util.userData;

public class userUpdationTests extends BaseTests {
    @Test(dataProviderClass=userData.class,dataProvider="userCreationData",groups="smoke")
        public void request_updateUser_WithValidCreds(int id, String username, String email, String password){
            var request = new User(id, username, email, password);
            var updateExistingUser = new userService();
            var response = updateExistingUser.updateUser(id, reqSpec, request);
            


            assertTrue(response.getStatusCode()==200, "Updation Failed");
        }
        @Test(groups="knownBug")
        public void request_updateUser_WithBlankCreds(){
            int id = 7;
            var request = new User(id, "", "", "");
            var updateExistingUser = new userService();
            var response = updateExistingUser.updateUser(id, reqSpec, request);

            assertTrue(response.getStatusCode()==400, "KNOWN BUG: API should reject blank update but returned 200");
        }
        @Test(groups="knownBug")
        public void request_updateUser_WithNegativeId(){
            int id = -4;
            var request = new User(id, "jack12", "anna@gmail.com", "annabethe");
            var updateExistingUser = new userService();
            var response = updateExistingUser.updateUser(id, reqSpec, request);
            
            assertTrue(response.getStatusCode()==400, "KNOWN BUG: API should reject Negative id but returned 200");
        }
        @Test(groups="knownBug")
        public void request_updateUser_WithInvalidEmail(){
            int id = 12;
            var request = new User(id, "jack12", "jackson", "annabethe");
            var updateExistingUser = new userService();
            var response = updateExistingUser.updateUser(id, reqSpec, request);
            
            assertTrue(response.getStatusCode()==400, "KNOWN BUG: API should reject Invalid email but returned 200");
        }
}
