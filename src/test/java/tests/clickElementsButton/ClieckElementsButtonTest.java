package tests.clickElementsButton;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest.BaseTest;

public class ClieckElementsButtonTest extends BaseTest {

    @Test
    public void checkIfElementsButtonAreClicked(){
        String expectedResult = "https://demoqa.com/elements";
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();

        Assert.assertEquals("https://demoqa.com/elements", expectedResult);
    }
}
