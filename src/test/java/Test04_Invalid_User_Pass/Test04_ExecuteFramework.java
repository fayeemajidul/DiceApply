package Test04_Invalid_User_Pass;

import org.testng.annotations.Test;

public class Test04_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DiceLogin();

    }
}
