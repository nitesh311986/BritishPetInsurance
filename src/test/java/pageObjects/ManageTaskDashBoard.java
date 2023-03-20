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

public class ManageTaskDashBoard extends BasePage{
    public ManageTaskDashBoard (WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(7)")
    WebElement taskIcon;
    @FindBy(xpath = "//div[@id='page-wrapper']/div[3]/div/h2")
    WebElement manageTaskMessage;
    @FindBy(xpath = "//div[@id='gridName']/table")
    WebElement table;

    //Methods
    public void clickONTaskIcon(){
        taskIcon.click();
    }

    public String verifyMessage(){
        return  manageTaskMessage.getText();
    }
    public void fetchData(){
        List<WebElement> tableHead = table.findElements(By.xpath("//div[@id='gridName']/table/thead/tr/th"));
        int hSize = tableHead.size();
        Assert.assertEquals(hSize, 11, "Task Data Inside Head Is Not Available");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr")));
        int rSize = totalRow.size();
        Assert.assertEquals(rSize, 10, "Task Data Inside Row Is Not Available");
        for (WebElement rEle : totalRow) {
            System.out.println(rEle.getText());
        }
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 110, "Quote Data Inside Column Is Not Visible");
        for (WebElement cEle : totalColumn) {
            System.out.println(cEle.getText());
        }

    }

}
