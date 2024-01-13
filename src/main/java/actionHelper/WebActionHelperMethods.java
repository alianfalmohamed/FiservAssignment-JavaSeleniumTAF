package actionHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebActionHelperMethods {

    private WebDriver driver;

    public WebActionHelperMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void writeOnEditText(String data, String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    public boolean clickbutton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return true;
    }

    public boolean clickbutton(WebElement xpath) {
        xpath.click();
        return true;
    }

    public void clickLink(String data) {
        driver.findElement(By.linkText(data));
    }
}
