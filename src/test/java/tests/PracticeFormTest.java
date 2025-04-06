package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnFormsMenu();
        indexPage.enterOnPracticeFormSubMenu();

        String firstNameValue = "Andreea";
        String lastNameValue = "Suteu";
        String emailValue = "andreea@gmail.com";
        String genderValue = "Female";
        String mobilePhoneValue = "0745645112";
        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        subjects.add("Chemistry");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");
        String pathValue = "52522714_265257021074795_1332014764607406080_n.jpg";
        String addressValue = "strada libertatii";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";
        String expectedMessage = "Thanks for submitting the form";


        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillFirstName(firstNameValue);
        practiceFormPage.fillLastName(lastNameValue);
        practiceFormPage.fillEmail(emailValue);
        practiceFormPage.fillGender(genderValue);
        practiceFormPage.fillMobilePhone(mobilePhoneValue);
        practiceFormPage.fillSubjects(subjects);
        practiceFormPage.fillHobbies(hobbies);
        practiceFormPage.pictureUpload(pathValue);
        practiceFormPage.fillAddress(addressValue);
        practiceFormPage.fillState(stateInputValue);
        practiceFormPage.fillCity(cityInputValue);
        practiceFormPage.sumbitClick();
        practiceFormPage.ValidateThankYouMessage(expectedMessage);
        practiceFormPage.validateEntireTable(firstNameValue, lastNameValue, emailValue, genderValue, mobilePhoneValue, addressValue,
                stateInputValue, cityInputValue);


//        By pictureElement = By.id("uploadPicture");
//        File file = new File("52522714_265257021074795_1332014764607406080_n.jpg");
//        elementHelper.fillLocator(pictureElement, file.getAbsolutePath());


    }
}