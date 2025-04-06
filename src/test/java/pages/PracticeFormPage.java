package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static pageLocators.PracticeFormLocators.*;

public class PracticeFormPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementHelper= new ElementHelper(driver);
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementHelper.fillLocator(lastNameElement, lastNameValue);
    }

    public void fillEmail(String emailValue){
        elementHelper.fillLocator(emailElement, emailValue);
    }

    public void fillGender(String genderValue){
        List<WebElement> genderOptionsList = driver.findElements(genderOptionsElement);
        if (genderValue.equals("Male")) {
            elementHelper.clickJSLocator(genderOptionsList.get(0));
        }
        if (genderValue.equals("Female")) {
            elementHelper.clickJSLocator(genderOptionsList.get(1));
        }
        if (genderValue.equals("Other")) {
            elementHelper.clickJSLocator(genderOptionsList.get(2));
        }
    }

    public void fillMobilePhone(String mobilePhoneValue){
        elementHelper.fillLocator(mobilePhoneElement, mobilePhoneValue);
    }

    public void fillSubjects(List<String>subjects){
        elementHelper.clickJSLocator(subjectsElement);
        for (int index = 0; index < subjects.size(); index++) {
            elementHelper.fillPressLocator(subjectsElement, subjects.get(index), Keys.ENTER);
        }
    }

    public void fillHobbies(List<String>hobbies){
        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbies.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbies.contains(currentText)) {
                elementHelper.clickJSLocator(hobbiesOptionsList.get(index));
            }
        }
    }


    public void pictureUpload (String path){
        File file = new File("path");
        elementHelper.fillLocator(pictureElement, file.getAbsolutePath());
    }

    public void fillAddress(String addressValue){
        elementHelper.fillLocator(addressElement, addressValue);
    }

    public void fillState(String stateValue){
        elementHelper.clickJSLocator(stateElement);
          elementHelper.fillPressLocator(stateInputElement, stateValue, Keys.ENTER);
    }

    public void fillCity(String cityValue){
        elementHelper.clickJSLocator(cityElement);
        elementHelper.fillPressLocator(cityInputElement, cityValue, Keys.ENTER);
    }

    public void sumbitClick(){
         elementHelper.clickJSLocator(submitElement);
    }

    public void ValidateThankYouMessage(String expectedMessage){
        elementHelper.validateTextLocator(thankyouElement, expectedMessage);
       System.out.println("Testul a fost validat");
    }

    public void validateEntireTable(String firstNameValue,String lastNameValue, String
                                    emailValue,String genderValue, String mobilePhoneValue,
                                    String addressValue,String stateInputValue,String cityInputValue){
        List<WebElement> tablesRowsList = driver.findElements(tablesRowsListElement);
        elementHelper.validateTextContainsElement(tablesRowsList.get(0), "Student Name");
        elementHelper.validateTextContainsElement(tablesRowsList.get(0), firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(0),lastNameValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(1),"Student Email");
        elementHelper.validateTextContainsElement(tablesRowsList.get(1), emailValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(2),"Gender");
        elementHelper.validateTextContainsElement(tablesRowsList.get(2), genderValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(3),"Mobile");
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), mobilePhoneValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Subjects");
        elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Maths");
        elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Arts");
        elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Biology");
        elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Chemistry");

        elementHelper.validateTextContainsElement(tablesRowsList.get(6),"Hobbies");
        elementHelper.validateTextContainsElement(tablesRowsList.get(6),"Sports");
        elementHelper.validateTextContainsElement(tablesRowsList.get(6),"Reading");

        elementHelper.validateTextContainsElement(tablesRowsList.get(7),"Picture");
        elementHelper.validateTextContainsElement(tablesRowsList.get(7),"52522714_265257021074795_1332014764607406080_n.jpg");

        elementHelper.validateTextContainsElement(tablesRowsList.get(8),"Address");
        elementHelper.validateTextContainsElement(tablesRowsList.get(8), addressValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(9),"State and City");
        elementHelper.validateTextContainsElement(tablesRowsList.get(9), stateInputValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(9), cityInputValue);
    }



}
