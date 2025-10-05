package models;

public class auth {
        private String username;
        private String password;
        public auth(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public auth() {
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        
}
