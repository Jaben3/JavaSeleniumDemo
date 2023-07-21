package tests;

import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.TrialOfStonesPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageObjectModelTest extends BaseTest{

    @Test
    public void TrialOfStonesTest(){
        // Navigate to Trial of Stones Page
        TrialOfStonesPage page = new TrialOfStonesPage(driver);
        page.navigateToPage();

        String expectedURL = "https://techstepacademy.com/trial-of-the-stones";
        String expectedTitle = "Ninja Trials: Trial of the Stones — TechStep Academy";
        assertEquals(page.getPageURL(), expectedURL);
        assertEquals(page.getPageTitle(), expectedTitle);

        // Solve Riddle of Stone and assert answer is displayed
        page.typeInRiddleOfStoneInput("rock");
        page.clickOnRiddleOfStoneButton();
        assertTrue(page.getRiddleOfStoneAnswer().isDisplayed());

        // Solve Riddle of Secrets and assert answer is displayed
        page.typeInRiddleOfSecretsInput(page.getRiddleOfStoneAnswer().getText());
        page.clickOnRiddleOfSecretsButton();
        assertTrue(page.getRiddleOfSecretsAnswer().isDisplayed());

        // Solve The Two Merchants and assert answer is displayed
        List<Integer> tmp = new ArrayList<>();
        for (WebElement item : page.getMerchantsWealth()){
            tmp.add(Integer.parseInt(item.getText()));
        }

        int index = tmp.indexOf(Collections.max(tmp));
        String richestMerchant = page.getMerchantsNames().get(index).getText();

        page.typeInMerchantsInput(richestMerchant);
        page.clickOnMerchantsButton();
        assertTrue(page.getMerchantsAnswer().isDisplayed());

        // Check Answers
        page.clickOnCheckAnswersButton();
        assertTrue(page.getFinalAnswer().isDisplayed());
        assertEquals(page.getFinalAnswer().getText(), "Trial Complete");
    }

    @Test()
    public void negativePathTest(){
        // Navigate to Trial of Stones Page
        TrialOfStonesPage page = new TrialOfStonesPage(driver);
        page.navigateToPage();

        // Input bad answer in Riddle of Stone and assert answer is NOT displayed
        page.typeInRiddleOfStoneInput("bad answer");
        page.clickOnRiddleOfStoneButton();
        assertFalse(page.getRiddleOfStoneAnswer().isDisplayed());
    }
}
