package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.Automation;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.Sources.SQLRetrieval;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.sql.SQLException;
import java.util.ArrayList;

public class UserInfo {
    WebDriver driver;
    public UserInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "fname")
    WebElement userName;

    @FindBy(id = "lname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement userEmail;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "passwordConfirmation")
    WebElement passwordConfirmation;

    @FindBy(id = "diceCommunications")
    WebElement radioButton;
    SQLRetrieval sqlRetrieval = new SQLRetrieval();
    ArrayList<String> userCredentials;


    String firstNameSQL;
    String lastNameSQL;
    String emailSQL;
    String passwordSQL;

    public void postData(String legalFirst) throws SQLException {
        userCredentials = getData(legalFirst);
        firstNameSQL = (userCredentials.get(0));
        lastNameSQL = (userCredentials.get(1));
        emailSQL = (userCredentials.get(2));
        passwordSQL = (userCredentials.get(3));
    }
    public ArrayList<String> getData(String legalFirst) throws SQLException {
        userCredentials= sqlRetrieval.SQLCredentials(legalFirst);
        return userCredentials;
    }

    public void enterUsernameAndPass(){
        //Legal Name
        userName.sendKeys(firstNameSQL);
        lastName.sendKeys(lastNameSQL);
        //User Email:
        userEmail.sendKeys(emailSQL);
        //User Password:
        password.sendKeys(passwordSQL);
        passwordConfirmation.sendKeys(passwordSQL);
    }

    public void radioButtonValidator(){
        //Checks if Enabled:
        boolean isRadioButtonEnabled = radioButton.isEnabled();
        if(isRadioButtonEnabled){
            radioButton.click();
        }
    }
    public CaptchaVerification completeUserRegistration(String firstName) throws SQLException {
        postData(firstName);
        enterUsernameAndPass();
        radioButtonValidator();
        return new CaptchaVerification(driver);
    }
}