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
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:submit"))).click();
    }

    @Then("Find purchaser details with tin {string}")
    public void findPurchaserDetailsWithTin(String tin) throws Throwable {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("GstExemptTaxCertificate:findPurchaser"))).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
        verify_error_message("At least one field is required");
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
        driver.findElement(By.xpath("//*[@id=\"GstExemptTaxCertificate:DocumentType\"]/div[3]")).click();
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
}



