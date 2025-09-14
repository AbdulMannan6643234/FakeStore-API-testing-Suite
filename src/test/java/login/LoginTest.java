package login;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Base.BaseTests;
import pages.LoginPage;
import pages.secureArea;

public class LoginTest extends BaseTests{
@Test
    public void testSuccesfulLogin(){
       LoginPage loginPage = homepage.clickformauthentication();
       loginPage.setUsername("tomsmith");
       loginPage.setPassword("SuperSecretPassword!");
       secureArea SecureArea = loginPage.clickLogin();
       assertTrue(SecureArea.getAlertText().contains("You logged into a secure area!"));
    }

}
