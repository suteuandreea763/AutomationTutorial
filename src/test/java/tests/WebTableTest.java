package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);

//        //deschidem un browser
//        driver = new ChromeDriver();
//
//        //accesam o pagina Web
//        driver.get("https://demoqa.com");
//
//        //facem browserul in modul maximaze
//        driver.manage().window().maximize();
//
//        JavascriptExecutor executor = (JavascriptExecutor) driver;


        By elementsMenu = By.xpath("//h5[text()='Elements']");
        elementHelper.clickJSLocator(elementsMenu);

        By webTablesSubMenu = By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJSLocator(webTablesSubMenu);

        By tablesRowListElement = By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']");
        List<WebElement> tablesRowList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowList.size(), 3, "Valoarea initiala a tabelului nu este 3");


        //indentificam un element
        By addElement = By.id("addNewRecordButton");
        elementHelper.clickJSLocator(addElement);

        //JavascriptExecutor folosit pentru erori click intercepted (reclame)
        //nu trebuie abuzat de acest lucru, deoarece el forteaza lucrurile

        By firstNameElement = By.id("firstName");
        String firstNameValue = "Razvan";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.id("lastName");
        String lastNameValue = "Gherasa";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By userEmailElement = By.id("userEmail");
        String userEmailValue = "razvan@gmail.com";
        elementHelper.fillLocator(userEmailElement, userEmailValue);

        By ageElement = By.id("age");
        String ageValue = "25";
        elementHelper.fillLocator(ageElement, ageValue);

        By salaryElement = By.id("salary");
        String salaryValue = "3000";
        elementHelper.fillLocator(salaryElement, salaryValue);

        By departmentElement = By.id("department");
        String departmentValue = "it";
        elementHelper.fillLocator(departmentElement, departmentValue);

        By submitElement = By.id("submit");
        elementHelper.clickJSLocator(submitElement);

        tablesRowList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowList.size(), 4, "Valoarea actuala a tabelului nu este 4");
        elementHelper.validateTextContainsElement(tablesRowList.get(3),firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),lastNameValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),userEmailValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),ageValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),salaryValue);
        elementHelper.validateTextContainsElement(tablesRowList.get(3),departmentValue);


        //edit functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickJSLocator(editElement);

        By editFirstNameElement = By.id("firstName");
        String editFirstNameValue = "Andrei";
        elementHelper.clearFilledLocator(editFirstNameElement, editFirstNameValue);

        By editLastNameElement = By.id("lastName");
        String editLastNameValue = "Mihai";
        elementHelper.clearFilledLocator(editLastNameElement, editLastNameValue);

        By editUserEmailElement = By.id("userEmail");
        String editUserEmailValue = "amihai@gmail.com";
        elementHelper.clearFilledLocator(editUserEmailElement, editUserEmailValue);

        By editAgeElement = By.id("age");
        String editAgeValue = "30";
        elementHelper.clearFilledLocator(editAgeElement, editAgeValue);

        By editSalaryElement = By.id("salary");
        String editSalaryValue = "9000";
        elementHelper.clearFilledLocator(editSalaryElement, editSalaryValue);

        By editDepartmentElement = By.id("department");
        String editDepartmentValue = "Marketing";
        elementHelper.clearFilledLocator(editDepartmentElement, editDepartmentValue);

        By resubmitElement = By.id("submit");
        elementHelper.clickJSLocator(resubmitElement);

        By deleteElement=By.id("delete-record-4");
        elementHelper.clickJSLocator(deleteElement);

        tablesRowList = driver.findElements(tablesRowListElement);
        Assert.assertEquals(tablesRowList.size(), 3, "Valoarea actuala a tabelului nu este 4.");

    }
}