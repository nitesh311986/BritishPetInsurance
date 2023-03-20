package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class QuotePagePremiumCheck extends BasePage{
    public QuotePagePremiumCheck(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(4)")
    WebElement quoteIcon;
    @FindBy(xpath = "//div[@id='gridName']/table/tbody[1]/tr/td[16]")
    WebElement premiumElement;

    //Methods
    public void clickOnQuoteIcon(){
        quoteIcon.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyPoundSign(){

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView();", premiumElement);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement>  yearlyPremiumColum = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[15]")));
        int ypSize = yearlyPremiumColum.size();
        Assert.assertEquals(ypSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement amountP : yearlyPremiumColum) {
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
        WebDriverWait mWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> monthlyPremiumColumn = mWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[16]")));
        int mpSize = monthlyPremiumColumn.size();
        Assert.assertEquals(mpSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement amountP : monthlyPremiumColumn) {
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
