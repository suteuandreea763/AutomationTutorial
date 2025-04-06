package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
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
        LoggerUtility.infoTest("The user clicks on the Alert Frame Window Menu");
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsSubMenu);
        LoggerUtility.infoTest("The user clicks on the Alerts SubMenu");
    }

    public void enterOnBrowserWindowSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.browserSubMenu);
        LoggerUtility.infoTest("The user clicks on the Browser Window SubMenu");
    }

    public void enterOnFrameSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.frameSubMenu);
        LoggerUtility.infoTest("The user clicks on the  Frame SubMenu");
    }
    public void enterOnFormsMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenu);
        LoggerUtility.infoTest("The user clicks on the Forms Menu");
    }
    public void enterOnPracticeFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormSubMenu);
        LoggerUtility.infoTest("The user clicks on the Practice Form SubMenu");
    }
    public void enterOnElementsMenu(){
        elementHelper.clickJSLocator(IndexLocators.elementsMenu);
        LoggerUtility.infoTest("The user clicks on the Elements Menu");
    }
    public void enterOnWebTablesSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.webTablesSubMenu);
        LoggerUtility.infoTest("The user clicks on the Web Tables SubMenu");
    }
}
