package Test04_Invalid_User_Pass;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends ConfigDriver {
    AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.dice.app.jobs:id/zerostate_have_an_account")
    WebElement verifyHasAccount;

    @FindBy(id = "com.dice.app.jobs:id/zerostate_sign_in")
    WebElement signInLink;

    @FindBy(id = "com.dice.app.jobs:id/email_editText")
    WebElement userEmail;

    @FindBy(id = "com.dice.app.jobs:id/password_editText")
    WebElement userPassword;

    @FindBy(id = "com.dice.app.jobs:id/sign_in_button")
    WebElement signInBtn;

    @FindBy(id = "com.dice.app.jobs:id/sign_in_progress")
    WebElement accountRender;

    @FindBy(id = "android:id/message")
    WebElement unableToFindAcc;
    public void visibilityOfElement(WebElement element){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void landingPage(){
        visibilityOfElement(verifyHasAccount);
        signInLink.click();
        visibilityOfElement(userEmail);
    }

    public void enterCredentials(){
        //User Email Input:
        userEmail.click();
        userEmail.sendKeys("Fazil@gmail.com");

        //USer Password Input:
        userPassword.click();
        userPassword.sendKeys("LebronJam3es123");
    }

    public void submitRequest(){
        signInBtn.click();
    }

    public void DiceLogin(){
        landingPage();
        enterCredentials();
        submitRequest();
        String unable = unableToFindAcc.getAttribute("text").split(",")[0];
        Assert.assertEquals(unable, "Oops");
    }
}
