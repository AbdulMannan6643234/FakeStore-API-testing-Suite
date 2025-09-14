package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;
    private By EmailField = By.id("email");
    public ForgotPassword(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }
    public emailSent clickButton(){
        driver.findElement(By.id("form_submit")).click();
        return new emailSent(driver);
    }

}
