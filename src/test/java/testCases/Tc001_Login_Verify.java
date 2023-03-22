package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.TestBase;
import utility.ScreenRecorderUtil;

public class Tc001_Login_Verify extends TestBase {

    //1st Test case
    @Test(priority = 0)
    public void verifyLogin() {

        LogInPage logInPage = new LogInPage(driver);
        //Verification part code
        String Verification = logInPage.verifyCopyRight();

        if (Verification.contains("(en-GB)")) {
            System.out.println("Page Contains Required String (en-GB)");
        } else {
            Assert.fail();
        }


        //Login Function Call
        logInPage.userLogIn();


    }

    //2nd Test case
    @Test(priority = 1)
    public void verifyRole() {
        Dashboard_Role dr = new Dashboard_Role(driver);
        String verifyRoleText = dr.verifyRoleText();
        Assert.assertEquals(verifyRoleText, "(en-GB)");

    }

   @Test(priority = 3)
    public void verifyItemsOnDashboard() {
        Dashboard_Item_Details dtd = new Dashboard_Item_Details(driver);

        //Client Details Verification
        String itemsDetails = dtd.verifyClientDetails();
        System.out.println(itemsDetails);
        String itemDetail[] = itemsDetails.split("\s");
        int aLength = itemDetail.length;
        for (int i = 0; i < aLength; i++) {
            if (itemDetail[i].equals("Client")) {
                System.out.println("Client Tag Is Presented");
            } else if (itemDetail[i].equals("18677")) {
                System.out.println("Total Client Number Has Updated");
            } else if (itemDetail[i].equals("0")) {
                System.out.println("Monthly Client Number Has Updated");

            } else {
                Assert.fail();
            }
        }


        //Quote Details Verification
        String quoteDetails = dtd.verifyQuote();
        System.out.println(quoteDetails);
        String quoteDetail[] = quoteDetails.split("\s");
        int qLength = quoteDetail.length;
        for (int i = 0; i < qLength; i++) {
            if (quoteDetail[i].equals("Quote")) {
                System.out.println("Quote Tag Is Presented");
            } else if (quoteDetail[i].equals("41891")) {
                System.out.println("Total Quote Number Has Updated");
            } else if (quoteDetail[i].equals("17")) {
                System.out.println("Monthly Quote Number Has Updated");

            } else {
                Assert.fail();
            }
        }


        //Policy Details Verification
        String policyDetails = dtd.verifyPolicy();
        System.out.println(policyDetails);
        String policyDetail[] = policyDetails.split("\s");
        int pLength = policyDetail.length;
        for (int i = 0; i < pLength; i++) {
            if (policyDetail[i].equals("Policy")) {
                System.out.println("Policy Tag Is Presented");
            } else if (policyDetail[i].equals("19068")) {
                System.out.println("Total Policy Number Has Updated");
            } else if (policyDetail[i].equals("14")) {
                System.out.println("Monthly Policy Number Has Updated");

            } else {
                Assert.fail();
            }
        }

        //Claims Details Verification
        String claimDetails = dtd.verifyClaims();
        System.out.println(claimDetails);
        String claimDetail[] = claimDetails.split("\s");
        int cLength = claimDetail.length;
        for (int i = 0; i < cLength; i++) {
            if (claimDetail[i].equals("Claim")) {
                System.out.println("Claim Tag Is Presented");
            } else if (claimDetail[i].equals("148")) {
                System.out.println("Total Claim Number Has Updated");
            } else if (claimDetail[i].equals("4")) {
                System.out.println("Monthly Claim Number Has Updated");

            } else {
                Assert.fail();
            }
        }


    }

    @Test(priority = 4)
    public void verifyGraphMessages() {
        Graph_Display_Page gdp = new Graph_Display_Page(driver);
        String message = gdp.verifyGeneralGraph();
        System.out.println(message);
        Assert.assertEquals(message, "Client, Quote, policy and Claims Created Details (Last 6 Months)");
        String policyMessage = gdp.verifyPolicyGraphMessage();
        System.out.println(policyMessage);
        Assert.assertEquals(policyMessage, "Policy Paid Amount v/s Outstanding Amount (Last 6 Months)");
        String claimMessage = gdp.verifyClaimGraphMessage();
        System.out.println(claimMessage);
        Assert.assertEquals(claimMessage, "Claim Paid Amount v/s Reversal Amount (Last 6 Months)");
        String quoteStatus = gdp.verifyQuoteStatus();
        System.out.println(quoteStatus);
        Assert.assertEquals(quoteStatus, "Quote Status (March 2023)");
        String policyStatus = gdp.verifyPolicyStatus();
        System.out.println(policyStatus);
        Assert.assertEquals(policyStatus, "Policy Status (March 2023)");
        String claimStatus = gdp.verifyClaimStatus();
        System.out.println(claimStatus);
        Assert.assertEquals(claimStatus, "Claim by Treatment Status (March 2023)");


    }

    @Test(priority = 5)
    public void verifyClientManagePage() {
        ClientDashBoard cdb = new ClientDashBoard(driver);
        cdb.clickClientIcon();
        String Url = driver.getCurrentUrl();
        System.out.println(Url);

        String message = cdb.verifyMessage();
        Assert.assertEquals(message, "Manage Client");
        cdb.fetchData();
    }

    @Test(priority = 6)
    public void verifyQuoteManagePage(){
        QuoteDashBoard qdb=new QuoteDashBoard(driver);
        qdb.clickQuoteIcon();
        String qMessage=qdb.verifyMessage();
        Assert.assertEquals(qMessage,"Manage Quote");
        qdb.fetchData();

    }

    @Test(priority = 7)
    public void verifyDateFormatOnQuotePage() {
        QuotePageDateFormat qpdF = new QuotePageDateFormat(driver);
        qpdF.clickQuoteIcon();
        qpdF.verifyDateFormat();

    }

    @Test(priority = 8)
    public void verifyAddQuotePageLaunch(){
        AddQuotePage aqp=new AddQuotePage(driver);
        aqp.openAddQuotePage();
        String message=aqp.verifyPage();
        Assert.assertEquals(message,"Add Quote","Launch To Wrong Page");
    }

    @Test(priority = 8)
    public void verifyProductListOnAddQuotePage() {
        AddQuotePageProductList aqpL = new AddQuotePageProductList(driver);
        String verifyS=aqpL.verifyProductList();
        Assert.assertEquals(verifyS," Select Exotic Cat Dog Introductory Cover Horse ");

    }

    @Test(priority = 9)
    public void verifyPolicyPage(){
        PolicyDashBoardPage pdbP=new PolicyDashBoardPage(driver);
        pdbP.clickPolicyIcon();
        String message=pdbP.verifyMessage();
        Assert.assertEquals(message,"Manage Policy","Land On Wrong page");
        pdbP.fetchData();
    }

    @Test(priority = 10)
    public void verifyPolicyPageDateFormat(){
        PolicyPageDateFormat ppdF=new PolicyPageDateFormat(driver);
        ppdF.clickPolicyIcon();
        ppdF.verifyDateFormat();

    }

    @Test(priority = 11)
    public void verifyPolicyInformationPageLaunch(){
        PolicyInformationPage pip=new PolicyInformationPage(driver);
        pip.clickPolicyIcon();
        pip.fetchData();

    }

    @Test(priority = 12)
    public void verifyPolicySamplePageDownLoad(){
        PolicySampleDocumentsDownLoad psdd=new PolicySampleDocumentsDownLoad(driver);
        psdd.clickPolicyIcon();
        psdd.fetchData();
    }

    @Test(priority = 13)
    public void verifyManageClaimDateAndPondSymbol(){
        ManageClaimsWithDateFormatAndPondSign mcwdfaP=new ManageClaimsWithDateFormatAndPondSign(driver);
        mcwdfaP.clickManageClaimIcon();
        mcwdfaP.verifyDateFormat();
        mcwdfaP.verifyPoundSign();
    }

    @Test(priority = 14)
    public void verifyClaimPageInformation(){
        ClaimInformationPage cip=new ClaimInformationPage(driver);
        cip.clickManageClaimIcon();
        cip.verifyClaimPageInformation();

    }

    @Test(priority = 15)
    public void verifyApprovalClaimDashBoardDetails()
    {
        ApprovalClaimInformationPage acip=new ApprovalClaimInformationPage(driver);
        acip.clickOnApprovalClaim();
        acip.fetchData();
    }

    @Test(priority = 16)
    public void verifyManageTaskDashBoard(){
        ManageTaskDashBoard mtdB=new ManageTaskDashBoard(driver);
        mtdB.clickONTaskIcon();
        String message=mtdB.verifyMessage();
        Assert.assertEquals(message,"Manage Task");
        mtdB.fetchData();
    }

    @Test(priority = 17)
    public void verifyAddTaskPageDetails(){
        AddTaskPageFormAndDropDownPage atP=new AddTaskPageFormAndDropDownPage(driver);
        atP.clickTaskIcon();
        atP.clickOnAddTaskButton();
        String assignString=atP.verifyAssignDropDown();
        Assert.assertEquals(assignString,"sa FIT sa ");

    }

    @Test(priority = 26)
    public void verifyLogOut(){
        LogOutPage lop=new LogOutPage(driver);
        lop.clickOnLogOutButton();
        String message=lop.verifyLogInPage();
        Assert.assertEquals(message,"Login to your account");
    }

    @Test (priority = 18)
    public void verifyQuotePageData(){
        QuoteInformationPage qip=new QuoteInformationPage(driver);
        qip.clickQuoteIcon();
        qip.fetchData();
    }

    @Test(priority = 19)
    public void verifyMicroChipPageData() {
        MicrochipFileUploadPage mfuL = new MicrochipFileUploadPage(driver);
        mfuL.clickOnQuoteIcon();
        mfuL.clickONMicrochipIcon();
        mfuL.fetchData();
    }

    @Test(priority = 20)
    public void verifyQuotePagePremiumPoundSign(){
        QuotePagePremiumCheck qppC=new QuotePagePremiumCheck(driver);
        qppC.clickOnQuoteIcon();
        qppC.verifyPoundSign();
    }

    @Test(priority = 21)
    public void verifyLetterTemplatePage(){
        LetterTemplatePageData ltpD=new LetterTemplatePageData(driver);
        ltpD.clickOnAdminIcon();
        ltpD.clickOnLetterIcon();
        ltpD.fetchData();
    }

    @Test(priority = 22)
    public void verifyLetterTemplatePageEditFun(){
        LetterTemplateEditPage lteP=new LetterTemplateEditPage(driver);
        lteP.clickOnAdminIcon();
        lteP.clickOnLetterIcon();
        String message=lteP.verifyLetterPageEditFunctionality();
        Assert.assertEquals(message,"Edit Letter Template");
        lteP.enterData();
    }

    @Test(priority = 23)
    public void verifyAccountPageIcon(){
        TaskIconPage tiP=new TaskIconPage(driver);
        tiP.clickTaskIcon();
        tiP.traversingThroughPages();
    }

    @Test(priority = 24)
    public void verifyAddClaimPageDropDown(){
        AddClaimPage adP=new AddClaimPage(driver);
        adP.clickManageClaimIcon();
        adP.clickOnAddClaimIcon();
        adP.verifyDropDownItems();
        adP.verifyCalender();
    }


}
