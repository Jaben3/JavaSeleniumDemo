package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageObjectModelTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void TrialOfStonesTest(){
        // Navigate to Trial of Stones Page
        driver.get("https://techstepacademy.com/trial-of-the-stones");

        // Solve Riddle of Stone
        driver.findElement(By.id("r1Input")).sendKeys("rock");
        driver.findElement(By.id("r1Btn")).click();
        String answer = driver.findElement(By.id("passwordBanner")).getText();

        // Solve Riddle of Secrets
        driver.findElement(By.id("r2Input")).sendKeys(answer);
        driver.findElement(By.id("r2Butn")).click();

        // Solve The Two Merchants
        List<WebElement> merchantsWealth = driver.findElements(By.xpath("//div/label[text()='Total Wealth ($):']/following-sibling::p"));
        List<Integer> tmp = new ArrayList<>();
        for (WebElement item : merchantsWealth){
            tmp.add(Integer.parseInt(item.getText()));
        }

        int index = tmp.indexOf(Collections.max(tmp));
        List<WebElement> merchantsNames = driver.findElements(By.xpath("//div/label[text()='Total Wealth ($):']/preceding-sibling::span/b"));
        String richestMerchant = merchantsNames.get(index).getText();

        driver.findElement(By.id("r3Input")).sendKeys(richestMerchant);
        driver.findElement(By.id("r3Butn")).click();

        // Check Answers
        driver.findElement(By.id("checkButn")).click();
        Assert.assertTrue(driver.findElement(By.id("trialCompleteBanner")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("trialCompleteBanner")).getText(), "Trial Complete");
    }

}
