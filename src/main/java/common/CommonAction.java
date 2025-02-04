package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.IMPLICIT_WAIT;
import static common.Config.PLATFORM_AND_BROWSER;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction(){

    }

    public static WebDriver createDriver(){
        if(driver == null){
            switch (PLATFORM_AND_BROWSER){
                case "win_chrome":
                    driver = new ChromeDriver();
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    break;
                default:
                    Assert.fail("INCORRECT SETTED PLATFORM OR BROWSER NAME" + PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }
}
