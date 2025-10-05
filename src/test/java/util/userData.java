package util;

import org.testng.annotations.DataProvider;

public class userData {
    @DataProvider
    public Object[][] userIdAndName(){
        return new Object[][] 
        { {1,"johnd"},
          {2,"mor_2314"},
          {3,"kevinryan"},
          {4,"donero"},
          {5,"derek"},
        };
    }

    @DataProvider
    public Object[][] userCreationData(){
        return new Object[][] 
        { {1,"alissonstone","allison@gmail.com","scriptgod"},
          {2,"johnbuyer","john@gmail.com","caprediem"},
          {3,"don","donatello@gmail.com","prophecy"},
          {4,"dean","dean@gmail.com","pieforlife"},
          {5,"sam","samuel@gmail.com","thefreak"}
        };
    }
}
