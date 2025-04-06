package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePages;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {


    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnElementsMenu();
        indexPage.enterOnWebTablesSubMenu();

        WebTablePages webTablesPage = new WebTablePages(driver);
        webTablesPage.verifyTableContent(3);

        webTablesPage.addNewRecordButtonClick();

        String firstNameValue = "Andreea";
        String lastNameValue = "Suteu";
        String userEmailValue = "adr@gmail.com";
        String ageValue = "24";
        String salaryValue = "3500";
        String departmentValue = "it";
        int expectedSize = 4;

        webTablesPage.fillFirstName(firstNameValue);
        webTablesPage.fillLastName(lastNameValue);
        webTablesPage.fillUserEmail(userEmailValue);
        webTablesPage.fillAge(ageValue);
        webTablesPage.fillSalary(salaryValue);
        webTablesPage.fillDepartment(departmentValue);
        webTablesPage.submitClick();

        webTablesPage.verifyTableContent(expectedSize);

        webTablesPage.editClick();

        String firstNameValueEdit = "Adr";
        String lastNameValueEdit = "Ssd";
        String userEmailValueEdit = "ddee@gmail.com";
        String ageValueEdit = "66";
        String salaryValueEdit = "3080";
        String departmentValueEdit = "ijjt";
        int expectedSizeEdit = 4;

        webTablesPage.verifyTableContent(expectedSizeEdit);
        webTablesPage.fillFirstName(firstNameValueEdit);
        webTablesPage.fillLastName(lastNameValueEdit);
        webTablesPage.fillUserEmail(userEmailValueEdit);
        webTablesPage.fillAge(ageValueEdit);
        webTablesPage.fillSalary(salaryValueEdit);
        webTablesPage.fillDepartment(departmentValueEdit);
        webTablesPage.submitClick();

        webTablesPage.deleteRecords();
        webTablesPage.verifyTableContent(3);

    }
}
