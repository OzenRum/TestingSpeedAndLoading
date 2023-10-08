package MasterBranchAcademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends Page_Object {


    @FindBy(id = "#list-view")
    public WebElement listViewOptionBox;
    @FindBy(xpath = "//button[@onclick='cart.add('43', '1');']")
    public WebElement addToCart;

    @FindBy(id = "cart-total")
    public WebElement itemsButton;

    @FindBy (xpath = "//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/a")
    public WebElement itemsDetails;

    //methods//

    public void items(){
        itemsButton.click();
    }
}
