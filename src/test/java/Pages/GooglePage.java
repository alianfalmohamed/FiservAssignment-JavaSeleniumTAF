package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.utility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GooglePage extends BasePage {
    public GooglePage(WebDriver driver){ super(driver);
    }
    Properties properties;
    String URL;

    public void navigateToGoogle()
    {
        String propertyPath = System.getProperty("user.dir") + "//src//test//java//resources//Env.properties";
        System.out.println(propertyPath);
        properties = utility.loadProperties(propertyPath);
        URL = properties.getProperty("URL");
        System.out.println("URL is " + URL);
        driver.get(URL);
    }

    public void enterSearchText(String searchText)
    {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchText);
        element.sendKeys(Keys.ENTER);
    }

    public void ClickSearchButton()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.name("btnK"));
    }

    public String getFirstSearchResultLinkText()
    {
        return driver.findElement(By.cssSelector(".tF2Cxc:first-child cite")).getText();
    }
}
