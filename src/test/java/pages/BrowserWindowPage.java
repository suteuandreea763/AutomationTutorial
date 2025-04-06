package pages;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageLocators.BrowserWindowLocators.tabButtonElement;
import static pageLocators.BrowserWindowLocators.windowButtonElement;

public class BrowserWindowPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private TabWindowHelper tabWindowHelper;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        elementHelper=new ElementHelper(driver);
        tabWindowHelper= new TabWindowHelper(driver);
    }

    public void interactWithSpecificTab(){
        elementHelper.clickJSLocator(tabButtonElement);
        LoggerUtility.infoTest("The user clicks on Tab Button");
        System.out.println(driver.getCurrentUrl());

        tabWindowHelper.switchToSpecificTabWindow(1);
        LoggerUtility.infoTest("The user switches the focus on second tab");
        System.out.println(driver.getCurrentUrl());

        tabWindowHelper.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes the current tab");
    }


    public void  interactWithSpecificWindow(){
        tabWindowHelper.switchToSpecificTabWindow(0);
        LoggerUtility.infoTest("The user switches the focus on second window");

        elementHelper.clickJSLocator(windowButtonElement);
        LoggerUtility.infoTest("The user clicks on Window Button");

        tabWindowHelper.switchToSpecificTabWindow(1);
        LoggerUtility.infoTest("The user closes second window");
    }

}
