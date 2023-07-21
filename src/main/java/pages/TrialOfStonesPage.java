package pages;

import elements.TrialOfStonesElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrialOfStonesPage {

    String pageURL = "https://techstepacademy.com/trial-of-the-stones";
    WebDriver driver;
    TrialOfStonesElements tose;

    public TrialOfStonesPage(WebDriver driver){
        this.driver = driver;
        tose = new TrialOfStonesElements(driver);
    }

    public void navigateToPage(){
        driver.get(pageURL);
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void typeInRiddleOfStoneInput(String str){
        tose.riddleOfStoneInput.sendKeys(str);
    }

    public void clickOnRiddleOfStoneButton(){
        tose.riddleOfStoneButton.click();
    }

    public WebElement getRiddleOfStoneAnswer(){
        return tose.riddleOfStoneAnswer;
    }
}
