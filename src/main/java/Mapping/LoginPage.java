package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    @FindBy (xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    public static WebElement UserNameField;

    @FindBy (xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    public static WebElement PasswordField;

    @FindBy (xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    public static WebElement SignInButton;

    @FindBy (xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    public static WebElement InvalidUserNameText;

    @FindBy (xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    public static WebElement InvalidCredentialsText;
}
