package TestCases;

import org.testng.annotations.Test;


public class AllTestPages extends BaseTest {

    @Test
    public void ExecuteAllPages() {

        try {
            System.out.println("Hello Danny and Andrew - It was nice talking to you and I enjoyed session with you " +
                    "- I just got out of my meeting and took your task on priority Finished it");
            System.out.println("If time permits I can do the entire framework in a nice way but I am occupied with back to back meetings.");
            System.out.println("Executing Bing search, Google Search Testcases");
            BingTestCase.bingSearchTest();
            GoogleTestCase.googleSearchTest();
        } finally {
            System.out.println("Execution completed");
        }
    }
}
