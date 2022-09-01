package tests.googletest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.googlepages.ResultPage;
import pages.googlepages.SearchPage;
import tests.base.BaseTest;

public class GoogleTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(GoogleTests.class);
    private final String SEARCH_TEXT = "Skelia";

    @Test(description = "search in google for text 'Skelia' and return amount of results in log message")
    public void countNumberOfResultsOnPage() {
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = searchPage.typeTextInSearchField(SEARCH_TEXT).printAmountOfResults();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultPage.getNumberOfResultsOnPage() > 6, "Expected number of results must be more than 6.");
        softAssert.assertAll();
    }

    @Test(description = "open two different tabs and search for the same text in both and compare result")
    public void compareResultsOnDifferentTabs() {
        SearchPage searchPage = new SearchPage(driver);
        int resultsOnFirstTab = searchPage.typeTextInSearchField(SEARCH_TEXT).getNumberOfResultsOnPage();
        LOG.info(String.format("About '%s' results on page.", resultsOnFirstTab));
        int resultsOnSecondTab = searchPage.openNewTabAndSwitch().typeTextInSearchField("Skelia").getNumberOfResultsOnPage();
        LOG.info(String.format("About '%s' results on page.", resultsOnSecondTab));
        if (resultsOnFirstTab == resultsOnSecondTab) {
            LOG.info("There is the same number of results on first and second tab.");
        } else {
            LOG.info("There is different number of results on first and second tab.");
        }
    }
}
