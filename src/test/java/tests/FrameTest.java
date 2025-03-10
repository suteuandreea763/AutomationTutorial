package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class FrameTest extends SharedData {


    @Test
    public void metodaTest () {

       // JavascriptExecutor executor = (JavascriptExecutor) driver;
        ElementHelper elementHelper=new ElementHelper(driver);


        By FramesWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        //executor.executeScript("arguments[0].click();", FramesWindowsMenu);
        elementHelper.clickJsLocator(FramesWindowsMenu);

        By framesSubmenu = By.xpath("//span[text()='Frames']");
       // executor.executeScript("arguments[0].click();", framesSubmenu);
        elementHelper.clickJsLocator(framesSubmenu);

        driver.switchTo().frame("frame1");

        By textElement =By.id("sampleHeading");
        //System.out.println(textElement.getText());
        System.out.println(driver.findElement(textElement).getText());


        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");

        By textElement2=By.id("sampleHeading");
        //System.out.println(textElement2.getText());
        System.out.println(driver.findElement(textElement2).getText());



    }
}

