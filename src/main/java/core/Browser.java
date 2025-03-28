package core;

import org.openqa.selenium.WebDriver;

public class Browser {
    
    private static WebDriver driver;

    public static void initDriver(String browserType) {
        BrowserType type = BrowserType.valueOf(browserType);
        if (driver == null) driver = createDriver(type);
    }

    public static void initDriver() {
        if (driver == null) driver = createDriver(getDefault());
    }

    public static WebDriver getDriver() { 
        if (driver == null) initDriver();
        return driver;
    }

    private static WebDriver createDriver(BrowserType type) {return BrowserFactory.createDriver(type);}

    public static void quitWebDriver() {
        driver.quit();
        driver=null;
    }

    private static BrowserType getDefault(){return BrowserType.CHROME;}
}
