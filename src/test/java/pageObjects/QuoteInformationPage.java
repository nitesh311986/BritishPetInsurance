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
import java.util.List;

public class QuoteInformationPage extends BasePage{
    public QuoteInformationPage(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(4)")
    WebElement quoteIcon;


    //Methods

    public void clickQuoteIcon(){
        quoteIcon.click();
    }
    public void fetchData(){
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[2]/a")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 10, "Quote Data Inside Column Is Not Visible");
        for (WebElement cEle : totalColumn) {
            System.out.println(cEle.getText());
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
            System.out.println(driver.getCurrentUrl());
            driver.close();
            driver.switchTo().window(tabs2.get(0));

        }
    }

}
