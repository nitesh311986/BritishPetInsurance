package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddQuotePage extends BasePage {
    //Constructor To Initialise Objects
    public AddQuotePage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "ul[id='side-menu']>li:nth-child(4)")
    WebElement quoteIcon;
    @FindBy(xpath = " //div[@class=' tooltip-demo pull-right']/a[2]")
    WebElement addQuoteButton;
    @FindBy(xpath = "//div[@id='page-wrapper']/div[3]/div/h2")
    WebElement messageAddQuote;

    public void openAddQuotePage() {
        quoteIcon.click();
        addQuoteButton.click();
    }
    public String verifyPage(){
        return  messageAddQuote.getText();
    }
}
