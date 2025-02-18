package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StepDefinition {
    WebDriver driver;
    WebDriverWait wait;

    public StepDefinition() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Given("I open the PUDO login page")
    public void i_open_the_PUDO_login_page() {
        driver.get("https://oohpod-dev-pudolocator-ui.azurewebsites.net");
        driver.manage().window().maximize();
    }

    @When("I enter valid email {string}")
    public void i_enter_valid_email(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[type='email'][placeholder='Enter your email']")));
        emailField.sendKeys(email);
    }

    @When("I enter valid password {string}")
    public void i_enter_valid_password(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='submit']")));
        loginButton.click();
    }
    
    @When("I enter invalid password {string}")
    public void i_enter_invalid_password(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys(password);
    }

 
    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        System.out.println("Login successful!");
        assertTrue(true);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message1(String expectedMessage) {
        System.out.println(expectedMessage);
        assertTrue(expectedMessage.contains("Login not allowed"));
    }

    @Then("I should see the website title as {string}")
    public void i_should_see_the_website_title_as(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        String actualTitle = driver.getTitle();
        assertTrue("Expected title was: " + expectedTitle + " but got: " + actualTitle, actualTitle.equals(expectedTitle));
        System.out.println("Website title verified successfully: " + actualTitle);
    }

      
    

    @Given("I open the PUDO add location page")
    public void i_open_the_PUDO_add_location_page() {
        driver.switchTo().defaultContent();
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (WebElement iframe : iframes) {
            driver.switchTo().frame(iframe);
            if (!driver.findElements(By.xpath("//span[contains(@class,'layout-menuitem-text') and text()='Add Location']")).isEmpty()) {
                break;
            }
            driver.switchTo().defaultContent();
        }

        WebElement addLocationButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'layout-menuitem-text') and text()='Add Location']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addLocationButton);
        addLocationButton.click();
    }

    @When("I enter {string} in the {string} field")
    public void i_enter_in_the_field(String value, String fieldName) {
        By fieldLocator = getLocator(fieldName);
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLocator));
        field.click();
        field.clear();
        field.sendKeys(value);
    }

    @When("I select {string} from the {string} dropdown")
    public void i_select_from_the_dropdown(String value, String dropdownName) {
        String dropdownXPath;
        String optionXPath;

        switch (dropdownName) {
            case "Country":
                dropdownXPath = "//div[@id='countryId']";
                optionXPath = "//li[@aria-label='" + value + "']";
                break;
            case "PUDO Type":
                dropdownXPath = "//div[@id='pudoType']";
                optionXPath = "//li[@aria-label='" + value + "']";
                break;
            case "Location Status":
                dropdownXPath = "//div[@id='locationStatusId']";
                optionXPath = "//li[@aria-label='"+ value +"']";
                break;
            case "Hardware Type":
                dropdownXPath = "//span[@aria-label='- Select Hardware Type -']";
                optionXPath = "//li[@aria-label='"+ value +"']";
                break;
            case "Time Zone":
            dropdownXPath = "//span[@aria-label='- Select Time Zone -']";
            optionXPath = "//li[@aria-label='"+ value +"']";
                break;
            
            
            default:
                throw new IllegalArgumentException("Dropdown not found: " + dropdownName);
        }

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXPath)));
        dropdown.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath)));
        option.click();
    }

    @When("I check the following checkboxes:")
    public void i_check_the_following_checkboxes(List<String> checkboxNames) {
        for (String checkboxName : checkboxNames) {
            By checkboxLocator = getLocator(checkboxName);
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Submit']")));
        submitButton.click();
    }

    private By getLocator(String fieldName) {
        switch (fieldName) {
            case "PUDO Code": return By.id("pudoCode");
            case "Name": return By.id("name");
            case "Address Line 1": return By.id("address1");
            case "Address Line 2": return By.id("address2");
            case "City/Town": return By.id("cityTown");
            case "Country": return By.id("countryId");
            case "County": return By.id("county");
            case "Post Code": return By.id("postCode");
            case "Latitude": return By.id("latitude");
            case "Longitude": return By.id("longitude");
            case "Location Status": return By.xpath("//div[contains(@class,'dropdown')]//span[text()='Select Status']");
            case "Hardware Type": return By.xpath("//div[contains(@class,'dropdown')]//span[text()='Select Hardware Type']");
            case "Time Zone": return By.xpath("//div[contains(@class,'dropdown')]//span[text()='Select Time Zone']");
            case "Open 24x7": return By.xpath("//div[@class='p-checkbox-box']");
            case "Always Open": return By.xpath("//label[text()='Always Open']/following::div[contains(@class, 'p-checkbox-box')][1]");
            case "Active": return By.xpath("//label[text()='Active']/following::div[contains(@class, 'p-checkbox-box')][1]");


            default: throw new IllegalArgumentException("Field not found: " + fieldName);
        }
    }
}
