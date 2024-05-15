package tests.elementsPageTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest.BaseTest;

public class ElementsPageCheckBox extends BaseTest {
    @Test
    public void checkIfCheckBoxAreClicked(){
        String expectedResult = "Check Box";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickCheckBoxButton();

        String actualResult = driver.findElement(textBoxText).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkIfCheckBoxAreSelected(){
        String expectedResult = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
        elementsPage.clickCheckBoxButton()
                .clickHomeCheckBox();

        String actualResult = driver.findElement(checkBoxSelectedHome).getText();
        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
