package TestCases;

import Core.BaseDriver;
import Mapping.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.NoSuchElementException;

import static Core.BaseDriver.driver;

public class LoginPageTestCases extends BaseDriver {

    @BeforeTest
    public void LoginPageStart(){
        startSession();
        PageFactory.initElements(driver, BaseDriver.class);
        PageFactory.initElements(driver, LoginPage.class);
    }

    @AfterTest
    public void LoginPageEnd(){
        stopSession();
    }
    @AfterClass
    public void LoginPageClassEnd(){
        stopSession();
    }


    @Test (priority = 1)
    public void InvalidUserNameTest() throws InterruptedException {
        InvalidUserName();
    }
    @Test (priority = 2)
    public void InvalidPasswordTest() throws InterruptedException {
        InvalidPassword();
    }
    @Test (priority = 3)
    public void validLoginTest() throws InterruptedException {
        validLogin();
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
    }
}
