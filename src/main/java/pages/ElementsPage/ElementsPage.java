package pages.ElementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ElementsPage extends BasePage {


    By textBoxButton = By.xpath("//ul[@class='menu-list']//span[text()='Text Box']");

    By fullNameTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='userName']");
    By emailTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='userEmail']");
    By currentAddressTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='currentAddress']");
    By permanentAddressTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='permanentAddress']");
    By submitButton = By.xpath("//div[@class='mt-2 justify-content-end row']//div[@class='text-right col-md-2 col-sm-12']//button[@class='btn btn-primary']");

    //

    By checkBoxButton = By.xpath("//ul[@class='menu-list']//span[text()='Check Box']");

    By checkBoxHome = By.xpath("//span[@class='rct-checkbox']");


    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickTextBoxButton(){
        driver.findElement(textBoxButton).click();
        return this;
    }

    public ElementsPage fillTextBoxesWithData(String fullName, String email, String currentAddress, String permanentAddress){
        driver.findElement(fullNameTextBox).sendKeys(fullName);
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(currentAddressTextBox).sendKeys(currentAddress);
        driver.findElement(permanentAddressTextBox).sendKeys(permanentAddress);
        return this;
    }

    public ElementsPage submitButton(){
        driver.findElement(submitButton).click();
        return this;
    }

    public ElementsPage clickCheckBoxButton(){
        driver.findElement(checkBoxButton).click();
        return this;
    }

    public ElementsPage clickHomeCheckBox(){
        driver.findElement(checkBoxHome).click();
        return this;
    }
}
