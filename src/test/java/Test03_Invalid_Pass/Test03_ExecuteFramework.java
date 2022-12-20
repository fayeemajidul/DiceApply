package Test03_Invalid_Pass;

import org.testng.annotations.Test;

public class Test03_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DiceLogin();

    }
}
