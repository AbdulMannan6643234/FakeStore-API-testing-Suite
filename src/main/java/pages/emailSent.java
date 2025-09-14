package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class emailSent {
    private WebDriver driver;
    public emailSent(WebDriver driver){
        this.driver = driver;
    }
    public String response(){
    String response =    driver.findElement(By.tagName("body")).getText();
    return response;
}
}
