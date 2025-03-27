package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

import static pageLocators.IndexLocators.alertsFrameWindowsMenu;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;


    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void enterOnAlertFrameWindowMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsFrameWindowsMenu);
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsSubMenu);
    }
}
