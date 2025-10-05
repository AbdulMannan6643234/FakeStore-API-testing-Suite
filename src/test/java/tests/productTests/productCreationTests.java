package tests.productTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.productService;
import models.Product;
import tests.Base.BaseTests;
import util.ProductData;

public class productCreationTests extends BaseTests{
@Test(dataProviderClass=ProductData.class,dataProvider="ProductCreationData",groups="smoke")
        public void request_createProduct_WithValidCreds(int id, String title, double price, String description,String category,String image){
            var request = new Product(id, title, price, description,category,image);
            var createProduct = new productService();
            var response = createProduct.createProduct(reqSpec, request)
            .then()
            .spec(creationResSpec)
            .extract().as(Product.class);

            assertTrue(response.getId()>0, "Product Creation Failed");
        }
        @Test(groups="knownBug")
        public void request_createProduct_WithBlankCreds(){
            var request = new Product(1,"",0,"","","");
            var createProduct = new productService();
            var response = createProduct.createProduct(reqSpec, request);

            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject blank Creation but returned 200");
        }
        @Test(groups="knownBug")
        public void request_createProduct_WithNegativeId(){
            var request = new Product(-1,"Gamepass",20,"1 Month Xbox Gamepass","digital goods","https://th.bing.com/th/id/OIF.FYOeyvZa1aUBBlE6QmqTFA?w=288&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3");
            var createProduct = new productService();
            var response = createProduct.createProduct(reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject negative id but returned 201");
        }
        @Test(groups="knownBug")
        public void request_createProduct_WithNegativePrice(){
            var request = new Product(1,"Gamepass",-20,"1 Month Xbox Gamepass","digital goods","https://th.bing.com/th/id/OIF.FYOeyvZa1aUBBlE6QmqTFA?w=288&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3");
            var createProduct = new productService();
            var response = createProduct.createProduct(reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject Negative Price but returned 201");
        }
}
