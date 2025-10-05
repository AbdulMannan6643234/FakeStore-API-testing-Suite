package tests.cartTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.cartService;
import models.Cart;
import tests.Base.BaseTests;

public class cartRetrievalTests extends BaseTests{
        @Test(groups="smoke")
        public void request_getAllCarts(){
        var getCarts = new cartService();
        var response = getCarts.getAllCarts(reqSpec,successfulResSpec);
        
        assertTrue(response.size()>0, "No Carts Exist");
    }
    @Test(groups="smoke")
    public void request_CartById(){
        int id = 6;
        var getCart = new cartService();
        var response = getCart.getCartById(id, reqSpec)
        .then()
            .spec(successfulResSpec)
            .extract().as(Cart.class);
        assertFalse(response.getId()<0, "Cart not found");
    }
    @Test(groups="regression")
    public void request_CartByNegativeId(){
        var getCart = new cartService();
        var response = getCart.getCartById(-1, reqSpec)
        .then()
        .log().all()
        .spec(successfulResSpec)
        .extract().asString();
        assertEquals(response,"null", "Cart found With Negative Id");
    }
}
