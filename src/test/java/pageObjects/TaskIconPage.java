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

public class TaskIconPage extends BasePage {
    public TaskIconPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(8)")
    WebElement accountIcon;

    //Methods
    public void clickTaskIcon() {
        accountIcon.click();
    }

    public void traversingThroughPages() {
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ibox-content']/div/div/a")));
        int cSize = totalColumn.size();
        Assert.assertEquals(cSize, 22, "Required Icons Missing");
        //Store the ID of the original window

        for (WebElement cEle : totalColumn) {
            cEle.click();
            //System.out.println(cEle.getText());
            System.out.println(driver.getCurrentUrl());
            //accountIcon.click();

        }

    }
}