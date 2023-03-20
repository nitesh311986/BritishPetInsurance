package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Graph_Display_Page extends BasePage {
    //Constructor To Initialise Objects
    public Graph_Display_Page(WebDriver driver) {
        super(driver);
    }


    //Elements
    @FindBy(xpath = "//div[@class='d-spacing1 cell chart']/div/h3")
    WebElement generalGraph;
    @FindBy(xpath = "//div[@class='d-spacing1']/div/div/div/h3")
    WebElement policyGraph;
    @FindBy(xpath = "//div[@class='dashboard-panel']/div[3]/div/div[3]/div/h3")
    WebElement claimGraph;
    @FindBy(xpath = "//div[@class='dashboard-panel']/div[4]/div/div/div[1]/div/h3")
    WebElement quoteStatus;
    @FindBy(xpath = "//div[@class='dashboard-panel']/div[4]/div/div/div[3]/div/h3")
    WebElement policyStatus;
    @FindBy(xpath = "//div[@class='dashboard-panel']/div[4]/div/div/div[5]/div/h3")
    WebElement claimStatus;



    //Methods
    public String verifyGeneralGraph() {
        return generalGraph.getText();
    }

    public String verifyPolicyGraphMessage() {
        return policyGraph.getText();
    }

    public String verifyClaimGraphMessage(){
        return claimGraph.getText();
    }
    public String verifyQuoteStatus(){
        return quoteStatus.getText();
    }
    public String verifyPolicyStatus(){
        return policyStatus.getText();
    }
    public String verifyClaimStatus(){
        return claimStatus.getText();
    }

}
