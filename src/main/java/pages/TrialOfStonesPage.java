package pages;

import elements.TrialOfStonesElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void typeInRiddleOfSecretsInput(String str){
        tose.riddleOfSecretsInput.sendKeys(str);
    }

    public void clickOnRiddleOfSecretsButton(){
        tose.riddleOfSecretsButton.click();
    }

    public WebElement getRiddleOfSecretsAnswer(){
        return tose.riddleOfSecretsAnswer;
    }

    public List<WebElement> getMerchantsWealth(){
        return tose.merchantsWealth;
    }

    public List<WebElement> getMerchantsNames(){
        return tose.merchantsNames;
    }

    public void typeInMerchantsInput(String str){
        tose.merchantsInput.sendKeys(str);
    }

    public void clickOnMerchantsButton(){
        tose.merchantsButton.click();
    }

    public WebElement getMerchantsAnswer(){
        return tose.merchantsAnswer;
    }

    public void clickOnCheckAnswersButton(){
        tose.checkButton.click();
    }

    public WebElement getFinalAnswer(){
        return tose.finalAnswer;
    }
}
