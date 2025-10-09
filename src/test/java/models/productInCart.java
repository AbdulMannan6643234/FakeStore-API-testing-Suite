package models;

public class productInCart {
        private int productId;
        private int quantity;
        public productInCart(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }
        public productInCart() {
        }
        public int getProductId() {
            return productId;
        }
        public void setProductId(int productId) {
            this.productId = productId;
       //test
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}
