package MasterBranchAcademy.TestCases;

import MasterBranchAcademy.Pages.CheckOut_Page;
import MasterBranchAcademy.Utilities.Base_Test;
import org.testng.annotations.Test;

public class Speed_of_creating_order extends Base_Test {
    CheckOut_Page checkOutPage = new CheckOut_Page();

    @Test
    public void creatingOrder() throws InterruptedException {
        extentLogger.info("User goes to checkOut page");
        checkOutPage.goToCheckOut();
        extentLogger.info("User fills the boxes");
        checkOutPage.fillingBillDetails();

        //In this step we got BUG. User can not go to next step.
        // There is a Bug ticket for more infotmation (https://trello.com/c/dFBBBajx)

    }











}
