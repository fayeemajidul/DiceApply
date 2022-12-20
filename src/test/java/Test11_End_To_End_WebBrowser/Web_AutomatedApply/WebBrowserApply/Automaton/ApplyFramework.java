package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.InitDriver;
import org.openqa.selenium.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

//Scenario that there is no Easy Apply Button

public class ApplyFramework implements WebDriver {
    @Test
    @Parameters({"email", "password"})
    public void AutoApply(String userEmail, String userPassword) throws InterruptedException, IOException {
        InitDriver initDriver = new InitDriver(); // Initialize Global Driver
        SignInDetails signInDetails = initDriver.signIn();
        FilterJobSelection filterJobSelection = signInDetails.searchJobRole(userEmail,userPassword);
        SaveJobs saveJobs = filterJobSelection.queryFilterJobs();
        EasyApply easyApply = saveJobs.navigateToSavedJobs();
        ApplicationProcess applicationProcess = easyApply.easyApplyJobs();
        RepeatedApply repeatedApply = applicationProcess.applicationProcess();
//        repeatedApply.connectSteps();
    }
    @Override
    public void get(String url) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}
