package TestCases;

import Core.BaseDriver;
import Mapping.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class DashboardTestCases extends BaseDriver {
    @BeforeClass
    public void DashboardPageStart() throws InterruptedException {
        startSession();
        PageFactory.initElements(driver, BaseDriver.class);
        PageFactory.initElements(driver, LoginPage.class);
        validLogin();
    }
    @AfterClass
    public void DashboardPageEnd(){
        stopSession();
    }
//    @AfterTest
//    public void dashboardPageTestEnd(){
//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    }

    @Test(priority = 1)
    public void EnterAdminPageTest() throws InterruptedException {
        EnterAdminPage();
    }
    @Test(priority = 2)
    public void EnterPimPageTest() throws InterruptedException {
        EnterPimPage();
    }
    @Test(priority = 3)
    public void EnterLeavePageTest() throws InterruptedException {
        EnterLeavePage();
    }
    @Test(priority = 4)
    public void EnterTimePageTest() throws InterruptedException {
        EnterTimePage();
    }
    @Test(priority = 5)
    public void EnterRecruitmentPageTest() throws InterruptedException {
        EnterRecruitmentPage();
    }
    @Test(priority = 6)
    public void EnterMyInfoPageTest() throws InterruptedException {
        EnterMyInfoPage();
    }
    @Test(priority = 7)
    public void EnterPerformancePageTest() throws InterruptedException {
        EnterPerformancePage();
    }
    @Test(priority = 8)
    public void EnterDashboardPageTest() throws InterruptedException {
        EnterDashboardPage();
    }    @Test(priority = 9)
    public void EnterDirectoryPageTest() throws InterruptedException {
        EnterDirectoryPage();
    }
    @Test(priority = 10)
    public void EnterBuzzPageTest() throws InterruptedException {
        EnterBuzzPage();
    }
    @Test(priority = 11)
    public void EnterMaintenancePageTest() throws InterruptedException {
        EnterMaintenancePage();
    }

    @Test(priority = 12)
    public void DashboardSearchFieldTest() throws InterruptedException {
        DashboardSearchField();
    }


}
