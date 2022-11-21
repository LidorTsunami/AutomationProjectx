package TestCases;

import Core.BaseDriver;
import Mapping.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

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
    }





}
