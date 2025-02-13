package PUDO.Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyWebsiteName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

        try {
            // Open the website
            driver.get("https://oohpod-dev-pudolocator-ui.azurewebsites.net");
            driver.manage().window().maximize();

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate email input field
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email'][placeholder='Enter your email']")));
            emailField.sendKeys("oma.devi@outlook.com");

            // Locate password input field using ID
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));           
            passwordField.sendKeys("Kyu003??");
            
         // Locate and click the Login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();
            
          //Verify the Web-site Name
           // WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("PUDO Locator"));
            
            String actualTitle = driver.getTitle();
            String expectedTitle = "PUDO Locator";
            
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Website name is correct: " + actualTitle);
            } else {
                System.out.println("Website name is incorrect. Expected: " + expectedTitle + ", but got: " + actualTitle);
            }
                      
            

	} catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close the browser
       // driver.quit();
    }
    }
}


