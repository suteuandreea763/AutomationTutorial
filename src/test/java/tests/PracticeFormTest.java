package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest () {

        ElementHelper elementHelper=new ElementHelper(driver);
       // JavascriptExecutor executor = (JavascriptExecutor) driver;

        PageHelper pageHelper=new PageHelper(driver);

        By formsMenu=By.xpath("//h5[text()='Forms']");
        elementHelper.clickJsLocator(formsMenu);

        By practiceFormSubMenu=By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJsLocator(practiceFormSubMenu);

        By firstNameElement=By.xpath("//input[@placeholder='First Name']");
        String firstNameValue="Andreea";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        WebElement lastNameElement=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue="Carmen";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement=driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        String emailValue="suteuandreea@yahoo.ro";
        emailElement.sendKeys(emailValue);

        String genderValue="Female";
        List<WebElement> genderOptionsList=driver.findElements(By.xpath("//input[@name='gender']"));
        if (genderValue.equals("Male")){
           executor.executeScript("arguments[0].click();",genderOptionsList.get(0) );
        }

        if (genderValue.equals("Female")) {
            executor.executeScript("arguments[0].click();",genderOptionsList.get(1) );
        }

        if (genderValue.equals("Other")) {
            executor.executeScript("arguments[0].click();",genderOptionsList.get(2) );
        }

       WebElement mobilePhoneElement= driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        String mobilePhoneValue="0766345673";
        mobilePhoneElement.sendKeys(mobilePhoneValue);
        pageHelper.scrollByPixel(0,500);


        By subjectsElement=By.id("subjectsInput");
        elementHelper.clickJsLocator(subjectsElement);


        //lista de string-uri si sa adaug elementele pe care vreau sa le selectez
        //trebuie sa parcurg lista pe care am facut-o cu un for
        //in interiorul for-ului trebuie sa completez pe rand fiecare valoare in subjectsElement si apoi sa apas un enter
        List<String> subjects=new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");


        for (int index=0; index<subjects.size(); index++){
            //subjectsElement.sendKeys(subjects.get(index));
           // subjectsElement.sendKeys(Keys.ENTER);
            elementHelper.fillPressLocator(subjectsElement,subjects.get(index),Keys.ENTER);
        }

        List<String> hobbies=new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");


        List<WebElement> hobbiesOptionsList=driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index=0; index<hobbiesOptionsList.size(); index++){
           String currentText= hobbiesOptionsList.get(index).getText();
           if (hobbies.contains(currentText)){
               hobbiesOptionsList.get(index).click();
           }
        }

        By pictureElement=By.id("uploadPicture");
        File file = new File("src/test/resources/52522714_265257021074795_1332014764607406080_n.jpg");
       elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By CurrentAddressElement=By.id("currentAddress");
        String CurrentAddressValue="Hunedoara,Hunedoara";
        elementHelper.fillLocator(CurrentAddressElement,CurrentAddressValue);

        By StateElement=By.xpath("//div[text()='Select State']");
        //executor.executeScript("arguments[0].click();", StateElement);
        elementHelper.clickJsLocator(StateElement);

        By StateInputElement=By.id("react-select-3-input");
        String StateValue="NCR";
        //StateInputElement.sendKeys(StateValue);
       // StateInputElement.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(StateInputElement,StateValue,Keys.ENTER);

        By CityElement=By.xpath("//div[text()='Select City']");
        //executor.executeScript("arguments[0].click();", CityElement);
        elementHelper.clickJsLocator(CityElement);

        By CityInputElement=By.id("react-select-4-input");
        String CityValue="Delhi";
        //CityInputElement.sendKeys(CityValue);
        //CityInputElement.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(CityInputElement,CityValue,Keys.ENTER);

        By SubmitButtonElement=By.id("submit");
        //SubmitButtonElement.click();
        //clickJSLocator se foloseste unde sunt reclame
        elementHelper.clickLocator(SubmitButtonElement);

        WebElement ThankYouElement= driver.findElement(By.id("example-modal-sizes-title-lg"));
        String expectedMessage="Thanks for submitting the form";
        String actualMessage= ThankYouElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        List<WebElement> TableRowsList=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(TableRowsList.get(0).getText().contains("Student Name"));
        Assert.assertTrue(TableRowsList.get(0).getText().contains(firstNameValue));
        Assert.assertTrue(TableRowsList.get(0).getText().contains(lastNameValue));

        Assert.assertTrue(TableRowsList.get(1).getText().contains("Student Email"));
        Assert.assertTrue(TableRowsList.get(1).getText().contains(emailValue));

        Assert.assertTrue(TableRowsList.get(2).getText().contains("Gender"));
        Assert.assertTrue(TableRowsList.get(2).getText().contains(genderValue));

        String subjectStringValue = String.join(", ", subjects);
        Assert.assertTrue(TableRowsList.get(5).getText().contains("Subjects"));
        Assert.assertTrue(TableRowsList.get(5).getText().contains(subjectStringValue));

        String hobbiesStringValue = String.join(", ", hobbies);
        Assert.assertTrue(TableRowsList.get(6).getText().contains("Hobbies"));
        Assert.assertTrue(TableRowsList.get(6).getText().contains(hobbiesStringValue));

        Assert.assertTrue(TableRowsList.get(8).getText().contains("Address"));
        Assert.assertTrue(TableRowsList.get(8).getText().contains(CurrentAddressValue));

        Assert.assertTrue(TableRowsList.get(3).getText().contains("Mobile"));
        Assert.assertTrue(TableRowsList.get(3).getText().contains(mobilePhoneValue));

        Assert.assertTrue(TableRowsList.get(7).getText().contains("Picture"));
        Assert.assertTrue(TableRowsList.get(7).getText().contains("52522714_265257021074795_1332014764607406080_n.jpg"));

        List<WebElement> RowsList=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(TableRowsList.get(9).getText().contains("State and City"));
        Assert.assertTrue(TableRowsList.get(9).getText().contains(StateValue));
        Assert.assertTrue(TableRowsList.get(9).getText().contains(CityValue));

        





    }
}
