package tests.productTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.productService;
import models.Product;
import tests.Base.BaseTests;

public class productRetrievalTests extends BaseTests{
        @Test(groups="smoke")
        public void request_getAllProducts(){
        var getProducts = new productService();
        var response = getProducts.getAllProducts(reqSpec,successfulResSpec);
        
        assertTrue(response.size()>0, "No Products Exist");
    }
    @Test(groups="smoke")
    public void request_ProductById(){
        int id = 6;
        var getProduct = new productService();
        var response = getProduct.getProductById(id, reqSpec)
        .then()
            .spec(successfulResSpec)
            .extract().as(Product.class);
        assertFalse(response.getTitle().equals(null), "Product not found");
    }
    @Test(groups="regression")
    public void request_ProductByNegativeId(){
        var getProduct = new productService();
        var response = getProduct.getProductById(-1, reqSpec)
        .then()
        .log().all()
        .spec(successfulResSpec)
        .extract().asString();
        assertTrue(response.isBlank(), "Product found With Negative Id");
    }
}
