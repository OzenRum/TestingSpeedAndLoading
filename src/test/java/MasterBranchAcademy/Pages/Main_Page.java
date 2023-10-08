package MasterBranchAcademy.Pages;

import MasterBranchAcademy.Utilities.Config_Reader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Main_Page {

    @FindBy (className = ".form-control.input-lg")
    private  WebElement searchBox;

    @FindBy (className = ".btn.btn-default.btn-lg")
    private WebElement searchButton;

    /////methods/////
    public void aramaYapmaIslemi(){

      searchBox.sendKeys(Config_Reader.getProperties("urun"));
      searchButton.click();
    }



}
