package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/div/div/input")
    public static WebElement SearchField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a")
    public static WebElement SearchElementAdmin;
}
