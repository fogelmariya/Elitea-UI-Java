package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import core.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BasePage {
    protected WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(Browser.getDriver(), this);
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(60));
    }

    public void open(String url){
        Browser.getDriver().get(url);
    }

    public WebDriver getDriver() {
        return Browser.getDriver();
    }

    protected void scrollIntoView(WebElement element){
        JavascriptExecutor js = ((JavascriptExecutor) Browser.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void waitForReadyStateComplete(){
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
