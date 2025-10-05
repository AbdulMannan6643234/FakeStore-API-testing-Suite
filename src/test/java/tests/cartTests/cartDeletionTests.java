package tests.cartTests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Services.cartService;
import tests.Base.BaseTests;

public class cartDeletionTests extends BaseTests{
        @Test(groups="knownBug")
    public void request_deleteExistingCart(){
        var deleteCart = new cartService();
        var response = deleteCart.deleteCart(3, reqSpec);
        assertEquals(response.getStatusCode(), 200, "Request Failed");
        response = deleteCart.getCartById(3, reqSpec);
        assertEquals(response.getStatusCode(),404,"Known Bug: Cart should not exist after deletion");
    }
    @Test(groups="knownBug")
    public void request_deleteCart_withNegativeId(){
        var deleteCart = new cartService();
        var response = deleteCart.deleteCart(-6, reqSpec);
        assertEquals(response.getStatusCode(), 400, "Known Bug: Delete request should fail with 400 (Bad Request) but got 200 (Success) with negative ids");
        
    }
    @Test(groups="smoke")
        public void request_deleteCart_withValidId(){
            int id = 7;
            var deleteCart = new cartService();
            var response = deleteCart.deleteCart(id, reqSpec);
            assertEquals(response.getStatusCode(),200,"Cart not Found");
        }
}
