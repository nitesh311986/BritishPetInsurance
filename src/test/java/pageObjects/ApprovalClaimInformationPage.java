package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ApprovalClaimInformationPage extends BasePage{
    public ApprovalClaimInformationPage(WebDriver driver){
        super(driver);
    }

    //Elements
    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(6)")
    WebElement manageClaimIcon;
    @FindBy(xpath = "//ul[@id='side-menu']/li[6]/ul/li[2]")
    WebElement approveClaimText;
    @FindBy(xpath = "//div[@id='divLoadApproveClaimsList']/div/table")
    WebElement table;
    @FindBy(xpath = "//div[@id='divLoadApproveClaimsList']/div/table/tfoot/tr/td")
    WebElement dataMessage;

    //div[@id='divLoadApproveClaimsList']/div/table/thead/tr/th

    //div[@id='divLoadApproveClaimsList']/div/table/tbody

    //Methods
    public void clickOnApprovalClaim(){
        Actions actions=new Actions(driver);
        actions.moveToElement(manageClaimIcon).perform();
        approveClaimText.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchData() {
        List<WebElement> totalHead = table.findElements(By.xpath("//div[@id='divLoadApproveClaimsList']/div/table/thead/tr/th"));
        int hSize = totalHead.size();
        Assert.assertEquals(hSize, 6, "Claim Data Inside Head Is Not Available");
        String dataMessageOfClaims=dataMessage.getText();
        System.out.println(dataMessageOfClaims);


    }

}
