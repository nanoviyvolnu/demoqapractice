package tests.BaseTest;

import common.CommonAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import pages.DemoQAMainPage.MainPage;
import pages.base.BasePage;

import java.time.Duration;
import java.util.Set;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // method to switch/create new window in browser
    protected void switchWindow(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String window1 = driver.getWindowHandle();
        String window2 = null;
        Set<String> currentWindows = driver.getWindowHandles();
        for (String window : currentWindows){
            if(!window1.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }

    // method to switch window to alert window
    protected void switchToAlertWindow(){
        Alert alert = driverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
    }

    @AfterSuite(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
