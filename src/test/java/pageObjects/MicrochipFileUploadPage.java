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

public class MicrochipFileUploadPage extends BasePage {
    public MicrochipFileUploadPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(4)")
    WebElement quoteIcon;

    @FindBy(xpath = "//div[@class='form-group pull-right']/div/a[3]")
    WebElement microchipIcon;

    //Methods
    public void clickOnQuoteIcon() {
        quoteIcon.click();
    }

    public void clickONMicrochipIcon() {
        microchipIcon.click();
    }

    public void fetchData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalHead = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='MicrochipFileUploadAuditGrid']/table/thead/tr/th")));
        int hSize = totalHead.size();
        Assert.assertEquals(hSize, 7, "MicrochipData Data Inside Head Is Not Available");
        WebDriverWait rWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = rWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='MicrochipFileUploadAuditGrid']/table/tbody/tr")));
        int rSize = totalRow.size();
        Assert.assertEquals(rSize, 10, "MicrochipData Data Inside Row Is Not Available");
        for (WebElement rEle : totalRow) {
            System.out.println(rEle.getText());
        }
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='MicrochipFileUploadAuditGrid']/table/tbody/tr/td")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 70, "MicrochipData Data Inside Column Is Not Visible");
        for (WebElement cEle : totalColumn) {
            System.out.println(cEle.getText());
        }


    }
}

