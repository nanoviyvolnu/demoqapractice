package ui.tests.elementsPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.tests.BaseTest.BaseTest;

public class ElementsPageTextBox extends BaseTest {


    @Test
    public void checkIfTextBoxAreClicked(){
        String expectedResult = "Text Box";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickTextBoxButton();

        String actualResult = driver.findElement(textBoxText).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void fillTextBoxes() {
        By resultName = By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='name']");
        By resultEmail = By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='email']");
        By resultAddress = By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='currentAddress']");
        By resultPermanentAddress = By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='permanentAddress']");


        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickTextBoxButton();

        String fullName = "Constantin";
        String email = "user@gmail.com";
        String currentAddress = "adr1";
        String permanentAddress = "permaddr1";

        elementsPage.fillTextBoxesWithData(fullName, email, currentAddress, permanentAddress);

        elementsPage.submitButton();

        WebElement actualresultName = driver.findElement(resultName);
        WebElement actualresultEmail = driver.findElement(resultEmail);
        WebElement actualresultAddress = driver.findElement(resultAddress);
        WebElement actualresultPermanentAddress = driver.findElement(resultPermanentAddress);

        // Wait until each element is visible
        basePage.waitElementIsVisible(actualresultName);
        basePage.waitElementIsVisible(actualresultEmail);
        basePage.waitElementIsVisible(actualresultAddress);
        basePage.waitElementIsVisible(actualresultPermanentAddress);

        // Get the text content of each element
        String nameText = actualresultName.getText();
        String emailText = actualresultEmail.getText();
        String addressText = actualresultAddress.getText();
        String permanentAddressText = actualresultPermanentAddress.getText();

        // Delete all text up to ":" for each text content
        nameText = nameText.substring(nameText.indexOf(":") + 1).trim();
        emailText = emailText.substring(emailText.indexOf(":") + 1).trim();
        addressText = addressText.substring(addressText.indexOf(":") + 1).trim();
        permanentAddressText = permanentAddressText.substring(permanentAddressText.indexOf(":") + 1).trim();

        // Perform assertions
        Assert.assertEquals(nameText, fullName);
        Assert.assertEquals(emailText, email);
        Assert.assertEquals(addressText, currentAddress);
        Assert.assertEquals(permanentAddressText, permanentAddress);
    }
}
