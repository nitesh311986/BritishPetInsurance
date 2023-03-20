package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    //Constructor To Initialise Objects
    public LogInPage(WebDriver driver)
    {
        super(driver);
    }



    //Objects Of Page
    //Text Verification Element
    @FindBy(xpath = "//p[@class='copyright']/small")
    WebElement copyRight;


    //Login Form Elements
    @FindBy(xpath = "//input[@id='UserName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement userPassword;
    @FindBy(xpath = "//button[@id='login']")
    WebElement submitButton;

    //Action Methods
    public String verifyCopyRight()
    {
        return copyRight.getText();
    }

    public void userLogIn()
    {
        userName.sendKeys("Sa");
        userPassword.sendKeys("Good2go@2019");
        submitButton.click();

    }
}
