package MasterBranchAcademy.Pages;

import MasterBranchAcademy.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class Page_Object {

        public Page_Object() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
    }
