package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddClaimPage extends BasePage{
    public AddClaimPage(WebDriver driver){
        super(driver);
    }
    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(6)")
    WebElement manageClaimIcon;
    @FindBy(xpath = "//ul[@id='side-menu']/li[6]/ul/li[1]")
    WebElement manageClaimText;
    @FindBy(xpath = "//div[@class=' tooltip-demo pull-right']/a[2]")
    WebElement addClaimIcon;
    @FindBy(xpath = "//div[@class='well1']/div/div/div/div/span/span/span[@class='k-input']")
    WebElement dropDown;
    @FindBy(xpath = "//div[@class='ibox-content']/div[6]/div[3]/div/div/div[3]/div/div/div/span/span[1]/span")
    WebElement calenderDate;

    //ul[@id='ClaimTreatmentTypeId_listbox']/li

    public void clickManageClaimIcon() {
        Actions actions=new Actions(driver);
        actions.moveToElement(manageClaimIcon).perform();
        manageClaimText.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnAddClaimIcon(){
        addClaimIcon.click();
    }

    public void verifyDropDownItems(){
        dropDown.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ClaimTreatmentTypeId_listbox']/li")));
        for (WebElement newL:list){
            System.out.println(newL.getText());
        }
    }

    public void verifyCalender(){
        calenderDate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
