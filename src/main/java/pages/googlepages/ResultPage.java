package pages.googlepages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ResultPage extends BasePage {

    SelenideElement results = $(By.id("result-stats"));
    ElementsCollection listOfResults = $$x("//*[@class='TbwUpd NJjxre']");

    private static final Logger LOG = Logger.getLogger(ResultPage.class);

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfResultsOnPage() {
        return listOfResults.size();
    }

    public ResultPage printAmountOfResults() {
        LOG.info(results.getText());
        LOG.info("Results on page: " + getNumberOfResultsOnPage());
        return new ResultPage(driver);
    }
}
