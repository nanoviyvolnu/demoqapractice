package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static common.Config.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url){
        driver.get(url);
    }

    public void close(){
        driver.close();
    }

    public WebElement waitElementIsVisible(WebElement webElement){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public WebElement waitElementsIsVisible(List<WebElement> webElement){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf((WebElement) webElement));
        return (WebElement) webElement;
    }
}
