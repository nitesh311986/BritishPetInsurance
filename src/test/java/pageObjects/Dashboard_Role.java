package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Role extends BasePage {
    //Constructor To Initialise Objects
    public Dashboard_Role(WebDriver driver)
    {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//span[@class='welcome-message']/label/small")
    WebElement roleText;

    //Methods
    public String verifyRoleText()
    {
        return roleText.getText();
    }

}
