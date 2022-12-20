package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.AbstractWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterJobSelection extends AbstractWaits {
    WebDriver driver;
    public FilterJobSelection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "typeaheadInput")
    WebElement searchBar;
    @FindBy(id = "searchDisplay-div")
    WebElement searchDisplay;
    By searchingDisplay = By.id("searchDisplay-div");

    @FindBy(xpath = "//button[@aria-label='Filter Search Results by Remote Only']//i[@class='fa fa-square-o']")
    WebElement remoteFilter;

    @FindBy(css = "i[class='fa fa-square-o']")
    WebElement easyApplyFilter;

    public void enterCareerPath(){
        searchBar.sendKeys("QA Automation Engineer");
        searchBar.sendKeys(Keys.ENTER);
        visibilityOf(searchingDisplay);
    }
    public void checkRadioButtonsSelected(){
        boolean isRemote = remoteFilter.isSelected();
        if(!isRemote){remoteFilter.click();}
        javaScriptExecutorScrollBy(0,600);
        boolean isEasyApply = easyApplyFilter.isSelected();
        if(!isEasyApply){easyApplyFilter.click();}
        javaScriptExecutorScrollBy(0,-600);
    }

    public SaveJobs queryFilterJobs(){
        enterCareerPath();
        checkRadioButtonsSelected();
        return new SaveJobs(driver);
    }

}