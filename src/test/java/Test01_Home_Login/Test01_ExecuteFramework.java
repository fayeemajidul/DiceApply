package Test01_Home_Login;

import org.testng.annotations.Test;

public class Test01_ExecuteFramework extends ConfigDriver {
    @Test
    public void mainFrameWork() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DiceLogin();
    }
}
