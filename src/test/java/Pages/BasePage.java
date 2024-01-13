package Pages;

import actionHelper.WebActionHelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    static WebActionHelperMethods weActionHelperMethods;

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        weActionHelperMethods = new WebActionHelperMethods(driver);
    }
}
