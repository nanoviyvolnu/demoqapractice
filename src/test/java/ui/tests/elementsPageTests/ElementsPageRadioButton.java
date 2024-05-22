package ui.tests.elementsPageTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.tests.BaseTest.BaseTest;

public class ElementsPageRadioButton extends BaseTest {


    By textMessageYes = By.xpath("//p[@class='mt-3']//span[text()='Yes']");

    By textMessageImpressive = By.xpath("//p[@class='mt-3']//span[text()='Impressive']");

    @Test
    public void checkIfRadioButtonAreClicked(){
        String expectedResult = "Radio Button";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickRadioButton();

        String actualResult = driver.findElement(textBoxText).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void checkIfYesRadioButtonAreSelected(){
        String expectedResult = "Yes";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickRadioButton();
        elementsPage.clickYesRadioButton();

        String actualResult = driver.findElement(textMessageYes).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfImpressiveRadioButtonAreSelected(){
        String expectedResult = "Impressive";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickRadioButton()
                .clickImpressiveRadioButton();

        String actualResult = driver.findElement(textMessageImpressive).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfNoRadioButtonAreSelected(){
        boolean expectedResult = false;
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickRadioButton()
                .clickImpressiveRadioButton();

        boolean actualResult = elementsPage.clickNoRadioButton();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
