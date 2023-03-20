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

public class PolicyPageDateFormat extends BasePage {
    public PolicyPageDateFormat(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(5)")
    WebElement policyIcon;
    @FindBy(xpath = "//div[@id='gridName']/table")
    WebElement table;

    //Methods
    public void clickPolicyIcon() {
        policyIcon.click();
    }

    public void verifyDateFormat() {
        //PolicyColumDateFormatVerification
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> policyDateColumn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[13]")));
        int pdcSize = policyDateColumn.size();
        Assert.assertEquals(pdcSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement startDate : policyDateColumn) {
            String date = startDate.getText().toString();
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = date.matches(datePattern);
            if (!isDate) {
                System.out.println("StartDate Column Having All Dates In Require Format");
                break;
            }
        }

        //ExpireColumDateFormatVerification
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> endDateColumn = eWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[14]")));
        int endSize = endDateColumn.size();
        Assert.assertEquals(endSize, 10, "Require Number Of Column Is Not Displayed");
        for (WebElement endDate : endDateColumn) {
            String date = endDate.getText().toString();
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = date.matches(datePattern);
            if (!isDate) {
                System.out.println("ExpireDate Column Having All Dates In Require Format");
                break;
            }
        }

    }

}
