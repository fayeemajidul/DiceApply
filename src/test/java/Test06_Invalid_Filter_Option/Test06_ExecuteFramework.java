package Test06_Invalid_Filter_Option;

import org.testng.annotations.Test;

public class Test06_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        FilterCareer career = loginPage.DiceLogin();
        career.filterDiceSelection();
    }
}
