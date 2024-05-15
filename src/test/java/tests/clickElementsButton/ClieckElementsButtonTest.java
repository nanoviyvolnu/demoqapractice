package tests.clickElementsButton;

import org.testng.annotations.Test;
import pages.base.BasePage;
import tests.BaseTest.BaseTest;

public class ClieckElementsButtonTest extends BaseTest {

    @Test
    public void checkIfElementsButtonAreClicked(){
        basePage.open("https://demoqa.com/");
        mainPage.clickElementsButton();
    }
}
