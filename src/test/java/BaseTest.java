import core.Browser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import utils.PropertyReader;

public class BaseTest extends Browser {

    @BeforeEach
    public void openDriver() {
        Browser.initDriver("CHROME");
        new MainPage().open(PropertyReader.getProperty("url"));
    }

    @AfterAll
    public static void quitDriver() {
        Browser.quitWebDriver();
    }
}
