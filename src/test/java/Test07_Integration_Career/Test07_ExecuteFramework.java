package Test07_Integration_Career;

import Mobile_AutomatedApply.AutomatedResources.ConfigDriver;
import org.testng.annotations.Test;

public class Test07_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        FilterCareer filterCareer = loginPage.DiceLogin();
        AutomateJobSelection automateJobSelection = filterCareer.filterDiceSelection();
        automateJobSelection.applicationAutomation();
    }
}
