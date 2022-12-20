package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractWaits {
    WebDriver driver;
    public AbstractWaits(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void visibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By)(element)));
    }
    //Our first real overloading experience
    public void visibilityOf(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated((element)));
    }
    public void invisibilityOf(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    public void invisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void javaScriptExecutorScrollBy(int x, int y){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(" + x  + ", " + y +")");
    }

    //Reliability
    @FindBy(id = "smart-toggle-link")
    WebElement menuToggle;
    By smartToggle = (By.id("smart-toggle"));

    @FindBy(id = "smart-toggle")
    WebElement menuToggle2;

    @FindBy(xpath = "//a[normalize-space()='Jobs']")
    WebElement clickJobs;

    @FindBy(css = "#navbarDropdown-9")
    WebElement dropDownToggle;

    @FindBy(css = "a[href='/dashboard/jobs']")
    WebElement dropDownJobSelect;

    public void clickMenuToggle(){
        menuToggle.click();
        visibilityOf(smartToggle);
        clickJobs.click();
    }
    public void goBackToSavedJobs(){
        dropDownJobSelect.click();
    }
}