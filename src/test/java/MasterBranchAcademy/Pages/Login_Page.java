package MasterBranchAcademy.Pages;

import MasterBranchAcademy.Utilities.Config_Reader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Page_Object{

    @FindBy (id = "input-email")
    private WebElement mailadress;
    @FindBy (id = "input-password")
    private WebElement password;
    @FindBy (xpath = "//input[@class='btn btn-primary']")
    private WebElement loginButton;
    @FindBy (xpath = "(//h2)[1]")
  public WebElement myaccountheader;

    //methods//
    public void login_islemi() throws InterruptedException {
        mailadress.sendKeys(Config_Reader.getProperties("mail"));
        password.sendKeys(Config_Reader.getProperties("password"));
        loginButton.click();
        Thread.sleep(1000);

    }
}
