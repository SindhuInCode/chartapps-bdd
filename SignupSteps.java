import io.cucumber.java.en.*;                     // For Given, When, Then
import org.openqa.selenium.*;                     // For Selenium
import org.openqa.selenium.chrome.*;              // For Chrome browser

public class SignupSteps {
    WebDriver driver;                             // Declare browser

    @Given("I open ChartApps")
    public void openChartApps() {
        // Start Chrome browser in headless mode (no window pops up)
        driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        driver.get("https://chartapps.io");       // Open the website
    }

    @When("I fill in the sign-up form")
    public void fillForm() {
        // Click the Sign Up link and type email & password
        driver.findElement(By.linkText("Sign Up for Free")).click();
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("password")).sendKeys("Test@123");
    }

    @Then("I submit the form")
    public void submitForm() throws InterruptedException {
        // Click the final Sign Up button and wait
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        Thread.sleep(2000); // short wait to let the action happen
        driver.quit();      // close the browser
    }
}
