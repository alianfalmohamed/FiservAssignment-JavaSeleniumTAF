package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTestCase extends BaseTest {

    @Test
    public static void googleSearchTest()
    {
        googlePage.gotoPage();
        //Enter Search String in Google search Text box, you can use data table for this since its one value and its a demo framework value is in the code
        String txt_SearchString = "fiserv";
        googlePage.enterSearchText(txt_SearchString);

        //Get first search link return from google search and assert with expected
        String linkTxt;
        linkTxt = googlePage.getFirstSearchResultLinkText();
        Assert.assertTrue(linkTxt.contains(txt_SearchString));
    }

    //@AfterTest
    //public void teardown() { driver.quit(); }

}
