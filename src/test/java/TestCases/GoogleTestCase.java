import Pages.GooglePage;
import TestCases.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTestCase extends BaseTest {

    private GooglePage googlePage;

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Anfal\\dependencies\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
    }

    @Test
    public void googleSearchTest()
    {
        String txt_SearchString = "fiserv";
        googlePage.navigateToGoogle();
        googlePage.enterSearchText(txt_SearchString);

        String linkTxt;
        linkTxt = googlePage.getFirstSearchResultLinkText();
        Assert.assertTrue(linkTxt.contains(txt_SearchString));
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();

    }

}
