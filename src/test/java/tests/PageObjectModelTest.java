package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

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
    }

}
