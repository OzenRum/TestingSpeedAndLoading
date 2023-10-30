package MasterBranchAcademy.TestCases;

import MasterBranchAcademy.Pages.Main_Page;
import MasterBranchAcademy.Pages.Login_Page;
import MasterBranchAcademy.Pages.Products_Page;
import MasterBranchAcademy.Utilities.Base_Test;
import MasterBranchAcademy.Utilities.Config_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Speed_of_adding_to_chart extends Base_Test {

    Login_Page loginPage = new Login_Page();
    Main_Page anasayfa = new Main_Page();
    Products_Page productsPage = new Products_Page();

    @Test
    public void addToChartSpeedtest() throws InterruptedException {
        extentLogger.info("User does login into Website with his account info");
        loginPage.login_islemi();

        extentLogger.info("User search a product");
        anasayfa.aramaYapmaIslemi();

        Assert.assertTrue(productsPage.listViewOptionBox.isDisplayed());

        extentLogger.info("User adds product into his cart");
        productsPage.addToCart.click();

        extentLogger.info("User goes to chart");
        productsPage.items();
        String dynamicUrunIsmi = Config_Reader.getProperties("urun");
        Assert.assertTrue(productsPage.itemsDetails.getText().contains(dynamicUrunIsmi));
    }
}
