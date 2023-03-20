package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ManageClaimsWithDateFormatAndPondSign extends BasePage {
    public ManageClaimsWithDateFormatAndPondSign(WebDriver driver) {
        super(driver);
    }

   /* @FindBy(css = "ul[id='side-menu']>li:nth-child(6)")
    WebElement manageClaimIcon;
    @FindBy(xpath = "//ul[@id='side-menu']/li[6]/ul/li[1]")
    WebElement manageClaimText;*/

    //Methods
    public void clickManageClaimIcon() {
        Actions actions = new Actions(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement manageClaimIcon = eWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[id='side-menu']>li:nth-child(6)")));
        actions.moveToElement(manageClaimIcon).perform();
        WebDriverWait mWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement manageClaimText = mWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='side-menu']/li[6]/ul/li[1]/a")));
        manageClaimText.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void verifyDateFormat() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> claimDateColumn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[14]")));
        int cdcSize = claimDateColumn.size();
        Assert.assertEquals(cdcSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement startDate : claimDateColumn) {
            String date = startDate.getText().toString();
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = date.matches(datePattern);
            if (!isDate) {
                System.out.println("StartDate Column Having All Dates In Require Format");
                break;
            }
        }
    }

    public void verifyPoundSign() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> claimAmountColumn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[16]")));
        int cdcSize = claimAmountColumn.size();
        Assert.assertEquals(cdcSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement amountP : claimAmountColumn) {
            String paymentAmount = amountP.getText();
            System.out.println(paymentAmount);
            String newArray[] = paymentAmount.split("\s");
            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i].equals("£")) {
                    System.out.println("All Amount Figure Prefixed By £");
                    break;
                }
                break;
            }
        }
    }


}
