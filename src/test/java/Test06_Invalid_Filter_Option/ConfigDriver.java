package Test06_Invalid_Filter_Option;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ConfigDriver {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public WebDriverWait explicitWait;

    @BeforeTest
    public AndroidDriver startSession() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start(); //Starts Service, programmatically.

        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName("android");
        androidOptions.setDeviceName("AndroEN");
        androidOptions.setAutomationName("UIAutomator2");
        androidOptions.setAppPackage("com.dice.app.jobs");
        androidOptions.setAppActivity("com.dice.app.jobs.activities.MainDiceActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),androidOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return driver;
    }
    //Long Press Element:
    public void longPress(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),"duration", 2000));
    }

    //Scroll Until Visible Text:
    public void scrollToText(String textToView) throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + textToView + "\"));"));
        Thread.sleep(500);
    }

    //Scroll to specified position:
    public void scrollToPosition(String direction,int forceOfGesture, int stopAtPosition){
        boolean canScrollMore;
        int i = 0;
        do{
            //Scroll using dimensions:
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", direction,
                    "percent", 3.0
            ));
            i++;
        }while (i < 5);
    }

    //Swipe Gesture, by direction:
    public void swipeGesture(WebElement element, String direction, int swipeForce){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", direction.toLowerCase(),
                "percent", swipeForce));
    }

    public String getScreenShotPath(String testCaseName, AndroidDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile =  "/Users/fayeemmooktadeer/Documents/DiceMobile/DiceApply/src/test/java/TestResults" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
    @AfterTest
    public void tearDown(){
//        driver.quit();
        service.stop();
    }
}