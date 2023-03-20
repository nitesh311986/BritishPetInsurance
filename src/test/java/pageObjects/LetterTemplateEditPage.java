package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LetterTemplateEditPage extends BasePage {
    public LetterTemplateEditPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(10)")
    WebElement adminIcon;
    @FindBy(xpath = "//div[@class='ibox-content']/div/div[5]/a/i")
    WebElement letterIcon;
    @FindBy(xpath = "//*[text()='Edit Letter Template']")
    WebElement templatePageMessage;
    @FindBy(css = "input[id='LetterTemplateName']")
    WebElement userName;
    @FindBy(css = "input[id='FromEmail']")
    WebElement userEmail;
    @FindBy(css = "input[id='DisplayOrder']")
    WebElement userOrder;
    @FindBy(css = "input[id='Subject']")
    WebElement subject;

    //div[@class='ibox-content']/div[6]/div/div/div/table/tbody/tr[2]/td/iframe

    //Methods
    public void clickOnAdminIcon() {
        adminIcon.click();
    }

    public void clickOnLetterIcon() {
        letterIcon.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String verifyLetterPageEditFunctionality() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalHead = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr/td[5]/div/a[1]")));
        int thSize = totalHead.size();
        //System.out.println(thSize);
        Assert.assertEquals(thSize, 15);
        for (WebElement thHead : totalHead) {
            thHead.click();
            break;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return templatePageMessage.getText();
    }

    public void enterData(){
        userName.sendKeys("nitesh");
        userEmail.sendKeys("nitesh.barot31@gmail.com");
        //userOrder.sendKeys("1");
        subject.sendKeys("new subject");


    }


}
