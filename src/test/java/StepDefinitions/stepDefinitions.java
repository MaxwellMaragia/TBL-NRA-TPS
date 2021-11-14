package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten;
    public WebDriverWait fifteen;
    public WebDriverWait twenty;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public Actions actions;
    public JavascriptExecutor jse;


    public static sharedatastep sharedata;


    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver.get(Pro.getProperty("NRA_BackOffice_URL"));
        driver.manage().window().maximize();
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.id("loginForm:j_idt18")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();
    }

    public void switchToFrameBackoffice(){
        WebElement frame = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to backoffice frame")
    public void switchToBoFrame() {
        switchToFrameBackoffice();
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @And("Click on Taxpayer services > Certificate Types > Create certificate request")
    public void clickOnTaxpayerServicesCertificateTypesCreateCertificateRequest() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Services']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Certificate Types']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[1]/a"))).click();
    }

    @Then("Select certificate {string}")
    public void selectCertificates(String certificate) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CertificateTypeForm:certiticateType\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + certificate + "')]")).click();
    }

    @Then("Click next button")
    public void clickNextButton() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("CertificateTypeForm:j_idt36"))).click();
    }

    @Then("Click submit button for GST Excemption")
    public void clickSubmitButtonGST() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:submit"))).click();
    }

    @Then("Find purchaser details with tin {string}")
    public void findPurchaserDetailsWithTin(String tin) throws Throwable {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:findPurchaser"))).click();
        switchToFrameBackoffice();
//        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
//        verify_error_message("At least one field is required");
        driver.findElement(By.id("SearchForm:accountNumber")).sendKeys(tin);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
        Thread.sleep(1000);
        switchToDefault();
        Thread.sleep(5000);
    }

    @Then("Find suppliers details with tin {string}")
    public void findSuppliersDetailsWithTin(String tin) throws Throwable {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:findSupplier"))).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
        verify_error_message("At least one field is required");
        driver.findElement(By.id("SearchForm:accountNumber")).sendKeys(tin);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
        switchToDefault();
    }

    @Then("Enter GST Excemptions for project number")
    public void enterGSTExcemptionsForProjectNumber() throws InterruptedException {
        Thread.sleep(2000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:VatFreeProjectNo"))).sendKeys(String.valueOf(timestamp.getTime()));
        //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:VatFreeProjectNo"))).sendKeys("34");
        Thread.sleep(1000);
    }

    @Then("Add GST Exempt Project Details")
    public void addGSTExemptProjectDetails() throws Throwable {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:goodsAndServicesTable:AddGS"))).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("VatFreeGoodsAndServices:Ok"))).click();
        verify_error_message("Proforma Invoice/Quotation: Validation Error: Value is required.");
        verify_error_message("Date: Validation Error: Value is required.");
        verify_error_message("Description of Goods: Validation Error: Value is required.");
        verify_error_message("Code: Validation Error: Value is required.");
        verify_error_message("Unit Price: Validation Error: Value is required.");
        verify_error_message("Quantity: Validation Error: Value is required.");
        verify_error_message("Value in SLL: Validation Error: Value is required.");
        verify_error_message("GST to be Exempted SLL: Validation Error: Value is required.");
        driver.findElement(By.id("VatFreeGoodsAndServices:ProformaInvoice_input")).sendKeys(String.valueOf(timestamp.getTime()));
        driver.findElement(By.id("VatFreeGoodsAndServices:Date_input")).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        driver.findElement(By.id("VatFreeGoodsAndServices:DescOfGoods")).sendKeys("Raw materials");
        driver.findElement(By.id("VatFreeGoodsAndServices:Code")).sendKeys(String.valueOf(timestamp.getTime()));
        driver.findElement(By.id("VatFreeGoodsAndServices:UnitPrice_input")).sendKeys("1200");
        driver.findElement(By.id("VatFreeGoodsAndServices:Quantity_input")).sendKeys("3");
        driver.findElement(By.id("VatFreeGoodsAndServices:Value_input")).sendKeys("12000");
        driver.findElement(By.id("VatFreeGoodsAndServices:VatToBeExempted_input")).sendKeys("5000");
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("VatFreeGoodsAndServices:Ok"))).click();
        switchToDefault();
    }

    @Then("The goods listed above are eligible for entry under Customs Procedure Code No?")
    public void theGoodsListedAboveAreEligibleForEntryUnderCustomsProcedureCodeNo() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:GoodsEligibleEntryUnderCustoms_input"))).sendKeys("23");
//        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:GoodsEligibleEntryUnderCustoms_input"))).sendKeys(String.valueOf(timestamp.getTime()));
        Thread.sleep(1500);
    }

    @Then("Enter procedue code number")
    public void enterProcedueCodeNumber() throws InterruptedException {
        //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:GoodsEligibleEntryUnderCustoms_input"))).sendKeys(String.valueOf(timestamp.getTime()));
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:GoodsEligibleEntryUnderCustoms_input"))).sendKeys("23");
        Thread.sleep(1500);
    }

    @Then("Enter exclusive use for")
    public void enterExclusiveUseForBy() throws InterruptedException {

        driver.findElement(By.id("GstExemptTaxCertificate:ForExclusiveUse")).sendKeys("SL TEAM");
        Thread.sleep(1500);
    }

    @Then("Enter place of use as {string}")
    public void enterPlaceOfUseAs(String pou) throws InterruptedException {
        driver.findElement(By.id("GstExemptTaxCertificate:Placeofuse")).sendKeys(pou);
        Thread.sleep(1500);
    }

    @Then("Enter physical address")
    public void enterPhysicalAddress() throws InterruptedException {
        driver.findElement(By.id("GstExemptTaxCertificate:PhysicalAddress")).sendKeys("BOMTO");
        Thread.sleep(1500);
    }

    @Then("Enter amount paid as {string}")
    public void enterAmountPaidAs(String amount) throws InterruptedException {
        driver.findElement(By.id("GstExemptTaxCertificate:AmountPaid_input")).sendKeys(amount);
        Thread.sleep(1500);
    }

    @Then("Enter receipt number")
    public void enterReceiptNumber() throws InterruptedException {
        driver.findElement(By.id("GstExemptTaxCertificate:RecieptNumber")).sendKeys(String.valueOf(timestamp.getTime()));
        Thread.sleep(1500);
    }

    @Then("Are bills of Quantity certified? {string}")
    public void areBillsOfQuantityCertified(String arg) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"GstExemptTaxCertificate:BillsofQuantityCertified\"]/div[3]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + arg + "')]")).click();
    }

    @Then("Select certifier with tin {string}")
    public void selectCertifierWithTin(String tin) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:findTin"))).click();
        switchToFrameBackoffice();
        driver.findElement(By.id("SearchForm:accountNumber")).sendKeys(tin);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
        switchToDefault();
    }

    @Then("Enter attachment {string}")
    public void enterAttachment(String attachment) throws InterruptedException {
        Thread.sleep(1500);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GstExemptTaxCertificate:DocumentType\"]/div[3]"))).click();
        Thread.sleep(1500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(1500);
        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + attachment;
        driver.findElement(By.id("GstExemptTaxCertificate:AttachmentPath_input")).sendKeys(path);
        Thread.sleep(1500);
        driver.findElement(By.id("GstExemptTaxCertificate:DocReference")).sendKeys(String.valueOf(timestamp.getTime()));
    }

    @Then("Enter details of person making application")
    public void enterDetailsOfPersonMakingApplication() throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:FullName"))).sendKeys("Margie "+getRandom(5));
        Thread.sleep(1500);
        driver.findElement(By.id("GstExemptTaxCertificate:Designation")).sendKeys("Software developer");
        Thread.sleep(1500);
        driver.findElement(By.id("GstExemptTaxCertificate:NID")).sendKeys("a");
        Thread.sleep(1500);
        driver.findElement(By.id("GstExemptTaxCertificate:IdentificationNumber")).sendKeys(String.valueOf(timestamp.getTime()));
        Thread.sleep(1500);

    }


    @Then("Obtain GST Excemption ARN {string}")
    public void obtainGSTExcemptionARN(String success) throws InterruptedException {
        String text  = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Processing Completed - Reference Number - NRA/BOMTO/CR/000009
        System.out.println(text);

        System.out.println("Certificate Request Case Reference Number is " +text.substring(42));
        sharedatastep.REF = text.substring(42);
        Thread.sleep(2000);
    }

    @And("Click on Taxpayer services > FAQs > Create FAQ")
    public void clickOnTaxpayerServicesFAQsCreateFAQ() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Services']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='FAQs']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[1]/a"))).click();
    }

    @Then("Verify all fields and dropdown values and select category as {string}")
    public void verifyAllFieldsAndDropdownValuesAndSelectCategoryAs(String category) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FaqForm:Section\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Exemptions')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'General')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Objections and Appeals')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Payments')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Portal')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Refunds')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Registration')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Tax Returns')]"))).isDisplayed();
        driver.findElement(By.xpath("//li[contains(text(),'" + category + "')]")).click();

    }

    @Then("Enter random FAQ and answer")
    public void enterRandomFAQAndAnswer() {
        sharedatastep.FAQ = "How to file returns for "+getRandom(6)+ " Taxtype";
        driver.findElement(By.id("FaqForm:FAQ")).sendKeys(sharedatastep.FAQ);
        driver.findElement(By.id("FaqForm:Answer")).sendKeys(getRandom(8));
        System.out.println("FAQ saved is");
        System.out.println("..............................................................");
        System.out.println(sharedatastep.FAQ);
    }

    @Then("Submit FAQ")
    public void submitFAQ() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FaqForm:j_idt42"))).click();
    }

    @And("Click on Taxpayer services > FAQs > Update FAQ")
    public void clickOnTaxpayerServicesFAQsUpdateFAQ() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Services']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='FAQs']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[2]/a"))).click();
    }

    @Then("Search for FAQ")
    public void searchForFAQ() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt40"))).click();
    }

    @Then("Enter Invalid FAQ details")
    public void enterInvalidFAQDetails() {
        driver.findElement(By.id("SearchForm:faq")).sendKeys(getRandom(6));
    }

    @Then("Enter valid FAQ")
    public void enterValidFAQ() {
        driver.findElement(By.id("SearchForm:faq")).clear();
        driver.findElement(By.id("SearchForm:faq")).sendKeys(sharedatastep.FAQ);
    }

    @Then("Verify FAQ found and displayed in table")
    public void verifyFAQFoundAndDisplayedInTable() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'"+sharedatastep.FAQ+"')]"))).isDisplayed();
    }

    @Then("Click edit button")
    public void clickEditButton() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.id("SearchForm:j_id15")).click();
    }


    @Then("Enter new random answer")
    public void enterNewRandomAnswer() {
        WebElement answer = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FaqForm:Answer")));
        answer.clear();
        answer.sendKeys(getRandom(7));
    }

    @Then("Click submit to update FAQ")
    public void clickSubmitToUpdateFAQ() {
        driver.findElement(By.id("FaqForm:j_idt42")).click();
    }

    @Then("Find tin for tax clearance {string}")
    public void findTinForTaxClearance(String tin) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TaxClearanceCertificate:FindTin"))).click();
        switchToFrameBackoffice();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        switchToDefault();

    }

    @Then("Enter transaction details {string}")
    public void enterTransactionDetails(String arg0) throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TaxClearanceCertificate:typeOfTransaction\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + arg0 + "')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("TaxClearanceCertificate:descriptionOfTransaction")).sendKeys("Change of ownership of a company.");
    }

    @Then("Enter period of assessment month {string} and year {string}")
    public void enterPeriodOfAssessmentMonthAndYear(String month, String year) throws InterruptedException {
        Thread.sleep(2000);
        WebElement dateField = driver.findElement(By.id("TaxClearanceCertificate:periodOfAssessment"));
        dateField.sendKeys(month+year);
        Thread.sleep(1000);

    }

    @Then("Enter attachment details")
    public void enterAttachmentDetails() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"TaxClearanceCertificate:documentType\"]/div[3]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'Application Letter')]")).click();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        driver.findElement(By.id("TaxClearanceCertificate:documentNameNumber")).sendKeys(String.valueOf(timestamp.getTime()));

        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
        driver.findElement(By.id("TaxClearanceCertificate:AttachmentPath_input")).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.id("TaxClearanceCertificate:notes")).sendKeys("Change of ownership of a company.");

    }

    @Then("Enter details of person making the application")
    public void enterDetailsOfPersonMakingTheApplication() {
        driver.findElement(By.id("TaxClearanceCertificate:personName")).sendKeys("Margie Wambui");
        driver.findElement(By.id("TaxClearanceCertificate:designation")).sendKeys("Engineer");

    }

    @Then("Submit certificate request application")
    public void submitCertificateRequestApplication() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TaxClearanceCertificate:Submit"))).click();
    }

    @Then("Obtain Certificate Request ARN {string}")
    public void obtainCertificateRequestARN(String success) throws InterruptedException {
        String text  = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Processing Completed - Reference Number - NRA/BOMTO/CR/000009
        System.out.println(text);

        System.out.println("Certificate Request Case Reference Number is " +text.substring(42));
        sharedatastep.REF = text.substring(42);
        Thread.sleep(2000);
    }

    @Then("find tin for withholding tax excemption {string}")
    public void findTinForWithholdingTaxExcemption(String tin) {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("WithholdingTaxExemptionCertificate:findTin"))).click();
        switchToFrameBackoffice();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        switchToDefault();
    }

    @Then("fill in witholding tax excemption details")
    public void fillInWitholdingTaxExcemptionDetails() throws InterruptedException {
        Thread.sleep(1000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"WithholdingTaxExemptionCertificate:natureIncome\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Technical fees')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("WithholdingTaxExemptionCertificate:descNatureIncome")).sendKeys("Technical fees");
        Thread.sleep(600);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"WithholdingTaxExemptionCertificate:reason\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Bilateral Agreement between Govts')]")).click();

    }

    @Then("Enter attachment details for Withholding Tax Exemption Certificate Application")
    public void enterAttachmentDetailsForWithholdingTaxExemptionCertificateApplication() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"WithholdingTaxExemptionCertificate:DocType\"]/div[3]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'Exemption Approval Letter')]")).click();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        driver.findElement(By.id("WithholdingTaxExemptionCertificate:docReference")).sendKeys(String.valueOf(timestamp.getTime()));

        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
        driver.findElement(By.id("WithholdingTaxExemptionCertificate:AttachmentPath_input")).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.id("WithholdingTaxExemptionCertificate:Notes")).sendKeys("Exemption Approval Letter");

    }

    @Then("Enter details of person making the application for Withholding Tax Exemption Certificate Application")
    public void enterDetailsOfPersonMakingTheApplicationForWithholdingTaxExemptionCertificateApplication() {
        driver.findElement(By.id("WithholdingTaxExemptionCertificate:declarantName")).sendKeys("Margie Wambui");
        driver.findElement(By.id("WithholdingTaxExemptionCertificate:declarantPosition")).sendKeys("Engineer");

    }

    @Then("Submit withholding tax excemption application")
    public void submitWithholdingTaxExcemptionApplication() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("WithholdingTaxExemptionCertificate:submit"))).click();
    }

    @And("Click on Taxpayer services > Certificate Types > Track request status")
    public void clickOnTaxpayerServicesCertificateTypesTrackRequestStatus() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Services']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Certificate Types']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[3]/a"))).click();

    }

    @Then("Enter ref number")
    public void enterRefNumber() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TrackRequestStatusForm:trackingNumber"))).sendKeys(sharedatastep.REF);
        driver.findElement(By.id("TrackRequestStatusForm:j_idt34")).click();
    }

    @Then("Verify status {string}")
    public void verifyApproval(String status) {
        String application_status = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TrackRequestStatusForm:status"))).getAttribute("value");
        Assert.assertEquals(status, application_status);
    }

    @Given("User navigates to portal")
    public void userNavigatesToPortal() {
        driver.get(Pro.getProperty("NRA_Portal_URL"));
        driver.manage().window().maximize();
    }

    @Then("Enters the username {string} and password {string} to login to portal")
    public void entersTheUsernameAndPasswordToLoginToPortal(String username, String password) {

        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_userName"))).sendKeys(username);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_password"))).sendKeys(password);
        driver.findElement(By.id("btnSubmit")).click();

    }

    @And("Navigate to my tax > Certificate request")
    public void navigateToMyTaxCertificateRequest() throws InterruptedException {
        WebElement mytax = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnMyTax")));
        jse.executeScript("arguments[0].click()", mytax);
        WebElement certRequest =fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnCertRequest")));
        jse.executeScript("arguments[0].click()", certRequest);

    }

    @Then("Select Certificate type {string} and transaction type {string}")
    public void selectCertificateTypeAndTransactionType(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(3000);
        WebElement certDropDown = sixty.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_certificateSelectForm\"]/div[1]/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", certDropDown);
        Thread.sleep(1000);
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span='"+arg0+"']"))).click();

        WebElement certcat = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_certificateSelectForm\"]/div[2]/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", certcat);
        Thread.sleep(1000);
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span='"+arg1+"']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnContinue")).click();
    }

    @Then("Enter tin as {string}")
    public void enterTinAs(String tin) throws InterruptedException {
        WebElement tinField = thirty.until(ExpectedConditions.elementToBeClickable(By.id("id_tin")));
        jse.executeScript("arguments[0].scrollIntoView(true);", tinField);
        tinField.sendKeys(tin);
        Thread.sleep(900);
    }

    @And("Taxpayer name as {string}")
    public void taxpayerNameAs(String names) throws InterruptedException {
        WebElement nameField = thirty.until(ExpectedConditions.elementToBeClickable(By.id("id_taxpayerName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.sendKeys(names);
        Thread.sleep(900);
    }

    @And("Trading name as {string}")
    public void tradingNameAs(String tradingName) throws InterruptedException {
        WebElement tradingNameField = thirty.until(ExpectedConditions.elementToBeClickable(By.id("id_tradingName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", tradingNameField);
        tradingNameField.sendKeys(tradingName);
        Thread.sleep(900);
    }

    @And("Email as {string}")
    public void emailAs(String email) throws InterruptedException {
        WebElement emailField = thirty.until(ExpectedConditions.elementToBeClickable(By.id("id_email")));
        jse.executeScript("arguments[0].scrollIntoView(true);", emailField);
        emailField.sendKeys(email);
        Thread.sleep(900);
    }

    @And("Contact number as {string}")
    public void contactNumberAs(String mobile) throws InterruptedException {
        WebElement mobileField = thirty.until(ExpectedConditions.elementToBeClickable(By.id("id_contactNumber")));
        jse.executeScript("arguments[0].scrollIntoView(true);", mobileField);
        mobileField.sendKeys(mobile);
        Thread.sleep(900);
    }

    @And("Postal address as {string}")
    public void postalAddressAs(String address) throws InterruptedException {
        WebElement addressField = driver.findElement(By.id("id_postalAddress"));
        jse.executeScript("arguments[0].scrollIntoView(true);", addressField);
        addressField.sendKeys(address);
        Thread.sleep(900);
    }

    @Then("Enter transaction details description {string}")
    public void enterTransactionDetailsDescription(String desc) throws InterruptedException {
        driver.findElement(By.id("id_description")).sendKeys(desc);
        Thread.sleep(900);
    }

    @Then("Enter assessment date as {string}")
    public void enterAssessmentDateAs(String date) throws InterruptedException {
        driver.findElement(By.id("id_assessment")).sendKeys(date);
        Thread.sleep(900);
    }

    @Then("Click next to go to attachment details screen")
    public void clickNextToGoToAttachmentDetailsScreen() {
        driver.findElement(By.xpath("//*[@id=\"id_tccCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Enter attachment details \\(Portal) {string}")
    public void enterAttachmentDetailsPortal(String type) throws InterruptedException {
        WebElement dropdown = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_attachmentForm\"]/div/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", dropdown);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[span='"+type+"']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_reference\"]")).sendKeys(getRandom(8));
        Thread.sleep(1000);
        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
        driver.findElement(By.xpath("//*[@id=\"id_fileChoose\"]/div/div[2]/div/div/div[1]/span/input")).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.id("id_notes")).sendKeys("Notes "+getRandom(5));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_tccCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Submit portal Tax Clearance Certificate Application")
    public void submitPortalTaxClearanceCertificateApplication() {
        WebElement submit = onehundred.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_tccCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")));
        jse.executeScript("arguments[0].click()", submit);
    }

    @Then("Verify portal success message {string}")
    public void verifyPortalSuccessMessage(String success) {
        WebElement message = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + success + "')]")));
        Assert.assertTrue(message.isDisplayed());
    }


    @Then("Obtain Tax Clearance ref number {string}")
    public void obtainTaxClearanceRefNumber(String success) throws InterruptedException {
        String message = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + success + "')]"))).getText();
        //Your TCC Certificate request has been submitted successfully. Your reference number is: NRA/BOMTO/CR/000624

        System.out.println(message);

        System.out.println("Certificate Request Case Reference Number is " +message.substring(88));
        sharedatastep.PortalREF = message.substring(88);
        Thread.sleep(1000);
    }

    @Then("Navigate to my tax > View Certificate Request Status")
    public void navigateToMyTaxViewCertificateRequestStatus() {
        WebElement mytax = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnMyTax")));
        jse.executeScript("arguments[0].click()", mytax);
        WebElement certRequest =fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnCertRequestStatus")));
        jse.executeScript("arguments[0].click()", certRequest);
    }

    @Then("Enter request number")
    public void enterRequestNumber() throws InterruptedException {
        WebElement requestNumberField = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_RequestNumber")));
        jse.executeScript("arguments[0].scrollIntoView(true);", requestNumberField);
        requestNumberField.sendKeys(sharedatastep.PortalREF);
        Thread.sleep(900);
        driver.findElement(By.id("btnSubmit")).click();
    }

    @Then("Verify case request status {string}")
    public void verifyCaseRequestStatus(String status) {
        String application_status = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_ApplicationStatus"))).getAttribute("value");
        Assert.assertEquals(status, application_status);
    }

    @And("Navigate to my support > FAQ")
    public void navigateToMySupportFAQ() {
        WebElement support = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnSupportToggle")));
        jse.executeScript("arguments[0].click()", support);
        WebElement faq =fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_linkFaq")));
        jse.executeScript("arguments[0].click()", faq);
    }

    @Then("Verify all FAQ categories are displayed")
    public void verifyAllFAQCategoriesAreDisplayed() {
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Exemptions')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'General')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Objections and Appeals')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Payments')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Portal')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Refunds')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Registration')]"))).isDisplayed();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Tax Returns')]"))).isDisplayed();
    }

    @Then("Search for invalid faq")
    public void searchForInvalidFaq() throws InterruptedException {
        WebElement faqField = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_searchKey")));
        jse.executeScript("arguments[0].scrollIntoView(true);", faqField);
        faqField.sendKeys("type 75 sph");
        Thread.sleep(900);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'No documents were found matching the search criteria')]"))).isDisplayed();
        System.out.println("Invalid faq specified");
    }

    @Then("Search for valid faq")
    public void searchForValidFaq() {
        driver.findElement(By.id("id_searchKey")).clear();
        driver.findElement(By.id("id_searchKey")).sendKeys("How to file returns for grX8SW Taxtype");

        //driver.findElement(By.id("id_searchKey")).sendKeys(sharedatastep.FAQ);
        driver.findElement(By.xpath("//*[@id=\"id_faqsWidget\"]/div/div[1]/div[3]/a/i")).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'How to file returns for grX8SW Taxtype')]"))).isDisplayed();
        //ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+sharedatastep.FAQ+"')]"))).isDisplayed();
        System.out.println("Faq is valid");
    }

    @Then("Select GST Exempt Tax Certificate Application certificate {string}")
    public void selectGSTExemptTaxCertificateApplicationCertificate(String cert) throws InterruptedException {
        Thread.sleep(3000);
        WebElement certDropDown = sixty.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_certificateSelectForm\"]/div[1]/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", certDropDown);
        Thread.sleep(1000);
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span='"+cert+"']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnContinue")).click();
    }

    @Then("Enter purchaser tin {string} name {string} and address {string}")
    public void enterPurchaserTinNameAndAddress(String tin, String name, String address) throws InterruptedException {
        WebElement tinField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_purchaserTin")));
        jse.executeScript("arguments[0].scrollIntoView(true);", tinField);
        tinField.sendKeys(tin);
        Thread.sleep(900);

        WebElement nameField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_purchaserName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.sendKeys(name);
        Thread.sleep(900);

        WebElement addressField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_purchaserAddress")));
        jse.executeScript("arguments[0].scrollIntoView(true);", addressField);
        addressField.sendKeys(address);
        Thread.sleep(900);
    }


    @Then("Enter supplier tin {string} name {string} and address {string}")
    public void enterSupplierTinNameAndAddress(String tin, String name, String address) throws InterruptedException {
        WebElement tinField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_supplierTin")));
        jse.executeScript("arguments[0].scrollIntoView(true);", tinField);
        tinField.sendKeys(tin);
        Thread.sleep(900);

        WebElement nameField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_supplierName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.sendKeys(name);
        Thread.sleep(900);

        WebElement addressField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_supplierAddress")));
        jse.executeScript("arguments[0].scrollIntoView(true);", addressField);
        addressField.sendKeys(address);
        Thread.sleep(900);
    }

    @Then("Proceed to GST screen")
    public void proceedToGSTScreen() {
        driver.findElement(By.xpath("//*[@id=\"id_vat5_certificateForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Upload GST CSV template")
    public void uploadGSTCSVTemplate() throws InterruptedException {
        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "GSTCERTIFICATE.csv";
        driver.findElement(By.xpath("//*[@id=\"id_fileChoose\"]/span/span/div/input")).sendKeys(path);
        Thread.sleep(1000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'File uploaded successfully.')]"))).isDisplayed();
        Thread.sleep(5000);
    }

    @Then("Enter GST Excempt project number")
    public void enterGSTExcemptProjectNumber() throws InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        WebElement excemptProjectNumberField = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_vatFreeProjectNum")));
        jse.executeScript("arguments[0].scrollIntoView(true);", excemptProjectNumberField);
        excemptProjectNumberField.sendKeys(String.valueOf(timestamp.getTime()));
        Thread.sleep(900);
    }

    @Then("Enter custom procedue code number")
    public void enterCustomProcedueCodeNumber() throws InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        WebElement field = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_customProcedureCodeNum")));
        jse.executeScript("arguments[0].scrollIntoView(true);", field);
        field.sendKeys(String.valueOf(timestamp.getTime()));
        Thread.sleep(900);
    }

    @Then("Fill in use by field {string}")
    public void fillInUseByField(String arg0) throws InterruptedException {
        WebElement field = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_forExclusiveUseBy")));
        jse.executeScript("arguments[0].scrollIntoView(true);", field);
        field.sendKeys(arg0);
        Thread.sleep(900);
    }

    @Then("Give place of use {string}")
    public void givePlaceOfUse(String arg0) throws InterruptedException {
        WebElement field = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_placeOfUse")));
        jse.executeScript("arguments[0].scrollIntoView(true);", field);
        field.sendKeys(arg0);
        Thread.sleep(900);
    }

    @Then("Give physical address {string}")
    public void givePhysicalAddress(String arg0) throws InterruptedException {
        WebElement field = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_physicalAddress")));
        jse.executeScript("arguments[0].scrollIntoView(true);", field);
        field.sendKeys(arg0);
        Thread.sleep(900);
    }


    @Then("Enter processing fees and receipt number")
    public void enterProcessingFeesAndReceiptNumber() throws InterruptedException {
        WebElement amount = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_amountPaid")));
        jse.executeScript("arguments[0].scrollIntoView(true);", amount);
        amount.sendKeys("10000");
        Thread.sleep(900);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        WebElement receipt = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_recieptNumber")));
        jse.executeScript("arguments[0].scrollIntoView(true);", receipt);
        receipt.sendKeys(String.valueOf(timestamp.getTime()));
        Thread.sleep(900);
    }

    @Then("Enter bill of quantity surveyor details")
    public void enterBillOfQuantitySurveyorDetails() throws InterruptedException {
        driver.findElement(By.id("id_quantitySurveyorName")).sendKeys("DR Jane Wangare");
        Thread.sleep(900);
        driver.findElement(By.id("id_qualifications")).sendKeys("Accountant");
        Thread.sleep(900);
        driver.findElement(By.id("id_postalAddress")).sendKeys("Kenema,  Kenema,  East,  Sierra Leone");
        Thread.sleep(900);
        driver.findElement(By.id("id_contactNumber")).sendKeys("+254707338839");
        Thread.sleep(900);
        driver.findElement(By.id("id_emailAddress")).sendKeys("wangare@accounting.com");
        Thread.sleep(900);

    }

    @Then("Proceed to attachment details screen")
    public void proceedToAttachmentDetailsScreen() {
        driver.findElement(By.xpath("//*[@id=\"id_vat5_certificateForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Enter attachment details for GST \\(portal)")
    public void enterAttachmentDetailsForGSTPortal() throws InterruptedException {
        WebElement dropdown = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_attachmentForm\"]/div/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", dropdown);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='Letter from Quantity Surveyor certifying ST14 Application']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_reference\"]")).sendKeys(getRandom(8));
        Thread.sleep(1000);

        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
        driver.findElement(By.xpath("//*[@id=\"id_fileChoose\"]/div/div[2]/div/div/div[1]/span/input")).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.id("id_notes")).sendKeys("Notes "+getRandom(5));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_vat5_certificateForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Enter details of person making the application \\(GST portal)")
    public void enterDetailsOfPersonMakingTheApplicationGSTPortal() throws InterruptedException {
        WebElement amount = ten.until(ExpectedConditions.elementToBeClickable(By.id("id_fullName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", amount);
        amount.sendKeys("DR Mungai");
        Thread.sleep(900);

        driver.findElement(By.id("id_designation")).sendKeys("Doctor");
        Thread.sleep(900);
        driver.findElement(By.id("id_identificationNumber")).sendKeys(getRandom(8));
        Thread.sleep(900);
        driver.findElement(By.xpath("//*[@id=\"id_vat5_certificateForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();

    }

    @Then("Submit GST Excemption certificate application \\(Portal)")
    public void submitGSTExcemptionCertificateApplicationPortal() {
        WebElement field = fourty.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_vat5_certificateForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")));
        jse.executeScript("arguments[0].click()", field);
    }

    @Then("Obtain GST Excemption Certificate ref number {string}")
    public void obtainGSTExcemptionCertificateRefNumber(String success) throws InterruptedException {
        String message = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + success + "')]"))).getText();
        //Your GST Certificate request has been submitted successfully. Your reference number is: NRA/BOMTO/CR/000014

        System.out.println(message);

        System.out.println("Certificate Request Case Reference Number is " +message.substring(88));
        sharedatastep.PortalREF = message.substring(88);
        Thread.sleep(1000);
    }

    @Then("Select Withholding Tax Exemption Certificate Application certificate {string}")
    public void selectWithholdingTaxExemptionCertificateApplicationCertificate(String cert) throws InterruptedException {
        Thread.sleep(3000);
        WebElement certDropDown = sixty.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_certificateSelectForm\"]/div[1]/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", certDropDown);
        Thread.sleep(1000);
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span='"+cert+"']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnContinue")).click();
    }

    @Then("Select nature of income as {string}")
    public void selectNatureOfIncomeAs(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        WebElement certDropDown = sixty.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_whtec_exemptionDetailsForm\"]/div[1]/div/fieldset/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", certDropDown);
        Thread.sleep(1000);
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span='"+arg0+"']"))).click();
        Thread.sleep(1000);
    }

    @Then("Type description of nature of income")
    public void typeDescriptionOfNatureOfIncome() {
        driver.findElement(By.id("id_description")).sendKeys("Test ten "+getRandom(6));
    }


    @Then("Select reason for applying excemption as {string} and click next")
    public void selectReasonForApplyingExcemptionAsAndClickNext(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        WebElement certDropDown = driver.findElement(By.xpath("//*[@id=\"id_whtec_exemptionDetailsForm\"]/div[1]/div/fieldset/tb-dropdown-with-othertext/div/div[2]/p-dropdown/div/div[3]"));
        jse.executeScript("arguments[0].click()", certDropDown);
        Thread.sleep(1000);
        fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span='"+arg0+"']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_whtecCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Enter attachment details for WHT excemption")
    public void enterAttachmentDetailsForWHTExcemption() throws InterruptedException {
        WebElement dropdown = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_attachmentForm\"]/div/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", dropdown);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='Bilateral Agreement between Govts']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_reference\"]")).sendKeys(getRandom(8));
        Thread.sleep(1000);

        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
        driver.findElement(By.xpath("//*[@id=\"id_fileChoose\"]/div/div[2]/div/div/div[1]/span/input")).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.id("id_notes")).sendKeys("Notes "+getRandom(5));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_whtecCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Enter details of person making the application \\(WHT Excemption portal)")
    public void enterDetailsOfPersonMakingTheApplicationWHTExcemptionPortal() throws InterruptedException {
        WebElement tinField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_declarantName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", tinField);
        tinField.sendKeys("Margie Wambui");
        Thread.sleep(900);

        WebElement nameField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_designation")));
        jse.executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.sendKeys("Doctor");
        Thread.sleep(900);

        driver.findElement(By.xpath("//*[@id=\"id_whtecCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Submit WHT excemption certificate application")
    public void submitWHTExcemptionCertificateApplication() {
        WebElement field = fourty.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_whtecCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")));
        jse.executeScript("arguments[0].click()", field);
    }

    @Then("Obtain WHT Excemption Certificate ref number {string}")
    public void obtainWHTExcemptionCertificateRefNumber(String success) throws InterruptedException {
        String message = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + success + "')]"))).getText();
        //Your WHTEC Certificate request has been submitted successfully. Your reference number is: NRA/BOMTO/CR/000661

        System.out.println(message);

        System.out.println("Certificate Request Case Reference Number is " +message.substring(90));
        sharedatastep.PortalREF = message.substring(90);
        Thread.sleep(1000);
    }

    @Then("Enter transaction and assessment details {string}")
    public void enterTransactionAndAssessmentDetails(String arg0) throws InterruptedException {
        WebElement tinField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_description")));
        jse.executeScript("arguments[0].scrollIntoView(true);", tinField);
        tinField.sendKeys("Test details - "+getRandom(5));
        Thread.sleep(900);

        WebElement nameField = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_assessment")));
        jse.executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.sendKeys(arg0);
        Thread.sleep(900);

        driver.findElement(By.xpath("//*[@id=\"id_tccCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();
    }

    @Then("Enter transfer details with tin {string}")
    public void enterTransferDetailsWithTin(String tin) throws InterruptedException {
        WebElement ref = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_returnRefNumber")));
        jse.executeScript("arguments[0].scrollIntoView(true);", ref);
        ref.sendKeys(getRandom(5));
        Thread.sleep(900);

        WebElement assetNumber = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_assetNumber")));
        jse.executeScript("arguments[0].scrollIntoView(true);", assetNumber);
        assetNumber.sendKeys(getRandom(5));
        Thread.sleep(900);

        WebElement holderName = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_leaseHolderName")));
        jse.executeScript("arguments[0].scrollIntoView(true);", holderName);
        holderName.sendKeys("Margie Wambui");
        Thread.sleep(900);

        WebElement titleNumber = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_titleNumber")));
        jse.executeScript("arguments[0].scrollIntoView(true);", titleNumber);
        titleNumber.sendKeys(getRandom(5));
        Thread.sleep(900);

        driver.findElement(By.id("id_plotNumber")).sendKeys(getRandom(5));
        Thread.sleep(900);

        driver.findElement(By.id("id_location")).sendKeys(getRandom(5));
        Thread.sleep(900);

        driver.findElement(By.id("id_physicalAddress")).sendKeys(getRandom(5));
        Thread.sleep(900);

        WebElement dropdown = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_tcc_transferDetailsForm\"]/div/div[1]/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]")));
        jse.executeScript("arguments[0].click()", dropdown);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='Cafeteria']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("id_tin")).sendKeys(tin);
        Thread.sleep(900);

        driver.findElement(By.id("id_taxpayerName")).sendKeys("DR Maxipain DAOhst");
        Thread.sleep(900);

        driver.findElement(By.id("id_contactNumber")).sendKeys("254768998856");
        Thread.sleep(900);

        driver.findElement(By.id("id_email")).sendKeys("margiewambui11@gmail.com");
        Thread.sleep(900);

        driver.findElement(By.id("id_postalAddress")).sendKeys("Kenema,  Kenema,  East,  Sierra Leone");
        Thread.sleep(900);

        driver.findElement(By.xpath("//*[@id=\"undefined\"]")).sendKeys("2013");
        Thread.sleep(900);

        driver.findElement(By.id("id_costPrice")).sendKeys("20000");
        Thread.sleep(900);

        driver.findElement(By.id("id_costOfImprovements")).sendKeys("20000");
        Thread.sleep(900);

        driver.findElement(By.id("id_sellingPrice")).sendKeys("50000");
        Thread.sleep(900);

        driver.findElement(By.id("id_valuation")).sendKeys("50000");
        Thread.sleep(900);

        driver.findElement(By.id("id_capitalGainLoss")).sendKeys("0");
        Thread.sleep(900);

        driver.findElement(By.id("id_taxPaid")).sendKeys("0");
        Thread.sleep(900);

        driver.findElement(By.id("id_RecieptNumber")).sendKeys(getRandom(5));
        Thread.sleep(900);

        driver.findElement(By.xpath("//*[@id=\"id_tccCertForm\"]/form-wizard/div/div/div[5]/div/div[3]/div/button[2]")).click();

    }
}



