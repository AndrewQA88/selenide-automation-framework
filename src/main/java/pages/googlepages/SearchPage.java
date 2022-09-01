package pages.googlepages;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.basepage.BasePage;
import utils.WindowHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage extends BasePage {

    SelenideElement searchField = $x("//input[@title='Пошук']");
    SelenideElement searchButton = $(By.className("gNO89b"));

    private static final Logger LOG = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage typeTextInSearchField(String searchText) {
        searchField.shouldBe(visible).sendKeys(searchText);
        LOG.info(String.format("Text '%s' is inserted into search field.", searchText));
        LOG.info("Click on search button.");
        searchButton.shouldBe(visible).click();
        LOG.info("Result page is opened.");
        return new ResultPage(this.driver);
    }

    public SearchPage openNewTabAndSwitch() {
        WindowHelper.openNewTab(driver, "https://www.google.com");
        return this;
    }
}
