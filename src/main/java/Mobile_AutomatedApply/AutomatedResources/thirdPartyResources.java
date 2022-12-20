package Mobile_AutomatedApply.AutomatedResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class thirdPartyResources {
    static ExtentReports extent;

    public static ExtentReports getReporterObject() {
        //ExtentReports, ExtentSparkReporter
        File path = new File("/Users/fayeemmooktadeer/Documents/DiceMobile/DiceApply/src/test/java/TestResults");
        //Created a path where extent reports will be generated.
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Results");

        extent = new ExtentReports();
        //Extent is dependent on ExtentSpark, think of Extent class as an executioner.
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Fayeem");
        return extent;

    }
}