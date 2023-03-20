package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class QuotePageDateFormat extends BasePage {
    //Constructor To Initialise Objects
    public QuotePageDateFormat(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(4)")
    WebElement quoteIcon;
    @FindBy(xpath = "//div[@id='gridName']/table")
    WebElement table;

    //Methods
    public void clickQuoteIcon() {
        quoteIcon.click();
    }

    public void verifyDateFormat() {
        //QuoteColumDateFormatVerification
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> quoteDateColumn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[3]")));
        int qdcSize = quoteDateColumn.size();
        Assert.assertEquals(qdcSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement quoteDate : quoteDateColumn) {
            String date = quoteDate.getText().toString();
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = date.matches(datePattern);
            if (!isDate) {
                System.out.println("QuoteDate Column Having All Dates In Require Format");
                break;
            }
        }

        //ExpireColumDateFormatVerification
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> expireDateColumn = eWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[4]")));
        int edcSize = expireDateColumn.size();
        Assert.assertEquals(edcSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement expireDate : expireDateColumn) {
            String date = expireDate.getText().toString();
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = date.matches(datePattern);
            if (!isDate) {
                System.out.println("ExpireDate Column Having All Dates In Require Format");
                break;
            }
        }

    }

}
