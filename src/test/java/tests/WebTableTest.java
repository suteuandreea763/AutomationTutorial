package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {


    @Test
    public void metodaTest () {

        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        ElementHelper elementHelper=new ElementHelper(driver);


        By elementsMenu=By.xpath("//h5[text()='Elements']");
        //executor.executeScript("arguments[0].click();", elementsMenu);
        elementHelper.clickJsLocator(elementsMenu);

        By webTableSubMenu=By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJsLocator(webTableSubMenu);


        List<WebElement> tablesRowsList= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tablesRowsList.size(),3,"valoarea initiala a tebelului nu este 3");



        //identificam un element
        By addElement = By.id("addNewRecordButton");
        //executor.executeScript("arguments[0].click();", addElement);
        elementHelper.clickJsLocator(addElement);


        By firstNameElement = By.id("firstName");
        String firstNameValue = "Suteu";
        //firstNameElement.sendKeys(firstNameValue);
        elementHelper.fillPressLocator(firstNameElement,firstNameValue, Keys.ENTER);


        By lastNameElement = By.id("lastName");
        String lastNameValue = "Andreea";
        //lastNameElement.sendKeys(lastNameValue);
        elementHelper.fillPressLocator(lastNameElement,lastNameValue, Keys.ENTER);


        By userEmailElement = By.id("userEmail");
        String userEmailValue = "suteuandreea763@yahoo.ro";
       // userEmailElement.sendKeys(userEmailValue);
        elementHelper.fillPressLocator(userEmailElement,userEmailValue, Keys.ENTER);


        By ageElement = By.id("age");
        String ageValue = "24";
        //ageElement.sendKeys(ageValue);
        elementHelper.fillPressLocator(ageElement,ageValue, Keys.ENTER);


        //WebElement salaryElement = driver.findElement(By.id("salary"));
        By salaryElement =By.id("salary");
        String salaryValue = "10000";
       // salaryElement.sendKeys(salaryValue);
        elementHelper.fillPressLocator(salaryElement,salaryValue, Keys.ENTER);


        By departmentElement =By.id("department");
        String departmentValue = "qa";
        //departmentElement.sendKeys(departmentValue);
        elementHelper.fillPressLocator(departmentElement,departmentValue, Keys.ENTER);


        By submitElement = By.id("submit");
        //executor.executeScript("arguments [0].click();", submitElement);
        elementHelper.clickJsLocator(submitElement);


         tablesRowsList= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tablesRowsList.size(),4,"valoarea actuala a tebelului nu este 4");
        String expectedRow= tablesRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(userEmailValue));
        Assert.assertTrue(expectedRow.contains(salaryValue));
        Assert.assertTrue(expectedRow.contains(departmentValue));

        //edit functionality
       // WebElement editElement = driver.findElement(By.id("edit-record-4"));
        By editElement = By.id("edit-record-4");
        //executor.executeScript("arguments[0].click();", editElement);
        elementHelper.clickJsLocator(editElement);

        By editFirstNameElement = By.id("firstName");
        String editFirstNameValue = "Popescu";
        //editFirstNameElement.clear();
       // editFirstNameElement.sendKeys(editFirstNameValue);
        elementHelper.fillPressLocator(editFirstNameElement,editFirstNameValue, Keys.ENTER);


        By editlastNameElement = By.id("lastName");
        String editlastNameValue = "Ion";
//        editlastNameElement.clear();
//        editlastNameElement.sendKeys(editlastNameValue);
        elementHelper.fillPressLocator(editlastNameElement,editlastNameValue, Keys.ENTER);

        By edituserEmailElement = By.id("userEmail");
        String edituserEmailValue = "ion12@yahoo.ro";
//        edituserEmailElement.clear();
//        edituserEmailElement.sendKeys(edituserEmailValue);
        elementHelper.fillPressLocator(edituserEmailElement,edituserEmailValue, Keys.ENTER);

        By editageElement = By.id("age");
        String editageValue = "19";
//        editageElement.clear();
//        editageElement.sendKeys(editageValue);
        elementHelper.fillPressLocator(editageElement,editageValue, Keys.ENTER);

        By editsalaryElement = By.id("salary");
        String editsalaryValue = "9000";
//        editsalaryElement.clear();
//        editsalaryElement.sendKeys(editsalaryValue);
        elementHelper.fillPressLocator(editsalaryElement,editsalaryValue, Keys.ENTER);

        By editdepartmentElement = By.id("department");
        String editdepartmentValue = "it";
//        editdepartmentElement.clear();
//        editdepartmentElement.sendKeys(editdepartmentValue);
        elementHelper.fillPressLocator(editdepartmentElement,editdepartmentValue, Keys.ENTER);


        By submitEditedElement = By.id("submit");
       // executor.executeScript("arguments[0].click();", submitEditedElement);
        elementHelper.clickJsLocator(submitEditedElement);

        tablesRowsList= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tablesRowsList.size(),4,"valoarea actuala a tebelului nu este 4");
        expectedRow= tablesRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(editFirstNameValue));
        Assert.assertTrue(expectedRow.contains(editlastNameValue));
        Assert.assertTrue(expectedRow.contains(editageValue));
        Assert.assertTrue(expectedRow.contains(edituserEmailValue));
        Assert.assertTrue(expectedRow.contains(editsalaryValue));
        Assert.assertTrue(expectedRow.contains(editdepartmentValue));


        tablesRowsList= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tablesRowsList.size(),4,"valoarea actuala a tebelului nu este 4");





    }
}
