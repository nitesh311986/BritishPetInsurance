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
import java.util.ArrayList;
import java.util.List;

public class PolicySampleDocumentsDownLoad extends BasePage {
    public PolicySampleDocumentsDownLoad(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(5)")
    WebElement policyIcon;
    @FindBy(xpath = "//div[@class='project-tabs user-profile dsh-tab']/ul/li[11]")
    WebElement clickLetterButton;
    @FindBy(xpath = "//div[@id='gridPolicyLetterList']/table/tbody/tr/td[14]/div/a[1]")
    WebElement clickDownLoadButton;


    //Methods
    public void clickPolicyIcon() {
        policyIcon.click();
    }

    public void fetchData() {

        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[3]")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 10, "Policy Data Inside Column Is Not Visible");
        for (WebElement cEle : totalColumn) {
            cEle.click();
            if (cEle.getText().equals("CHAA-00018-DSU-00000024")) {

                ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,350)", "");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                clickLetterButton.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                JavascriptExecutor js1 = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", clickDownLoadButton);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                WebDriverWait dWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                List<WebElement> totalDownLoadSymbol = dWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridPolicyLetterList']/table/tbody/tr/td[14]/div/a[1]")));
                int dSize = totalDownLoadSymbol.size();
                Assert.assertEquals(dSize, 10, "DownLoad Symbol Inside Column Is Not Visible");
               for(int i=0;i<dSize;i++) {
                  totalDownLoadSymbol.get(i).click();
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   break;
               }
                driver.close();
                driver.switchTo().window(tabs2.get(0));
            } else {
                break;
            }

        }

    }

}
