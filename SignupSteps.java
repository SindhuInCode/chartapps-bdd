package Cucumber;
 
import static org.testng.Assert.assertTrue;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class cucumber {
 
    WebDriver driver;
    WebDriverWait wait;
 
    @Given("User is on the ChartApps login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chartapps.app/dashboard/auth");
 
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
 
    @When("User enters valid username and password")
    public void user_enters_credentials() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("sindhusena08@gmail.com");
 
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@type='password']")));
        passwordField.sendKeys("Password@123");
    }
 
    @And("User clicks the login button")
    public void user_clicks_login() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div[2]/form/button")));
        loginBtn.click();
    }
 
    @Then("User should be redirected to the dashboard")
    public void verify_dashboard_page() {
        wait.until(ExpectedConditions.urlContains("/dashboard")); // wait for URL to change
 
        boolean dashboardLoaded = driver.getCurrentUrl().contains("/dashboard")
            || driver.getPageSource().contains("Welcome");
 
        assertTrue(dashboardLoaded, "User is not redirected to dashboard");
       
    }
}


