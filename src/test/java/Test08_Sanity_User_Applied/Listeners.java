package Test08_Sanity_User_Applied;

import Test05_SmokeTest_SearchFilter.ConfigDriver;
import Test05_SmokeTest_SearchFilter.thirdPartyResources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends ConfigDriver implements ITestListener {
    ExtentTest test;
    ExtentReports extent = thirdPartyResources.getReporterObject();
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.fail(result.getThrowable());
        try {
            driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        try {
            test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
