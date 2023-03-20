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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddQuotePageProductList extends BasePage {
    public AddQuotePageProductList(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(4)")
    WebElement quoteIcon;
    @FindBy(xpath = "//div[@class=' tooltip-demo pull-right']/a[2]")
    WebElement addQuoteButton;
    @FindBy(xpath = "//div[@class='ibox-content']/div/div/div[4]/div/div/span")
    WebElement productList;


    public String verifyProductList() {
        quoteIcon.click();
        addQuoteButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productList.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> pList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul[id='PrimaryProductId_listbox']>li")));
        System.out.println(pList.size());

        String verfiy=" ";
        for (WebElement product : pList) {
            //System.out.println(product.getText());
            verfiy=verfiy+product.getText()+" ";

        }
        return verfiy;

    }
}
