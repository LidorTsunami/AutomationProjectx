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
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    public static WebDriver driver;

    String path = System.getProperty("user.dir");

    public WebDriver getDriver() { return driver;}

    public void startSession(){
        try{
            PropertyUtil pus = new PropertyUtil(path + "\\selenium.properties");
            String browser = pus.getProperty("browser");
            String WebSiteURL = pus.getProperty("WebSiteURL");
            String grid = pus.getProperty("grid");
            String gridUrl = pus.getProperty("gridUrl");
            if(browser.equalsIgnoreCase("FireFox")){
                if (grid.equalsIgnoreCase("true")){
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("firefox");
                    cap.setPlatform(Platform.WINDOWS);
                    driver = new RemoteWebDriver(new URL(gridUrl), cap);
                }else{
                    System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
                    WebDriver driver = new FirefoxDriver();
                }
            }else if(browser.equalsIgnoreCase("chrome")){
                if(grid.equalsIgnoreCase("true")){
                    System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    //set some options
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                    Capabilities cap = null;
                    driver = new RemoteWebDriver(new URL(gridUrl), cap);
                }else{
                    System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
            String url = pus.getProperty("WebSiteURL");
            driver.get(url);
            driver.manage().window().maximize();

        }catch (Exception e){
            e.getMessage();
        }
    }
    public void stopSession() {
        driver.quit();
    }

    //Login Page Functions
    public void validLogin() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage.UserNameField.sendKeys("Admin");
        LoginPage.PasswordField.sendKeys("admin123");
        LoginPage.SignInButton.click();
        Thread.sleep(3000);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
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
    }
}
