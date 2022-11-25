package Core;

import Mapping.LoginPage;
import Utils.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.NoSuchElementException;

public class BaseDriver {

    public static WebDriver driver;

    String path = System.getProperty("user.dir");

    public WebDriver getDriver() {
        return driver;
    }

    public void startSession() {
        try {
            PropertyUtil pus = new PropertyUtil(path + "\\selenium.properties");
            String browser = pus.getProperty("browser");
            String WebSiteURL = pus.getProperty("WebSiteURL");
            String grid = pus.getProperty("grid");
            String gridUrl = pus.getProperty("gridUrl");
            if (browser.equalsIgnoreCase("FireFox")) {
                if (grid.equalsIgnoreCase("true")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("firefox");
                    cap.setPlatform(Platform.WINDOWS);
                    driver = new RemoteWebDriver(new URL(gridUrl), cap);
                } else {
                    System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
                    WebDriver driver = new FirefoxDriver();
                }
            } else if (browser.equalsIgnoreCase("chrome")) {
                if (grid.equalsIgnoreCase("true")) {
                    System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    //set some options
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    Capabilities cap = null;
                    driver = new RemoteWebDriver(new URL(gridUrl), cap);
                } else {
                    System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
            String url = pus.getProperty("WebSiteURL");
            driver.get(url);
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void stopSession() {
        driver.quit();
    }

    //Login Page Functions
    public void validLogin() throws InterruptedException {
        Thread.sleep(3000);
        LoginPage.UserNameField.sendKeys("Admin");
        LoginPage.PasswordField.sendKeys("admin123");
        LoginPage.SignInButton.click();
        Thread.sleep(3000);
    }

    public void InvalidUserName() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage.UserNameField.sendKeys("Lidor");
        LoginPage.PasswordField.sendKeys("admin123");
        LoginPage.SignInButton.click();
        Thread.sleep(3000);
    }

    public void InvalidPassword() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage.UserNameField.sendKeys("Admin");
        LoginPage.PasswordField.sendKeys("Lidor");
        LoginPage.SignInButton.click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
    }



    //DashboardPage
    public void DashboardSearchField() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/div/div/input")).sendKeys("Admin");
        Thread.sleep(4000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li/a"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
    }
    public void EnterAdminPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
    }
    public void EnterPimPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterLeavePage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterTimePage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/h6"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterRecruitmentPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterMyInfoPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterPerformancePage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterDashboardPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div/p"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterDirectoryPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
    public void EnterBuzzPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/h4"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }

    public void EnterMaintenancePage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[2]")).click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/h6"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

    }
}
