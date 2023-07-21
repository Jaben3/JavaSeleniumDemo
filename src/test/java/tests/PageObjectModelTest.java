package tests;

import elements.TrialOfStonesElements;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageObjectModelTest extends BaseTest{

    @Test
    public void TrialOfStonesTest(){
        // Navigate to Trial of Stones Page
        driver.get("https://techstepacademy.com/trial-of-the-stones");

        // Init TrialOfStones Elements
        TrialOfStonesElements tose = new TrialOfStonesElements(driver);

        // Solve Riddle of Stone and assert answer is displayed
        tose.riddleOfStoneInput.sendKeys("rock");
        tose.riddleOfStoneButton.click();
        assertTrue(tose.riddleOfStoneAnswer.isDisplayed());

        // Solve Riddle of Secrets and assert answer is displayed
        tose.riddleOfSecretsInput.sendKeys(tose.riddleOfStoneAnswer.getText());
        tose.riddleOfSecretsButton.click();
        assertTrue(tose.riddleOfSecretsAnswer.isDisplayed());

        // Solve The Two Merchants and assert answer is displayed
        List<Integer> tmp = new ArrayList<>();
        for (WebElement item : tose.merchantsWealth){
            tmp.add(Integer.parseInt(item.getText()));
        }

        int index = tmp.indexOf(Collections.max(tmp));
        String richestMerchant = tose.merchantsNames.get(index).getText();

        tose.merchantsInput.sendKeys(richestMerchant);
        tose.merchantsButton.click();
        assertTrue(tose.merchantsAnswer.isDisplayed());

        // Check Answers
        tose.checkButton.click();
        assertTrue(tose.finalAnswer.isDisplayed());
        assertEquals(tose.finalAnswer.getText(), "Trial Complete");
    }
}
