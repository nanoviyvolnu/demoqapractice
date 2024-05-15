package pages.DemoQAMainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MainPage extends BasePage {

    By elementsButton = By.xpath("//div[@class='card-up']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickElementsButton(){
        driver.findElement(elementsButton).click();
        return this;
    }
}
