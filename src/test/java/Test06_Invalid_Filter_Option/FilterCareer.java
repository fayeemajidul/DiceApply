package Test06_Invalid_Filter_Option;

import Mobile_AutomatedApply.AutomatedResources.ConfigDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FilterCareer extends ConfigDriver {
    AndroidDriver driver;
    public FilterCareer(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Job Search']/android.widget.FrameLayout/android.widget.ImageView")
    private WebElement btmNavSearchIcon;

    @FindBy(xpath = "//android.widget.Button[@content-desc='New Search']")
    private WebElement topSearchIcon;

    @FindBy(id = "com.dice.app.jobs:id/keyword_autoComplete")
    private WebElement careerSearch;

    @FindBy(id = "com.dice.app.jobs:id/locationKeyword_layout")
    private WebElement clickOnFirstCareer;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.RadioButton[2]")
    private WebElement enableRemoteOption;

    @FindBy(id = "com.dice.app.jobs:id/submit_menuItem")
    private WebElement submitBtn;

    @FindBy(id = "com.dice.app.jobs:id/error_text")
    private WebElement unableToSearch;

    public void filterJobSearch() throws InterruptedException {
        btmNavSearchIcon.click();
        topSearchIcon.click();
        careerSearch.click();
        careerSearch.sendKeys("SIXTYSIXFOURTYFIVE"); //Validate Jobs Search (+ , -), Test Case
        Thread.sleep(1000);
        clickOnFirstCareer.click();
        enableRemoteOption.click();
        submitBtn.click();

    }

    public void filterDiceSelection() throws InterruptedException {
        filterJobSearch();
        Thread.sleep(3000);
        String getTextAfterInvalidSearch = unableToSearch.getAttribute("text").split(" ")[0];
        Assert.assertEquals(getTextAfterInvalidSearch, "No");
    }
}


