package pages.pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class secureArea {
    private WebDriver driver;
    private By statusAlert = By.id("flash");
    public secureArea(WebDriver driver){
        this.driver = driver;
    }
    public String getAlertText(){
      return  driver.findElement(statusAlert).getText();

    }
}
