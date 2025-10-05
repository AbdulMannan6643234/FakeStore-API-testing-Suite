package tests.Auth;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.authService;
import models.auth;

public class authTests{
    
    @Test(groups="smoke")
    public void request_authentication_withValidCreds(){
        var request = new auth("mor_2314","83r5^_" );
        var requestAuth = new authService();
        var token = requestAuth.authentication( request).then()
            .extract().asString();
        assertFalse(token.equals(null),"Invalid Response");
    }
    @Test(groups="regression")
    public void request_authentication_withInvalidCreds(){
        var request = new auth("Smith","williams" );
        var requestAuth = new authService();
        var response = requestAuth.authentication( request);
        assertTrue(response.getStatusCode()==401,"Invalid Response");
    }
    @Test(groups="regression")
    public void request_authentication_withBlankCreds(){
        var request = new auth("","" );
        var requestAuth = new authService();
        var response = requestAuth.authentication( request);
        assertEquals(response.getStatusCode(),400,"Invalid Response");
    }

}
