package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BingTestCase extends BaseTest{

    public static void bingSearchTest()
    {
        bingPage.gotoPage();
        String txtSearch  = "Selenium";
        bingPage.enterSearchTextinBingPage(txtSearch);
        String linkTxt = bingPage.getFirstSearchLinkText();
        System.out.println("First link " + linkTxt);
        Assert.assertTrue(linkTxt.toLowerCase().contains(txtSearch.toLowerCase()));
    }

    //@AfterTest
    //public void teardown() {driver.quit();}
}
