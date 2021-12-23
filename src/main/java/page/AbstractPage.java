package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected final Logger logger = LogManager.getRootLogger();
    protected WebDriver driver = DriverSingleton.getDriver();

    public AbstractPage() {
        PageFactory.initElements(this.driver, this);
    }

    protected WebElement findElement(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitUntilElementIsDisabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }

    protected void waitForPageToLoad() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        webDriverWait.withMessage("Error: page not loaded").until(this::checkReadyState);
    }

    private boolean checkReadyState(SearchContext searchContext) {
        Object pageState = ((JavascriptExecutor) searchContext)
            .executeScript("return document.readyState");
        return ((String) pageState).equalsIgnoreCase("complete");
    }

}
