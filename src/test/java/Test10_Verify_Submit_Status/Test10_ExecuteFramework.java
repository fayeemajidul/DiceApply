package Test10_Verify_Submit_Status;

import Mobile_AutomatedApply.AutomatedResources.ConfigDriver;
import Test08_Sanity_User_Applied.AutomateJobSelection;
import org.testng.annotations.Test;

public class Test10_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        FilterCareer filterCareer = loginPage.DiceLogin();
        AutomateJobSelection automateJobSelection = filterCareer.filterDiceSelection();
        automateJobSelection.applicationAutomation();
    }
}
