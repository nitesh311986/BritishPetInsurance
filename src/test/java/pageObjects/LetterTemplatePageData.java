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

public class LetterTemplatePageData extends BasePage {
    public LetterTemplatePageData(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(10)")
    WebElement adminIcon;
    @FindBy(xpath = "//div[@class='ibox-content']/div/div[5]/a/i")
    WebElement letterIcon;


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

    public void fetchData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalHead = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/thead/tr/th")));
        int thSize = totalHead.size();
        //System.out.println(thSize);
        Assert.assertEquals(thSize,5);
        for (WebElement thHead : totalHead) {
            System.out.println(thHead.getText());
        }
        WebDriverWait waitR = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = waitR.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr")));
        int rSize = totalRow.size();
        //System.out.println(rSize);
        Assert.assertEquals(rSize,15);
        for (WebElement trRow : totalRow) {
            System.out.println(trRow.getText());
        }
    }

}
