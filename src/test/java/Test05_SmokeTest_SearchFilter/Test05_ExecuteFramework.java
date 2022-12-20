package Test05_SmokeTest_SearchFilter;

import org.testng.annotations.Test;

public class Test05_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        FilterCareer career = loginPage.DiceLogin();
        career.filterDiceSelection();
    }
}
