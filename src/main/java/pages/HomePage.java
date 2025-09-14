package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickformauthentication(){
     ClickLink("Form Authentication");   
     return new LoginPage(driver);
    }
    public DropDown clickDropDown(){
        ClickLink("Dropdown");
        return new DropDown(driver);
    }
    private void ClickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public ForgotPassword ClickForgotPassword(){
        ClickLink("Forgot Password");
        return new ForgotPassword(driver);
    }
    public Hovers clickonHover(){
        ClickLink("Hovers");
        return new Hovers(driver);
    }

}
