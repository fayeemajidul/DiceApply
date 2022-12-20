package Test02_Invalid_User;

import org.testng.annotations.Test;

public class Test02_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DiceLogin();

    }
}
