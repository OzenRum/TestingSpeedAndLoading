package MasterBranchAcademy.TestCase_2;

import MasterBranchAcademy.Pages.Main_Page;
import MasterBranchAcademy.Utilities.Base_Test;
import org.testng.annotations.Test;

public class Speed_of_searching extends Base_Test {

    Main_Page anasayfa=new Main_Page();
    @Test
    public void searchspeedTest (){
        extentLogger.info("User makes search from search box");
        anasayfa.aramaYapmaIslemi();

    }
}
