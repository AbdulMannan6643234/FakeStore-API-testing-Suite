package tests.productTests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Services.productService;
import tests.Base.BaseTests;

public class productDeletionTests extends BaseTests{
        @Test(groups="knownBug")
        public void request_deleteExistingProduct(){
        var deleteProduct = new productService();
        var response = deleteProduct.deleteProduct(3, reqSpec);
        assertEquals(response.getStatusCode(), 200, "Request Failed");
        response = deleteProduct.getProductById(3, reqSpec);
        assertEquals(response.getStatusCode(),404,"Known Bug: Product should not exist after deletion");
    }
        @Test(groups="knownBug")
        public void request_deleteUser_WithNegativeId(){
        var deleteProduct = new productService();
        var response = deleteProduct.deleteProduct(-6, reqSpec);
        assertEquals(response.getStatusCode(), 400, "Known Bug: Delete request should fail with 400 (Bad Request) but got 200 (Success) with negative ids");
        
    }
        @Test(groups="smoke")
        public void request_deleteProduct_withValidId(){
            int id = 7;
            var deleteProduct = new productService();
            var response = deleteProduct.deleteProduct(id, reqSpec);
            assertEquals(response.getStatusCode(),200,"Product not Found");
        }
}
