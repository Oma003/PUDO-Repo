package PUDO.Automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPUDO {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website
            driver.get("https://oohpod-dev-pudolocator-ui.azurewebsites.net");
            driver.manage().window().maximize();

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Locate email input field
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email'][placeholder='Enter your email']")));
            emailField.sendKeys("oma.devi@outlook.com");

            // Locate password input field using ID
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

            // Password condition
            String password = "Kyu003??"; // Change this value to test different cases
            if (password.equals("Kyu003??")) {
                passwordField.sendKeys(password);

                // Locate and click the Login button
                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
                loginButton.click();

                // Print success message
                System.out.println("Login successful!");
            } else {
                System.out.println("Login not allowed. Incorrect password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           // driver.quit();
        }
    }
}



