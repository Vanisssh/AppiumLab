package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.concurrent.TimeUnit;

public class MainPageObject {
    protected AppiumDriver<WebElement> driver;

    public MainPageObject(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        FluentWait<AppiumDriver<WebElement>> wait = new FluentWait<>(driver)
                .withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);

        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
    }

    public void waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
    }

    public void waitForElementAndClear(By by, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.clear();
    }
}
