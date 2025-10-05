package tests.productTests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Services.productService;
import models.Product;
import tests.Base.BaseTests;
import util.ProductData;

public class productUpdationTests extends BaseTests{
@Test(dataProviderClass=ProductData.class,dataProvider="ProductCreationData",groups="smoke")
        public void request_updateProduct_WithValidCreds(int id, String title, double price, String description,String category,String image){
            var request = new Product(id, title, price, description,category,image);
            var updateExistingProduct = new productService();
            var response = updateExistingProduct.updateProduct(id,reqSpec,request);
            


            assertEquals(response.getStatusCode(),200, "Updation Failed");
        }
        @Test(groups="knownBug")
        public void request_updateProduct_WithBlankCreds(){
            int id = 7;
            var request = new Product(id, "",0, "", "","");
            var updateExistingProduct = new productService();
            var response = updateExistingProduct.updateProduct(id, reqSpec, request);

            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject blank update but returned 200");
        }
        @Test(groups="knownBug")
        public void request_updateProduct_WithNegativeId(){
            int id = -4;
            var request = new Product(id,"Gamepass",20,"1 Month Xbox Gamepass","digital goods","https://th.bing.com/th/id/OIF.FYOeyvZa1aUBBlE6QmqTFA?w=288&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3");
            var updateExistingProduct = new productService();
            var response = updateExistingProduct.updateProduct(id, reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject Negative id but returned 200");
        }
        @Test(groups="knownBug")
        public void request_updateProduct_WithNegativePrice(){
            int id = 12;
            var request = new Product(id,"Gamepass",-20,"1 Month Xbox Gamepass","digital goods","https://th.bing.com/th/id/OIF.FYOeyvZa1aUBBlE6QmqTFA?w=288&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3");
            var updateExistingProduct = new productService();
            var response = updateExistingProduct.updateProduct(id, reqSpec, request);
            
            assertEquals(response.getStatusCode(),400, "KNOWN BUG: API should reject Negative Price but returned 200");
        }
}
