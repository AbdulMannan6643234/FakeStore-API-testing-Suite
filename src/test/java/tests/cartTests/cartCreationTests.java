package tests.cartTests;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.cartService;
import models.Cart;
import models.productInCart;
import tests.Base.BaseTests;

public class cartCreationTests extends BaseTests{
@Test
           public void request_createCart_WithValidCreds(){
            var products = new ArrayList<productInCart>();
            products.add(new productInCart(14,10));
            var request = new Cart(5,12,products);
            var createCart = new cartService();
            var response = createCart.createCart(reqSpec, request)
            .then()
            .spec(creationResSpec)
            .extract().as(Cart.class);

            assertTrue(response.getId()>0, "art Creation Failed");
        }
        @Test(groups="knownBug")
        public void request_createCart_WithBlankCreds(){
            var products = new ArrayList<productInCart>();
            var request = new Cart(0,0,products);
            var createCart = new cartService();
            var response = createCart.createCart(reqSpec, request);

            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject blank Creation but returned 201");
        }
        @Test(groups="knownBug")
        public void request_createCart_WithNegativeId(){
            var products = new ArrayList<productInCart>();
            products.add(new productInCart(14,22));
            var request = new Cart(-1,12,products);
            var createCart = new cartService();
            var response = createCart.createCart(reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject negative id but returned 201");
        }
        @Test(groups="knownBug")
        public void request_createCart_WithNegativeUserId(){
            var products = new ArrayList<productInCart>();
            var request = new Cart(1,-12,products);
            var createCart = new cartService();
            var response = createCart.createCart(reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject Negative Userid but returned 201");
        }
}
