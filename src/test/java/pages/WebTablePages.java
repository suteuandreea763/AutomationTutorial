package pages;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTableLocators;

import java.util.List;

import static pageLocators.PracticeFormLocators.tablesRowsListElement;
import static pageLocators.WebTableLocators.*;

public class WebTablePages {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public WebTablePages(WebDriver driver){
        this.driver= driver;
        elementHelper=new ElementHelper(driver);
    }

    public void verifyTableContent( int expectedTablesRowListElement){
        elementHelper.waitForElementsVisible(tablesRowListElement);
        List<WebElement> tablesRowsList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowsList.size(), expectedTablesRowListElement, "Valoarea initiala a tabelului nu este 3");
    }

    public void addNewRecordButtonClick() {
        elementHelper.clickJSLocator(addElement);
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementHelper.fillLocator(lastNameElement, lastNameValue);
    }

    public void fillUserEmail(String userEmailValue){
        elementHelper.fillLocator(userEmailElement, userEmailValue);
    }

    public void fillAge(String ageValue){
        elementHelper.fillLocator(ageElement, ageValue);
    }

    public void fillSalary(String salaryValue){
        elementHelper.fillLocator(salaryElement, salaryValue);
    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillLocator(departmentElement, departmentValue);
    }

    public void submitClick(){
        elementHelper.clickJSLocator(submitElement);
    }

    public void verifyTableContent(int expectedSize, String firstNameValue, String lastNameValue, String userEmailValue,
                                   String ageValue, String salaryValue, String departmentValue){
        List<WebElement> tablesRowList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowList.size(), 4, "Valoarea actuala a tabelului nu este 4");
        elementHelper.validateTextContainsElement(tablesRowList.get(3),firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),lastNameValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),userEmailValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),ageValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),salaryValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),departmentValue);
    }

    public void deleteRecords(){
        elementHelper.clickJSLocator(deleteElement);
    }

    public void editClick(){
        elementHelper.clickJSLocator(editElement);
    }
}
