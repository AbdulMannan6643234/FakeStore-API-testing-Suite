package util;

import org.testng.annotations.DataProvider;

public class ProductData {
    @DataProvider
    public Object[][] ProductCreationData(){
        return new Object[][] 
        { {1,"Gamepass",20,"1 Month Xbox Gamepass","digital goods","https://th.bing.com/th/id/OIF.FYOeyvZa1aUBBlE6QmqTFA?w=288&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3"},
          {2,"Steamdeck",400,"Handheld PC","tech","https://th.bing.com/th/id/OIP.wcp-29vnVpFwX5CoVpAFNQHaEK?w=265&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3"},
          {3,"Nitro V15",800,"Gaming Laptop","tech","https://th.bing.com/th/id/OIP.ohE3qxpFF4Nz2QjxUkpfMgHaEh?w=262&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3"},
          {4,"MacBook Air",1000,"Macbook","tech","https://th.bing.com/th?id=OIF.rQB4Cft9sA6bkH0jOO2g%2fA&w=181&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3"},
          {5,"Keyboard",70,"Mechanical RGB keyboard","tech","https://th.bing.com/th/id/OIP.VtxBfGfJDkrxmn4Fi3tMqwHaHa?w=166&h=180&c=7&r=0&o=7&cb=12&dpr=1.3&pid=1.7&rm=3"}
        };
    }
}
