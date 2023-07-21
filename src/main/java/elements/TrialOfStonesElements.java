package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrialOfStonesElements {
    WebDriver driver;

    @FindBy(id="r1Input") public WebElement riddleOfStoneInput;
    @FindBy(id="r1Btn") public WebElement riddleOfStoneButton;
    @FindBy(id="passwordBanner") public WebElement riddleOfStoneAnswer;
    @FindBy(id="r2Input") public WebElement riddleOfSecretsInput;
    @FindBy(id="r2Butn") public WebElement riddleOfSecretsButton;
    @FindBy(id="successBanner1") public WebElement riddleOfSecretsAnswer;
    @FindBy(xpath = "//div/label[text()='Total Wealth ($):']/following-sibling::p") public List<WebElement> merchantsWealth;
    @FindBy(xpath = "//div/label[text()='Total Wealth ($):']/preceding-sibling::span/b") public List<WebElement> merchantsNames;
    @FindBy(id="r3Input") public WebElement merchantsInput;
    @FindBy(id="r3Butn") public WebElement merchantsButton;
    @FindBy(id="successBanner2") public WebElement merchantsAnswer;
    @FindBy(id="checkButn") public WebElement checkButton;
    @FindBy(id="trialCompleteBanner") public WebElement finalAnswer;

    public TrialOfStonesElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
