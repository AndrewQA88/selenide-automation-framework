package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    protected WebDriver driver;

    private final Logger LOG = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setWebDriver(driver);
        open("https://www.google.com");
        getWebDriver().manage().window().maximize();
        LOG.info("Page is maximized");
    }

    @AfterMethod
    public void closeDriver() {
        closeWebDriver();
    }
}
