package models;

import java.util.List;

public class Cart {
        private int id;
        private int userid;
        private List<productInCart> products;
        public Cart(int id, int userid, List<productInCart> products) {
            this.id = id;
            this.userid = userid;
            this.products = products;
        }
        public Cart() {
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getUserid() {
            return userid;
        }
        public void setUserid(int userid) {
            this.userid = userid;
        }
        public List<productInCart> getProducts() {
            return products;
        }
        public void setProducts(List<productInCart> products) {
            this.products = products;
        }
}
