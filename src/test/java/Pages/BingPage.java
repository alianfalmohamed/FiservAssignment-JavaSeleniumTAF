package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BingPage extends BasePage {

    public static String URL ="http://www.bing.com";
    public BingPage(WebDriver driver) {super(driver);}

    private By searchBoxLocator = By.id("sb_form_q");
    private By firstSearchResultLocator = By.cssSelector("li.b_algo h2 a");

    public void gotoPage(){
        driver.get(URL);
    }

    public void enterSearchTextinBingPage(String searchText){
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(searchText);
        searchBox.submit();
    }

    public String getFirstSearchLinkText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultLocator));
        return firstResult.getAttribute("href");
    }
}
