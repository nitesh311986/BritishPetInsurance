package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddTaskPageFormAndDropDownPage extends BasePage {
    public AddTaskPageFormAndDropDownPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(7)")
    WebElement taskIcon;
    @FindBy(xpath = "//div[@class=' tooltip-demo pull-right']/a[2]")
    WebElement addTaskButton;

    @FindBy(xpath = "//div[@class='ibox float-e-margins']/div[1]/div/div[6]/div/div/div/span/span/span[2]")
    WebElement assignDropDown;


    public void clickTaskIcon() {
        taskIcon.click();
    }

    public void clickOnAddTaskButton() {
        addTaskButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String verifyAssignDropDown() {
        assignDropDown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> drop = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='AssignedToId_listbox']/li[1]/table/tbody/tr/td")));
        System.out.println(drop.size());
        String rev="";
        for (WebElement element:drop)
        {
            rev=rev+element.getText()+" ";
            System.out.println(element.getText());
        }
        return rev;

    }
}


