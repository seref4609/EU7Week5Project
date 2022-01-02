package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
 Task3:
         1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
         2. Login with username: Tester, password: test
         3. Click  Order button
         4. Verify under Product Information, selected option is “MyMoney”
         5. Then select FamilyAlbum, make quantity 2, and click Calculate,
         6. Then verify Total is equal to Quantity*PricePerUnit
         */

public class DropDown {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
    @AfterMethod
    public void tearDown(){


    }
    @Test
    public void test(){
        WebElement userInputBox = driver.findElement(By.id("ctl00_MainContent_username"));
        userInputBox.sendKeys("Tester");
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys("test"+ Keys.ENTER);




    }

}
