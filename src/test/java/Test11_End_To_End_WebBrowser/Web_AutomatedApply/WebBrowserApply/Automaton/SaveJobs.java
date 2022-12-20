package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.AbstractWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SaveJobs extends AbstractWaits {
    WebDriver driver;
    public SaveJobs(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void saveJob(){
        for(int i = 1; i <= 20; i++){
            boolean hasSavedButton = driver.findElements(By.xpath("//dhi-search-card[" + i + "]//div[1]//div[1]//div[1]//div[2]//div[2]//dhi-save-button[1]//div[1]//button[1]")).size() > 0;
            if (hasSavedButton){
                driver.findElement(By.xpath("//dhi-search-card[" + i + "]//div[1]//div[1]//div[1]//div[2]//div[2]//dhi-save-button[1]//div[1]//button[1]")).click();
                javaScriptExecutorScrollBy(0,25);

            }else{
                System.out.println("Job #" + i + " has already been applied to");
                javaScriptExecutorScrollBy(0,40);
            }
        }
        javaScriptExecutorScrollBy(0,-10000);
    }

    public EasyApply navigateToSavedJobs(){
        saveJob();
        return new EasyApply(driver);
    }
}
