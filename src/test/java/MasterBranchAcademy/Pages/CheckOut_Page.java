package MasterBranchAcademy.Pages;

import MasterBranchAcademy.Utilities.Config_Reader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.ConfigurationGroupMethods;

import java.awt.*;

public class CheckOut_Page extends Page_Object {
    @FindBy(id = "cart-total")
    public WebElement itemsButton;
    @FindBy(xpath= "//*[@id=\"top-links\"]/ul/li[5]/a/i")
    public WebElement checkoutButton;
    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameBox;
    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameBox;
    @FindBy(id = "input-payment-company")
    private WebElement companyNameBox;
    @FindBy(id = "input-payment-address-1")
    private WebElement address1Box;
    @FindBy(id = "input-payment-address-2")
    private WebElement address2Box;
    @FindBy(id = "input-payment-city")
    private WebElement cityBox;
    @FindBy(id = "input-payment-city")
    private WebElement postcodeBox;
    @FindBy(id = "input-payment-country")
    private WebElement countryBox;
    @FindBy(id = "input-payment-zone")
    private WebElement regionBox;
    @FindBy(className = "btn.btn-primary")
    private WebElement continueButton;
    @FindBy(xpath = "(//p)[3]")
    private WebElement textArea;
    @FindBy(xpath = "(//input)[14]")
    private WebElement checkBox;
    @FindBy(xpath = "//*[@id='button-payment-method']")
    private WebElement continueButton2;

//methods//
    public void goToCheckOut() throws InterruptedException {
        itemsButton.click();
        checkoutButton.click();
        Thread.sleep(1000);
    }

    public void fillingBillDetails(){
        firstNameBox.sendKeys(Config_Reader.getProperties("FirstName"));
        lastNameBox.sendKeys(Config_Reader.getProperties("LastName"));
        companyNameBox.sendKeys(Config_Reader.getProperties("CompanyName"));
        address1Box.sendKeys(Config_Reader.getProperties("address1"));
        address2Box.sendKeys(Config_Reader.getProperties("address2"));
        cityBox.sendKeys(Config_Reader.getProperties("City"));
        postcodeBox.sendKeys(Config_Reader.getProperties("PostCode"));
        countryBox.sendKeys(Config_Reader.getProperties("Country"));
        regionBox.sendKeys(Config_Reader.getProperties("Region"));

        continueButton.click();
    }
    public void paymentMethodPart(){
        textArea.sendKeys(Config_Reader.getProperties("Payment Method"));
        continueButton2.click();
    }


}
