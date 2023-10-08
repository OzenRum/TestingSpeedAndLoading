package MasterBranchAcademy.TestCase_1;

import MasterBranchAcademy.Pages.Login_Page;
import MasterBranchAcademy.Utilities.Base_Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Speed_of_loading_of_main_page extends Base_Test {
    Login_Page loginPage = new Login_Page();

    @Test
    public void loginPageTest() throws InterruptedException {

        loginPage.login_islemi();
        extentLogger = reports.createTest("Login Test Report");

        String expectedHeader = "My Account";
        String actualHeader = loginPage.myaccountheader.getText();
        System.out.println(actualHeader);

        extentLogger.info("User sees headline");
        Assert.assertEquals(actualHeader,expectedHeader,"My account text'i goruntulenemedi");
    }
}
