package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

 /*
    Task1:
            1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
            2. Click on "Click me, to Open an alert after 5 seconds"
            3. Explicitly wait until alert is present
            4. Then handle the Javascript alert
    Task2:
            1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
            2. Click on "Enable button after 10 seconds"
            3. Explicitly wait until the button is enabled
             4. Then verify the button is enabled
    Task3:
            1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            2. Login with username: Tester, password: test
            3. Click  Order button
             4. Verify under Product Information, selected option is “MyMoney”
            5. Then select FamilyAlbum, make quantity 2, and click Calculate,
            6. Then verify Total is equal to Quantity*PricePerUnit
            */


public class ChercherTest {

WebDriver driver;
WebDriverWait wait;
@BeforeMethod
    public void setUp(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

}
@AfterMethod
public void tearDown(){


}
@Test
public void alertPresentTest(){

    // Click on "Click me, to Open an alert after 5 seconds"
    WebElement initiateALert = driver.findElement(By.id("alert"));
    initiateALert.click();

    wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.alertIsPresent());
    // handle javascript alert
    // if you don't wait you will get NoAlertPresentException: no such alert
    Alert alert = driver.switchTo().alert();
    alert.accept();


}
@Test
    public void disableButtonTest(){

    WebElement button = driver.findElement(By.id("disable"));
    System.out.println("button.isEnabled() = " + button.isEnabled()); // false

    WebElement buttonInitiator = driver.findElement(By.id("enable-button"));
    buttonInitiator.click();

    wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.elementToBeClickable(button));

    System.out.println("button.isEnabled() = " + button.isEnabled()); // true
    Assert.assertTrue(button.isEnabled(),"Verify the Button is enabled");

}
}
