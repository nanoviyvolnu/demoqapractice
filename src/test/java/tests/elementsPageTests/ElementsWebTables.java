package tests.elementsPageTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest.BaseTest;

import java.util.ArrayList;

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

    @Test
    public void checkIfTextBoxesAreFilled(){
        String firstName = "Constantin";
        String lastName = "Balaban";
        String email = "constantinbalaban003@gmail.com";
        String age = "21";
        String salary = "1000000";
        String department = "QA";

        boolean expectedResult = true;

        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickWebTablesButton()
                .clickAddButton()
                .fillTextBoxesWebTables(firstName,lastName,email,age,salary,department)
                .clickSubmitButton()
                .checkIfEntityIsAdded(firstName, lastName, email, age, salary, department);


        boolean actualResult = elementsPage.checkIfEntityIsAdded(firstName, lastName, email, age, salary, department);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfRowHasSearched(){
        String searchText = "kierra@example.com";

        boolean expectedResult = true;

        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickWebTablesButton()
                .checkIfDisplayedAfterSearch(searchText);

        boolean actualResult = elementsPage.checkIfDisplayedAfterSearch(searchText);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
