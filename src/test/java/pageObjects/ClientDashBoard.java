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

public class ClientDashBoard extends BasePage {
    //Constructor To Initialise Objects
    public ClientDashBoard(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(3)")
    WebElement clientIcon;
    @FindBy(xpath = "//div[@id='page-wrapper']/div[3]/div/h2")
    WebElement clientMessage;
    @FindBy(xpath = "//div[@id='gridName']/table")
    WebElement table;


    //Methods
    public void clickClientIcon() {
        clientIcon.click();
    }

    public String verifyMessage() {
        return clientMessage.getText();
    }

    public void fetchData() {
        List<WebElement> totalHead = table.findElements(By.xpath("//div[@id='gridName']/table/thead/tr/th"));
        int hSize = totalHead.size();
        Assert.assertEquals(hSize, 7, "Client Data Inside Head Is Not Available");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr")));
        int rSize = totalRow.size();
        Assert.assertEquals(rSize, 10, "Client Data Inside Row Is Not Available");
        for(WebElement rEle:totalRow)
        {
            System.out.println(rEle.getText());
        }
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 70, "Client Data Inside Column Is Not Available");
        for(WebElement cEle:totalColumn)
        {
            System.out.println(cEle.getText());
        }

    }

}


