package tests.elementsPageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest.BaseTest;

public class ElementsWebTables extends BaseTest {

    @Test
    public void checkIfWebTablesAreClicked(){
        String expectedResult = "Web Tables";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickWebTablesButton();

        String actualResult = driver.findElement(textBoxText).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfFiveRowsAreDisplayed(){
        int expectedResult = 5;
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickWebTablesButton()
                .clickToDisplayFiveRows();

        int actualResult = elementsPage.checkDisplayedRows();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfModalWindowAreDisplayed(){
        String expectedResult = "Registration Form";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickWebTablesButton()
                .clickAddButton();

        String actualResult = driver.findElement(modalText).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
