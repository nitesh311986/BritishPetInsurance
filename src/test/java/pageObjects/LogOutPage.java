package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage{
    public LogOutPage(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(12)")
    WebElement logOutIcon;
    @FindBy(xpath = "//div[@class='middle-box text-center loginscreen']/header/h4")
    WebElement logInMessage;

    //Methods
    public void clickOnLogOutButton(){
        logOutIcon.click();
    }
    public String verifyLogInPage()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return logInMessage.getText();
    }




}
