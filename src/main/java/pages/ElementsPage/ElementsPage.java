package pages.ElementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ElementsPage extends BasePage {

    BasePage basePage = new BasePage(driver);


    By textBoxButton = By.xpath("//ul[@class='menu-list']//span[text()='Text Box']");

    By fullNameTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='userName']");
    By emailTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='userEmail']");
    By currentAddressTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='currentAddress']");
    By permanentAddressTextBox = By.xpath("//div[@class='col-md-9 col-sm-12']//*[@id='permanentAddress']");
    By submitButton = By.xpath("//div[@class='mt-2 justify-content-end row']//div[@class='text-right col-md-2 col-sm-12']//button[@class='btn btn-primary']");

    //

    By checkBoxButton = By.xpath("//ul[@class='menu-list']//span[text()='Check Box']");

    By checkBoxHome = By.xpath("//span[@class='rct-checkbox']");

    //

    By radioButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']");
    By radioButtonYes = By.xpath("//label[@for='yesRadio']");
    By radioButtonImpressive = By.xpath("//label[@for='impressiveRadio']");
    By radioButtonNo = By.xpath("//label[@for='noRadio']");

    //

    By webTablesButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']");

    By displayFiveRows = By.xpath("//span[@class='select-wrap -pageSizeOptions']//select[@aria-label='rows per page']//option[@value='5']");

    By rows = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']");

    By addButton = By.xpath("//button[@id='addNewRecordButton']");

    By modalWindow = By.xpath("//div[@class='modal-content']");

    By modalWindowFirstName = By.xpath("//form[@id='userForm']//div[@id='firstName-wrapper']//input[@class=' mr-sm-2 form-control']");
    By modalWindowLastName = By.xpath("//form[@id='userForm']//div[@id='lastName-wrapper']//input[@class=' mr-sm-2 form-control']");
    By modalWindowEmail = By.xpath("//form[@id='userForm']//div[@id='userEmail-wrapper']//input[@class='mr-sm-2 form-control']");
    By modalWindowAge = By.xpath("//form[@id='userForm']//div[@id='age-wrapper']//input[@class=' mr-sm-2 form-control']");
    By modalWindowSalary = By.xpath("//form[@id='userForm']//div[@id='salary-wrapper']//input[@class=' mr-sm-2 form-control']");
    By modalWindowDepartment = By.xpath("//form[@id='userForm']//div[@id='department-wrapper']//input[@class=' mr-sm-2 form-control']");
    By modalWindowSubmitButton = By.xpath("//div[@class='text-right col-md-2 col-sm-12']//button[@class='btn btn-primary']");

    By modalWindowRows = By.xpath("//div[@class='rt-table']//div[@class='rt-tr-group']//div[@class='rt-td']");

    By textBoxFind = By.xpath("//div[@class='mb-3 input-group']//input[@type='text']");

    By searchButton = By.xpath("//div[@class='input-group-append']");


    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickTextBoxButton() {
        driver.findElement(textBoxButton).click();
        return this;
    }

    public ElementsPage fillTextBoxesWithData(String fullName, String email, String currentAddress, String permanentAddress) {
        driver.findElement(fullNameTextBox).sendKeys(fullName);
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(currentAddressTextBox).sendKeys(currentAddress);
        driver.findElement(permanentAddressTextBox).sendKeys(permanentAddress);
        return this;
    }

    public ElementsPage submitButton() {
        driver.findElement(submitButton).click();
        return this;
    }

    public ElementsPage clickCheckBoxButton() {
        driver.findElement(checkBoxButton).click();
        return this;
    }

    public ElementsPage clickHomeCheckBox() {
        driver.findElement(checkBoxHome).click();
        return this;
    }

    public ElementsPage clickRadioButton() {
        driver.findElement(radioButton).click();
        return this;
    }

    public ElementsPage clickYesRadioButton() {
        WebElement radioButtonYesClick = driver.findElement(radioButtonYes);

        basePage.waitElementIsVisible(radioButtonYesClick);


        if (!radioButtonYesClick.isSelected()) {
            radioButtonYesClick.click();
        }
        return this;
    }

    public ElementsPage clickImpressiveRadioButton() {
        WebElement radioButtonImpressiveClick = driver.findElement(radioButtonImpressive);

        basePage.waitElementIsVisible(radioButtonImpressiveClick);
        if (!radioButtonImpressiveClick.isSelected()) {
            radioButtonImpressiveClick.click();
        }
        return this;
    }

    public boolean clickNoRadioButton() {
        WebElement radioButtonNoClick = driver.findElement(radioButtonNo);

        basePage.waitElementIsVisible(radioButtonNoClick);
        if (!radioButtonNoClick.isSelected()) {
            radioButtonNoClick.click();
            return false;
        }
        return true;
    }

    public ElementsPage clickWebTablesButton() {
        driver.findElement(webTablesButton).click();
        return this;
    }

    public ElementsPage clickToDisplayFiveRows() {
        WebElement displayFive = driver.findElement(displayFiveRows);
        basePage.waitElementIsVisible(displayFive);

        displayFive.click();
        return this;
    }

    public int checkDisplayedRows() {
        List<WebElement> listRows = driver.findElements(rows);
        int count = 0;
        for (WebElement row : listRows) {
            count++;
        }
        return count;
    }

    public ElementsPage clickAddButton() {
        driver.findElement(addButton).click();
        WebElement modalWindowElement = driver.findElement(modalWindow);
        basePage.waitElementIsVisible(modalWindowElement);

        driver.switchTo().activeElement();
        return this;
    }

    public ElementsPage fillTextBoxesWebTables(String firstName, String lastName, String email, String age, String salary, String department) {
        ArrayList<WebElement> arrayList = new ArrayList<WebElement>();
        WebElement firstNameElement = driver.findElement(modalWindowFirstName);
        WebElement lastNameElement = driver.findElement(modalWindowLastName);
        WebElement emailElement = driver.findElement(modalWindowEmail);
        WebElement ageElement = driver.findElement(modalWindowAge);
        WebElement salaryElement = driver.findElement(modalWindowSalary);
        WebElement departmentElement = driver.findElement(modalWindowDepartment);

        arrayList.add(firstNameElement);
        arrayList.add(lastNameElement);
        arrayList.add(emailElement);
        arrayList.add(ageElement);
        arrayList.add(salaryElement);
        arrayList.add(departmentElement);

//        basePage.waitElementIsVisible(arrayList.get(0));
//        basePage.waitElementIsVisible(arrayList.get(1));
//        basePage.waitElementIsVisible(arrayList.get(2));
//        basePage.waitElementIsVisible(arrayList.get(3));
//        basePage.waitElementIsVisible(arrayList.get(4));
//        basePage.waitElementIsVisible(arrayList.get(5));

        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        ageElement.sendKeys(age);
        emailElement.sendKeys(email);
        ageElement.sendKeys(age);
        salaryElement.sendKeys(salary);
        departmentElement.sendKeys(department);
        return this;
    }

    public ElementsPage clickSubmitButton() {
        driver.findElement(modalWindowSubmitButton).click();
        return this;
    }

    public boolean checkIfEntityIsAdded(String firstName, String lastName, String email, String age, String salary, String department) {
        List<WebElement> webElementList = driver.findElements(modalWindowRows);
        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().contains(firstName)
                    &&
                    webElementList.get(i + 1).getText().contains(lastName) &&
                    webElementList.get(i + 2).getText().contains(age) &&
                    webElementList.get(i + 3).getText().contains(email) &&
                    webElementList.get(i + 4).getText().contains(salary) &&
                    webElementList.get(i + 5).getText().contains(department)
            ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfDisplayedAfterSearch(String searchText){
        List<WebElement> webElementList = driver.findElements(modalWindowRows);
        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().contains(searchText)
            ) {
                return true;
            }
        }
        return false;
    }
}
