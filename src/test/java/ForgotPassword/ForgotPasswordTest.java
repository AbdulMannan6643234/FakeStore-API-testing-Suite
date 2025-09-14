package ForgotPassword;

import org.testng.annotations.Test;

import Base.BaseTests;
public class ForgotPasswordTest extends BaseTests {
    @Test
    public void forgetpassword(){  
    var forgotpassword = homepage.ClickForgotPassword();
    String email = "tau@example.com";
    forgotpassword.setEmail(email);
    var emailsent = forgotpassword.clickButton();
    }
}
