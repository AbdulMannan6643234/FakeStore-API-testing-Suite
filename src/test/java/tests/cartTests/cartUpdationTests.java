package tests.cartTests;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.cartService;
import models.Cart;
import models.productInCart;
import tests.Base.BaseTests;

public class cartUpdationTests extends BaseTests {
    @Test
           public void request_updateCart_WithValidCreds(){
            var products = new ArrayList<productInCart>();
            products.add(new productInCart(14,10));
            var request = new Cart(5,12,products);
            var updateCart = new cartService();
            var response = updateCart.updateCart(5, reqSpec, request)
            .then()
            .spec(successfulResSpec)
            .extract().as(Cart.class);

            assertTrue(response.getId()>0, "Cart Updation Failed");
        }
        @Test(groups="knownBug")
        public void request_updateCart_WithBlankCreds(){
            var products = new ArrayList<productInCart>();
            var request = new Cart(0,0,products);
            var updateCart = new cartService();
            var response = updateCart.updateCart(0,reqSpec, request);

            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject blank Updation but returned 200");
        }
        @Test(groups="knownBug")
        public void request_updateCart_WithNegativeId(){
            var products = new ArrayList<productInCart>();
            products.add(new productInCart(14,22));
            var request = new Cart(-1,12,products);
            var updateCart = new cartService();
            var response = updateCart.updateCart(-1,reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject negative id but returned 200");
        }
        @Test(groups="knownBug")
        public void request_updateCart_WithNegativeUserId(){
            var products = new ArrayList<productInCart>();
            var request = new Cart(1,-12,products);
            var updateCart = new cartService();
            var response = updateCart.updateCart(1, reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject Negative Userid but returned 200");
        }
}
