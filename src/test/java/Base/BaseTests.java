package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.HomePage;

public class BaseTests{
    private WebDriver driver;
    protected HomePage homepage;
    
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homepage = new HomePage(driver);
        
    }
        
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}