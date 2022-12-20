package Test08_Sanity_User_Applied;

import Mobile_AutomatedApply.AutomatedResources.ConfigDriver;
import org.testng.annotations.Test;

public class Test08_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        FilterCareer filterCareer = loginPage.DiceLogin();
        AutomateJobSelection automateJobSelection = filterCareer.filterDiceSelection();
        automateJobSelection.applicationAutomation();
    }
}
