package TestCases;

import Pages.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import util.utility;

import java.util.Properties;
public class BaseTest {

    public GooglePage googlePage;
    protected WebDriver driver;
    Properties properties;
    public static String URL = null;
    public static String CHROME_DRIVER_PATH = null;


    @BeforeSuite
    @Parameters({ "browserName", "environment" })
    public void setup(String browserName, String environment){

        //Get Env.Properties file path
        String propertyPath = System.getProperty("user.dir") + "//src//test//java//resources//Env.properties";
        System.out.println(propertyPath);

        //Read all properties from Env.Properties file
        properties = utility.loadProperties(propertyPath);

        //Get URL and DriverPath instead of hardcoding
        URL = properties.getProperty("URL");
        System.out.println("URL is " + URL);
        CHROME_DRIVER_PATH = properties.getProperty("CHROME_DRIVER_PATH");
        System.out.println(CHROME_DRIVER_PATH);
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        DriverManagerType driverType;
        switch (browserName.toLowerCase()) {
            case "chrome":
                driverType = DriverManagerType.CHROME;
                break;
            case "firefox":
                driverType = DriverManagerType.FIREFOX;
                break;
            case "ie":
                driverType = DriverManagerType.IEXPLORER;
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        // Setup the WebDriver using WebDriverManager
        WebDriverManager.getInstance(driverType).setup();
        // Initialize the WebDriver based on the DriverManagerType
        switch (driverType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case IEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }
        googlePage = new GooglePage(driver);
        driver.get(URL);
    }

    @AfterSuite
    public void tearDown(){
        if(driver !=null) {
            driver.quit();
        }
    }
}
