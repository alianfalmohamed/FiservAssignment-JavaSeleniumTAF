package TestCases;

import Pages.GooglePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;
public class BaseTest {

    protected GooglePage googlePage;

    protected WebDriver driver;

    Properties properties;

    static String URL;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Anfal\\dependencies\\chromedriver-win64\\chromedriver.exe");
        googlePage = new GooglePage(driver);
    }

    @AfterSuite
    public void tearDown(){
        if(driver !=null) {
            driver.quit();
        }
    }
}
