package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PolicyInformationPage extends BasePage {
    public PolicyInformationPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(5)")
    WebElement policyIcon;
    @FindBy(xpath = "//div[@id='page-wrapper']/div[3]/div/h2")
    WebElement policyMessage;

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
            //System.out.println(cEle.getText());
            /*if(cEle.getText().equals("CHAA-00018-EDTV-00000001"))
            {
                System.out.println(cEle.getText());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));
                driver.close();
                driver.switchTo().window(tabs2.get(0));
                break;
            }*/
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
