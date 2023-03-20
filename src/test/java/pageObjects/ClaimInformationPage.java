package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClaimInformationPage extends BasePage {
    public ClaimInformationPage(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(6)")
    WebElement manageClaimIcon;
    @FindBy(xpath = "//ul[@id='side-menu']/li[6]/ul/li[1]")
    WebElement manageClaimText;

    public void clickManageClaimIcon() {
        Actions actions=new Actions(driver);
        actions.moveToElement(manageClaimIcon).perform();
        manageClaimText.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyClaimPageInformation() {

        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[5]/a")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 10, "Claim Data Inside Column Is Not Visible");
        for (WebElement cEle : totalColumn) {
            System.out.println(cEle.getText());
            cEle.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            driver.close();
            driver.switchTo().window(tabs2.get(0));

        }
    }

}
