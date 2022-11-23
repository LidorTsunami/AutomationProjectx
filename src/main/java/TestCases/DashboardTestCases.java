package TestCases;

import Core.BaseDriver;
import Mapping.DashboardPage;
import Mapping.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class DashboardTestCases extends BaseDriver {
    @BeforeClass
    public void dashboardTestStart() throws InterruptedException {
        PageFactory.initElements(driver, BaseDriver.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, DashboardPage.class);
        startSession();
        validLogin();
    }
    @AfterClass
    public void dashboardTestEnd(){
        stopSession();
    }

    @Test(priority = 1)
    public void SearchFieldTestCase() throws InterruptedException {
        SearchFieldTest();
    }
}
