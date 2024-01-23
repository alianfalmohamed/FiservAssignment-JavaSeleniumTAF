package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GooglePage extends BasePage {
    public static String URL ="http://www.google.com";
    public GooglePage(WebDriver driver){ super(driver); }

    public void gotoPage(){
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
